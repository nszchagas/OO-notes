package dados;

import java.text.DecimalFormat;

public class Terreno {
	private StringBuilder endereco;
	private Integer areaOcupada;
	private Float valorAtual;
	
	public Terreno(String endereco, Integer areaOcupada, Float valorAtual) {
		setEndereco(endereco);
		setAreaOcupada(areaOcupada);
		setValorAtual(valorAtual);
	}

	public String getEndereco () {
		return endereco.toString();
	}

	public void setEndereco (String endereco) {
		this.endereco = new StringBuilder(endereco);
	}

	public Integer getAreaOcupada () {
		return areaOcupada;
	}

	public void setAreaOcupada (Integer areaOcupada) {
		this.areaOcupada = areaOcupada;
	}

	public Float getValorAtual () {
		return valorAtual;
	}

	public void setValorAtual (Float valorAtual) {
		this.valorAtual = valorAtual;
	}
	
	@Override
	public String toString() {
		return String.format(
			"%-40s%-40s%-30s%-50s%-30s%-40s", 
			"---", 
			"---", 
			"---", 
			getEndereco(), 
			getAreaOcupada(), 
			new DecimalFormat("0.00")
		);
	}
}
