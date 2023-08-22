package secao9;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Agenda p1 = new Agenda("Jayson Todd", 19, 1.87f, 0);
		Agenda p2 = new Agenda("Barbara Gordon", 22, 1.80f, 1);
		
		//p1.armazenaPessoa(p1.nome, p1.idade, p1.altura, p1.posicao); Não precisa mais, agora está no contrutor.
		//p2.armazenaPessoa(p2.nome, p2.idade, p2.altura, p2.posicao);
		
		System.out.println(p1.buscaPessoa(p1.nome) + "\n");
		System.out.println(p2.buscaPessoa(p2.nome) + "\n");
		
		
		System.out.println(p1.imprimePessoa(p1.posicao) + "\n");
		System.out.println(p2.imprimePessoa(p2.posicao) + "\n");
		
		//p2.removePessoa(p2.nome, p2.idade, p2.altura, p2.posicao);

		//System.out.println(p2.imprimePessoa(p2.posicao) + "\n");
		
		//p2.armazenaPessoa(p2.nome, p2.idade, p2.altura, p2.posicao);
		//System.out.println(p2.imprimePessoa(p2.posicao) + "\n");
		
		System.out.println("-------------------------------------------------");
	}
}
