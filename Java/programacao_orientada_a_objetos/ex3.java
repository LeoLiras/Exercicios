package secao9;

public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int andar_atual = 0, pessoas = 4, andares = 5, capacidade = 5;
		
		Elevador e1 = new Elevador(capacidade, andares);
		
		e1.sobe(andar_atual, andares);
		e1.entra(pessoas);
	}

}
