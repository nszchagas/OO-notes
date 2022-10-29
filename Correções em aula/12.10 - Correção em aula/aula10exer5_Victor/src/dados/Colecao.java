package dados;

import java.util.ArrayList;

import visao.Visao;

public class Colecao {
	private ArrayList<Cidade> listaCidades;

	public Colecao() {
		listaCidades = new ArrayList<Cidade>();
	}

	public void setListaCidades(Cidade cidade) {
		this.listaCidades.add(cidade);
	}

	public ArrayList<Cidade> getListaCidades() {
		return this.listaCidades;
	}

	public Cidade getListaCidades(int i) {
		return this.listaCidades.get(i);
	}

	public void cadastrarCidade(Cidade cidade) {
		if (this.listaCidades.contains(cidade)) {
			Visao.mostraMensagemAviso("Cidade ja cadastrada!");
		} else {
			this.setListaCidades(cidade);
		}
	}
}
