package dados;

public class Pessoa {
	private final float PISO = 232F;
	private String nome;
	private String cpf;
	private String dataDeNascimento;

	public Pessoa(String nome, String cpf, String dataDeNascimento) {
		setNome(nome);
		setCpf(cpf);
		setDataDeNascimento(dataDeNascimento);
	}

	public float getPISO() {
		return PISO;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}
