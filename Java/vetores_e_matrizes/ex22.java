package secao7;

public class ex22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vetor1[] = {1, 3, 5, 7, 11, 13};
		int vetor2[] = {2, 4, 6, 8, 10, 12};
		int vetor3[] = new int[12];
		int contador1 = 0, contador2 = 0;
		
		for(int i = 0; i < vetor3.length; i++) {
			if(i %2 == 0) {
				vetor3[i] = vetor1[contador1];
				contador1++;
			}else {
				vetor3[i] = vetor2[contador2];
				contador2++;
			}
			System.out.println(vetor3[i]);
		}
	}

}
