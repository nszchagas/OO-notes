package principal;

import java.util.Vector;

import dados.Aluno;
import visao.Visao;

public class Principal {
	public static void main(String[] args) {
		Vector<Aluno> turma = new Vector<Aluno>();

		while (Visao.verificaContinuar())
			turma.add(new Aluno(Visao.cadastraNome(), Visao.cadastraMediaFinal(), Visao.cadastraMatricula(turma)));
		Visao.mostraResultado(turma);
	}

}
