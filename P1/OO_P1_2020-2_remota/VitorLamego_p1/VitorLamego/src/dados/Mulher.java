package dados;

import servicos.Servicos;

public class Mulher extends Pessoa {
	private Character gestante;
	
	public Mulher(StringBuilder nomeCompleto, char estadoSaude, char gestante, int identificador) {
		super(nomeCompleto, estadoSaude, identificador);
		setGestante(gestante);
	}

	public Character getGestante() {
		return gestante;
	}

	public void setGestante(Character gestante) {
		this.gestante = gestante;
	}
	
	public String toString() {
		String gestacao = Servicos.transformaCaracterGestacao(this.getGestante());
		String situacao = Servicos.tranformaCaracterEstadoSaude(this.getEstadoSaude());
		String formato = "%-20s%-20s%-30s%-20s%-20s\n";
		return String.format(formato,this.getIdentificador(), this.getNomeCompleto(), situacao, "-----", gestacao);
	}
}
