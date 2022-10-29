package dados;

public class Pessoa {
	protected StringBuilder nomeCompleto;
	protected Character genero;
	protected Integer identificador;
	
	public Pessoa(String pNome, char pGenero, int pId) {
		this.setNomeCompleto(new StringBuilder(pNome));
		this.setGenero(pGenero);
		this.setIdentificador(pId);
	}
	
	public Pessoa(Pessoa pPessoa) {
		this.setNomeCompleto(pPessoa.getNomeCompleto());
		this.setGenero(pPessoa.getGenero());
		this.setIdentificador(pPessoa.getIdentificador());
	}
	
	public StringBuilder getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(StringBuilder nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Character getGenero() {
		return genero;
	}
	
	public String getGeneroString() {
		if (this.genero == 'M') {
			return "Masculino";
		}
		return "Feminino";
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public char getSituacao() {
		return 'N';
	}
}
