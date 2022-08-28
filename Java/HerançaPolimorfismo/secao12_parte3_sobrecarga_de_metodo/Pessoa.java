package secao12_parte3_sobrecarga_de_metodo;

public class Pessoa {
	private String nome;
	private int codigo;
	private int idade;
	
	public Pessoa() {
		System.out.println("Construtor Padrão.");
	}
	
	public Pessoa(String nome, int codigo, int idade) {
		this.nome = nome;
		this.codigo = codigo;
		this.idade = idade;
	}
	
	public void exibe() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Codigo: " + this.codigo);
		System.out.println("Idade: " + this.idade + "\n");
	}
	
	public void exibe(int numero) {
		if(numero == 1) {
			System.out.println("Nome: " + this.nome);
			System.out.println("Codigo: " + this.codigo);
			System.out.println("Idade: " + this.idade + "\n");
		}else {
			System.out.println("Nome: " + this.nome);
			System.out.println("Codigo: " + this.codigo + "\n");
		}
	}
}
