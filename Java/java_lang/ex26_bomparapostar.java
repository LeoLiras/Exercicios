package secao18_Java_Lang;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex26_bomparapostar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero_alunos = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Informe o número de alunos que serão armazenados: ");
		numero_alunos = Integer.parseInt(teclado.nextLine());
		
		for(int i = 0; i < numero_alunos; i++) {
			System.out.println("Informe a matrícula do aluno: ");
			int matricula = Integer.parseInt(teclado.nextLine());
			
			System.out.println("Informe o sobrenome do aluno: ");
			String sobrenome = teclado.nextLine();
			
			System.out.println("Informe a data de nascimento do aluno: ");
			String data_nascimento = teclado.nextLine();
			System.out.println("\n");
			
			Alunos aluno = new Alunos(matricula, sobrenome, data_nascimento);
			
			try {
				PrintStream arquivo = new PrintStream(new FileOutputStream("alunos.txt", true));
				
				arquivo.println("Aluno: " + matricula + " - " + "Sobrenome: " + sobrenome + " - " + "Data de Nascimento: " + data_nascimento);
				
			}catch(FileNotFoundException e) {
				System.out.println("Não foi possível criar o arquivo");
			}
		}
	}

}
