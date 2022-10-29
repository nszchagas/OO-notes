package dados;

public class Mamifero {
	private Integer idadeAmamentacao;
	private Integer idadeVida;
	private String descricaoEspecie;
	private Float tamanhoAdulto;

	public Mamifero(Integer idadeVida, Integer idadeAmamentacao, String descricaoEspecie, Float tamanhoAdulto) {
		setIdadeVida(idadeVida);
		setIdadeAmamentacao(idadeAmamentacao);
		setDescricaoEspecie(descricaoEspecie);
		setTamanhoAdulto(tamanhoAdulto);
	}

	public void setIdadeAmamentacao(Integer idadeAmamentacao) {
		this.idadeAmamentacao = idadeAmamentacao;
	}

	public void setIdadeVida(Integer idadeVida) {
		this.idadeVida = idadeVida;
	}

	public void setDescricaoEspecie(String descricaoEspecie) {
		this.descricaoEspecie = descricaoEspecie;
	}

	public void setTamanhoAdulto(Float tamanhoAdulto) {
		this.tamanhoAdulto = tamanhoAdulto;
	}

	public Integer getIdadeAmamentacao() {
		return idadeAmamentacao;
	}

	public Integer getIdadeVida() {
		return idadeVida;
	}

	public String getDescricaoEspecie() {
		return descricaoEspecie;
	}

	public Float getTamanhoAdulto() {
		return tamanhoAdulto;
	}
}
