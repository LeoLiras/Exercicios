package secao5;

import java.util.Random;

public class ex32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int contador = 0, dado1, dado2;
		
		Random d1 = new Random();
		Random d2 = new Random();
		
		while(contador <= 1000) {
			dado1 = d1.nextInt(7);
			dado2 = d2.nextInt(7);
			
			if(dado1 > dado2) {
				System.out.println("d1 > d2");
			}else if(dado2 > dado1) {
				System.out.println("d1 < d2");
			}else if(dado1 == dado2) {
				System.out.println("d1 = d2");
			}
		}
	}

}
