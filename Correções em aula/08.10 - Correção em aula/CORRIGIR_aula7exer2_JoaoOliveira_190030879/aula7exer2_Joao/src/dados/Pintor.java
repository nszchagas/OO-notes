package dados;

public class Pintor {
	private String nome;
	private Integer codigo;
	private Integer anoNascimento;

	public Pintor(String nome, int codigoPessoal, int anoNascimento) {
		setNome(nome);
		setCodigo(codigoPessoal);
		setAnoNascimento(anoNascimento);
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

	public void setCodigo(Integer codigoPessoal) {
		this.codigo = codigoPessoal;
	}

	public Integer getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(Integer anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public String toString() {
		String formato = "| %-6d | %-47s | ";
		return String.format(formato, this.getCodigo(), this.getNome());
	}

}
