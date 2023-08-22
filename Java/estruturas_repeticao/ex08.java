package secao5;

import java.util.Scanner;

public class ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maior = -9999, menor = 9999, valor;
		
		Scanner teclado = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
			System.out.println("Insira um valor: " + (i + 1) + " /5: ");
			valor = teclado.nextInt();
			
			if(valor > maior) {
				maior = valor;
			}
			if(valor < menor) {
				menor = valor;
			}
		}
		
		System.out.println("Maior valor lido: " + maior);
		System.out.println("Menor valor lido: " + menor);
		
		teclado.close();
	}

}
