package dados;

public class Pessoa {
	private Integer identificador;
	private StringBuffer nome;
	private Character situacaoSaude;
	
	public Pessoa(Integer identificador, String nome, Character situacaoSaude) {
		setIdentificador(identificador);
		this.nome = new StringBuffer();
		setNome(nome);
		setSituacaoSaude(situacaoSaude);
	}
	
	protected void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	protected void setNome(String nome) {
		this.nome.append(nome);
	}
	protected void setSituacaoSaude(Character situacaoSaude) {
		this.situacaoSaude = situacaoSaude;
	}
	
	public Integer getIdentificador() {
		return this.identificador;
	}
	public String getNome() {
		return this.nome.toString();
	}
	public Character getSituacaoSaude() {
		return this.situacaoSaude;
	}
	
	protected String getSituacaoSaudePorExtenso() {
		switch(this.situacaoSaude) {
		case 'T':
			return "contaminada em Tratamento";
		case 'F':
			return "contaminada Falecida";
		case 'C':
			return "contaminada Curada";
		case 'S':
			return "Sem contaminacao";
		default:
			return "";
		}
	}
}
