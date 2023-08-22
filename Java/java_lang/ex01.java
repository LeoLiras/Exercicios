package secao18_Java_Lang;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		String texto = "";
		int sair = 1;
		
		try {
			PrintStream arquivo = new PrintStream(new FileOutputStream("arq2.txt", true));
			
			while(texto.equals("0") == false){
				System.out.println("Escreva o texto ou 0 para sair: ");
				texto = teclado.nextLine();
				
				if(texto.equals("0") == true) {
					break;
				}
				arquivo.println(texto);	
			}
			
			
			
			arquivo.close();
			
		}catch(FileNotFoundException e){
			System.out.println("Não foi possível criar o arquivo.");
		}
		
		try {
			Scanner ler = new Scanner(new FileInputStream("arq2.txt"));
			
			while(ler.hasNextLine()) {
				String linha = ler.nextLine();
				System.out.println(linha);
			}
		}catch(FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
		
	}

}
