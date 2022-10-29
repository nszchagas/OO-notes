package dados;

public class Aluno {

	private StringBuilder nomeCompleto;
	int matricula;
	float mediaFinal;

	public StringBuilder getNome() {
		return this.nomeCompleto;
	}

	public void setNome(StringBuilder nome) {
		this.nomeCompleto = nome;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getMatricula() {
		return this.matricula;
	}

	public float getMediaFinal() {
		return this.mediaFinal;
	}

	public void setMediaFinal(float media) {
		this.mediaFinal = media;
	}

	public Aluno(StringBuilder nome, float mediaFinal, int matricula) {
		this.setNome(nome);
		this.setMediaFinal(mediaFinal);
		this.setMatricula(matricula);
	}

}
