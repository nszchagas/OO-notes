package dados;

public class Aluno {
	private String nomeCompleto;
	private Integer matricula;
	private Float mediaFinal;
	
	public Aluno(String nome, int matricula, float media) {
		setNomeCompleto(nome);
		setMatricula(matricula);
		setMediaFinal(media);
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

	public Float getMediaFinal() { // em classe de dados não é recomendado usar tipo primitivo
		return mediaFinal;
	}

	public void setMediaFinal(Float mediaAritmetica) {
		this.mediaFinal = mediaAritmetica;
	}
	
	
	
	
}
