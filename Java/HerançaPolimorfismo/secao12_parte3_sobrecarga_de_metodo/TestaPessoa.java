package secao12_parte3_sobrecarga_de_metodo;

public class TestaPessoa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa("Bruce Wayne", 10, 25);
		Pessoa p2 = new Pessoa();
		
		p1.exibe(1);
		p2.exibe(2);
	}

}
