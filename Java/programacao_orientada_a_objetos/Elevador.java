package secao9;

public class Elevador {
	private int andar_atual; 
	private int	andares; 
	private int	capacidade; 
	private int	pessoas_presentes;
	
	public Elevador(int capacidade, int total_andares) {
		this.capacidade = capacidade;
		this.andares = total_andares;
	}
	
	public void entra(int pessoas) {
		pessoas++;
		
		if(pessoas > this.capacidade) {
			System.out.println("Limite de pessoas excedido.");
		}else {
			System.out.println("Pessoas no elevador: " + pessoas);
		}
	}
	
	public void sai(int pessoas) {
		if(pessoas > 0) {
			pessoas--;
			System.out.println("Pessos no elevador: " + pessoas);
		}else {
			System.out.println("Não há nenhuma pessoa no elevador");
		}
	}
	
	public void sobe(int andar_atual, int andares) {
		if(andar_atual < andares) {
			andar_atual++;
			System.out.println("Andar atual: " + andar_atual);
		}else {
			System.out.println("Elevador está no último andar.");
		}
	}
	
	public void desce(int andar_atual) {
		if(andar_atual > 0) {
			andar_atual--;
			System.out.println("Andar atual: " + andar_atual);
		}else {
			System.out.println("Elevador já está no térreo");
		}
	}
}
