package principal;

import dados.GrupoHabitantes;
import visao.Visao;

public class Principal {
	public static void main(String[] args) {

		GrupoHabitantes grupo = new GrupoHabitantes();

		while (Visao.verificaCadastrar(grupo.getHabitantes().size()))
			grupo.addHabitante(Visao.cadastraHabitante());
		Visao.imprimeResultado(grupo);

	}

}
