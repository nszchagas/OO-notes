package dados;


public class Homem extends Pessoa {
	private Integer idade;

	public Homem(Integer idPessoa, StringBuilder nome, String situacao, Integer idade) {
		super(idPessoa, nome, situacao);
		setIdade(idade);

	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String toString() {

		return (this.getIdPessoa() + "\t\t\t" + this.getNome() + "\t\t\t" + this.getSituacao() + "\t\t\t"
				+ this.getIdade() + "\t\t\t-");
	}

}
