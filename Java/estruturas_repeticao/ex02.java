package secao5;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valor = 1;
		
		System.out.println("While-----------------------------------------------------------------------------");
		while(valor <= 100) {
			System.out.println(valor);
			valor++;
		}
		
		valor = 1;
		System.out.println("do While ------------------------------------------------------------------------------");
		
		do {
			System.out.println(valor);
			valor++;
		}while(valor <= 100);
		
		valor = 1;
		System.out.println("For ------------------------------------------------------------------------------");
		
		for(int i = valor; i <= 100; i++) {
			System.out.println(i);
		}
	}

}
