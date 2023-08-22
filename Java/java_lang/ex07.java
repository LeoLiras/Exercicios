package secao18_Java_Lang;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner ler = new Scanner(new FileInputStream("arq2.txt"));
			PrintStream arquivo = new PrintStream(new FileOutputStream("arq3.txt", false));
			
			while(ler.hasNextLine()) {
				String linha = ler.nextLine();
				linha = linha.replace('a', '*');
				linha = linha.replace('e', '*');
				linha = linha.replace('i', '*');
				linha = linha.replace('o', '*');
				linha = linha.replace('u', '*');
				
				arquivo.println(linha);
			}
			
			
			
		}catch(FileNotFoundException e) {
			
		}
	}

}
