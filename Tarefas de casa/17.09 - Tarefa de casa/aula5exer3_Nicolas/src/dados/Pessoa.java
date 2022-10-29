package dados;

public class Pessoa {

	private float salario;
	private int idade;
	private char sexo;
	private int numeroDeFilhos;

	public Pessoa(float salario, int idade, char sexo, int numeroDeFilhos) {
		this.setSalario(salario);
		this.setIdade(idade);
		this.setSexo(sexo);
		this.setNumeroDeFilhos(numeroDeFilhos);
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public String getSexoExtenso() {
		return ((this.sexo == 'M') ? " masculino " : " feminino  ");
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getNumeroDeFilhos() {
		return numeroDeFilhos;
	}

	public void setNumeroDeFilhos(int numeroDeFilhos) {
		this.numeroDeFilhos = numeroDeFilhos;
	}

}
