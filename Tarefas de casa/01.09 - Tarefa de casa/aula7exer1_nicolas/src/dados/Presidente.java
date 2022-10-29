package dados;

public class Presidente {

	private String nome;

	private Integer inicioMandato, finalMandato;

	public Presidente(String nome, int inicioMandato, int finalMandato) {
		this.setNome(nome);
		this.setInicioMandato(inicioMandato);
		this.setFinalMandato(finalMandato);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getInicioMandato() {
		return inicioMandato;
	}

	public void setInicioMandato(int inicioMandato) {
		this.inicioMandato = inicioMandato;
	}

	public Integer getFinalMandato() {
		return finalMandato;
	}

	public void setFinalMandato(int finalMandato) {
		this.finalMandato = finalMandato;
	}

}
