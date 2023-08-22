package secao18_Java_Lang;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		String texto = " ";
		
		try {
			PrintStream telefones = new PrintStream(new FileOutputStream("telefones.txt", true));
			
			while(texto.equals("0") == false) {
				System.out.println("Insira o nome da pessoa ou 0 para sair: ");
				texto = teclado.nextLine();
				
				if(texto.equals("0") == true) {
					break;
				}
				
				telefones.print(texto + " - ");
				
				System.out.println("Insira o número de telefone da pessoa: ");
				texto = teclado.nextLine();
				
				telefones.println(texto);
			}
			
		}catch(FileNotFoundException e) {
			
		}
	}

}
