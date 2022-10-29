package dados;

public class Mulher extends Pessoa {
	private Character gestante;

	public Mulher(Integer identificador, String nomeCompleto, Character situacaoSaude, Character gestante) {
		super(identificador, nomeCompleto, situacaoSaude);
		setGestante(gestante);
	}

	public void setGestante(Character gestante) {
		this.gestante = gestante;
	}

	public Character getGestante() {
		return gestante;
	}

	public String toString() {
		String formato = "%-20s%-30s%-30s%-20s%-20s\n";
		return String.format(formato, this.getIdentificador(), this.getNomeCompleto(),
				((this.getSituacaoSaude() == 'T') ? "Contaminada em Tratamento"
						: (this.getSituacaoSaude() == 'F') ? "Contaminada falecida"
								: (this.getSituacaoSaude() == 'C') ? "contaminada Curada" : "Sem contaminacao"),
				"---", ((this.getGestante() == 'S') ? "Sim" : (this.getGestante() == 'N') ? "Nao" : "Nao tem certeza"));
	}
}
