package secao5;

public class ex19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero = 974912389;
		String strNum = Integer.toString(numero);
		
		for(char digito : strNum.toCharArray()) {
			System.out.print(digito + "-");
		}
	}

}
