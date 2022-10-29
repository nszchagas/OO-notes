package servicos;

import java.util.Vector;

import dados.Turma;

public class Servicos {

	public static float calculaMediaGeral(Turma alunos) {
		float soma = 0f;

		for (int i = 0; i < alunos.getAlunos().size(); i++)
			soma += alunos.getAluno(i).getMediaFinal();

		return ((alunos.getAlunos().size() == 0) ? 0 : soma / alunos.getAlunos().size());
	}

	public static Vector<String> separaNomes(String nome) {

		Vector<String> nomesSeparados = new Vector<String>();

		for (int i = 0; i < nome.toString().split(" ").length; i++)
			nomesSeparados.add(nome.toString().split(" ")[i]);

		return nomesSeparados;
	}

}
