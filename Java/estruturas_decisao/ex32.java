package secao4;

public class ex32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int qntd = 10;
		int id_produto = 106;
		
		switch(id_produto) {
		case 100:
			System.out.println("Cachorro quente");
			System.out.println("Total: " + (qntd * 1.2));
			break;
		case 106: 
			System.out.println("Refrigerante");
			System.out.println("Total: " + (qntd * 1.0));
			break;
		}
	}
}
