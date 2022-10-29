package principal;

import dados.Mamifero;
import dados.Zoologico;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {

		boolean continuar;
		Zoologico zoo = new Zoologico();

		do {
			Mamifero animal = Visao.cadastraAnimal();
			if (animal != null) {
				zoo.addAnimal(animal);
				continuar = Visao.desejaContinuar(zoo.getZoologico().size());
			}
			else
				continuar = false;

		} while (continuar);

		Visao.mostraAnimais(zoo.getZoologico());

	}
}
