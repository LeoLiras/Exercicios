package secao8;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dia = 23, mes = 2, ano = 1990;
		
		System.out.println(data_extenso(dia, mes, ano));
	}
	
	static String data_extenso(int dia, int mes, int ano) {
		String mes_extenso = "";
		
		switch(mes) {
		case 1: 
			mes_extenso = "Janeiro";
			break;
		case 2: 
			mes_extenso = "Fevereiro";
			break;
		}
		
		return dia + " de " + mes_extenso + " de " + ano;
	}
}
