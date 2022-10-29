package dados;

import java.util.ArrayList;

import interfaces.AnalisaDados;

public class GrupoTerrenos implements AnalisaDados {
	private ArrayList<Terreno> terrenos;

	public GrupoTerrenos() {
		terrenos = new ArrayList<Terreno>();
	}

	public void addTerrenos(Terreno terreno) {
		terrenos.add(terreno);
	}

	public ArrayList<Terreno> getTerrenos() {
		return terrenos;
	}

	public ArrayList<Terreno> getTerrenosPorArea(int area) {
		ArrayList<Terreno> areasIguais = new ArrayList<Terreno>();
		for (Terreno terreno : terrenos) {
			if (terreno.getArea() == area)
				areasIguais.add(terreno);
		}

		return areasIguais;
	}

	public float calculaMaiorReal(char atributo) {
		float maior = 0.0f;
		switch (atributo) {
		case 'p':
			for (Terreno terreno : terrenos) {
				if (maior < terreno.getPreco())
					maior = terreno.getPreco();
			}
			break;
		case 'a':
			for (Terreno terreno : terrenos) {
				if (maior < terreno.getArea())
					maior = terreno.getArea();
			}
		}

		return maior;
	}

	public float calculaMenorReal(char atributo) {
		float menor = 1e9f;
		switch (atributo) {
		case 'p':
			for (Terreno terreno : terrenos) {
				if (menor > terreno.getPreco())
					menor = terreno.getPreco();
			}
			break;
		case 'a':
			for (Terreno terreno : terrenos) {
				if (menor > terreno.getArea())
					menor = terreno.getArea();
			}
		}

		return menor;
	}

	public boolean isValorDuplicado(int area) {
//		if (!getTerrenosPorArea(area).isEmpty()) {
//			System.out.println("TERRENOS ENCONTRADOS:");
//			for (Terreno terreno : getTerrenosPorArea(area))
//				System.out.println(terreno); // já mostrar aqui
//		}
		return !getTerrenosPorArea(area).isEmpty();
	}

	public double calculaSomatorio(char atributo) { //transformar esse metodo num "menu" e deixar um metodo so pra somar 
		double soma = 0.0;
		switch (atributo) {
		case 'a':
			for (Terreno terreno : terrenos)
				soma += terreno.getArea();
			break;
		case 'p':
			for (Terreno terreno : terrenos)
				soma += terreno.getPreco();
		}

		return soma;
	}

	public double calculaMedia(char atributo) {
		if (terrenos.size() == 0)
			return 0;
		return calculaSomatorio(atributo) / terrenos.size();
	}
}
