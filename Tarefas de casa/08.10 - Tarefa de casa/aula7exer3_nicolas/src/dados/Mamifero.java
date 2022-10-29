package dados;

import visao.Visao;

public class Mamifero {

	protected Integer idadeAmamentacao;
	protected Integer idadeVida;
	protected String especie;
	protected Float tamanho;

	public Mamifero(String especie, Float tamanho, Integer idadeAmamentacao, Integer idadeVida) {
		this.setIdadeAmamentacao(idadeAmamentacao);
		this.setIdadeVida(idadeVida);
		this.setEspecie(especie);
		this.setTamanho(tamanho);
	}

	public Mamifero(Mamifero mamifero) {
		this.setIdadeAmamentacao(mamifero.getIdadeAmamentacao());
		this.setIdadeVida(mamifero.getIdadeVida());
		this.setEspecie(mamifero.getEspecie());
		this.setTamanho(mamifero.getTamanho());
	}

	public Integer getIdadeAmamentacao() {
		return idadeAmamentacao;
	}

	public void setIdadeAmamentacao(Integer idadeAmamentacao) {
		this.idadeAmamentacao = idadeAmamentacao;
	}

	public Integer getIdadeVida() {
		return idadeVida;
	}

	public void setIdadeVida(Integer idadeVida) {
		this.idadeVida = idadeVida;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Float getTamanho() {
		return tamanho;
	}

	public void setTamanho(Float tamanho) {
		this.tamanho = tamanho;
	}

	public String toString() {

		StringBuilder texto = new StringBuilder("");
		texto.append(Visao.ajustaTexto(this.getEspecie(), 32));
		texto.append(Visao.ajustaTexto(this.getTamanho().toString(), 13));
		texto.append(Visao.ajustaTexto(this.getIdadeAmamentacao().toString(), 29));
		texto.append(Visao.ajustaTexto(this.getIdadeVida().toString(), 22));

		return texto.toString();

	}

}
