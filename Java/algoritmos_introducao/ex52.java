package secao03;

public class ex52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float premio = 300000;
		float jogador1 = 3500, jogador2 = 1000, jogador3 = 5000;
		
		float total = jogador1 + jogador2 + jogador3;
		
		float p1 = jogador1 / total;
		float p2 = jogador2 / total;
		float p3 = jogador3 / total;
		
		System.out.println("Prêmio Jogador 1: " + (premio * p1));
		System.out.println("Prêmio Jogador 2: " + (premio * p2));
		System.out.println("Prêmio Jogador 3: " + (premio * p3));
		
		
	}

}
