package dados;

import java.util.ArrayList;

public class Turma {
	private ArrayList<Aluno> alunos;

	public Turma() {
		alunos = new ArrayList<Aluno>();
	}

	public ArrayList<Aluno> getAlunos() {
		return this.alunos;
	}

	public Aluno getAluno(int i) {
		return alunos.get(i);
	}

	public void setAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

}
