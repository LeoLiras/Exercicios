package secao5;

import java.util.Scanner;

public class ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int soma = 0, valor;
		
		Scanner teclado = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
			System.out.println("Insira um valor " + (i + 1) + "/5: ");
			valor = teclado.nextInt();
			soma = soma + valor;
		}
		
		System.out.println("A soma dos valores inseridos é: " + soma);
		
		teclado.close();
	}

}
