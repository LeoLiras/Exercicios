package secao7;

public class ex28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int v1[] = new int[10];
		int v2[] = new int[10];
		int contador_v1 = 0, contador_v2 = 0;
		
		for(int i = 0; i < vetor.length; i++) {
			if(vetor[i] %2 == 0) {
				v2[contador_v2] = vetor[i];
				contador_v2++;
			}else {
				v1[contador_v1] = vetor[i];
				contador_v1++;
			}
		}
		
		System.out.println("Valores ímpares: ");
		for(int i = 0; i < contador_v1; i++) {
			System.out.print(v1[i] + " - ");
		}
		
		System.out.println("\n\nValores pares: ");
		for(int i = 0; i < contador_v2; i++) {
			System.out.print(v2[i] + " - ");
		}
	}

}
