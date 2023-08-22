package secao5;

import java.util.Scanner;

public class ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valor, contador_par = 0, contador = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		do{
			System.out.println("Informe um valor inteiro ou '1000' para sair: ");
			valor = teclado.nextInt();
			
			if(valor %2 == 0) {
				System.out.println(valor + " é par");
				contador_par++;
			}
			contador++;
		}while(valor != 1000);
		
		System.out.println("Total de valores lidos: " + contador);
		System.out.println("Total de valores pares lidos: " + contador_par);
		
		teclado.close();
		
	}

}
