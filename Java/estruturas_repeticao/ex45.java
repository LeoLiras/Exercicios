package secao5;

import java.util.Scanner;

public class ex45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double km_h = 0, m_seg = 0;
		int opt = 1;
		
		Scanner teclado = new Scanner(System.in);
		
		while(opt != 0) {
			System.out.println("Insira uma opção ou '0' para sair: ");
			System.out.println("1 - km/h  ->  m/s");
			System.out.println("2 - m/s  -> km/h");
			
			opt = teclado.nextInt();
			
			if(opt == 1) {
				System.out.println("km/h: ");
				km_h = teclado.nextInt();
				
				m_seg = km_h * 3.6;
				System.out.println(km_h + " km/h equivale a " + m_seg + " m/s\n\n");
			}else if(opt == 2) {
				System.out.println("m/s: ");
				m_seg = teclado.nextInt();
				
				km_h = m_seg / 3.6;
				System.out.println(m_seg + " m/s equivale a " + km_h + " km/h\n\n");
			}else {
				System.out.println("Opção inválida.");
			}
		}
		
		teclado.close();
	}

}
