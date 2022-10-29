package dados;

public class Saudavel extends Pessoa {
	private Integer idadeAnos;
	
	public Saudavel(String nomeCompleto, char genero, int identificacao, int idadeAnos) {
		super(nomeCompleto, genero, identificacao);
		setIdadeAnos(idadeAnos);
	}

	public Integer getIdadeAnos () {
		return idadeAnos;
	}

	public void setIdadeAnos (Integer idadeAnos) {
		this.idadeAnos = idadeAnos;
	}
	
	public String toString() {
		return String.format(
			"%-30s%-50s%-30s%-20s%-50s", 
			getIdentificacao(), 
			getNomeCompleto(), 
			getGenero(), 
			getIdadeAnos(), 
			"-"
		);
	}
}
