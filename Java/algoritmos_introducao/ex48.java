package secao03;

public class ex48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int seg = 1000;
		int min = seg / 60;
		int hora = min / 60;
		
		seg = seg - (min * 60);
		min = min - (hora * 60);
		
		
		System.out.println(hora + ":" + min + ":" + seg);
	}

}
