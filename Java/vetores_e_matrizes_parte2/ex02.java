package secao7parte2;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matriz[][] = new int[5][5];
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				if(i == j) {
					matriz[i][j] = 1;
				}else {
					matriz[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < matriz.length; i++) {
			System.out.print("\n");
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
		}
	}

}
