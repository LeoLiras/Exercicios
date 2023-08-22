package secao5;

public class ex51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double salario_inicial = 2000, salario, aumento = 0.015;
		int  contador = 1997;
		
		salario = salario_inicial + (salario_inicial * aumento);
		
		while(contador != 2010) {
			aumento *= 2;
			salario = salario + (salario * aumento);
			System.out.println(aumento + "\n");
			System.out.println(salario + "\n");
			contador++;
		}
		
		System.out.println("Salário atual: R$ " + salario);
	}

}
