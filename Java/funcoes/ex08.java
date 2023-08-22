package secao8;

public class ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cateto_a = 3, cateto_b = 4;
		
		System.out.println(hipotenusa(cateto_a, cateto_b));
	}
	
	static int hipotenusa(int a, int b) {
		int hip = (int) Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
		
		return hip;
	}
}
