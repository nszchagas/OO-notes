package dados;

public class Mulher extends Pessoa {
	private String situacaoGestante;

	public Mulher(StringBuilder nome, String situacaoSaude, Integer codigo, String situacaoGestante) {
		super(nome, situacaoSaude, codigo);
		this.setSituacaoGestante(situacaoGestante);
	}

	public String getSituacaoGestante() {
		return situacaoGestante;
	}

	public void setSituacaoGestante(String situacaoGestante) {
		this.situacaoGestante = situacaoGestante;
	}

	public String toString() {
		String formato = "%-20s%-20s%-20s%-20s%-30s%-30s\n";
		return String.format(formato, this.getCodigo(), this.getNome(), "FEMININO", this.getSituacaoSaude(), "---",
				this.getSituacaoGestante());
	}

}
