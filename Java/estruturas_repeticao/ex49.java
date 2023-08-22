package secao5;

public class ex49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double salario_carlos = 5000, salario_joao;
		int contador_meses = 0;
		
		salario_joao = salario_carlos / 3;
		
		while(salario_joao < salario_carlos && salario_joao != salario_carlos) {
			salario_carlos = salario_carlos + (salario_carlos * 0.02);
			salario_joao = salario_joao + (salario_joao * 0.05);
			
			contador_meses++;
		}
		
		System.out.println("Meses passados: " + contador_meses);
		System.out.println("Valor de Carlos: " + salario_carlos);
		System.out.println("Valor de Joao: " + salario_joao);
	}

}
