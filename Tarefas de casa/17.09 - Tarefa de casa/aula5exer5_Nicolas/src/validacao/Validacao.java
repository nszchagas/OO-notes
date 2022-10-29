package validacao;

import java.util.Vector;

import dados.Aluno;
import servicos.Servicos;
import visao.Visao;

public class Validacao {

	public static boolean isNome(StringBuilder nome) {
		if (Servicos.separaNomes(nome).size() <= 1 || !validaNomesSeparadamente(Servicos.separaNomes(nome)))
			Visao.mensagemNomeInvalido();
		return (Servicos.separaNomes(nome).size() > 1 && validaNomesSeparadamente(Servicos.separaNomes(nome)));
	}

	public static boolean isOpcaoContinuar(char opcao) {
		if (opcao != 's' && opcao != 'n')
			Visao.mensagemCaractereInvalido();
		return ((opcao == 's') || (opcao == 'n'));

	}

	private static boolean validaNomesSeparadamente(Vector<StringBuilder> nomes) {
		for (int i = 0; i < nomes.size(); i++)
			if (nomes.elementAt(i).length() < 3)
				return false;
		return true;
	}

	public static boolean isMedia(float media) {
		final int MIN = 0, MAX = 10;
		if (media < MIN || media > MAX)
			Visao.mensagemValorInvalido(MIN, MAX);
		return (media >= MIN && media <= MAX);
	}

	public static boolean isMatriculaValida(Vector<Aluno> turma, int matricula) {
		boolean matriculaRepetida = false;
		final int MAX = 1000;
		int i = 0;

		while (i < turma.size() && matriculaRepetida == false) {
			matriculaRepetida = (turma.elementAt(i++).getMatricula() == matricula);
			
		}
		if (matriculaRepetida == true)
			Visao.mensagemMatriculaRepetida();

		if (matricula <= MAX)
			Visao.mensagemValorInvalido(MAX);

		return (!matriculaRepetida && matricula > MAX);
	}

}
