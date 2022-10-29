package dados;

public class Mulher extends Pessoa{
	private Character gestante;
	
	public Mulher(Integer identificador, String nome, Character situacaoSaude, Character gestante) {
		super(identificador, nome, situacaoSaude);
		setGestante(gestante);
	}

	private void setGestante(Character gestante) {
		this.gestante = gestante;
	}
	
	public Character getGestante() {
		return this.gestante;
	}
	
	public String getGestantePorExtenso() {
		switch(this.gestante) {
		case 'S':
			return "sim";
		case 'N':
			return "nao";
		case 'T':
			return "nao tem certeza";
		default:
			return "";
		}
	}
	
	public String toString() {
		return String.format("%-15s%-40s%-28s%-15s%-20s", this.getIdentificador(), this.getNome(),
				this.getSituacaoSaudePorExtenso(), "", this.getGestantePorExtenso());
	}
}
