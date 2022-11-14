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

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class Utils {
	
	static Scanner teclado = new Scanner(System.in);
	
	public static HttpClient conectar() {
		HttpClient connection = HttpClient.newBuilder().build();
		
		return connection;
	}
	
	public static void desconectar() {
		System.out.println("Desconectando...");
	}
	
	public static void listar() {
		HttpClient con = conectar();
		
		String link = "http://admin:admin123@localhost:5984/produtos/_all_docs?include_docs=true";
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(link)).build();
		
		try {
			HttpResponse<String> resposta = con.send(request, BodyHandlers.ofString());
			
			JSONObject obj = new JSONObject(resposta.body());
			
			System.out.println(obj);
			
			if((int)obj.getInt("total_rows") > 0) {
				JSONArray produtos = (JSONArray)obj.get("rows");
				
				System.out.println("\n=============== Produtos =============\n");
				
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
	
	public static void inserir() {
		HttpClient con = conectar();
		
		String link = "http://admin:admin123@localhost:5984/jcouch";
		
		System.out.println("Informe o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Informe o preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Informe a quantidade em estoque do produto: ");
		int estoque = teclado.nextInt();
		
		JSONObject novo_produto = new JSONObject();
		
		novo_produto.put("nome", nome);
		novo_produto.put("preco", preco);
		novo_produto.put("estoque", estoque);
		
		HttpRequest requisicao = HttpRequest.newBuilder() 
				.uri(URI.create(link))
				.POST(BodyPublishers.ofString(novo_produto.toString()))
				.header("Content-Type", "application/json")
				.build();
		
		try {
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
			JSONObject obj = new JSONObject(resposta.body());
			
			if(resposta.statusCode() == 201) {
				System.out.println("\nProduto " + nome + " cadastrado com sucesso.\n");
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
	
	public static void atualizar() {
		HttpClient con = conectar();
		
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
		
		String link = "http://localhost:5984/jcouch/" + id + "/" + "?rev=" + rev;
		
		JSONObject novo_produto = new JSONObject();
		
		novo_produto.put("nome", nome);
		novo_produto.put("preco", preco);
		novo_produto.put("estoque", estoque);
		
		HttpRequest requisicao = HttpRequest.newBuilder()
					.uri(URI.create(link))
					.PUT(BodyPublishers.ofString(novo_produto.toString()))
					.header("Content-Type", "application/json")
					.build();
		
		try {
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
			JSONObject obj = new JSONObject(resposta.body());
			
			if(resposta.statusCode() == 201) {
				System.out.println("\nProduto atualizado com sucesso.\n");
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
	
	public static void deletar() {
		HttpClient con = conectar();
		
		System.out.println("Informe o ID do produto: ");
		String id = teclado.nextLine();
		System.out.println("Informe a revisão do produto: ");
		String rev = teclado.nextLine();
		
		String link = "http://admin:admin123@localhost:5984/" + id + "/" + "?rev=" + rev;
		
		HttpRequest requisicao = HttpRequest.newBuilder()
					.uri(URI.create(link))
					.DELETE()
					.build();
		
		try {
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
			if(resposta.statusCode() == 200) {
				System.out.println("O produto foi deletado com sucesso.");
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
	
	public static void menu() {
		System.out.println("==================Gerenciamento de Produtos CouchDB===============");
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
