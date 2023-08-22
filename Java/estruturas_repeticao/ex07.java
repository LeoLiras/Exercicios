package secao5;

import java.util.Scanner;

public class ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valor;
		int soma = 0, media;
		
		Scanner teclado = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
			System.out.println("Insira um valor positivo " + (i + 1) + "/5: ");
			valor = teclado.nextInt();
			
			if(valor > 0) {
				soma += valor;
			}	
		}
		
		media = soma / 5;
		
		System.out.println("A média dos valores positivos inseridos é: " + media);
		System.out.println("Valores negativos ignorados");
		
		teclado.close();
	}

}
