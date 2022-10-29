package dados;

public class Pessoa {
	private StringBuilder nomeCompleto;
	private Integer numCadastro;
	private Character saude;
	
	
	
	public Pessoa(String nome, Integer numCadastro, Character saude) {
		this.nomeCompleto = new StringBuilder(nome);
		this.numCadastro = numCadastro;
		setSaude(saude);
	}

	public StringBuilder getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(StringBuilder nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getNumCadastro() {
		return numCadastro;
	}

	public Character getSaude() {
		return saude;
	}

	public void setSaude(Character saude) {
		this.saude = saude;
	}
	
	


}
