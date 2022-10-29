package dados;

import java.util.ArrayList;

public class Turma {

	private ArrayList<Aluno> turma;
	// criar um construtor que cria e já coloca aluno se for o primeiro aluno 
	
	
	public Turma(Aluno aluno) {
		setAluno(aluno);
	}

	public Turma() {
		turma = new ArrayList<Aluno>();
	}

	public Aluno getAluno(int i) {
		return turma.get(i);
	}

	public ArrayList<Aluno> getTurma() {
		return this.turma;
	}

	public void setAluno(Aluno aluno) {
		this.turma.add(aluno);
	}

	public int getTamanhoTurma() {
		return this.getTurma().size();
	}
}
