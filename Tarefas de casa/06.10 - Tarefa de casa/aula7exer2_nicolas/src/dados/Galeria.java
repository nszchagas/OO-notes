package dados;

import java.util.ArrayList;

public class Galeria {

	private ArrayList<Quadro> quadros;
	private ArrayList<Pintor> pintores;

	public Galeria() {
		quadros = new ArrayList<Quadro>();
		pintores = new ArrayList<Pintor>();
	}

	public void addQuadro(Quadro quadro) {
		this.quadros.add(quadro);
		this.pintores.add(quadro.getPintor());
	}

	public ArrayList<Quadro> getQuadros() {
		return this.quadros;
	}

	public void addPintor(Pintor pintor) {
		this.pintores.add(pintor);
	}

	public ArrayList<Pintor> getPintores() {
		return this.pintores;
	}

	// operações //

	public Pintor getPintorPorNome(String nome) {
		Pintor pintor = null;
		int posicao = 0;

		if (this.getPintores().size() == 0)
			return null;
		else
			while (posicao < this.getPintores().size() && pintor == null) {
				if (this.getPintores().get(posicao).getNome().contains(nome))
					pintor = this.getPintores().get(posicao);
				posicao++;
			}

		return pintor;
	}

	public ArrayList<Quadro> getQuadrosPorNome(String nome) {
		ArrayList<Quadro> quadros = new ArrayList<Quadro>();

		if (this.getQuadros().size() == 0)
			return null;
		for (int posicao = 0; posicao < this.getQuadros().size(); posicao++)
			if (this.getQuadros().get(posicao).getPintor().isNomePintor(nome))
				quadros.add(this.getQuadros().get(posicao));
		return quadros;
	}

	public ArrayList<Integer> getCodigosPintor() {
		ArrayList<Integer> codigos = new ArrayList<Integer>();
		if (this.getPintores().size() > 0)
			for (int posicao = 0; posicao < this.getPintores().size(); posicao++)
				codigos.add(this.getPintores().get(posicao).getCodigo());
		return codigos;
	}

	public ArrayList<Integer> getCodigosQuadro() {
		ArrayList<Integer> codigos = new ArrayList<Integer>();

		if (this.getQuadros().size() > 0) {
			for (int posicao = 0; posicao < this.getQuadros().size(); posicao++)
				codigos.add(this.getQuadros().get(posicao).getCodigo());
		}
		return codigos;

	}

}
