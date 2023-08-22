package secao4;

public class ex38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dia = 29, mes = 2, ano = 2008, ano_atual = 2008;
		
		if(ano > 1900 && ano <= ano_atual) {
			if(mes > 0 && mes < 13) {
				if(mes != 2) {
					if(dia > 0 && dia <= 31) {
						System.out.println("Data válida");
					}else if(dia < 0 || dia > 31) {
						System.out.println("Data inválida. Dia deve estar entre 1 e 31");
					}
				}else{
					if(dia > 0 && dia <= 28) {
						System.out.println("Data válida");
					} else if(dia == 29) {
						if(ano %400 == 0) {
							if(ano %4 == 0 && ano %100 == 1) {
								System.out.println("Data válida");
							}else {
								System.out.println("Data inválida. Ano não bissexto");
							}
						}else {
							System.out.println("Data inválida. Ano não bissexto");
						}
					} else if(dia > 29) {
						System.out.println("Data inválida. Para Fevereiro, o dia deve ser entre 1 e 29");
					}
				}
			}else {
				System.out.println("Data inválida. Mês deve estar entre 1 e 12");
			}
		}else {
			System.out.println("Data inválida. Ano deve ser maior que 1900 e menor ou igual a 2008");
		}
	}

}
