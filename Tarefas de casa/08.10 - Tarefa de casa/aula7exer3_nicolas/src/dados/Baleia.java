package dados;

import visao.Visao;

public class Baleia extends Mamifero {

	private Float peso;

	public Baleia(Mamifero mamifero, Float peso) {
		super(mamifero);
		this.setPeso(peso);
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String toString() {
		StringBuilder texto = new StringBuilder(Visao.ajustaTexto("Baleia", 10));
		texto.append(super.toString());
		texto.append(Visao.ajustaTexto("--", 12));
		texto.append(Visao.ajustaTexto(this.getPeso().toString(), 12));
		texto.append(Visao.ajustaTexto("--", 29));
		return texto.toString();

	}

}
