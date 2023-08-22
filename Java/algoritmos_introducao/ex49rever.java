package secao03;

public class ex49rever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h_inicio = 13, min_inicio = 30, seg_inicio = 43;
		int duracao_seg = 5000;
		int duracao_min = duracao_seg / 60;
		int duracao_hora = duracao_min / 60;
		
		int seg = duracao_seg - (duracao_min * 60);
		int min = duracao_min - (duracao_hora * 60);
		
		int h_termino = h_inicio + duracao_hora;
		int min_termino = min_inicio + min;
		int seg_termino = seg_inicio + seg;
		
		if(seg_termino > 60) {
			seg_termino = seg_termino - 60;
			min_termino++;
		}
		if(min_termino > 60) {
			min_termino = min_termino - 60;
			h_termino++;
		}
		if(h_termino == 24) {
			h_termino = 0;
			min_termino = 0;
			seg_termino = 0;
		}
		
		System.out.println("Horário de início da experiência: " + h_inicio + ":" + min_inicio + ":" + seg_inicio);
		System.out.println("Duracao: " + duracao_hora + ":" + min + ":" + seg);
		System.out.println("Horário de término da experiência: " + h_termino + ":" + min_termino + ":" + seg_termino);
	}

}
