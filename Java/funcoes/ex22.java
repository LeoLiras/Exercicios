package secao8;

public class ex22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		
		imprimir(n);
	}

	static void imprimir(int n) {
		int aux1 = 0, aux2 = 1;
		
		while(aux2 != (n + 1)) {
			System.out.print("!");
			aux1++;
			
			if(aux1 == aux2) {
				System.out.print("\n");
				aux2++;
				aux1 = 0;
			}
		}
	}
}
