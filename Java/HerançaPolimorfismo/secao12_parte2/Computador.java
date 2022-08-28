package secao12_parte2;

public class Computador extends Equipamento {
	private String marca;
	private int ram;
	
	public Computador(int qntd, int id, String marca, int ram) {
		super(qntd, id);
		this.marca = marca;
		this.ram = ram;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getRam() {
		return this.ram;
	}
	
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	public void exibe() {
		System.out.println("Id do produto: " + this.getId());
		System.out.println("Quantidade: " + this.getQntd());
		System.out.println("Marca: " + this.marca);
		System.out.println("Ram: " + this.ram);
	}
}
