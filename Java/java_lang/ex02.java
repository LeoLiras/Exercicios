package secao18_Java_Lang;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner ler = new Scanner(new FileInputStream("arq2.txt"));
			int contador = 0;
			
			while(ler.hasNextLine()) {
				String linha = ler.nextLine();
				System.out.println(linha);
				contador++;
			}
			
			System.out.println("O texto tem " + contador + " linhas.");
		}catch(FileNotFoundException e) {
			
		}
	}

}
