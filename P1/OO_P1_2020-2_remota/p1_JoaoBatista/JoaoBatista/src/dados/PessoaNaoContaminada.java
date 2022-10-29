package dados;

public class PessoaNaoContaminada extends Pessoa{
	private Integer idade;
	
	public PessoaNaoContaminada(StringBuilder nome, char gen, int cod, int idade) {
		super(nome, gen, cod);
		this.setIdade(idade);
	}
	
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String toString() {
		return (this.getCodigo()+"\t|\t"+this.getNome()+"\t|\t"+this.getGenero()+"\t|\t"+this.getIdade()+"\t|\t----------\t|\t");
	}
}
