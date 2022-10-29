package dados;

public class Pessoa {
	private Integer identificador;
	private StringBuilder nomeCompleto;
	private Character situacaoSaude;
	
	public Pessoa(int id, StringBuilder nome, char situacaoSaude) {
		identificador = id;
		nomeCompleto = nome;
		this.situacaoSaude = situacaoSaude;
	}
	
	public int getId() {
		return identificador;
	}
	
	public char getSituacaoSaude() {
		return situacaoSaude;
	}
	
	private String converteSaudeExtenso() {
		switch (situacaoSaude) {
		case 'T':
			return "Contaminada em tratamento";
		case 'F':
			return "Contaminada falecida";
		case 'C':
			return "Contaminada curada";
		default:
			return "Sem contaminacao";
		}
	}
	
	public String toString() {
		return String.format("%-18.18s %-20.20s %-30.30s ", identificador, nomeCompleto, converteSaudeExtenso());
	}
}
