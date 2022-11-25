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
	
	public static HttpClient conectar() {
		HttpClient con = HttpClient.newBuilder().build();
		
		return con;
	}
	
	public static void listar() {
		HttpClient con  = conectar();
		
		String link = "https://jfirebase-791e4-default-rtdb.firebaseio.com/produtos.json";
		
		HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(link)).build();
		
		try {
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
			if(resposta.body().equals("null")) {
				System.out.println("\nAinda não há produtos cadastrados.\n");
				
				menu();
			}else {
				JSONObject obj = new JSONObject(resposta.body());
				
				System.out.println("\n=============== Produtos ===============\n");
				
				for(int i = 0; i < obj.length(); i++) {
					JSONObject produto = (JSONObject)obj.get(obj.names().getString(i));
					
					System.out.println("ID: " + obj.names().getString(i));
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
	
	public static void inserir() {
		HttpClient con = conectar();
		
		String link = "https://jfirebase-791e4-default-rtdb.firebaseio.com/produtos.json";
		
		System.out.println("Insira o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Insira a quantidade em estoque do produto: ");
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
			
			if(resposta.statusCode() == 200) {
				System.out.println("\nProduto " + nome + " inserido com sucesso.\n");
				
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
	
	public static void atualizar() {
		HttpClient con = conectar();
		
		System.out.println("Informe o ID do produto: ");
		String id = teclado.nextLine();
		System.out.println("Informe o novo nome do produto: "); 
		String nome = teclado.nextLine();
		System.out.println("Informe o novo preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Informe a nova quantidade em estoque do produto: ");
		int estoque = teclado.nextInt();
		
		String link = "https://jfirebase-791e4-default-rtdb.firebaseio.com/produtos/" + id + ".json";
		
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
	
	public static void deletar() {
		HttpClient con = conectar();
		
		System.out.println("Informe o ID do produto a ser deletado: ");
		String id = teclado.nextLine();
		
		String link = "https://jfirebase-791e4-default-rtdb.firebaseio.com/produtos/" + id + ".json";
		
		HttpRequest requisicao = HttpRequest.newBuilder()
					.uri(URI.create(link))
					.DELETE()
					.header("Content-Type", "application/json")
					.build();
		
		try {
			HttpResponse<String> resposta = con.send(requisicao, BodyHandlers.ofString());
			
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
		System.out.println("==================Gerenciamento de Produtos FireBase===============");
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
