package secao4;

public class ex23rever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ano = 1988;
		
		if(ano %400 == 0) {
			System.out.println("Ano bissexto");
		}else if(ano %4 == 0 && ano %100 == 1) {
			System.out.println("Ano bissexto");
		}else {
			System.out.println("Ano não bissexto");
		}
		System.out.println(ano);
	}

}
