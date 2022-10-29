package dados;

public class Mulher extends Pessoa {
	private Character gestante;

	public Mulher(String nome, Integer numCadastro, Character saude, Character gestante) {
		super(nome, numCadastro, saude);
		this.gestante = gestante;
	}

	public Character getGestante() {
		return gestante;
	}

	public void setGestante(Character gestante) {
		this.gestante = gestante;
	}

	public String toString() {
		return String.format("%-15s%-35s%-30s%-20s%-20s%-2s", this.getNumCadastro(), "| " + this.getNomeCompleto(),
				"| " + (this.getSaude() == 'T' ? "Contaminada em tratamento"
						: (this.getSaude() == 'F' ? "Contaminada falecida"
								: (this.getSaude() == 'C' ? "Contaminada curada" : "Sem contaminacao"))),
				"|     -",
				"| " + (this.getGestante() == 'S' ? "Sim" : (this.getGestante() == 'N' ? "Nao" : "Nao tenho certeza")),
				"|");
	}
}
