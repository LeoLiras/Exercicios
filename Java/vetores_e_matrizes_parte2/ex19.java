package secao7parte2;

public class ex19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float matriz[][] = new float[5][4];
		float maior = -99;
		
		int matricula_maior = 0, media_geral = 0, soma = 0;
		
		for(int i = 0; i < matriz.length; i++) {
			int j = 0;
			matriz[i][j] = i;
		}
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 1; j < matriz[i].length - 1; j++) {
				matriz[i][j] = (float) Math.random() * 10;
			}
			matriz[i][3] = matriz[i][1] + matriz[i][2];
			if(matriz[i][3] > maior) {
				maior = matriz[i][3];
				matricula_maior = i;
			}
		}
		
		for(int i = 0; i < matriz.length; i++) {
			System.out.print("\n");
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "        ");
			}	
		}
		
		for(int i = 0; i < matriz.length; i++) {
			int j = 3;
			
			soma += matriz[i][j];
		}
		
		media_geral = soma / matriz.length;
		
		System.out.println("\n\nAluno com maior nota final: " + matricula_maior);
		System.out.println("Nota: " + maior);
		System.out.println("Media geral da sala: " + media_geral);
	}

}
