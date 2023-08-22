package secao4;

public class ex09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float salario = 2000f, prestacao = 401f;
		
		float p_prestacao = (prestacao / salario) * 100;
		
		System.out.println((p_prestacao > 20) ? "Empréstimo não concedido" : "Empréstimo concedido");
	}

}
