package principal;

import dados.Galeria;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {

		Galeria galeria = new Galeria();

		while (Visao.mostraMenuInicial(galeria))
			;

	}
}
