package dados;

import java.util.Vector;

public class Mulher extends Pessoa {
	private Character situacaoGestante;

	public Mulher(String nome, char situacaoDeSaude, char situacaoGestante) {
		super(nome, situacaoDeSaude);
		this.setSituacaoGestante(situacaoGestante);
	}

	public Mulher(int codigo, String nome, char situacaoDeSaude, char situacaoGestante) { // sobrecarga pra exibir o
																							// codigo na tabela
		super(nome, situacaoDeSaude);
		super.setID(codigo);
		this.setSituacaoGestante(situacaoGestante);
	}

	public Character getSituacaoGestante() {
		return situacaoGestante;
	}

	public void setSituacaoGestante(char situacaoGestante) {
		this.situacaoGestante = situacaoGestante;
	}

	private String getGestanteExtenso() {
		switch (this.getSituacaoGestante()) {
		case 'S':
			return "Sim";
		case 'N':
			return "Nao";
		case 'T':
			return "Nao tem certeza";
		}
		return "";
	}

	@Override
	public Vector<String> toVectorString() {
		Vector<String> dados = super.toVectorString();
		dados.add("----");
		dados.add(this.getGestanteExtenso());
		return dados;

	}

	@Override
	public boolean equals(Object obj) {
		try {
			return ((Mulher) obj).getNome().equalsIgnoreCase(this.getNome())
					&& ((Mulher) obj).getSituacaoGestante().equals(this.getSituacaoGestante())
					&& ((Mulher) obj).getSituacaoDeSaude().equals(this.getSituacaoDeSaude());

		} catch (ClassCastException e) {
			return false;

		}
	}

	@Override
	public String toString() {
		return (super.toString() + String.format("Já foi gestante? %s", this.getGestanteExtenso()));
	}

}
