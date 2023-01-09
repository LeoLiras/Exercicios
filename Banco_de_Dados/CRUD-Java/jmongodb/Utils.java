package jmongodb;

import java.util.Arrays;
import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class Utils {
	
	static Scanner teclado = new Scanner(System.in);
	
	public static MongoCollection<Document> conectar() {
		try {
			MongoClient conection =  (MongoClient) MongoClients.create(
					MongoClientSettings.builder()
						.applyToClusterSettings(builder -> 
						builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
						.build());
			
			MongoDatabase database = conection.getDatabase("jmongo");
			MongoCollection<Document> collection = database.getCollection("produtos");
			
			return collection;
		}catch(Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	public static void desconectar() {
		System.out.println("Desconectando...");
	}
	
	public static void listar() {
		MongoCollection<Document> collection = conectar();
		
		if(collection.countDocuments() > 0) {
			MongoCursor<Document> cursor = collection.find().iterator();
			
			try {
				System.out.println("============= Produtos =============");
				System.out.println("_________________________________________");
				
				while(cursor.hasNext()) {
					String json = cursor.next().toJson();
					
					JSONObject obj = new JSONObject(json);
					JSONObject id = obj.getJSONObject("_id");
					
					System.out.println("\nID: " + id.get("$oid"));
					System.out.println("Produto: " + obj.get("nome"));
					System.out.println("Preço: " + obj.get("preco"));
					System.out.println("Estoque: " + obj.get("estoque"));
					System.out.println("______________________________________\n");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			cursor.close();
			
		}else {
			System.out.println("Ainda não há documentos cadastrados.");
		}
		
		menu();
	}
	
	public static void inserir() {
		
		try {
			MongoCollection<Document> collection = conectar();
			
			teclado.nextLine();
			System.out.println("Informe o nome do produto: ");
			String nome = teclado.nextLine();
			System.out.println("Informe o preço do produto: ");
			float preco = teclado.nextFloat();
			System.out.println("Informe a quantidade em estoque do produto: ");
			int estoque = teclado.nextInt();
			
			JSONObject produto = new JSONObject();
			produto.put("nome", nome);
			produto.put("preco", preco);
			produto.put("estoque", estoque);
			
			collection.insertOne(Document.parse(produto.toString()));
			
			System.out.println("\nO produto " + nome + " foi inserido com sucesso\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void atualizar() {
		try {
			MongoCollection<Document> collection = conectar();
			
			System.out.println("Insira o ID do produto: ");
			String _id = teclado.nextLine();
			System.out.println("Insira o novo nome do produto: ");
			String nome = teclado.nextLine();
			System.out.println("Insira o novo preço do produto: ");
			float preco = teclado.nextFloat();
			System.out.println("Insira a nova quantidade em estoque do produto: ");
			int estoque = teclado.nextInt();
			
			Bson query = combine(set("nome", nome), set("preco", preco), set("estoque", estoque));
			
			UpdateResult res = collection.updateOne(new Document("_id", new ObjectId(_id)), query);
			
			if(res.getModifiedCount() == 1) {
				System.out.println("\nProduto" + nome + " atualizado com sucesso.\n");
			}else {
				System.out.println("Não foi possível atualizar o produto.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deletar() {
		MongoCollection<Document> collection = conectar();
		
		try {
			System.out.println("Insira o ID do produto a ser deletado: ");
			String _id = teclado.nextLine();
			
			DeleteResult del = collection.deleteOne(new Document("_id", new ObjectId(_id)));
			
			if(del.getDeletedCount() == 1) {
				System.out.println("Produto excluído com sucesso.");
			}else {
				System.out.println("Não foi possível excluir o produto.");
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
