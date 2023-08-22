package secao18_Java_Lang;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner ler1 = new Scanner(new FileInputStream("arq2.txt"));
			Scanner ler2 = new Scanner(new FileInputStream("arq3.txt"));
			
			PrintStream arquivo = new PrintStream(new FileOutputStream("arq4.txt", false));
			
			while(ler1.hasNextLine()) {
				String leitura = ler1.nextLine();
				arquivo.println(leitura);
			}
			
			arquivo.println("\n");
			
			while(ler2.hasNextLine()) {
				String leitura = ler2.nextLine();
				arquivo.println(leitura);
			}
		}catch(FileNotFoundException e) {
			
		}
	}

}
