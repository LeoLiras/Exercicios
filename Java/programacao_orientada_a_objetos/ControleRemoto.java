package secao9;

public class ControleRemoto {
	private int canal = 0; 
	private int volume = 0;
	
	public void trocaCanal() {
		canal++;
		System.out.println("Canal: " + canal);
	}
	
	public void trocaVolume() {
		volume++;
		System.out.println("Volume: " + volume);
	}
}
