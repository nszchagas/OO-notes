package principal;

import dados.Aluno;
import dados.Turma;
import saida.Visao;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {

		Turma turma = new Turma();

		do {
			turma.setAluno(
					new Aluno(Validacao.validaNome(), Validacao.validaMatricula(turma), Validacao.validaMedia()));
		} while (Validacao.isContinuaCadastro());

		Visao.mostraRelatorio(turma);

	}

}
