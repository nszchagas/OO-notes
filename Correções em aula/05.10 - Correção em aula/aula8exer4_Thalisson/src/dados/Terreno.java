package dados;

import java.text.DecimalFormat;

public class Terreno {
	private StringBuilder endereco;
	private Integer area;
	private Float preco;
	
	public Terreno(StringBuilder endereco, int area, float preco) {
		this.endereco = endereco;
		this.area = area;
		this.preco = preco;
	}
	
	public StringBuilder getEndereco() {
		return endereco;
	}
	
	public int getArea() {
		return area;
	}
	
	public float getPreco() {
		return preco;
	}

	public String toString() {
		String formato = "%-20.20s %-20.20s %-20.20s";
		return String.format(formato, getEndereco(), getArea(), new DecimalFormat("0.00").format(getPreco()));
	}
}
