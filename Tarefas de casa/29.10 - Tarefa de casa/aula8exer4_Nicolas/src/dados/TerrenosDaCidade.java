package dados;

import java.util.Collections;
import java.util.Vector;

import interfaces.AnaliseDados;

public class TerrenosDaCidade implements AnaliseDados {

	private Vector<Terreno> terrenos;

	public TerrenosDaCidade() {
		terrenos = new Vector<Terreno>();
	}

	public TerrenosDaCidade(TerrenosDaCidade terrenos) {
		this.terrenos = terrenos.getTerrenos();
	}

	public Vector<Terreno> getTerrenos() {
		return this.terrenos;
	}

	public void addTerreno(Terreno terreno) {
		this.getTerrenos().add(terreno);
	}

	public Vector<Float> getValores() {
		Vector<Float> valores = new Vector<Float>();

		for (Terreno terreno : this.getTerrenos())
			valores.add(terreno.getValor());
		return valores;
	}

	@Override
	public float[] getMaiorEMenor() {
		Vector<Float> ordenado = new Vector<Float>(this.getValores());
		Collections.sort(ordenado);
		return new float[] { ordenado.elementAt(ordenado.size() - 1), ordenado.elementAt(0) };
	}

	@Override
	public Vector<Object> getDuplicados(int areaProcurada) {
		Vector<Object> terrenos = new Vector<Object>();
		for (Terreno terreno : this.getTerrenos())
			if (terreno.getArea().equals(areaProcurada))
				terrenos.add(terreno);
		return terrenos;
	}

	@Override
	public float getSoma(char tipo) {
		// tipo = 'f' float(valores) ou 'i' inteiro(areas) (Terrenos)

		float soma = 0f;
		for (Terreno terreno : this.getTerrenos())
			soma += (tipo == 'f') ? terreno.getValor() : terreno.getArea();
		return soma;
	}

	@Override
	public float getMedia(char tipo) {
		if (this.getTerrenos().size() > 0)
			return this.getSoma(tipo) / this.getTerrenos().size();
		else
			return 0;
	}

}
