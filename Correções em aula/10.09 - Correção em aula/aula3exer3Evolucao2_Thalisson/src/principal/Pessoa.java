package principal;

public class Pessoa {
	// Declaracoes
	private float altura;
	private int idade;
	private String nome;
	
	// Instrucoes
 	 // Metodo construtor
	 Pessoa(String nome, int idade, float altura) {
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
	 }
	 
	 public int getIdade() {
		 return idade;
	 }
	 
	 public float getAltura() {
		 return altura;
	 }
	 
	 public String getNome() {
		 return nome;
	 }
	 
	 public void setIdade(int idade) {
		 this.idade = idade;
	 }
	 
	 public void setAltura(float altura) {
		 this.altura = altura;
	 }
	 
	 public void setNome(String nome) {
		 this.nome = nome;
	 }
}
