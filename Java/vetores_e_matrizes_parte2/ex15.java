package secao7parte2;

import java.util.Random;

public class ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char respostas[] = {'A', 'C', 'B', 'D', 'A'};
		char matriz[][] = new char[5][5];
		
		int contador = 0;
		int acertos[] = new int[5];
		
		Random resposta = new Random();
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				char aluno_resposta = (char)(resposta.nextInt((68 - 65) +1) + 65);
				matriz[i][j] = aluno_resposta;
			}
		}
		for(int k = 0; k < matriz.length; k++) {
			System.out.print("\n");
			for(int l = 0; l < matriz[k].length; l++) {
				System.out.print(matriz[k][l] + " ");
			}
			
			for(int i = 0; i < matriz.length; i++) {
				contador = 0;
				for(int j = 0; j < matriz[i].length; j++) {
					if(matriz[i][j] == respostas[j]){
						contador++;
					}
				}
				acertos[i] = contador;
			}
		}
		
		System.out.println("\n\nAcertos: ");
		for(int i = 0; i < acertos.length; i++) {
			System.out.print(acertos[i] + " - ");
		}
	}

}
