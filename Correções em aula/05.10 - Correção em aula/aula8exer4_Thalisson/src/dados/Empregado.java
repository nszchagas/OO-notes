package dados;

import java.text.DecimalFormat;

public class Empregado {
	private Integer matricula;
	private StringBuilder nome;
	private Float salario;
	
	public Empregado(int matricula, StringBuilder nome, float salario) {
		this.matricula = matricula;
		this.nome = nome;
		this.salario = salario; //não precisa gerar o setters
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public StringBuilder getNome() {
		return nome;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public String toString() {
		String formato = "%-20.20s %-20.20s %-20.20s";
		return String.format(formato, getNome(), getMatricula(), new DecimalFormat("0.00").format(getSalario()));
	}
}
