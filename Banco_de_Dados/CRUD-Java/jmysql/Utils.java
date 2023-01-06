package jmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Utils {
	
	static Scanner teclado = new Scanner(System.in);
	/**
	 * Realiza a conexão com o servidor.
	 * É necessário um driver de conexão para se conectar ao servidor do database. O driver utilizado foi obtido no próprio site do MySQL e está disponível no package 'libs' do projeto.
	 * @return Conexão
	 */
	public static Connection conectar() {
		//Definindo classe do driver, o usuário e a senha do database, além da url do servidor.
		String CLASSE_DRIVER = "com.mysql.cj.jdbc.Driver";
		String USUARIO = "estudos";
		String SENHA = "root123";
		String URL_SERVIDOR = "jdbc:mysql://localhost:3306/jmysql?useSSL=false";
		
		//Tratamento de exceções.
		try {
			Class.forName(CLASSE_DRIVER);
			return DriverManager.getConnection(URL_SERVIDOR, USUARIO, SENHA);
		}catch(Exception e) {
			if(e instanceof ClassNotFoundException) {
				System.out.println("\nVerifique o driver de conexão.\n");
			}else {
				System.out.println("\nVerifique se o servidor está ativo.\n");
			}
			System.exit(-1);
			return null;
		}
	}
	
	/**
	 * Realiza a desconexão com o servidor.
	 * @param Conexão
	 */
	public static void desconectar(Connection con) {
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				System.out.println("Não foi possível desconectar");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Lista todos os dados já inseridos no database.
	 */
	public static void listar() {
		//Código SQL de busca em formato de string.
		String BUSCAR_TODOS = "SELECT * FROM produtos";
		
		//Tratamento de exceções.
		try {
			//Realiza a conexão.
			Connection con = conectar();
			//Preparando para exutar o código.
			PreparedStatement produtos = con.prepareStatement(BUSCAR_TODOS, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet resultado = produtos.executeQuery();
			
			//Vai para o final da lista e pega o número da linha do último item, eprmitindo saber quantos elementos têm no database.
			resultado.last();
			int qnt = resultado.getRow();
			resultado.beforeFirst();
			
			//Se houverem dados no database, printa todos eles no console.
			if(qnt > 0) {
				while(resultado.next()) {
					//ResultSet começa a contagem em 1 e não em 0.
					System.out.println("\nID: " + resultado.getInt(1));
					System.out.println("Nome: " + resultado.getString(2));
					System.out.println("Preço: " + resultado.getFloat(3));
					System.out.println("Estoque: " + resultado.getInt(4));
					System.out.println("_____________________________________________\n");
				}
			}else {
				System.out.println("\nAinda não há produtos cadastrados.\n");
				
				menu();
			}
			produtos.close();
			desconectar(con);
			
			menu();
			
		}catch(Exception e) {
			System.err.println("Erro listando produtos");
			System.out.println(e);
			System.exit(-1);
			
			menu();
		}
	}
	
	/**
	 * Insere novos dados no database.
	 */
	public static void inserir() {
		//Recebendo as informações dos novos dados.
		System.out.println("\nInforme o nome do produto: ");
		String nome = teclado.next();
		System.out.println("Informe o preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Informe a quantidade em estoque do produto: ");
		int estoque = teclado.nextInt();
		
		//Tratanto SQLInjection, evitando que usuários mal intencionados danifiquem o sistema.
		String INSERIR = "INSERT INTO produtos (nome, preco, estoque) VALUES (?, ?, ?)";
		
		try {
			//Realiza a conexão.
			Connection con = conectar();
			//Preparando para inserir os dados.
			PreparedStatement registrar = con.prepareStatement(INSERIR);
			
			//Inserindo os dados.
			registrar.setString(1, nome);
			registrar.setFloat(2, preco);
			registrar.setInt(3, estoque);
			registrar.executeUpdate();
			registrar.close();
			
			System.out.println("\nProduto " + nome + " registrado com sucesso.\n");
			
			//Desconectando.
			desconectar(con);
			
			menu();
			
		}catch(Exception e) {
			System.err.println("\nErro detectado.\n");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	/**
	 * Permite atualizar as informações de dados que já existem no database.
	 */
	public static void atualizar() {
		System.out.println("Informe o código do produto: ");
		int id = Integer.parseInt(teclado.nextLine());
		
		//Código de busca SQL no formato de String.
		String BUSCAR_POR_ID = "SELECT * FROM produtos WHERE id=?";
		
		//Tratando SQLInjection.
		try {
			//Realiza a conexão.
			Connection con = conectar();
			//Preparando para atualizar os dados.
			PreparedStatement produto = con.prepareStatement(BUSCAR_POR_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
			produto.setInt(1, id);
			ResultSet resultado = produto.executeQuery();
			
			//Vai para o último ítem do database e pega o número da linha, indicando se há ou não dados.
			resultado.last();
			int qntd = resultado.getRow();
			resultado.beforeFirst();
			
			//Se houver dados, recebe as informações para atualizar o dado com o ID inserido.
			if(qntd > 0) {
				System.out.println("\nInforme o novo nome do produto: ");
				String nome = teclado.nextLine();
				System.out.println("Informe o novo preço do produto: ");
				float preco = teclado.nextFloat();
				System.out.println("Informe a nova quantidade em estoque do produto: ");
				int estoque = teclado.nextInt();
				
				//String SQL de atualização de dados. IMPORTANTE: Não esquecer do filtro com WHERE!!
				String ATUALIZAR = "UPDATE produtos set nome=?, preco=?, estoque=? WHERE id=?";
				PreparedStatement update = con.prepareStatement(ATUALIZAR);
				
				//Realizando a atualização.
				update.setString(1, nome);
				update.setFloat(2, preco);
				update.setInt(3, estoque);
				update.setInt(4, id);
				
				update.executeUpdate();
				update.close();
				
				desconectar(con);
				
				System.out.println("Produto " + nome + " atualizado com sucesso.");
			}else {
				System.out.println("Não há produto registrado com este ID.");
				
				menu();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Erro ao atualizar produto");
			System.exit(-1);
			
			menu();
		}
	}
	
	/**
	 * Permite deletar dados do database.
	 */
	public static void deletar() {
		//Código SQL que permite deletar dados.
		String DELETAR = "DELETE FROM produtos WHERE id=?";
		//Código SQL de busca.
		String BUSCAR_POR_ID = "SELECT * FROM produtos WHERE id=?";
		
		//Recebendo o ID do produto a ser deletado.
		System.out.println("Informe o ID do produto: ");
		int id = Integer.parseInt(teclado.nextLine());
		
		//Tratamento de exceções.
		try {
			//SQLInjection.
			Connection con = conectar();
			
			PreparedStatement produto = con.prepareStatement(BUSCAR_POR_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			produto.setInt(1, id);
			ResultSet resultado = produto.executeQuery();
			
			resultado.last();
			int qntd = resultado.getRow();
			resultado.beforeFirst();
			
			if(qntd > 0) {
				//Preparando para deletar.
				PreparedStatement deletar = con.prepareStatement(DELETAR);
				
				//Deletando dado.
				deletar.setInt(1, id);
				deletar.executeUpdate();
				deletar.close();
				
				desconectar(con);
				
				System.out.println("Produto " + id + " deletado com sucesso");
				
				menu();
			}else {
				System.out.println("Não há produto registrado com esse ID.");
				
				menu();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println("Erro ao deletar produto");
			System.exit(-1);
			
			menu();
		}
	}
	
	/**
	 * Menu do console para chamar os métodos da aplicação e interagir com o database.
	 */
	public static void menu() {
		System.out.println("==================Gerenciamento de Produtos MySQL===============");
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
