package dados;

import java.text.DecimalFormat;

public class Pessoa {

	protected String nome;
	protected Long cpf;
	protected Float salario;
	protected Data dataDeNascimento;

	public Pessoa(String nome, Long cpf, Data data) {
		this.setDataNascimento(data);
		this.setCpf(cpf);
		this.setNome(nome);
		this.setSalario(calculaSalario());
	}

	public Pessoa(Pessoa pessoa) {
		this.setDataNascimento(pessoa.getDataNascimento());
		this.setNome(pessoa.getNome());
		this.setCpf(pessoa.getCpf());
		this.setSalario(pessoa.getSalario());

	}

	public void setDataNascimento(Data data) {
		this.dataDeNascimento = data;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public Data getDataNascimento() {
		return this.dataDeNascimento;
	}

	public String getNascimentoTexto() {
		return dataDeNascimento.toString();
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Float getSalario() {
		return this.salario;
	}

	public String toString() {

		String formato = "|%-51s |%-20s |%-13s |%-14s |";
		return String.format(formato, this.getNome(), this.getDataNascimento(), this.getCpf(),
				new DecimalFormat("0.00").format(this.getSalario()));
	}

	public Float calculaSalario() {
		final float PISO_SALARIAL = 232F;
		return PISO_SALARIAL;

	}

}
