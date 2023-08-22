package secao20;

public class ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerificaPrimo1 p1 = new VerificaPrimo1(1);
		VerificaPrimo1 p2 = new VerificaPrimo1(1000);
		VerificaPrimo1 p3 = new VerificaPrimo1(2000);
		VerificaPrimo1 p4 = new VerificaPrimo1(3000);
		
		Thread t1 = new Thread(p1);
		t1.start();
		Thread t2 = new Thread(p2);
		t2.start();
		Thread t3 = new Thread(p3);
		t3.start();
		Thread t4 = new Thread(p4);
		t4.start();
		
		
		 
	}

}
