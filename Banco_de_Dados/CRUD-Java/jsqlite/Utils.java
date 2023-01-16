package jsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Utils {
	
	static Scanner teclado = new Scanner(System.in);
	
	//Assim como nos outros, foi utilizado um driver de conexão disponível no package 'libs' dp projeto.
	
	/**
	 * Realiza a conexão ao database
	 * @return Conexão
	 */
	public static Connection conectar() {
		//URL do database em formato de STRING.
		String URL_SERVIDOR = "jdbc:sqlite:src/jsqlite/jsqlite.estudos";
		
		//Tratamento de excessões.
		try {
			
			//Conexão com o database.
			Connection con = DriverManager.getConnection(URL_SERVIDOR);
			
			//Código SQL de criaçao de tabela.
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
	
	/**
	 * Realiza a desconexão do database.
	 * @param Conexão
	 */
	public static void desconectar(Connection con) {
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Lista todos os dados já inseridos no database.
	 */
	public static void listar() {
		//Código SQL de seleção de dados.
		String BUSCAR_TODOS = "SELECT * FROM produtos";
		
		//Tratamento de exceções.
		try {
			//Conexão
			Connection con = conectar();
			
			PreparedStatement produtos = con.prepareStatement(BUSCAR_TODOS);
			ResultSet resultado = produtos.executeQuery();
			
			//Printando os dados no console.
			System.out.println("\n=================Produtos==================\n");
			
			while(resultado.next()) {
				System.out.println("\nID: " + resultado.getInt(1));
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
	
	/**
	 * Insere novos dados no database.
	 */
	public static void inserir() {
		//Recebendo as características do dado a ser inserido.
		teclado.nextLine();
		System.out.println("Insira o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Insira o estoque do produto: ");
		int estoque = teclado.nextInt();
		
		//Código SQL de inserção de dados.
		String INSERIR = "INSERT INTO produtos (nome, preco, estoque) VALUES (?, ?, ?)";
		
		//Tratamento de exceções.
		try {
			//Conexão
			Connection con = conectar();
			
			PreparedStatement inserir = con.prepareStatement(INSERIR);
			
			inserir.setString(1, nome);
			inserir.setFloat(2, preco);
			inserir.setInt(3, estoque);
			
			//Retorna a quantidade de items inseridos. Assim, se o valor for maior que 1, significa que o item foi inserido com sucesso.
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
	
	/**
	 * Atualiza dados já existentes no database.
	 */
	public static void atualizar() {
		//Recebendo o ID do produto a ser atualizado.
		teclado.nextLine();
		System.out.println("Insira o ID do produto: ");
		int id = Integer.parseInt(teclado.nextLine());
		
		//Tratamento de excessões.
		try {
			//Conexão.
			Connection con = conectar();
			
			//Recebendo os novos valores atualisados do dado.
			System.out.println("Insira o novo nome do produto: ");
			String nome = teclado.nextLine();
			System.out.println("Insira o novo preço do produto: ");
			float preco = teclado.nextFloat();
			System.out.println("Insira a nova quantidade em estoque do produto: ");
			int estoque = teclado.nextInt();
			
			//Código SQL de UPDATE no formato de String.
			String ATUALIZAR = "UPDATE produtos SET nome=?, preco=?, estoque=? WHERE id=?";
			
			//Atualizando os dados.
			PreparedStatement atualizar = con.prepareStatement(ATUALIZAR);
			
			atualizar.setString(1, nome);
			atualizar.setFloat(2, preco);
			atualizar.setInt(3, estoque);
			atualizar.setInt(4, id);
			
			//Retorna a quantidade de itens atualizados. Assim, se a quantidade for maior que 1, então o dado foi atualizado com sucesso.
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
	
	/**
	 * Deleta dados do database.
	 */
	public static void deletar() {
		//Recebendo o ID do dado a ser deletado.
		teclado.nextLine();
		System.out.println("Insira o ID do produto a ser deletado");
		int id = Integer.parseInt(teclado.nextLine());
		
		//Código SQL de DELETE no formato de String.
		String DELETAR = "DELETE FROM produtos WHERE id=?";
		
		//Tratamento de excessões.
		try {
			//Conexão.
			Connection con = conectar();
			
			//Deletando o dado com o ID informado.
			PreparedStatement deletar = con.prepareStatement(DELETAR);
			
			deletar.setInt(1, id);
			
			//Retorna o número de itens deletados. Assim, se o valor for maior que 1, então o produto foi deletado com sucesso.
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
		System.out.println("==================Gerenciamento de Produtos SQLite===============");
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
