package secao7;

public class ex20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vetor[] = new int [20];
		int pares[] = new int [20];
		int impares[] = new int [20];
		
		int contador_pares = 0, contador_impares = 0;
		
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) Math.round(Math.random() * 50);
			
			if(vetor[i] %2 == 0) {
				pares[contador_pares] = vetor[i];
				contador_pares++;
			}else {
				impares[contador_impares] = vetor[i];
				contador_impares++;
			}
		}
		System.out.println("Pares: ");
		
		for(int i = 0; i < pares.length; i++) {
			System.out.print(pares[i] + " ");
			
			if(i %2 == 0) {
				System.out.print("\n");
			}
		}
		
		System.out.println("\n\nÍmpares: ");
		
		for(int i = 0; i < impares.length; i++) {
			System.out.print(impares[i] + " ");
			
			if(i %2 == 0) {
				System.out.print("\n");
			}
		}
	}
}
