package jpostgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class Utils {
	
	static Scanner teclado = new Scanner(System.in);
	//Database previmente criado no pgAdmin4.
	
	/**
	 * Realiza a conexão com o Database
	 * @return Conexão
	 */
	public static Connection conectar() {
		//Driver de conexão disponível no pasta 'libs' do projeto.
		
		Properties pro = new Properties();
		
		//Recebendo os dados de acesso do database.
		pro.setProperty("user", "estudos");
		pro.setProperty("password", "root123");
		pro.setProperty("ssl", "false");
		
		//String da URL do servidor para a conexão.
		String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/jpostgresql";
		
		//Tratamento de exceções.
		try {
			return DriverManager.getConnection(URL_SERVIDOR, pro);
		}catch(Exception e) {
			e.printStackTrace();
			
			if(e instanceof ClassNotFoundException) {
				System.err.println("Verifique o driver de conexão.");
			}else {
				System.err.println("Verifique se o servidor está ativo");
			}
			System.exit(-1);
			return null;
		}
	}
	
	/**
	 * Realiza a desconexão com o database.
	 * @param Conexão
	 */
	public static void desconectar(Connection con) {
		if(con != null) {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Lista todos os dados já inseridos no database.
	 */
	public static void listar() {
		//Código SQL de busca no formato de String.
		String BUSCAR_TODOS = "SELECT * FROM produtos";
		
		//Tratamento de exceções.
		try {
			//Conexão
			Connection con = conectar();
			
			PreparedStatement produtos = con.prepareStatement(BUSCAR_TODOS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultado = produtos.executeQuery();
			
			//Uma maneira de verificar a quantidade de produtos inseridos: indo para a última linha e pegando o valor dela.
			resultado.last();
			int qntd = resultado.getRow();
			resultado.beforeFirst();
			
			//Printando todos os produtos cadastrados.
			if(qntd > 0) {
				while(resultado.next()) {
					System.out.println("\nProdutos: ");
					System.out.println("==============================\n");
					
					System.out.println("\nID: " + resultado.getInt(1));
					System.out.println("Produto " + resultado.getString(2));
					System.out.println("Preço: " + resultado.getFloat(3));
					System.out.println("Estoque: " + resultado.getInt(4));
					System.out.println("_____________________________________________");	
					
					menu();
				}
				
			}else {
				System.out.println("\nNão há produtos cadastrados.\n");
				
				menu();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Insere novos dados no database
	 */
	public static void inserir() {
		//Recebendo os valores do novo dado.
		teclado.nextLine();
		System.out.println("\nInsira o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Insira a quantidade em estoque do produto: ");
		int estoque = teclado.nextInt();
		
		//Código SQL de inserção no formato de String.
		String INSERIR = "INSERT INTO produtos (nome, preco, estoque) VALUES (?, ?, ?)";
		
		//Tratamento de exceções.
		try {
			//Conexão.
			Connection con = conectar();
			
			PreparedStatement inserir = con.prepareStatement(INSERIR);
			
			//Inserindo os valores do dado novo.
			inserir.setString(1, nome);
			inserir.setFloat(2, preco);
			inserir.setInt(3, estoque);
			inserir.executeUpdate();
			
			desconectar(con);
			
			System.out.println("\nProduto " + nome + " inserido com sucesso.\n");
			
			menu();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Atualiza dados já inseridos no database.
	 */
	public static void atualizar() {
		//Recebendo o ID do dado que será atualizado.
		teclado.nextLine();
		System.out.println("\nInsira o ID do produto: ");
		int id = teclado.nextInt();
		
		//Código SQL de busca no formato de String para obtermos o dado com o ID informado.
		String BUSCAR_POR_ID = "SELECT * FROM produtos WHERE id=?";
		
		//Tratamento de exceções.
		try {
			//Conexão.
			Connection con = conectar();
			
			PreparedStatement produto = con.prepareStatement(BUSCAR_POR_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			produto.setInt(1, id);
			
			//Verificando se há dados no database.
			ResultSet resultado = produto.executeQuery();
			resultado.last();
			int qntd = resultado.getRow();
			resultado.beforeFirst();
			
			if(qntd > 0) {
				//Recebendo os novos valores do dado a ser atualizado.
				teclado.nextLine();
				System.out.println("\nInforme o novo nome do produto:");
				String nome = teclado.nextLine();
				System.out.println("Informe o novo preço do produto: ");
				float preco = teclado.nextFloat();
				System.out.println("Informe a quantidade em estoque do produto: ");
				int estoque = teclado.nextInt();
				
				//Código SQL de UPDATE no formato de String.
				String ATUALIZAR = "UPDATE produtos SET nome=?, preco=?, estoque=? WHERE id=?";
				
				PreparedStatement update = con.prepareStatement(ATUALIZAR);
				
				//Inserindo os novos valores no database.
				update.setString(1, nome);
				update.setFloat(2, preco);
				update.setInt(3, estoque);
				update.setInt(4, id);
				update.executeUpdate();
				update.close();
				
				desconectar(con);
				
				System.out.println("\nProduto atualizado com sucesso\n");
				
				menu();
				
			}else {
				System.out.println("\nNão foi encontrado nenhum produto com o ID inserido.\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deleta dados do database.
	 */
	public static void deletar() {
		//Códigos SQL de DELETE e de busca no formato de String, para localizarmos o dado e o deletarmos.
		String DELETAR = "DELETE FROM produtos WHERE id=?";
		String BUSCAR_POR_ID = "SELECT * FROM produtos WHERE id=?";
		
		//Recebendo o ID do produto a ser deletado.
		teclado.nextLine();
		System.out.println("Informe o ID do produto: ");
		int id = teclado.nextInt();
		
		//Tratamento de exceções.
		try {
			//Conexão.
			Connection con = conectar();
			
			PreparedStatement produto = con.prepareStatement(BUSCAR_POR_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			produto.setInt(1, id);
			ResultSet resultado = produto.executeQuery();
			
			//Verificando se há dados cadastrados.
			resultado.last();
			int qntd = resultado.getRow();
			resultado.beforeFirst();
			
			if(qntd > 0) {
				//Deletando o dado que possui o ID informado.
				PreparedStatement deletar = con.prepareStatement(DELETAR);
				deletar.setInt(1, id);
				deletar.executeUpdate();
				deletar.close();
				
				desconectar(con);
				
				System.out.println("Produto deletado com sucesso");
				
				menu();
			}else {
				System.out.println("Não há produto com o ID informado.");
				
				menu();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Menu de interação com o database.
	 */
	public static void menu() {
		System.out.println("\n==================Gerenciamento de Produtos PostgreSQL===============\n");
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
