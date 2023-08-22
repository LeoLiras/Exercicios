package secao7;

import java.util.Scanner;

public class ex34bug {
	public static void main(String[] args) {
		int vetor[] = new int[5];
		int valor, contador = 1;
		
		Scanner teclado = new Scanner(System.in);
		
		while(contador <= 6) {
			System.out.println("Insira um valor inteiro " + contador + " /5: ");
			valor = teclado.nextInt();
			
			for(int i = 0; i < vetor.length; i++) {
				if(vetor[i] == valor) {
					System.out.println("Insira somente valores distintos.");
				}else {
					vetor[contador] = valor;
					contador++;
				}
			}
		}
		teclado.close();
	}
}
