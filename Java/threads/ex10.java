package secao20;

import java.util.Scanner;

public class ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
			
		int valor;
		
		System.out.println("Insira um valor: ");
		valor = Integer.parseInt(teclado.nextLine());
		
		VerificaPar v1 = new VerificaPar(1, (valor / 2));
		VerificaPar v2 = new VerificaPar(((valor / 2)) + 1, valor);
		
		Thread t1 = new Thread(v1);
		Thread t2 = new Thread(v2);
		
		t1.start();
		t2.start();
	
	}

}
