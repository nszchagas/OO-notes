package dados;

public class Pessoa {
	private Integer idPessoa;
	private StringBuilder nome;
	private String situacao;
	public Pessoa(Integer idPessoa,StringBuilder nome,String situacao){
		setIdPessoa(idPessoa);
		setNome(nome);
		setSituacao(situacao);
	}
	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public StringBuilder getNome() {
		return nome;
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
