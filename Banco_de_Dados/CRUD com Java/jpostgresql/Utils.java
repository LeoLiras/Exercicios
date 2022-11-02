package jpostgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class Utils {
	
	static Scanner teclado = new Scanner(System.in);
	
	public static Connection conectar() {
		Properties pro = new Properties();
		pro.setProperty("user", "estudos");
		pro.setProperty("password", "root123");
		pro.setProperty("ssl", "false");
		
		String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/jpostgresql";
		
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
	
	public static void desconectar(Connection con) {
		if(con != null) {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void listar() {
		String BUSCAR_TODOS = "SELECT * FROM produtos";
		
		try {
			Connection con = conectar();
			
			PreparedStatement produtos = con.prepareStatement(BUSCAR_TODOS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultado = produtos.executeQuery();
			
			resultado.last();
			int qntd = resultado.getRow();
			resultado.beforeFirst();
			
			if(qntd > 0) {
				while(resultado.next()) {
					System.out.println("Produtos: ");
					System.out.println("==============================");
					
					System.out.println("ID: " + resultado.getInt(1));
					System.out.println("Produto " + resultado.getString(2));
					System.out.println("Preço: " + resultado.getFloat(3));
					System.out.println("Estoque: " + resultado.getInt(4));
					System.out.println("_____________________________________________");	
					
					menu();
				}
				
			}else {
				System.out.println("Não há produtos cadastrados.");
				
				menu();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void inserir() {
		System.out.println("Insira o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Insira a quantidade em estoque do produto: ");
		int estoque = teclado.nextInt();
		
		String INSERIR = "INSERT INTO produtos (nome, preco, estoque) VALUES (?, ?, ?)";
		
		try {
			Connection con = conectar();
			
			PreparedStatement inserir = con.prepareStatement(INSERIR);
			
			inserir.setString(1, nome);
			inserir.setFloat(2, preco);
			inserir.setInt(3, estoque);
			inserir.executeUpdate();
			
			System.out.println("Produto " + nome + " inserido com sucesso.");
			
			menu();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void atualizar() {
		System.out.println("Informe o código do produto: ");
		int id = Integer.parseInt(teclado.nextLine());
		
		String BUSCAR_POR_ID = "SELECT * FROM produtos WHERE id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement produto = con.prepareStatement(BUSCAR_POR_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			produto.setInt(1, id);
			ResultSet resultado = produto.executeQuery();
			
			resultado.last();
			int qntd = resultado.getRow();
			resultado.beforeFirst();
			
			if(qntd > 0) {
				System.out.println("Informe o nome do produto: ");
				String nome = teclado.nextLine();
				System.out.println("Informe o preço do produto: ");
				float preco = teclado.nextFloat();
				System.out.println("Informe a quantidade em estoque do produto: ");
				int estoque = teclado.nextInt();
				
				String ATUALIZAR = "UPDATE produtos set nome=?, preco=?, estoque=? WHERE id=?";
				PreparedStatement update = con.prepareStatement(ATUALIZAR);
				
				update.setString(1, nome);
				update.setFloat(2, preco);
				update.setInt(3, estoque);
				update.setInt(4, id);
				
				update.executeUpdate();
				update.close();
				
				desconectar(con);
				
				System.out.println("Produto " + nome + " atualizado com sucesso.");
				
				menu();
			}else {
				System.out.println("Não há produto registrado com este ID.");
				
				menu();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
			menu();
		}
	}
	
	public static void deletar() {
		String DELETAR = "DELETE FROM produtos WHERE id=?";
		String BUSCAR_POR_ID = "SELECT * FROM produtos WHERE id=?";
		
		System.out.println("Informe o ID do produto: ");
		int id = teclado.nextInt();
		
		try {
			Connection con = conectar();
			
			PreparedStatement produto = con.prepareStatement(BUSCAR_POR_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			produto.setInt(1, id);
			ResultSet resultado = produto.executeQuery();
			
			resultado.last();
			int qntd = resultado.getRow();
			resultado.beforeFirst();
			
			if(qntd > 0) {
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
	
	public static void menu() {
		System.out.println("==================Gerenciamento de Produtos===============");
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
