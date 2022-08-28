package secao12_parte2;

public class TestaEquipamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Equipamento e1 = new Equipamento(1, 10);
		Computador c1 = new Computador(13, 24, "Dell", 4);
		
		c1.exibe();
		e1.exibe();
	}

}
