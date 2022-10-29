package dados;

import java.util.ArrayList;

public class GrupoMamiferos {
	private ArrayList<Mamifero> grupoMamiferos;

	public GrupoMamiferos() {
		grupoMamiferos = new ArrayList<Mamifero>();
	}

	public ArrayList<Mamifero> getGrupoMamiferos() {
		return grupoMamiferos;
	}

	public void setGrupoMamiferos(Mamifero mamifero) {
		this.grupoMamiferos.add(mamifero);
	}
}
