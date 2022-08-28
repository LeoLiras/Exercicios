package secao12_Heranca_e_Polimorfismo;

public class Quadrado {
	private int lado;
	private float area;
	private int perimetro;
	
	public Quadrado(int lado){
		this.lado = lado;
	}
	
	public void calcularArea() {
		this.area = this.lado * this.lado;
		
		System.out.println("Área do quadrado: " + this.area);
	}
	
	public void calcularPerimetro() {
		this.perimetro = this.lado * 4;
		
		System.out.println("Perímetro do quadrado: " + this.perimetro);
	}
	
	public void imprimir() {
		System.out.println("Lado do quadrado: " + this.lado);
		System.out.println("Área do quadrado: " + this.area);
		System.out.println("Perímetro do quadrado: " + this.perimetro);
	}
	
}
