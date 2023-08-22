package secao7parte2;

public class ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matriz[][] = new int [4][4];
		int maior = -99999, linha = 0, coluna = 0;
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) Math.round(Math.random() * 20);
				if(matriz[i][j] > maior) {
					maior = matriz[i][j];
					linha = i;
					coluna = j;
				}
			}
		}
		System.out.println("Maior valor da matriz: " + maior);
		System.out.println("Linha: " + linha);
		System.out.println("Coluna: " + coluna + "\n");
		
		for(int i = 0; i < matriz.length; i++) {
			System.out.print("\n");
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "  ");
			}
		}
	}
}
