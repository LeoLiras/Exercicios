package secao5;

public class ex21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valor1 = 1, valor2 = 5, soma_pares = 0, multi_impares = 1;
		
		if(valor1 > valor2) {
			for(int i = valor1; i <= valor2; i++) {
				if(i %2 == 0) {
					soma_pares += i;
				}else {
					multi_impares *= i;
				}
			}
		}else if(valor2 > valor1) {
			for(int i = valor2; i >= valor1; i--) {
				if(i %2 == 0) {
					soma_pares += i;
				}else {
					multi_impares *= i;
				}
			}
		}
		System.out.println("Soma dos valores pares: " + soma_pares);
		System.out.println("Multiplicação dos valores ímpares: " + multi_impares);
	}
}
