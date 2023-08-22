package secao5;

public class ex31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numerador = 1, denominador = 1;
		float soma = 0;
		
		while(numerador <= 99) {
			soma =+ numerador / denominador;
			numerador += 2;
			denominador++;
		}
		
		System.out.println("S = " + soma);
		System.out.println("Último numerador: " + numerador);
		System.out.println("Último denominador: " + denominador);
	}

}
