package validacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Vector;

import dados.Aluno;
import dados.Turma;
import leitura.Leitura;
import saida.Visao;
import servicos.Servicos;

public class Validacao {

	public static boolean isMedia(float media) {
		final int MIN = 0, MAX = 10;
		if (media < MIN || media > MAX)
			Visao.mensagemValorInvalido(MIN, MAX);
		return (media >= MIN && media <= MAX);
	}

	public static boolean isNome(String nome) {
		Vector<String> nomesSeparados = Servicos.separaNomes(nome);
		if (nomesSeparados.size() <= 1 || !validaNomesSeparadamente(nomesSeparados))
			Visao.mensagemNomeInvalido(3);
		return (nomesSeparados.size() > 1 && validaNomesSeparadamente(nomesSeparados));
	}

	public static boolean isMatricula(int matricula, Turma turma) {
		final int MAX = 1000;
		if (matricula <= MAX)
			Visao.mensagemValorInvalido(MAX);
		if (isMatriculaRepetida(matricula, turma))
			Visao.mensagemMatriculaRepetida();
		return (matricula > MAX && !isMatriculaRepetida(matricula, turma));
	}

	public static boolean isMatriculaRepetida(int matricula, Turma turma) {
		boolean matriculaRepetida = false;
		int i = 0;

		if (turma.getTamanhoDaTurma() > 0) {
			do {
				matriculaRepetida = (turma.getAluno(i).getMatricula() == matricula);
				i++;
			} while (!matriculaRepetida && i < turma.getAlunos().size());
		}

		return matriculaRepetida;
	}

	public static boolean isContinuaCadastro(char opcao) {
		if (opcao != 'S' && opcao != 'N')
			Visao.mensagemCaractereInvalido();
		if (opcao == 'S')
			Visao.mensagemInicioCadastro();
		return (opcao == 'S' || opcao == 'N');
	}

	private static boolean validaNomesSeparadamente(Vector<String> nomes) {
		for (int i = 0; i < nomes.size(); i++)
			if (nomes.elementAt(i).length() < 3)
				return false;
		return true;
	}

}
