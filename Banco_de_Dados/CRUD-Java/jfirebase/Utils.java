package jfirebase;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import org.json.JSONObject;

public class Utils {
	
	static Scanner teclado = new Scanner(System.in);
	
	//O Firebase possui uma API Reste, como o CouchDB;
	//O real-time database foi criado no próprio site do Firebase;
	//É necessário no mínimo a versão 11 do Java para este CRUD.
	
	/**
	 * Realiza a conexão
	 * @return Conexão
	 */
	public static HttpClient conectar() {
		//Cria um cliente para realizar a conexão com o database.
		HttpClient con = HttpClient.newBuilder().build();
		
		return con;
	}
	
	/**
	 * Lista todos os dados já inseridos no database;
	 */
	public static void listar() {
		//Conexão.
		HttpClient con  = conectar();
		
		//Link para conexão. 'produtos.json' é uma coleção do database.
		String link = "https://jfirebase-791e4-default-rtdb.firebaseio.com/produtos.json";
		
		//Requisição da conexão com o Firebase
		HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(link)).build();
		
		//Tratamento de exceções durante a conexão.
		try {
			//Recebendo a resposta da requisição.
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
			//Se resposta == null, é por que não há produtos cadastrados.
			if(resposta.body().equals("null")) {
				System.out.println("\nAinda não há produtos cadastrados.\n");
				
				menu();
			}else {
				JSONObject obj = new JSONObject(resposta.body());
				
				System.out.println("\n=============== Produtos ===============\n");
				
				//Lista todos os produtos cadastrados.
				for(int i = 0; i < obj.length(); i++) {
					JSONObject produto = (JSONObject)obj.get(obj.names().getString(i));
					
					System.out.println("\nID: " + obj.names().getString(i));
					System.out.println("Produto: " + produto.get("nome"));
					System.out.println("Preço: " + produto.get("preco"));
					System.out.println("Estoque: " + produto.get("estoque"));
					System.out.println("-----------------------------------------");
				}
				menu();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Insere novos dados no database.
	 */
	public static void inserir() {
		//Conexão.
		HttpClient con = conectar();
		
		//Link para conexão com a coleção.
		String link = "https://jfirebase-791e4-default-rtdb.firebaseio.com/produtos.json";
		
		
		//Recebendo os valores do novo dado a ser inserido.
		System.out.println("\nInsira o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Insira a quantidade em estoque do produto: ");
		int estoque = teclado.nextInt();
		
		//Criando um objeto JSON e adicionando os valores ao objeto para, posteriormente, inserir o objeto no database.
		JSONObject novo_produto = new JSONObject();
		novo_produto.put("nome", nome);
		novo_produto.put("preco", preco);
		novo_produto.put("estoque", estoque);
		
		//Requisição do tipo POST.
		HttpRequest requisicao = HttpRequest.newBuilder()
					.uri(URI.create(link))
					.POST(BodyPublishers.ofString(novo_produto.toString()))
					.header("Content-Type", "application/json")
					.build();
		
		//Tratamento de exceções.
		try {
			//Recebendo a resposta da requisição
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
			JSONObject obj = new JSONObject(resposta.body());
			
			//Se resposta == 200, significa que o produto foi cadastrado e não houveram erros.
			if(resposta.statusCode() == 200) {
				System.out.println("\nProduto " + nome + " inserido com sucesso.\n");
				
				menu();
			}else {
				//Printa o erro no console, caso ocorra, facilitando a resolução do problema.
				System.out.println(obj);
				System.out.println("Status: " + resposta.statusCode());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Atualiza dados já existentes no database.
	 */
	public static void atualizar() {
		//Conexão
		HttpClient con = conectar();
		
		//Recebendo o ID do produto a ser atualizado.
		System.out.println("\nInforme o ID do produto: ");
		String id = teclado.nextLine();
		
		//Recebendo as novas informações do produto.
		System.out.println("Informe o novo nome do produto: "); 
		String nome = teclado.nextLine();
		System.out.println("Informe o novo preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Informe a nova quantidade em estoque do produto: ");
		int estoque = teclado.nextInt();
		
		//Link de conexão com o produto específico a ser atualizado na coleção.
		String link = "https://jfirebase-791e4-default-rtdb.firebaseio.com/produtos/" + id + ".json";
		
		//Criando um objeto JSON e inserindo os valores nele, para posteriormente inserir o objeto no database.
		JSONObject novo_produto = new JSONObject();
		novo_produto.put("nome", nome);
		novo_produto.put("preco", preco);
		novo_produto.put("estoque", estoque);
		
		//Requisição do tipo PUT.
		HttpRequest requisicao = HttpRequest.newBuilder()
					.uri(URI.create(link))
					.PUT(BodyPublishers.ofString(novo_produto.toString()))
					.header("Content-Type", "application/json")
					.build();
		
		//Tratamento de exceções.
		try {
			//Resposta da requisição.
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
			JSONObject obj = new JSONObject(resposta.body());
			
			//Se o status é igual a 200, o proceso de atualização ocorreu sem problemas.
			//MELHORIA: caso o usuário informe um ID que não existe, a requisição não retorna um erro, mas cria um novo objeto com o ID inserido.
			if(resposta.statusCode() == 200) {
				System.out.println("\nProduto atualizado com sucesso!\n");
				System.out.println(resposta.body());
				
				menu();
			}else {
				System.out.println(obj);
				System.out.println("Status: " + resposta.statusCode());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deleta dados do database.
	 */
	public static void deletar() {
		//Conexão
		HttpClient con = conectar();
		
		//Recebendo o ID do dado a ser deletado.
		System.out.println("\nInforme o ID do produto a ser deletado: ");
		String id = teclado.nextLine();
		
		//Link para conexão com o objeto específico da coleção a ser deletado.
		String link = "https://jfirebase-791e4-default-rtdb.firebaseio.com/produtos/" + id + ".json";
		
		//Requisição do tipo DELETE.
		HttpRequest requisicao = HttpRequest.newBuilder()
					.uri(URI.create(link))
					.DELETE()
					.header("Content-Type", "application/json")
					.build();
		
		//Tratamento de exceções.
		try {
			//Resposta da requisição.
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
			//Checando se o produto foi deletado com sucesso.
			if(resposta.statusCode() == 200 && resposta.body().equals("null")) {
				System.out.println("\nProduto deletado com sucesso!\n");
				
				menu();
			}else {
				System.out.println("\nNão há produto com o ID informado.\n");
				
				menu();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void menu() {
		System.out.println("\n==================Gerenciamento de Produtos FireBase===============");
		System.out.println("Selecione uma opção: ");
		System.out.println("1 - Listar produtos.");
		System.out.println("2 - Inserir produtos.");
		System.out.println("3 - Atualizar produtos.");
		System.out.println("4 - Deletar produtos.");
		
		int opcao = Integer.parseInt(teclado.nextLine());
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
