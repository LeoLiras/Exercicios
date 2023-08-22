package secao4;

public class ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float num1 = 3.25f, num2 = 3.25f;
		
		if(num1 > num2) {
			System.out.println(num1 + " é maior que " + num2);
			System.out.println("Diferença: " + (num1 - num2));
		}else if(num2 > num1) {
			System.out.println(num2 + " é maior que " + num1);
			System.out.println("Diferença: " + (num2 - num1));
		}else {
			System.out.println("Os números são iguais");
		}
	}

}
