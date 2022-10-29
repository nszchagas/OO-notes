package principal;

import java.util.Vector;

import dados.Pessoa;
import visao.Visao;

public class Principal {
	public static void main(String[] args) {

		Vector<Pessoa> habitantes = new Vector<Pessoa>();
		while (Visao.verificaContinuar(habitantes.size())) {
			Visao.mensagemCadastreNumPessoa(habitantes.size());
			habitantes.add(new Pessoa(Visao.registraSalario(), Visao.registraIdade(), Visao.registraSexo(),
					Visao.registraNumeroDeFilhos()));
		}

		Visao.mostraResultados(habitantes);
		Visao.mostraRegistros(habitantes);

	}

}
