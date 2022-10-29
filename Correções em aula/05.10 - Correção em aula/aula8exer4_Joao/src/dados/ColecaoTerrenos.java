package dados;

import java.util.ArrayList;
import interfaces.AnalisaDados;

public class ColecaoTerrenos implements AnalisaDados{
	private ArrayList<Terreno> colecaoTerrenos;
	
	public ColecaoTerrenos () {
		this.colecaoTerrenos = new ArrayList<Terreno>();
	}

	public ArrayList<Terreno> getColecaoTerrenos () {
		return colecaoTerrenos;
	}

	public void setColecaoTerrenos (Terreno terreno) {
		this.colecaoTerrenos.add(terreno);
	}

	
	public float achaMenorValor() {
		float menorValor = colecaoTerrenos.get(0).getValorAtual();
		for (Terreno terreno : this.colecaoTerrenos) {
			if (terreno.getValorAtual() <= menorValor) {
				menorValor = terreno.getValorAtual();
			}
		}
		return menorValor;
	}

	
	public float achaMaiorValor() {
		float maiorValor = colecaoTerrenos.get(0).getValorAtual();
		for (Terreno terreno : this.colecaoTerrenos) {
			if (terreno.getValorAtual() >= maiorValor) {
				maiorValor = terreno.getValorAtual();
			}
		}
		return maiorValor;
	}

	
	public boolean isInteiroRepetido(int valor) {
		for (Terreno terreno : this.colecaoTerrenos) {
			if (terreno.getAreaOcupada().equals(valor)) {
				return true;
			}
		}
		return false;
	}

	
	public float calculaSomatorio() {
		float total = 0f;
		for (Terreno terreno : this.colecaoTerrenos) {
			total += terreno.getValorAtual();
		}
		return total;
	}

	
	public float calculaMedia() {
		return calculaSomatorio() / this.colecaoTerrenos.size();
	}
}