package secao12_Heranca_e_Polimorfismo;

public class Televisor {
	private boolean ligado;
	private int canal;
	private int volume;
	private int numeroCanais;
	private int volumeMaximo;
	
	public Televisor(boolean ligado, int canal, int volume, int numeroCanais, int volumeMaximo) {
		this.ligado = ligado;
		this.canal = canal;
		this.volume = volume;
		this.numeroCanais = numeroCanais;
		this.volumeMaximo = volumeMaximo;
	}
	
	public void imprimir() {
		if(this.ligado == true) {
			System.out.println("Televisor ligado.");
			System.out.println("Canal: " + this.canal);
			System.out.println("Volume: " + this.volume);
			System.out.println("Número de Canais: " + this.numeroCanais);
			System.out.println("Volume Máximo: " + this.volumeMaximo);
		}else {
			System.out.println("Televisor desligado.");
		}
	}
	
	public void ligar() {
		this.ligado = true;
	}
	
	public void desligar() {
		this.ligado = false;
	}
	
	public void canalAcima() {
		if(this.canal < numeroCanais) {
			this.canal++;
		}else {
			this.canal = 1;
		}
	}
	
	public void canalAbaixo() {
		if(this.canal > 1) {
			this.canal--;
		}else {
			this.canal = this.numeroCanais;
		}
	}
	
	public void volumeAcima() {
		if(this.volume < this.volumeMaximo) {
			this.volume++;
		}else {
			System.out.println("Volume já está no máximo");
		}
	}
	public void volumeAbaixo() {
		if(this.volume > 0) {
			this.volume--;
		}else {
			System.out.println("Volume já está no mínimo");
		}
	}
}

