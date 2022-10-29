package dados;

import java.util.ArrayList;

import interfaces.Pesquisas;

public class ColecaoCidades implements Pesquisas<Cidade> {

	ArrayList<Cidade> cidades;

	public ColecaoCidades() {
		cidades = new ArrayList<Cidade>();
	}

	public void add(Cidade cidade) {
		this.cidades.add(cidade);
	}

	public ArrayList<Cidade> getColecao() {
		return this.cidades;
	}

	@Override
	public ArrayList<Cidade> mostraContaminadas(ArrayList<Cidade> cidades, int parametro) {
		ArrayList<Cidade> cidadesParametro = new ArrayList<Cidade>();
		for (Cidade cidade : cidades)
			if (cidade.getContaminados() >= parametro)
				cidadesParametro.add(cidade);
		return cidadesParametro;
	}
}
