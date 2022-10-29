package dados;

import java.text.DecimalFormat;

public class Elefante extends Mamifero {
	private Float peso;
	private String habitat;

	public Elefante(Integer idadeVida, Integer idadeAmamentacao, String descricaoEspecie, Float tamanhoAdulto,
			Float peso, String habitat) {
		super(idadeAmamentacao, idadeVida, descricaoEspecie, tamanhoAdulto);
		setPeso(peso);
		setHabitat(habitat);
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public Float getPeso() {
		return peso;
	}

	public String getHabitat() {
		return habitat;
	}

	public String toString() {
		DecimalFormat mascara = new DecimalFormat("0.00");
		String formato = "%-10s%-15s%-20s%-20s%-10s%-10s%-10s%-40s\n";
		return String.format(formato, this.getClass().getSimpleName(), this.getIdadeVida(), this.getIdadeAmamentacao(),
				this.getDescricaoEspecie(), mascara.format(this.getTamanhoAdulto()), '-', mascara.format(this.getPeso()), this.getHabitat());
	}
}
