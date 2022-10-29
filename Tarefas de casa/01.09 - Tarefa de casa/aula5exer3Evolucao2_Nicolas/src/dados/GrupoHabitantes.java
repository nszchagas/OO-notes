package dados;

import java.util.Vector;

public class GrupoHabitantes {
	private Vector<Habitante> habitantes;

	public GrupoHabitantes() {
		this.habitantes = new Vector<Habitante>();
	}

	public void addHabitante(Habitante habitante) {
		this.habitantes.add(habitante);
	}

	public Vector<Habitante> getHabitantes() {
		return habitantes;
	}

	public Habitante getHabitanteNaPosicao(int posicao) {
		return this.habitantes.elementAt(posicao);
	}
}