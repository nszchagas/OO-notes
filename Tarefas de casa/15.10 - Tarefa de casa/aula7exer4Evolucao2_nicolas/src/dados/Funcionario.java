package dados;

public class Funcionario {
	private String nome;
	private String cpf;
	private String dataDeNascimento;
	private Float salario;

	public Funcionario(String nome, String cpf, String dataDeNascimento) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setDataDeNascimento(dataDeNascimento);
		this.setSalario(this.calculaSalario());
	}

	public Funcionario(Funcionario funcionario) {
		this.setNome(funcionario.getNome());
		this.setCpf(funcionario.getCpf());
		this.setDataDeNascimento(funcionario.getDataDeNascimento());
		this.setSalario(funcionario.calculaSalario());
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

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public float calculaSalario() {
		final float PISO = 232f;
		return PISO;
	}

	public String toString() {

		String formato = "| %-50s | %-11s | %-18s ";
		return String.format(formato, this.getNome(), this.getCpf(), this.getDataDeNascimento());

	}

}
