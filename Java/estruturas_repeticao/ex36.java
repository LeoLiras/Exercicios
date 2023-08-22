package secao5;

public class ex36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int soma_quadrados = 0, aux1 = 1, aux2 = 2, contador = 0;
		double diferenca = 0;
		double quadrado_da_soma = 0;
		
		while(contador < 100) {
			soma_quadrados += Math.pow(aux1, aux2);
			aux1++;
			contador++;
		}
		
		aux1 = 1;
		contador = 0;
		
		while(contador < 100) {
			quadrado_da_soma += aux1;
			aux1++;
			contador++;
		}
		
		quadrado_da_soma = Math.pow(quadrado_da_soma, 2);
		
		if(soma_quadrados > quadrado_da_soma) {
			diferenca = soma_quadrados - quadrado_da_soma;
		}else if(soma_quadrados < quadrado_da_soma) {
			diferenca = quadrado_da_soma - soma_quadrados;
		}
		
		System.out.println("Diferença: " + diferenca);
	}

}
