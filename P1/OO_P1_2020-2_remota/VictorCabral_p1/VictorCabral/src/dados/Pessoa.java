package dados;

public class Pessoa {
	private String codigoPessoa;
	private StringBuilder nome;
	private Character situacaoSaude;

	public Pessoa(String codigoPessoa, StringBuilder nome, Character situacaoSaude) {
		setCodigoPessoa(codigoPessoa);
		setNome(nome);
		setSituacaoSaude(situacaoSaude);
	}

	//Getters
	public String getCodigoPessoa() {
		return codigoPessoa;
	}
	
	public StringBuilder getNome() {
		return nome;
	}

	public Character getSituacaoSaude() {
		return situacaoSaude;
	}

	//Setters
	public void setCodigoPessoa(String codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}
	
	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public void setSituacaoSaude(Character situacaoSaude) {
		this.situacaoSaude = situacaoSaude;
	}

	public int contaminadosCurados() {
		int contador = 0;
		if (getSituacaoSaude() == 'C')
			contador++;
		return contador;
	}
	
	public int contaminadosEmTratamento() {
		int contador = 0;
		if (getSituacaoSaude() == 'T')
			contador++;
		return contador;
	}
	
	public int contaminadosFalecidos() {
		int contador = 0;
		if (getSituacaoSaude() == 'F')
			contador++;
		return contador;
	}
}
