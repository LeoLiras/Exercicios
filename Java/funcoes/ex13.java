package secao8;

public class ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valor1 = 4, valor2 = 7;
		char operacao = '+';
		
		System.out.println(conta(valor1, valor2, operacao));
	}
	
	static int conta(int val1, int val2, char operacao) {
		int res = 0;
		
		switch(operacao) {
		case '+':
			res = val1 + val2;
			break;
		case '*': 
			res = val1 * val2;
			break;
		}
		
		return res;
	}

}
