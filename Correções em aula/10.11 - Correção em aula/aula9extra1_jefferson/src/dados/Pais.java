package dados;

import java.util.ArrayList;

public class Pais implements Pesquisas {
	private ArrayList<Cidade> cidades;

	public Pais() {
		this.cidades = new ArrayList<Cidade>();
	}

	public ArrayList<Cidade> getCidades() {
		return this.cidades;
	}

	public void addCidade(Cidade pais) {
		this.cidades.add(pais);
	}

	// -----------------------------------------------------------------------------------

	public boolean contains(StringBuilder cidade, StringBuilder estado) {
		for (Cidade pais : this.getCidades()) {

			if (pais.equals(cidade, estado))
				return true;
		}
		return false;
	}

	// METODOS DA INTERFACE
	public void mostraContaminadas(int quantidade) {
		for (Cidade cidade : getCidades()) {
			if (cidade.getContaminados() >= quantidade) {
				System.out.print(cidade);
			}
		}
	}

	
}