package principal;

import dados.Aluno;
import dados.Turma;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		Turma alunos = new Turma();

		while (Visao.verificaIniciarCadastro()) {
			Aluno aluno = new Aluno(Visao.cadastraNome(), Visao.cadastraMatricula(alunos), Visao.cadastraMedia());
			alunos.setAluno(aluno);
		}

		Visao.mostraRelatorio(alunos);
	}
}
