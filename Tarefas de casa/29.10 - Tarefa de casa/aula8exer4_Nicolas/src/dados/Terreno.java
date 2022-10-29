package dados;

public class Terreno {

	private StringBuilder endereco;
	private Integer area;
	private Float valor;

	public Terreno(StringBuilder endereco, Integer area, Float valor) {
		super();
		this.setEndereco(endereco);
		this.setArea(area);
		this.setValor(valor);
	}

	public StringBuilder getEndereco() {
		return endereco;
	}

	public void setEndereco(StringBuilder endereco) {
		this.endereco = endereco;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	

	@Override
	public String toString() {
		String formato = "%-11d | %-80s | %.2f\n";
		return String.format(formato, this.getArea(), this.getEndereco(), this.getValor());
	}

}
