package dados;

public class Pessoa {
	private StringBuilder nomeCompleto;
	private Character estadoSaude;
	private Integer identificador;
	
	public Pessoa(StringBuilder nomeCompleto, char estadoSaude, int identificador) {
		setEstadoSaude(estadoSaude);
		setNomeCompleto(nomeCompleto);
		setIdentificador(identificador);
	}
	
	public StringBuilder getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(StringBuilder nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public Character getEstadoSaude() {
		return estadoSaude;
	}
	public void setEstadoSaude(Character estadoSaude) {
		this.estadoSaude = estadoSaude;
	}
	
	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
	
}
