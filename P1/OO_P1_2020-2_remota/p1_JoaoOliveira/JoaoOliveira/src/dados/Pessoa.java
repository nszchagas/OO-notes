package dados;

public abstract class Pessoa {
	private StringBuilder nomeCompleto;
	private Character genero;
	private Integer identificacao;
	
	public Pessoa (String nomeCompleto, char genero, int identificacao) {
		setNomeCompleto(nomeCompleto);
		setGenero(genero);
		setIdentificacao(identificacao);
	}

	public String getNomeCompleto () {
		return nomeCompleto.toString();
	}

	public void setNomeCompleto (String nomeCompleto) {
		this.nomeCompleto = new StringBuilder(nomeCompleto);
	}

	public String getGenero () {
		return (this.genero == 'M' ? "MASCULINO" : "FEMININO");
	}

	public void setGenero (Character genero) {
		this.genero = genero;
	}

	public Integer getIdentificacao () {
		return identificacao;
	}

	public void setIdentificacao (Integer identificacao) {
		this.identificacao = identificacao;
	}
}
