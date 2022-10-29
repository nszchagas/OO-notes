package principal;

import java.text.DecimalFormat;

public class PessoaInfectada extends Pessoa{
	private Character situacaoSaude;
	
	public PessoaInfectada(String nome, Character genero, Integer identificador, Character situacaoSaude) {
		super(nome, genero, identificador);
		setSituacaoSaude(situacaoSaude);
	}

	public void setSituacaoSaude(Character situacaoSaude) {
		this.situacaoSaude = situacaoSaude;
	}
	
	public Character getSituacaoSaude() {
		return this.situacaoSaude;
	}
	
	public String toString() {
		String formato = "%-3s%-15s%-20s%-13s\n";
		return String.format(formato, "", this.getNome(), this.getGenero(),
				this.getIdentificador(), this.getSituacaoSaude());
	}
}
