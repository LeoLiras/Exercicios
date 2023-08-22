package secao03;

public class ex40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dias_trabalhados = 20;
		float salario_dia = 30.00f;
		
		float salario_total = dias_trabalhados * salario_dia;
		float salario_liquido = salario_total - (salario_total * 0.08f);
		
		System.out.println("Salário Total: " + salario_total);
		System.out.println("Salário Líquido(descontando 8% de IE) : " + salario_liquido);
	}

}
