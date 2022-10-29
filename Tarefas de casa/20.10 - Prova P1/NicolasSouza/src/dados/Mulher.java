package dados;

public class Mulher extends Pessoa {
	private Character situacaoGestante;

	public Mulher(Pessoa pessoa, Character situacaoGestante) {
		super(pessoa);
		this.setSituacaoGestante(situacaoGestante);
	}

	public Character getSituacaoGestante() {
		return situacaoGestante;
	}

	public void setSituacaoGestante(Character situacaoGestante) {
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

	public String toString() {
		String formato = "%-5s | %-15s |";
		return (super.toString() + String.format(formato, "---", this.getGestanteExtenso()));
	}

}
