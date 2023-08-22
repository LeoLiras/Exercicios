package secao8;

public class ex39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5, b = 10;
		
		a = troca(b, b = a);
		
		System.out.println("A:  " + a);
		System.out.println("B:  " + b);
	}
	static int troca(int x, int y) {
		return x;
	}
}
