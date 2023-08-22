package secao7parte2;

public class ex13rever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matriz[][] = new int [4][4];
		int soma = 0;
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) Math.round(Math.random() * 20);
			}
		}
		
		for(int i = 0; i < (matriz.length - 1); i++) {
			for(int j = 1; j < matriz[i].length; j++) {
				if(j != i && i != 2 && j != 1) {
					soma += matriz[i][j];
				}
			}
		}
		System.out.println("Soma dos valores acima da diagonal principal: " + soma);
		
		for(int i = 0; i < matriz.length; i++) {
			System.out.print("\n");
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "  ");
			}
		}
	}
}
