package secao18_Java_Lang;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex03_ex04 {
	public static void main(String[] args) {
		try {
			Scanner ler = new Scanner(new FileInputStream("arq2.txt"));
			int contador_vogais = 0, contador_consoantes = 0;
			
			while(ler.hasNextLine()) {
				String linha = ler.nextLine();
				linha = linha.toLowerCase();
				
				for(int i = 0; i < linha.length(); i++) {
					if(linha.charAt(i) == 'a' || linha.charAt(i) == 'e' || linha.charAt(i) == 'i' || linha.charAt(i) == 'o' || linha.charAt(i) == 'u') {
						contador_vogais++;
					}else if(linha.charAt(i) != ' ' && linha.charAt(i) != '?' && linha.charAt(i) != ',') {
						contador_consoantes++;
					}
				}
			}
			
			System.out.println("O texto tem " + contador_vogais + " vogais.");
			System.out.println("O texto tem " + contador_consoantes + " consoantes.");
			
		}catch(FileNotFoundException e) {
			
		}
	}
}
