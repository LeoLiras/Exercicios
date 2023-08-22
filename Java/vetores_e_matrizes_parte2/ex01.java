package secao7parte2;

public class ex01 {
	public static void main(String[] args) {
		int matriz[][] = new int [4][4];
		int contador = 0;
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) Math.round(Math.random() * 20);
				
				if(matriz[i][j] > 10) {
					System.out.println("Elemento maior que 10: " + matriz[i][j]);
					System.out.println("Linha: " + i);
					System.out.println("Coluna: " + j + "\n");
					contador++;
				}
			}
		}
		System.out.println("\n\nTotal de valores maiores que 10: " + contador);
	}
}
