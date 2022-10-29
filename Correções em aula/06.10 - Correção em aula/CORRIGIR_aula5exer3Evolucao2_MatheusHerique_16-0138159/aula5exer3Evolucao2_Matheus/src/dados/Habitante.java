package dados;

public class Habitante {
	// Declaracoes
	private float salario;
	private int idade;
	private int numeroFilhos;
	private char sexo;

	// Metodo construtor
	public Habitante(float salario, int idade, char sexo, int numeroFilhos) {
		setSalario(salario);
		setIdade(idade);
		setSexo(sexo);
		setNumeroFilhos(numeroFilhos);
	}

	// Getters e Setters
	public void setSalario(float salario) {
		this.salario = salario;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setNumeroFilhos(int numeroFilhos) {
		this.numeroFilhos = numeroFilhos;
	}

	public float getSalario() {
		return salario;
	}

	public int getIdade() {
		return idade;
	}

	public char getSexo() {
		return sexo;
	}

	public int getNumeroFilhos() {
		return numeroFilhos;
	}
}
