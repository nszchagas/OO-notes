package dados;

public class Pessoa {
	private Integer id;
	private StringBuilder nomeCompleto;
	private Character situacaoSaude;

	public Pessoa(Integer id, StringBuilder nomeCompleto, Character situacaoSaude) {
		this.setId(id);
		this.setNomeCompleto(nomeCompleto);
		this.setSituacaoSaude(situacaoSaude);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StringBuilder getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(StringBuilder nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Character getSituacaoSaude() {
		return situacaoSaude;
	}

	public void setSituacaoSaude(Character situacaoSaude) {
		this.situacaoSaude = situacaoSaude;
	}

	public String getSituacaoSaudeExtenso() {
		switch (getSituacaoSaude()) {
		case 'T':
			return "Contaminada em Tratamento";
		case 'F':
			return "Contaminada Falecida";
		case 'C':
			return "Contaminada Curada";
		default:
			return "Sem Contaminacao";
		}
	}

	@Override
	public String toString() {
		return String.format("%-15s%-25s%-30s", getId(), getNomeCompleto(), getSituacaoSaudeExtenso());
	}
}
