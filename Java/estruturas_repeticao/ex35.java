package secao5;

import java.util.Scanner;

public class ex35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		
		int valor_inicial, valor_final, soma = 0;
		
		System.out.println("Insira o valor inicial do intervalo: ");
		valor_inicial = teclado.nextInt();
		System.out.println("Insira o valor final do intervalo: ");
		valor_final = teclado.nextInt();
		
		if(valor_inicial < valor_final) {
			for(int i = valor_inicial; i <= valor_final; i++) {
				if(i %2 == 1) {
					soma += i;
				}
			}
		}else {
			System.out.println("Intervalo inválido. O valor inicial deve ser menor que o valor final");
		}
		System.out.println("Soma dos valores ímpares do intervalo: " + soma);
		teclado.close();
	}

}
