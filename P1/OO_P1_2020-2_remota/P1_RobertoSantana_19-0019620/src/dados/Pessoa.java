package dados;

public class Pessoa {
	private Integer codigo;
	private StringBuilder nome;
	private Character situacao;
	
	public Pessoa(int codigo, StringBuilder nome, char situacao) {
		setCodigo(codigo);
		setNome(nome);
		setSituacao(situacao);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Character getSituacao() {
		return situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	public StringBuilder getNome() {
		return nome;
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}
}
