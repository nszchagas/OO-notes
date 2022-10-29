package dados;

public abstract class Pessoa {
	protected static final float PISO = 232.00F;
	private String nome;
	private String dataNascimento;
	private String cpf;

	public Pessoa(String nome, String dataNascimento, String cpf) {
		setNome(nome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}

/*OBS:
 * 
 * -> Classe agora eh abstrata
 * 
 */
