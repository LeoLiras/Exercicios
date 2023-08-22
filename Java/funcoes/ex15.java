package secao8;

public class ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 50, b = 3, c = 5;
		
		if(a > 0 && b > 0 && c > 0) {
			if(triangulo(a, b, c) == 1) {				
				System.out.println(tipoTriangulo(a, b, c));
			}
		}else {
			System.out.println("Valores devem ser maiores que 0.");
		}
	}
	
	static int triangulo(int a, int b, int c) {
		int retorno = 0;
		
		if(a < (b + c) && b < (a + c) && c < (a + b)) {
			System.out.println("É um triângulo");
			retorno = 1;
		}else {
			System.out.println("Não é um triângulo");
			retorno = -1;
		}
		
		return retorno;
	}
	
	static String tipoTriangulo(int a, int b, int c) {
		String tipo = "";
		if(a == b && b == c) {
			tipo = "Equilátero";
		}else if(a == b || b == c || a == c) {
			tipo = "Isósceles";
		}else {
			tipo = "Escaleno";
		}
		
		return "Triângulo " + tipo;
	}

}
