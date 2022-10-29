package dados;

public class Evento {
	private String presidente, evento;
	private Integer ano;
	
	public Evento(String evento, String presidente, Integer ano) {
		this.evento = evento;
		this.presidente = presidente;
		this.ano = ano;
	}
	
	public Integer getAno() {
		return this.ano;
	}
	
	public String getPresidente() {
		return this.presidente;
	}
	
	public String getEvento() {
		return this.evento;
	}

}
