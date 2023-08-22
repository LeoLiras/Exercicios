package secao9;

public class Agenda {
	private String nomes[] = new String[10];
	private int idades[] = new int[10];
	private float alturas[] = new float[10];
	private int posicoes[] = new int[10];
	
	String nome;
	int idade;
	int posicao;
	float altura;
	
	public Agenda(String nome, int idade, float altura, int posicao){
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.posicao = posicao;
		
		this.armazenaPessoa(nome, idade, altura, posicao);
	}
	
	
	
	public void armazenaPessoa(String nome, int idade, float altura, int posicao){	
		this.nomes[posicao] = nome;
		this.idades[posicao] = idade;
		this.alturas[posicao] = altura;
		this.posicoes[posicao] = posicao;
	}
	
	public void removePessoa(String nome, int idade, float altura, int posicao){	
		this.nomes[posicao] = null;
		this.idades[posicao] = 0;
		this.alturas[posicao] = 0;
	}
	
	public String buscaPessoa(String nome) {
		int pos_pessoa = 0;
		
		for(int i = 0; i < this.nomes.length; i++) {
			if(this.nomes[i] == nome) {
				pos_pessoa = i;
			}
		}
		return nome + " está na posição: " + pos_pessoa;
	}
	
	public String imprimePessoa(int pos) {
		return "Nome: " + this.nomes[pos] + "\n Idade: " + this.idades[pos] + "\n Altura: " + this.alturas[pos];
	}
	
	public void imprimeAgenda() {
		for(int i = 0; i < this.nomes.length; i++) {
			System.out.println("Nome: " + this.nomes[i]);
			System.out.println("Idade: " + this.idades[i]);
			System.out.println("Altura: " + this.alturas[i]);
			System.out.println("\n");
		}
	}
}
