package secao8;

public class ex40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vetor[] = {2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		pares(vetor);
	}

	static void pares(int[] vetor) {
		int contador = 0;
		
		for(int i = 0; i < vetor.length; i++) {
			if(vetor[i] %2 == 0) {
				contador++;
			}
		}
		System.out.println("O vetor possui " + contador + " valores pares.");
	}
}
