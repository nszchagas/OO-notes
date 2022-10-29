package dados;

public class Pintor {

	private String nome;
	private Integer codigo;
	private Integer anoNascimento;

	public Pintor(String nome, int codigo, int ano) {
		this.setNome(nome);
		this.setAnoNascimento(ano);
		this.setCodigo(codigo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(Integer anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public boolean isNomePintor(String nome) {
		return this.nome.contains(nome);
	}

}
