package jredis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class Utils {
	
	static Scanner teclado = new Scanner(System.in);
	
	public static String gera_id() {
		Jedis con = conectar();
		
		String chave = con.get("chave");
		
		if(chave != null) {
			chave = String.valueOf(con.incr("chave"));
			
			desconectar(con);
			return chave;
		}else {
			con.set("chave", "1");
			
			desconectar(con);
			return "1";
		}
	}
	
	public static Jedis conectar() {
		Jedis con = new Jedis("redis://localhost:6379");
		
		return con;
	}
	
	public static void desconectar(Jedis con) {
		con.disconnect();
	}
	
	public static void listar() {
		Jedis con = conectar();
		
		try {
			Set<String> res = con.keys("produtos*");
			
			if(res.size() > 0) {
				System.out.println("\n================Produtos==============\n");
				
				for(String key : res) {
					Map<String, String> product = con.hgetAll(key);
					
					System.out.println("ID: " + key);
					System.out.println("Produto: " + product.get("nome"));
					System.out.println("Preço: " + product.get("preco"));
					System.out.println("Estoque: " + product.get("estoque"));
					System.out.println("______________________________________________");
					}
				}else {
					System.out.println("\nAinda não há produtos cadastrados.\n");
			}
		}catch(JedisConnectionException e) {
			System.out.println("Verifique se o servidor está ativo.\n");
			e.printStackTrace();
		}
		
		menu();
	}
	
	public static void inserir() {
		Jedis con = conectar();
		
		System.out.println("Insira o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o preço do produto: ");
		String preco = teclado.nextLine();
		System.out.println("Insira a quantidade em estoque do produto: ");
		String estoque = teclado.nextLine();
		
		Map<String, String> product = new HashMap<String, String>();
		
		product.put("nome", nome);
		product.put("preco", preco);
		product.put("estoque", estoque);
		
		String chave = "produtos" + Utils.gera_id();
		
		try {
			String res = con.hmset(chave, product);
			
			if(res != null) {
				System.out.println("\nProduto " + nome + " adicionado com sucesso.\n");
				menu();
			}
		}catch(JedisConnectionException e) {
			System.out.println("Verifique se o Redis está ativo.");
			e.printStackTrace();
		}
		//desconectar(con);
	}
	
	public static void atualizar() {
		Jedis con = conectar();
		
		System.out.println("Informe a chave do produto: ");
		String chave = teclado.nextLine();
		
		System.out.println("Insira o novo nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o novo preço do produto: ");
		String preco = teclado.nextLine();
		System.out.println("Insira a nova quantidade em estoque do produto: ");
		String estoque = teclado.nextLine();
		
		Map<String, String> product = new HashMap<String, String>();
		
		product.put("nome", nome);
		product.put("preco", preco);
		product.put("estoque", estoque);
		
		try {
			String res = con.hmset(chave, product);
			
			if(res != null) {
				System.out.println("\nProduto " + nome + " atualizado com sucesso.\n");
			}else {
				System.out.println("Não foi possível atualizar o produto.");
			}
		}catch(JedisConnectionException e) {
			System.out.println("Verifique se o Redis está ativo.");
			e.printStackTrace();
		}
		desconectar(con);
		
		menu();
	}
	
	public static void deletar() {
		Jedis con = conectar();
		
		System.out.println("Informe a chave do produto: ");
		String chave = teclado.nextLine();
		
		try {
			Long delet = con.del(chave);
			
			if(delet > 0) {
				System.out.println("\nProduto deletado com sucesso.\n");
			}else {
				System.out.println("\nNão há produtos com a chave informada.\n");
			}
		}catch(JedisConnectionException e) {
			System.out.println("Verifique se o Redis está ativo: ");
			e.printStackTrace();
		}
		desconectar(con);
		
		menu();
	}
	
	public static void menu() {
		System.out.println("==================Gerenciamento de Produtos Jedis===============");
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
