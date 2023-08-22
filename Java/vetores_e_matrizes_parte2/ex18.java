package secao7parte2;

import java.util.Scanner;

public class ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matriz[][] = new int[2][2];
		int soma = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.println("Insira um valor inteiro: ");
				matriz[i][j] = teclado.nextInt();
			}
		}
		for(int i = 0; i < matriz.length; i++) {
			soma = 0;
			for(int j = 0; j < matriz[i].length; j++) {
				soma += matriz[i][j];
			}
			System.out.println("Soma dos valores da linha " + i + ": " + soma);
		}
		for(int i = 0; i < matriz.length; i++) {
			System.out.print("\n");
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
		}
		teclado.close();
	}

}
