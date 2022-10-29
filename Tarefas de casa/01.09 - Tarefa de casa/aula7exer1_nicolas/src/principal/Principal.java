package principal;

import java.util.Vector;

import dados.Evento;
import visao.Visao;

public class Principal {
	public static void main(String[] args) {
		Vector<Evento> sequenciaDeEventos = new Vector<Evento>();
		
		do {
			sequenciaDeEventos.add(Visao.cadastraEvento());
		} while (Visao.verificaContinuar());

		Visao.apresentaDados(sequenciaDeEventos);

	}

}
