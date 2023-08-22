package secao03;

public class ex43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float valor_total = 100f;
		float valor_desconto = valor_total - (valor_total * 0.1f);
		
		System.out.println("Valor total: R$" + valor_total);
		System.out.println("Valor com desconto: R$" + valor_desconto);
		System.out.println("Em até 3x de R$" + (valor_desconto / 3) + " sem juros");
		System.out.println("Comissão venda a vista: R$" + (valor_desconto * 0.05f));
		System.out.println("Comissão venda parcelada R$" + (valor_total * 0.05f));
		
	}

}
