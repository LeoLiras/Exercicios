package secao7;

public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int quadrados[] = new int[10];
		
		for(int i = 0; i < numeros.length; i++) {
			quadrados[i] = (int)Math.pow(numeros[i], 2);
			System.out.println(numeros[i] + " ao quadrado é: " + quadrados[i]);
		}
	}

}
