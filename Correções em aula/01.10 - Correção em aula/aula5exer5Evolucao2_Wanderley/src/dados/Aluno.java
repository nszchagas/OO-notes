package dados;

import java.text.DecimalFormat;

public class Aluno {

	private String nomeCompleto;
	private Integer matricula;
	private Float mediaAritmetica;

	public Aluno(String nome, int matricula, float media) {
		setNomeCompleto(nome);
		setMatricula(matricula);
		setMediaAritmetica(media);
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Float getMediaAritmetica() {
		return mediaAritmetica;
	}

	public void setMediaAritmetica(Float mediaAritmetica) {
		this.mediaAritmetica = mediaAritmetica;
	}

	public String toString() {
		DecimalFormat mascara = new DecimalFormat("0.00");
		return (this.getMatricula() + "\t\t" + this.getNomeCompleto() + "\t\t\t"
				+ mascara.format(this.getMediaAritmetica()));
	}

}
