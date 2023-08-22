package secao5;

import java.util.Scanner;

public class ex27rever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,aux1 = 1, aux2 = 1;
		float harmonico = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Insira um valor inteiro: ");
		n = teclado.nextInt();
		
		for(int i = aux2; i <= n; i++) {
			harmonico += (aux1 / aux2);
			aux2++;
		}
		
		System.out.println("Harmônico: " + harmonico);
		teclado.close();
	}

}
