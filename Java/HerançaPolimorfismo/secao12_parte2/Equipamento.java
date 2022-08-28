package secao12_parte2;

public class Equipamento {
	private int id;
	private int qntd;
	
	public Equipamento(int id, int qntd) {
		this.id = id;
		this.qntd = qntd;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQntd() {
		return this.qntd;
	}
	
	public void setQntd(int qntd) {
		this.qntd = qntd;
	}
	
	public void exibe() {
		System.out.println("Id do produto: " + this.id);
		System.out.println("Quantidade: " + this.qntd + "\n");
	}
}
