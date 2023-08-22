package secao20;

public class VerificaPrimo1 implements Runnable{
	private int valor;
	
	public VerificaPrimo1(int valor) {
		this.valor = valor;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = this.valor; i < (this.valor + 1000); i++) {
			System.out.println(i);{
				if(i % i == 0 && i % 1 == i) {
					System.out.println("É primo");
				}else {
					System.out.println("Não é primo");
				}
			}
		}
	}
}
