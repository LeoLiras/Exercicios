package jsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Utils {
	
	static Scanner teclado = new Scanner(System.in);
	
	public static Connection conectar() {
		String URL_SERVIDOR = "jdbc:sqlite:src/jsqlite/jsqlite.estudos";
		
		try {
			Connection con = DriverManager.getConnection(URL_SERVIDOR);
			
			String TABLE = "CREATE IF NOT EXISTS produtos("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "nome TEXT NOT NULL,"
					+ "preco REAL NOT NULL,"
					+ "estoque INTEGER NOT NULL);";
			
			Statement start = con.createStatement();
			start.executeUpdate(TABLE);
			
			return con;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void desconectar(Connection con) {
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void listar() {
		String BUSCAR_TODOS = "SELECT * FROM produtos";
		
		try {
			Connection con = conectar();
			
			PreparedStatement produtos = con.prepareStatement(BUSCAR_TODOS);
			ResultSet resultado = produtos.executeQuery();
			
			System.out.println("\n=================Produtos==================\n");
			
			while(resultado.next()) {
				System.out.println("ID: " + resultado.getInt(1));
				System.out.println("Produto: " + resultado.getString(2));
				System.out.println("Preço: " + resultado.getFloat(3));
				System.out.println("Estoque" + resultado.getInt(4));
				System.out.println("_________________________________________\n");
			}
			
			menu();
			
		}catch(Exception e) {
			e.printStackTrace();
			menu();
		}
	}
	
	public static void inserir() {
		System.out.println("Insira o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Insira o estoque do produto: ");
		int estoque = teclado.nextInt();
		
		String INSERIR = "INSERT INTO produtos (nome, preco, estoque) VALUES (?, ?, ?)";
		
		try {
			Connection con = conectar();
			
			PreparedStatement inserir = con.prepareStatement(INSERIR);
			
			inserir.setString(1, nome);
			inserir.setFloat(2, preco);
			inserir.setInt(3, estoque);
			
			int qntd = inserir.executeUpdate();
			
			if(qntd > 0) {
				System.out.println("\nProduto " + nome + " inserido com sucesso.\n");
			}else {
				System.out.println("\nFalha ao inserir o produto.\n");
			}
			
			inserir.close();
			desconectar(con);
			menu();
			
		}catch(Exception e) {
			e.printStackTrace();
			menu();
		}
	}
	
	public static void atualizar() {
		System.out.println("Insira o ID do produto: ");
		int id = Integer.parseInt(teclado.nextLine());
		
		try {
			Connection con = conectar();
			
			System.out.println("Insira o novo nome do produto: ");
			String nome = teclado.nextLine();
			System.out.println("Insira o novo preço do produto: ");
			float preco = teclado.nextFloat();
			System.out.println("Insira a nova quantidade em estoque do produto: ");
			int estoque = teclado.nextInt();
			
			String ATUALIZAR = "UPDATE produtos SET nome=?, preco=?, estoque=? WHERE id=?";
			
			PreparedStatement atualizar = con.prepareStatement(ATUALIZAR);
			
			atualizar.setString(1, nome);
			atualizar.setFloat(2, preco);
			atualizar.setInt(3, estoque);
			atualizar.setInt(4, id);
			
			int qntd = atualizar.executeUpdate();
			
			if(qntd > 0) {
				System.out.println("\nProduto atualizado com sucesso.\n");
			}else {
				System.out.println("\nFalha ao atualizar o produto.\n");
			}
			
			atualizar.close();
			desconectar(con);
			
		}catch(Exception e) {
			e.printStackTrace();
			menu();
		}
	}
	
	public static void deletar() {
		System.out.println("Insira o ID do produto a ser deletado");
		int id = Integer.parseInt(teclado.nextLine());
		
		String DELETAR = "DELETE FROM produtos WHERE id=?";
		
		try {
			Connection con = conectar();
			
			PreparedStatement deletar = con.prepareStatement(DELETAR);
			
			deletar.setInt(1, id);
			
			int qntd = deletar.executeUpdate();
			System.out.println(qntd);
			
			if(qntd > 0) {
				System.out.println("\nProduto deletado com sucesso.\n");
			}else {
				System.out.println("\nNão foi possível deletar o produto.\n");
			}
			
			deletar.close();
			desconectar(con);
			menu();
			
		}catch(Exception e) {
			e.printStackTrace();
			menu();
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
