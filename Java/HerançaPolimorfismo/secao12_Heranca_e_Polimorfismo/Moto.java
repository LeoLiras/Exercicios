package secao12_Heranca_e_Polimorfismo;

public class Moto {
	private String marca;
	private String modelo;
	private String cor;
	private int marcha;
	private int menorMarcha;
	private int maiorMarcha;
	private boolean ligada;
	
	public Moto(String marca, String modelo, String cor, int marcha, int menorMarcha, int maiorMarcha, boolean ligada){
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.marcha = marcha;
		this.menorMarcha = menorMarcha;
		this.maiorMarcha = maiorMarcha;
		this.ligada = ligada;
	}
	
	public void imprimir() {
		System.out.println("Marca: " + this.marca);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Cor: " + this.cor);
		System.out.println("Marcha: " + this.marcha);
		System.out.println("Menor marcha: " + this.menorMarcha);
		System.out.println("Maior marcha: " + this.maiorMarcha + "\n");
		
		if(this.ligada == true) {
			System.out.println("Moto ligada");
		}else {
			System.out.println("Moto desligada");
		}
	}
	
	public void sobeMarcha() {
		if(this.ligada == true) {
			if(this.marcha < this.maiorMarcha) {
				this.marcha++;
			}else {
				System.out.println("Marcha máxima.");
			}
		}else {
			System.out.println("Moto desligada");
		}
	}
		
	
	public void desceMarcha() {
		if(this.ligada == true) {
			if(this.marcha > this.menorMarcha) {
				this.marcha--;
			}else {
				System.out.println("Moto no neutro");
				}
			}else {
				System.out.println("Moto desligada");
			}
		}
	
	public void ligarMoto() {
		this.ligada = true;
	}
	
	public void desligarMoto() {
		this.ligada = false;
	}
}
