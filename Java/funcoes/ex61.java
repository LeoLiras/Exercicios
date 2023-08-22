package secao8;

public class ex61 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String palavra1 = "roma";
		String palavra2 = "oi";
		
		compararAnagrama(palavra1, palavra2);
	}
	
	static void compararAnagrama(String p1, String p2) {
		int contador = 0;
		
		char array_p1[] = p1.toCharArray();
		char array_p2[] = p2.toCharArray();
		
		for(int i = 0; i < array_p1.length; i++) {
			System.out.print(array_p1[i] + " - ");
		}
		System.out.println("\n");
		for(int i = 0; i < array_p2.length; i++) {
			System.out.print(array_p2[i] + " - ");
		}
		
		for(int i = 0; i < array_p1.length; i++) {
			for(int j = 0; j < array_p2.length; j++) {
				if(array_p1[i] == array_p2[j]) {
					contador++;
				}
			}
		}
		
		System.out.println("\n");
		System.out.println(contador);
		
		if(contador == array_p1.length && contador == array_p2.length) {
			System.out.println("São anagramas.");
		}else {
			System.out.println("Não são anagramas.");
		}
	}

}
