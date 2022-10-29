package dados;

import java.text.DecimalFormat;

public class Empregado {
	private Integer matricula;
	private StringBuilder nome;
	private Float salario;
	
	public Empregado(Integer matricula, String nome, Float salario) {
		setMatricula(matricula);
		setNome(nome);
		setSalario(salario);
	}

	public Integer getMatricula () {
		return matricula;
	}

	public void setMatricula (Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome () {
		return nome.toString();
	}

	public void setNome (String nome) {
		this.nome = new StringBuilder(nome);
	}

	public Float getSalario () {
		return salario;
	}

	public void setSalario (Float salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return String.format(
			"%-40s%-40s%-30s%-50s%-30s%-40s",
			getMatricula(),
			getNome(),
			new DecimalFormat("0.00").format(getSalario()),
			"---", 
			"---", 
			"---"
		);
	}
}
