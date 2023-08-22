package secao18_Java_Lang;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ex23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String funcionarios[] = {"João", "Mario", "Rafael"};
		int anos[] = {5, 2, 7};
		
		try {
			PrintStream arquivo = new PrintStream(new FileOutputStream("emp.txt", true));
			
			for(int i = 0; i < funcionarios.length; i++) {
				arquivo.println(funcionarios[i] + " - " + anos[i] + " anos de serviço.");
			}
		}catch(FileNotFoundException e) {
			
		}
	}

}
