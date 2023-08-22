package secao7;

public class ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vetor[] = {1, 2, 4, 6, 8, 2, 5, 6, 9, 8};
		
		for(int i = 0; i < vetor.length; i++) {
			for(int j = 0; j < vetor.length; j++) {
				if(vetor[i] ==  vetor[j] && i != j) {
					vetor[i] = 0;
				}
			}
		}
		
		for(int elemento : vetor) {
			System.out.println(elemento);
		}
	}

}
