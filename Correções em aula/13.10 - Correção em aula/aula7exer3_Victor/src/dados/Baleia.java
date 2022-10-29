package dados;

import java.text.DecimalFormat;

public class Baleia extends Mamifero {
	private Float peso;

	public Baleia(Integer idadeVida, Integer idadeAmamentacao, String descricaoEspecie, Float tamanhoAdulto,
			Float peso) {
		super(idadeVida, idadeAmamentacao, descricaoEspecie, tamanhoAdulto);
		setPeso(peso);
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getPeso() {
		return peso;
	}

	public String toString() {
		DecimalFormat mascara = new DecimalFormat("0.00");
		String formato = "%-10s%-15s%-20s%-20s%-10s%-10s%-10s%-40s\n";
		return String.format(formato, this.getClass().getSimpleName(), this.getIdadeVida(), this.getIdadeAmamentacao(),
				this.getDescricaoEspecie(), mascara.format(this.getTamanhoAdulto()), '-', mascara.format(this.getPeso()),  '-');
	}
}
