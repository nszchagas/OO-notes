package dados;

import java.text.DecimalFormat;

public abstract class Pessoa {
	private StringBuilder nome;
	private Integer codigo;
	private Character situacaoDeSaude;

	public Pessoa(String nome, char situacaoDeSaude) {
		this.setNome(new StringBuilder(nome));
		this.setSituacaoDeSaude(situacaoDeSaude);
	}

	public StringBuilder getNome() {
		return nome;
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Character getSituacaoDeSaude() {
		return situacaoDeSaude;
	}

	public void setSituacaoDeSaude(Character situacaoDeSaude) {
		this.situacaoDeSaude = situacaoDeSaude;
	}

	private String getSituacaoDeSaudeExtenso() {
		switch (this.getSituacaoDeSaude()) {
		case 'T':
			return "Contaminado(a) em tratamento";
		case 'F':
			return "Contaminado(a) falecido(a)";
		case 'C':
			return "Contaminado(a) curado(a)";
		case 'S':
			return "Sem contaminacao";
		}
		return "";
	}

	public String toString() {
		String formato = "| %-13s | %-33s | %-28s | ";
		return String.format(formato, new DecimalFormat("00").format(this.getCodigo()), this.getNome(),
				this.getSituacaoDeSaudeExtenso());
	}

}
