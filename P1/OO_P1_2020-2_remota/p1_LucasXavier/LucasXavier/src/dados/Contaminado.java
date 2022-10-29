package dados;

public class Contaminado extends Pessoa{
	private Character situacao; // E-em tratamento, F-falecido ou C-curado 
	
	public Contaminado(String pNome, char pGenero, int pId, char pSituacao) {
		super(pNome, pGenero, pId);
		this.setSituacao(pSituacao);
	}
	
	public Contaminado(Pessoa pPessoa, char pSituacao) {
		super(pPessoa);
		this.setSituacao(pSituacao);
	}

	public char getSituacao() {
		return situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}
	
	public String getSituacaoString() {
		switch (this.getSituacao()) {
		case 'E':
			return "Em tratamento";
		case 'F':
			return "Falecido";
		default:
			return "Curado";
		}
	}
	
	public String toString() { // Identificador, Nome completo, Gênero por extenso, Idade e Situação
		String formato = "%-3d\t%-20s\t%-8s\t%-5s\t%-10s%n";
		String str = String.format(formato, getIdentificador(), getNomeCompleto(), getGeneroString(), "---", getSituacaoString());
		return str;
	}
}
