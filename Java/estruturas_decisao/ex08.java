package secao4;

public class ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float nota1 = 11f, nota2 = 80f;
		
		if(nota1 >= 0 && nota1 <= 10) {
			if(nota2 >=0 && nota2 <= 10) {
				float media = (nota1 + nota2) / 2;
				System.out.println("Média: " + media);
			}else {
				System.out.println("Nota 2: " + nota2 + " inválida");
			}
		}else {
			System.out.println("Nota 1: " + nota1 + " inválida");
		}
	}

}
