package dados;

public class Pessoa {
	private StringBuilder nome;
	private String situacaoSaude;
	private Integer codigo;

	public Pessoa(StringBuilder nome, String situacaoSaude, Integer codigo) {
		this.setNome(nome);
		this.setSituacaoSaude(situacaoSaude);
		this.setCodigo(codigo);
	}

	public StringBuilder getNome() {
		return nome;
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public String getSituacaoSaude() {
		return situacaoSaude;
	}

	public void setSituacaoSaude(String situacaoSaude) {
		this.situacaoSaude = situacaoSaude;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
