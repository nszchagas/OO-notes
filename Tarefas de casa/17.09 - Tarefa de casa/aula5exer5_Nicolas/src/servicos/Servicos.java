package servicos;

import java.util.Vector;

import dados.Aluno;

public class Servicos {

	public static float calculaMediaTurma(Vector<Aluno> turma) {
		float media = 0f;
		for (int i = 0; i < turma.size(); i++)
			media += turma.elementAt(i).getMediaFinal();
		return ((turma.size() == 0) ? media : media / turma.size());
	}

	public static Vector<StringBuilder> separaNomes(StringBuilder nome) {

		Vector<StringBuilder> nomesSeparados = new Vector<StringBuilder>();

		for (int i = 0; i < nome.toString().split(" ").length; i++)
			nomesSeparados.add(new StringBuilder(nome.toString().toUpperCase().split(" ")[i]));

		return nomesSeparados;
	}
	
	
	
}
