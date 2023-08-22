
package secao4;

public class ex35 {
	public static void main(String[] args) {
		int dia = 32, mes = 3, ano = 0;
		
		if(dia > 0 && dia <= 31) {
			if(mes != 2) {
				if(ano > 0) {
					System.out.println("Data válida");
				}else {
					System.out.println("Data inválida. Ano deve ser maior que 0");
				}
			}else {
				if(dia > 29) {
					System.out.println("Data inválida. Fevereiro não pode ter mais que 29 dias");
				}else {
					System.out.println("Data válida");
				}
			}
		}else {
			System.out.println("Data inválida. Valor de dia incorreto.");
		}
	}

}
