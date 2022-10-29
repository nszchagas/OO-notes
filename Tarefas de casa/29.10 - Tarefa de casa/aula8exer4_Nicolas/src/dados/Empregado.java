package dados;

public class Empregado {

	private Integer matricula;
	private StringBuilder nome;
	private Float salario;

	public Empregado(Integer matricula, StringBuilder nome, Float salario) {
		super();
		this.setMatricula(matricula);
		this.setNome(nome);
		this.setSalario(salario);
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public StringBuilder getNome() {
		return nome;
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		String formato = "%-11d | %-80s | %.2f\n";
		return String.format(formato, this.getMatricula(), this.getNome(), this.getSalario());
	}

}
