package dados;

import java.util.Vector;

public class Homem extends Pessoa {
	private Integer idade;

	public Homem(String nome, char situacaoDeSaude, int idade) {
		super(nome, situacaoDeSaude);
		this.setIdade(idade);
	}

	public Homem(int codigo, String nome, char situacaoDeSaude, int idade) { // sobrecarga pra exibir o codigo na
																				// tabela
		super(nome, situacaoDeSaude);
		super.setID(codigo);
		this.setIdade(idade);
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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
