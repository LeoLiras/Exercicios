package secao5;

import java.util.Scanner;

public class ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valor, maior = -9999, contador = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			System.out.println("Insira um valor " + (i + 1) + "/10: ");
			valor = teclado.nextInt();
			
			if(valor > maior) {
				maior = valor;
				contador = 0;
				contador++;
			}else if(valor == maior) {
				contador++;
			}
		}
		
		System.out.println("Maior valor lido: " + maior);
		System.out.println("Quantidade de vezes que o maior valor foi lido: " + contador);
		
		teclado.close();
	}

}
