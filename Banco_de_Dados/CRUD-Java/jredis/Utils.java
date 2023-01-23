package jredis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class Utils {
	
	static Scanner teclado = new Scanner(System.in);
	//Para o Redis é necessário um software de conexão. Nesse caso usou-se o Jedis, disponível na pasta 'libs' do projeto.
	
	/**
	 * Gera uma chave de ID para o dado inserido no Redis.
	 * @return
	 */
	public static String gera_id() {
		//Conexão.
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
	
	/**
	 * Realiza a conexão com o Redis.
	 * @return Conexão
	 */
	public static Jedis conectar() {
		Jedis con = new Jedis("redis://localhost:6379");
		
		return con;
	}
	
	/**
	 * Realiza a desconexão com o Redis.
	 * @param Conexão
	 */
	public static void desconectar(Jedis con) {
		con.disconnect();
	}
	
	/**
	 * Lista os dados já inseridos no Redis
	 */
	public static void listar() {
		//Conexão.
		Jedis con = conectar();
		
		//Tratamento de exceções.
		try {
			//Recuperando todas as chaves do database.
			Set<String> res = con.keys("produtos*");
			
			//Se res > 0, existem chaves.
			if(res.size() > 0) {
				System.out.println("\n================Produtos==============\n");
				
				//Listando os produtos.
				for(String key : res) {
					//Mapeia as chaves e seus valores.
					Map<String, String> product = con.hgetAll(key);
					
					System.out.println("\nID: " + key);
					System.out.println("Produto: " + product.get("nome"));
					System.out.println("Preço: " + product.get("preco"));
					System.out.println("Estoque: " + product.get("estoque"));
					System.out.println("______________________________________________");
					}
				}else {
					System.out.println("\nAinda não há produtos cadastrados.\n");
			}
		}catch(JedisConnectionException e) {
			System.out.println("\nVerifique se o servidor está ativo.\n");
			e.printStackTrace();
		}
		
		menu();
	}
	
	/**
	 * Insere novos dados no Redis.
	 */
	public static void inserir() {
		//Conexão.
		Jedis con = conectar();
		
		//Recebendo os dados a serem inseridos no Redis.
		//Nota: O Redis só trabalha com o formato String.
		System.out.println("Insira o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o preço do produto: ");
		String preco = teclado.nextLine();
		System.out.println("Insira a quantidade em estoque do produto: ");
		String estoque = teclado.nextLine();
		
		//Mapeando as chaves e valores.
		Map<String, String> product = new HashMap<String, String>();
		
		//Integrando as chaves com os valores informados pelo usuário.
		product.put("nome", nome);
		product.put("preco", preco);
		product.put("estoque", estoque);
		
		//
		String chave = "produtos" + Utils.gera_id();
		
		//Tratamento de exceções.
		try {
			//Retorno da chave e do valor.
			String res = con.hmset(chave, product);
			
			if(res != null) {
				System.out.println("\nProduto " + nome + " adicionado com sucesso.\n");
				menu();
			}else {
				System.out.println("\nNão foi possível inserir o produto.\n");
			}
		}catch(JedisConnectionException e) {
			System.out.println("Verifique se o Redis está ativo.");
			e.printStackTrace();
		}
		
		desconectar(con);
	}
	
	/**
	 * Atualiza os dados do Redis.
	 */
	public static void atualizar() {
		//MELHORIA: Caso esse método receba uma chave que não existe, ele cria um novo produto, mesmo que a chave não siga o padrão pré-estabelecido.
		//Conexão.
		Jedis con = conectar();
		
		//Recebendo a chave do dado a ser atualizado.
		System.out.println("Informe a chave do produto: ");
		String chave = teclado.nextLine();
		
		//Recebendo os novos valores do dado da chave informada.
		System.out.println("Insira o novo nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o novo preço do produto: ");
		String preco = teclado.nextLine();
		System.out.println("Insira a nova quantidade em estoque do produto: ");
		String estoque = teclado.nextLine();
		
		//Mapeando as chaves e valores.
		Map<String, String> product = new HashMap<String, String>();
		
		//Integrando as chaves e valores.
		product.put("nome", nome);
		product.put("preco", preco);
		product.put("estoque", estoque);
		
		//Tratamento de exceções.
		try {
			//Retorno da chave-valor.
			String res = con.hmset(chave, product);
			
			if(res != null) {
				System.out.println("\nProduto " + nome + " atualizado com sucesso.\n");
			}else {
				System.out.println("\nNão foi possível atualizar o produto.\n");
			}
		}catch(JedisConnectionException e) {
			System.out.println("Verifique se o Redis está ativo.");
			e.printStackTrace();
		}
		desconectar(con);
		
		menu();
	}
	
	/**
	 * Deleta dados do Redis.
	 */
	public static void deletar() {
		//Conexão.
		Jedis con = conectar();
		
		//Recebendo a chave do dado a ser deletado.
		System.out.println("Informe a chave do produto: ");
		String chave = teclado.nextLine();
		
		//Tratamento de exceções.
		try {
			//Variável do tipo Long pois o método del pode deletar milhões de dados de uma só vez.
			Long delet = con.del(chave);
			
			if(delet > 0) {
				System.out.println("\nProduto deletado com sucesso.\n");
			}else {
				System.out.println("\nNão há produtos com a chave informada.\n");
			}
		}catch(JedisConnectionException e) {
			System.out.println("\nVerifique se o Redis está ativo.\n");
			e.printStackTrace();
		}
		desconectar(con);
		
		menu();
	}
	
	public static void menu() {
		System.out.println("==================Gerenciamento de Produtos Redis===============");
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
			System.out.println("\nOpção inválida.\n");
			menu();
		}
	}
}
