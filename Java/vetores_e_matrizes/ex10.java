package secao7;

public class ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float notas[] = {7.4f, 6.5f, 8.9f, 10f, 5.6f};
		float soma = 0, media;
		
		for(int i = 0; i < notas.length; i++) {
			soma += notas[i];
		}
		
		media = soma / notas.length;
		
		System.out.println("Média geral: " + media);
	}

}
