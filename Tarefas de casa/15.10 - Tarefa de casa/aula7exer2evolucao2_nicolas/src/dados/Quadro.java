package dados;

import java.text.DecimalFormat;

public class Quadro {
	private Integer codigo;
	private Pintor pintor;
	private Float preco;
	private Integer anoAquisicao;

	public Quadro(int codigoIdentificacao, Pintor pintor, float preco, int anoAquisicao) {
		setCodigo(codigoIdentificacao);
		setPintor(pintor);
		setPreco(preco);
		setAnoAquisicao(anoAquisicao);
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigoIdentificacao) {
		this.codigo = codigoIdentificacao;
	}

	public Pintor getPintor() {
		return this.pintor;
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

	public Integer getAnoAquisicao() {
		return this.anoAquisicao;
	}

	public void setAnoAquisicao(Integer anoAquisicao) {
		this.anoAquisicao = anoAquisicao;
	}

	public String toString() {
		String formato = "| %-30s | %-30s | %-20s | %-20s |";
		return String.format(formato, this.getCodigo(), this.getPintor().getNome(),
				new DecimalFormat("0.00").format(this.getPreco()), this.getAnoAquisicao());
	}
}
