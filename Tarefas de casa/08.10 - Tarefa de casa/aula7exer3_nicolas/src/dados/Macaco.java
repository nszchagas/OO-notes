package dados;

import visao.Visao;

public class Macaco extends Mamifero {

	String porte;

	public Macaco(Mamifero mamifero, String porte) {
		super(mamifero);
		this.setPorte(porte);
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String toString() {
		StringBuilder texto = new StringBuilder(Visao.ajustaTexto("Macaco", 10));
		texto.append(super.toString());
		texto.append(Visao.ajustaTexto(this.getPorte(), 12));
		texto.append(Visao.ajustaTexto("--", 12));
		texto.append(Visao.ajustaTexto("--", 29));
		return texto.toString();
	}

}
