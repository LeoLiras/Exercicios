package secao5;

import java.util.Random;
import java.util.Scanner;

public class ex46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, jogada = 9000, contador = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		Random numero = new Random();
		num = numero.nextInt(1001);
		
		do {
			contador++;
			
			System.out.println("Insira um valor: ");
			jogada = teclado.nextInt();
			
			if(jogada > num) {
				System.out.println("Chute mais baixo");
			}else if(jogada < num) {
				System.out.println("Chute mais alto");
			}else if(jogada == num) {
				System.out.println("Voce acertou!!");
				System.out.println("Total de jogadas realizadas: " + contador);
			}	
		}while(jogada != num);
		
		teclado.close();
	}

}
