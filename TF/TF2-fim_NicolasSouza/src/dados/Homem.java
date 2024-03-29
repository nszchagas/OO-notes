package dados;

import java.util.Vector;

public class Homem extends Pessoa {
	private Integer idade;

	public Homem(String nome, char situacaoDeSaude, int idade) {
		super(nome, situacaoDeSaude);
		this.idade = idade;
	}

	public Homem(int codigo, String nome, char situacaoDeSaude, int idade) { // sobrecarga pra exibir com o codigo na
																				// tabela
		super(nome, situacaoDeSaude);
		super.setID(codigo);
		this.idade = idade;
	}

	public Integer getIdade() { //n�o precisa do setIDade 
		return idade;
	}

	@Override
	public Vector<String> toVectorString() {
		Vector<String> dados = super.toVectorString();
		dados.add(this.getIdade().toString());
		dados.add("----");
		return dados;

	}

	@Override
	public String toString() {
		return (super.toString() + String.format("Idade: %s", this.getIdade()));
	}

	@Override
	public boolean equals(Object obj) {
		try {
			return ((Homem) obj).getNome().equalsIgnoreCase(this.getNome())
					&& ((Homem) obj).getIdade().equals(this.getIdade())
					&& ((Homem) obj).getSituacaoDeSaude().equals(this.getSituacaoDeSaude());
		} catch (ClassCastException e) {
			return false;
		}
	}

}
