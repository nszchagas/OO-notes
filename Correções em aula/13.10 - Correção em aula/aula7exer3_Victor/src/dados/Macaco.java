package dados;

import java.text.DecimalFormat;

public class Macaco extends Mamifero {
	private Character porte;

	public Macaco(Integer idadeVida, Integer idadeAmamentacao, String descricaoEspecie, Float tamanhoAdulto,
			Character porte) {
		super(idadeVida, idadeAmamentacao, descricaoEspecie, tamanhoAdulto);
		setPorte(porte);
	}

	public void setPorte(Character porte) {
		this.porte = porte;
	}

	public Character getPorte() {
		return this.porte;
	}

	public String toString() {
		DecimalFormat mascara = new DecimalFormat("0.00");
		String formato = "%-10s%-15s%-20s%-20s%-10s%-10s%-10s%-40s\n";
		return String.format(formato, this.getClass().getSimpleName(), this.getIdadeVida(), this.getIdadeAmamentacao(),
				this.getDescricaoEspecie(), mascara.format(this.getTamanhoAdulto()),
				((this.getPorte() == 'P') ? "Pequeno" : (this.getPorte() == 'M') ? "Medio" : "Grande"), '-', '-'); //tirar o get.Class().getSimpleName()
	}

}
