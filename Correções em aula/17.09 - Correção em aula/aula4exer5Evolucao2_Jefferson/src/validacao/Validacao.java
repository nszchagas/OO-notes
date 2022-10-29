package validacao;

import java.util.Vector;

import servicos.Servicos;
import visao.Visao;

public class Validacao {

	public static boolean isNome(StringBuilder nome) {
		if (Servicos.separaNomes(nome).size() <= 1 || !validaNomesSeparadamente(Servicos.separaNomes(nome)))
			Visao.mensagemNomeInvalido();

		return (Servicos.separaNomes(nome).size() > 1 && validaNomesSeparadamente(Servicos.separaNomes(nome)));
	}

	public static boolean isOpcaoContinuar(char opcao) {
		if (opcao != 'S' && opcao != 'N')
			Visao.digiteUmCaractereValido();

		return ((opcao == 'S') || (opcao == 'N'));

	}

	public static boolean validaNomesSeparadamente(Vector<StringBuilder> nomes) {
		for (int i = 0; i < nomes.size(); i++)
			if (nomes.elementAt(i).length() < 3)
				return false;

		return true;
	}

}
