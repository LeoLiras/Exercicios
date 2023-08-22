package secao8;

public class ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero = 0;
		
		System.out.println(verificar(numero));
	}
	
	static int verificar(int numero) {
		if(numero > 0) {
			return 1;
		}else if(numero < 0) {
			return -1;
		}else {
			return 0;
		}
	}

}
