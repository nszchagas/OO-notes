package dados;

import visao.Visao;

public class Elefante extends Mamifero {
	
	private Float peso;
	private String habitatNatural;
	
	
	
	public Elefante(Mamifero mamifero, Float peso, String habitatNatural) {
		super(mamifero);
		this.setPeso(peso);
		this.setHabitatNatural(habitatNatural);
	}
	
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public String getHabitatNatural() {
		return habitatNatural;
	}
	public void setHabitatNatural(String habitatNatural) {
		this.habitatNatural = habitatNatural;
	}
	
	public String toString() {
		StringBuilder texto = new StringBuilder(Visao.ajustaTexto("Elefante", 10));
		texto.append(super.toString());
		texto.append(Visao.ajustaTexto("--", 12));
		texto.append(Visao.ajustaTexto(this.getPeso().toString(), 12));
		texto.append(Visao.ajustaTexto(this.getHabitatNatural(), 29));
		return texto.toString();		
	}
	
	

}
