package secao20;

public class VerificaPar implements Runnable{
	private int valor1;
	private int valor2;
	
	public VerificaPar(int valor1, int valor2) {
		this.valor1 = valor1;
		this.valor2 = valor2;
	}

	@Override
	public void run() {
		for(int i = valor1; i <= valor2; i++) {
			if(i % 2 == 0) {
				System.out.println(i + " é par.");
			}else {
				System.out.println(i + " é ímpar.");
			}
		}
	}
}
