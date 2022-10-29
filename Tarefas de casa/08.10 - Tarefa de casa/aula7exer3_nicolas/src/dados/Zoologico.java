package dados;

import java.util.ArrayList;

public class Zoologico {

	private ArrayList<Mamifero> zoologico;

	public Zoologico() {
		zoologico = new ArrayList<Mamifero>();
	}

	public void addAnimal(Mamifero animal) {
		this.zoologico.add(animal);
	}

	public void addVariosAnimais(ArrayList<Mamifero> animais) {
		this.zoologico.addAll(animais);
	}

	public ArrayList<Mamifero> getZoologico() {
		return this.zoologico;
	}

	public Mamifero getAnimalPosicao(int posicao) {
		return this.zoologico.get(posicao);

	}
}
