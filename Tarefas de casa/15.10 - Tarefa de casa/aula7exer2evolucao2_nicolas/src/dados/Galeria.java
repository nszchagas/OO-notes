package dados;

import java.util.ArrayList;

public class Galeria {
	private ArrayList<Pintor> listaPintores;
	private ArrayList<Quadro> listaQuadros;

	public Galeria() {
		this.listaPintores = new ArrayList<Pintor>();
		this.listaQuadros = new ArrayList<Quadro>();
	}

	public ArrayList<Pintor> getListaPintores() {
		return listaPintores;
	}

	public void addPintor(Pintor pintor) {
		this.listaPintores.add(pintor);
	}

	public ArrayList<Quadro> getListaQuadros() {
		return listaQuadros;
	}

	public void addQuadro(Quadro quadro) {
		this.listaQuadros.add(quadro);
	}

	public ArrayList<Pintor> getPintoresPorNome(String nome) {
		ArrayList<Pintor> pintores = new ArrayList<Pintor>();
		for (Pintor pintor : this.getListaPintores())
			if (pintor.getNome().toLowerCase().contains(nome.toLowerCase().trim()))
				pintores.add(pintor);
		return pintores;
	}

	public ArrayList<Quadro> getQuadrosPorPintor(Integer codigo) {
		ArrayList<Quadro> quadros = new ArrayList<Quadro>();
		for (Quadro quadro : this.getListaQuadros())
			if (quadro.getPintor().getCodigo() == codigo)
				quadros.add(quadro);
		return quadros;
	}

	public Pintor getPintorPorCodigo(Integer codigo) {
		for (Pintor pintor : this.getListaPintores())
			if (pintor.getCodigo().equals(codigo))
				return pintor;

		return null;
	}

	public Float getPrecoQuadrosPintor(Pintor pintor) {
		Float preco = 0f;
		for (Quadro quadro : this.getListaQuadros())
			if (quadro.getPintor() == pintor)
				preco += quadro.getPreco();
		return preco;

	}
}
