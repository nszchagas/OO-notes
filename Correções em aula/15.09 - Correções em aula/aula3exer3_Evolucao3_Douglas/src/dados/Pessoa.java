package dados;

public class Pessoa {

	private String nome;
	private int idade;
	private float altura;

	public Pessoa(String nome, int idade, float altura) {
		this.setNome(nome);
		this.setAltura(altura);
		this.setIdade(idade);
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getAltura() {
		return altura;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}


}
