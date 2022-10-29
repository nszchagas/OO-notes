package dados;

public class Evento {

	private Integer ano;
	private String presidenteAno;
	private String eventoImportante;

	public Evento(int ano, String presidente, String evento) {
		this.setAno(ano);
		this.setPresidenteAno(presidente);
		this.setEventoImportante(evento);

	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPresidenteAno() {
		return presidenteAno;
	}

	public void setPresidenteAno(String presidenteAno) {
		this.presidenteAno = presidenteAno;
	}

	public String getEventoImportante() {
		return eventoImportante;
	}

	public void setEventoImportante(String eventoImportante) {
		this.eventoImportante = eventoImportante;
	}

}
