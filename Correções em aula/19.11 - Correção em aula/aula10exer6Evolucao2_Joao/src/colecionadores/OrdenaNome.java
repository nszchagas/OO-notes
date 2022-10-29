package colecionadores;

import java.util.Comparator;
import dados.TimeFutebol;

public class OrdenaNome implements Comparator<TimeFutebol> {
	public int compare(TimeFutebol o1, TimeFutebol o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}
