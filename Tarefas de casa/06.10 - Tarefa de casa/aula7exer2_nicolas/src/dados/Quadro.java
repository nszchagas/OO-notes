package dados;

public class Quadro {
	
	private Integer codigo;
	private Pintor pintor;
	private Float preco;
	private Integer anoDeAquisicao;

	public Quadro(Pintor pintor, int codigo, int ano, float preco) {

		this.setAnoDeAquisicao(ano);
		this.setCodigo(codigo);
		this.setPintor(pintor);
		this.setPreco(preco);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Pintor getPintor() {
		return pintor;
	}

	public void setPintor(Pintor pintor) {
		this.pintor = pintor;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getAnoDeAquisicao() {
		return anoDeAquisicao;
	}

	public void setAnoDeAquisicao(Integer anoDeAquisicao) {
		this.anoDeAquisicao = anoDeAquisicao;
	}
	
	
	
	

}
