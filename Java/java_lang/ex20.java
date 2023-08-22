package secao18_Java_Lang;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ex20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nomes[] = {"Bruce Wayne", "Selina Kyle"};
		int notas[] = {8, 10};
		
		try {
			PrintStream notas_arq = new PrintStream(new FileOutputStream("notas.txt", true));
			
			notas_arq.println("Nomes  |  Notas Finais");
			
			for(int i = 0; i < nomes.length; i++) {
				notas_arq.println(nomes[i] + " - " + notas[i]);
			}
		}catch(FileNotFoundException e) {
			
		}
		
	}

}
