package secao4;

public class ex20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 8, b = 8, c = -8;
		
		if(a > 0 && b > 0 && c > 0) {
			if(a < (b + c) && b < (a + c) && c < (a + b)) {
				if(a == b && b == c) {
					System.out.println("Triângulo Equilátero");
				}else if(a == b || a == c || b == c) {
					System.out.println("Triângulo Isósceles");
				}else if( a != b && a !=c && b != c) {
					System.out.println("Triângulo Escaleno");
				}
			}
		}else {
			System.out.println("Não pode ser um triângulo");
		}
	}

}
