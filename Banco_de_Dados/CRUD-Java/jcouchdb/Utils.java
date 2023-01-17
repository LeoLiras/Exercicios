package jcouchdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

//import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class Utils {
	
	static Scanner teclado = new Scanner(System.in);
	
	/**
	 * Realiza a criação do client HTTP para trabalhar com a API Rest do CouchDB e para a realização da conexão com o database.
	 * @return A própria conexão
	 */
	public static HttpClient conectar() {
		//Criando um cliente HTTP para realizar a conexão como o CouchDB.
		HttpClient connection = HttpClient.newBuilder().build();
		
		return connection;
	}
	
	//Diferentemente de outros atabases, o CouchDB não necessita de um método exclusivo para a desconexão. Além disso, foi utilizado a API Rest do CouchDB para realizar o CRUD.
	
	/**
	 * Lista todos os produtos já registrados no banco de dados.
	 */
	public static void listar() {
		//Criando um cliente HTTP para realizar a conexão como o CouchDB.
		HttpClient con = conectar();
		
		//Link padrão para a conexão. Note que 'admin:admin123' refere-se a 'user:password' do CouchDB. Esse link foi retirado da ferramenta Postman.
		String link = "http://admin:admin@localhost:5984/produtos/_all_docs?include_docs=true";
		
		//Realiza a requisição da conexão com o Database.
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(link)).build();
		
		//Tratamento de exceções de erros de conexão;
		try {
			//Envia a requisição e espera uma resposta.
			HttpResponse<String> resposta = con.send(request, BodyHandlers.ofString());
			
			//Criando um objeto JSON, que é a forma como o CouchDB trabalha.
			JSONObject obj = new JSONObject(resposta.body());
			
			//Se o objeto tiver mais que 0 linhas significa que já há produtos cadastrados.
			if((int)obj.getInt("total_rows") > 0) {
				JSONArray produtos = (JSONArray)obj.get("rows");
				
				System.out.println("\n=============== Produtos =============\n");
				
				//Extrai e printa todos os produtos do documento.
				for(Object produto : produtos) {
					JSONObject doc = (JSONObject) produto;
					JSONObject prod = (JSONObject) doc.get("doc");
					
					System.out.println("ID: " + prod.get("_id"));
					System.out.println("Rev: " + prod.get("_rev"));
					System.out.println("Produto: " + prod.get("nome"));
					System.out.println("Preço: " + prod.get("preco"));
					System.out.println("Estoque: " + prod.get("estoque"));
					System.out.println("--------------------------------------");
				}
			}else {
				System.out.println("\nAinda não há produtos cadastrados.\n");
			}
		}catch(IOException e) {
			System.out.println("\nErro durante a conexão.\n");
			e.printStackTrace();
		}catch(InterruptedException e) {
			System.out.println("\nErro durante a conexão.\n");
			e.printStackTrace();
		}
		
		menu();
	}
	
	/**
	 * Insere novos produtos ao banco de dados.
	 */
	public static void inserir() {
		//Criando um cliente HTTP para realizar a conexão como o CouchDB.
		HttpClient con = conectar();
		
		//Link padrão para a conexão. Note que 'admin:admin123' refere-se a 'user:password' do CouchDB. Esse link foi retirado da ferramenta Postman.
		String link = "http://admin:admin@localhost:5984/produtos";
		
		//Recebendo os dados do novo produto.
		teclado.nextLine();
		System.out.println("Informe o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Informe o preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Informe a quantidade em estoque do produto: ");
		int estoque = teclado.nextInt();
		
		//Inserindo os dados em um objeto JSON.
		JSONObject novo_produto = new JSONObject();
		
		novo_produto.put("nome", nome);
		novo_produto.put("preco", preco);
		novo_produto.put("estoque", estoque);
		
		//Realizando a requisição. Note que a requisição utilizada é o POST, para inserir um item que ainda não existe.
		HttpRequest requisicao = HttpRequest.newBuilder() 
				.uri(URI.create(link))
				.POST(BodyPublishers.ofString(novo_produto.toString()))
				.header("Content-Type", "application/json")
				.build();
		
		//Tratamento de exceções de erros durante a conexão.
		try {
			//Envia a requisição e espera uma resposta.
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
			//Recebe a resposta.
			JSONObject obj = new JSONObject(resposta.body());
			
			//Se o status é igual a 201 o produto foi criado com sucesso. Isso pode ser observado no Postman.
			if(resposta.statusCode() == 201) {
				System.out.println("\nProduto " + nome + " cadastrado com sucesso.\n");
				
				menu();
			}else { 
				System.out.println(obj);
				System.out.println("\nStatus: " + resposta.statusCode());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Permite atualizar dados de produtos já existentes no banco de dados.
	 */
	public static void atualizar() {
		//Criando um cliente HTTP para realizar a conexão como o CouchDB.
		HttpClient con = conectar();
		
		//Informando os dados novos para atualizar o produto.
		teclado.nextLine();
		System.out.println("Informe o ID do produto: ");
		String id = teclado.nextLine();
		System.out.println("Informe a revisão do produto: ");
		String rev = teclado.nextLine();
		System.out.println("Informe o novo nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Informe o novo preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Informe a nova quantidade em estoque do produto: ");
		int estoque = teclado.nextInt();
		
		//Link para conexão e utilização do tipo de requisição PUT.
		String link = "http://localhost:5984/produtos/" + id + "/" + "?rev=" + rev;
		
		//Adicionando os dados novos em um objeto JSON.
		JSONObject novo_produto = new JSONObject();
		
		novo_produto.put("nome", nome);
		novo_produto.put("preco", preco);
		novo_produto.put("estoque", estoque);
		
		//Criando uma requisição do tipo PUT para lidar com dados que já existem.
		HttpRequest requisicao = HttpRequest.newBuilder()
					.uri(URI.create(link))
					.PUT(BodyPublishers.ofString(novo_produto.toString()))
					.header("Content-Type", "application/json")
					.build();
		
		//Tratamento de exceções de erros durante a conexão.
		try {
			//Envia a requisição.
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
			//Recebe a resposta da requisição.
			JSONObject obj = new JSONObject(resposta.body());
			
			//Se o status é igual a 201 o produto foi atualizado com sucesso. Isso pode ser observado no Postman.
			if(resposta.statusCode() == 201) {
				System.out.println("\nProduto atualizado com sucesso.\n");
				
				menu();
			}else {
				System.out.println(obj);
				System.out.println("Status: " + resposta.statusCode());
			}
		}catch(IOException e){
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Permite deletar produtos registrados no banco de dados através do ID e da revisão do produto.
	 */
	public static void deletar() {
		//Criando um cliente HTTP para realizar a conexão como o CouchDB.
		HttpClient con = conectar();
		
		//Recebendo dados necessários para realizar o DELETE.
		teclado.nextLine();
		System.out.println("Informe o ID do produto: ");
		String id = teclado.nextLine();
		System.out.println("Informe a revisão do produto: ");
		String rev = teclado.nextLine();
		
		//Link padrão para a requisição. Note que 'admin:admin123' refere-se a 'user:password' do CouchDB. Esse link foi retirado da ferramenta Postman.
		String link = "http://admin:admin@localhost:5984/produtos/" + id + "/" + "?rev=" + rev;
		
		//Realizando a requisição do tipo DELETE.
		HttpRequest requisicao = HttpRequest.newBuilder()
					.uri(URI.create(link))
					.DELETE()
					.build();
		
		//Tratamento de exceções de erros durante a conexão.
		try {
			//Enviando a requisição.
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
			//Se o status é igual a 200 o produto foi deletado com sucesso. Isso pode ser observado no Postman.
			if(resposta.statusCode() == 200) {
				System.out.println("\nO produto foi deletado com sucesso.\n");
				
				menu();
			}else {
				System.out.println(resposta.body());
				System.out.println("Status: " + resposta.statusCode());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método que apresenta o menu da aplicação para o usuário.
	 */
	public static void menu() {
		System.out.println("==================Gerenciamento de Produtos CouchDB===============");
		System.out.println("Selecione uma opção: ");
		System.out.println("1 - Listar produtos.");
		System.out.println("2 - Inserir produtos.");
		System.out.println("3 - Atualizar produtos.");
		System.out.println("4 - Deletar produtos.");
		
		int opcao = teclado.nextInt();
		if(opcao == 1) {
			listar();
		}else if(opcao == 2) {
			inserir();
		}else if(opcao == 3) {
			atualizar();
		}else if(opcao == 4) {
			deletar();
		}else {
			System.out.println("Opção inválida.");
		}
	}
}
