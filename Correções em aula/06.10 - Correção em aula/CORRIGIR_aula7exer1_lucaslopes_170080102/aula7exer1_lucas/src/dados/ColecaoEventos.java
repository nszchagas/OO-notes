package dados;

import java.util.ArrayList;

public class ColecaoEventos {
	private ArrayList<Evento> colecaoEventos;
	
	public ColecaoEventos(Evento evento) {
		this.colecaoEventos = new ArrayList<Evento>();
		addEvento(evento);
	}
	
	public void addEvento(Evento evento) {
		this.colecaoEventos.add(evento);
	}
	
	public ArrayList<Evento> getColecaoEventos(){
		return this.colecaoEventos;
	}

}
