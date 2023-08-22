package secao20;

public class Pilha {
	int carga = 100;
	
	public Pilha(int carga) {
		this.carga = carga;
	}
	
	public void push() {
		if(this.carga < 100) {
			this.carga += 10;
		}
		
	}
	
	public void pop() {
		if(this.carga > 10) {
			this.carga -= 10;
		}else {
			
		}
	}
}
