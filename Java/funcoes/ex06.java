package secao8;

public class ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int horas = 1, minutos = 0, segundos = 4;
		
		System.out.println(converter(horas, minutos, segundos));
		
	}

	static String converter(int h, int min, int seg){
		int h_para_seg = h * 60 * 60;
		int min_para_seg = 0;
		
		if(min > 60 || min < 0) {
			return "Minutos deve estar entre 00 e 59";
		}else {
			min_para_seg = min * 60;
		}
		
		int total_seg = h_para_seg + min_para_seg + seg;
		
		return h + ":" + min + ":" + seg + " equivale a: " + total_seg + " segundos"; 
	}
}
