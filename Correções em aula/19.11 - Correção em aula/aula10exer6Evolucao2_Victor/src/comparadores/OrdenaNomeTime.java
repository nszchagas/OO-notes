package comparadores;

import java.util.Comparator;
import dados.TimeDeFutebol;

public class OrdenaNomeTime implements Comparator<TimeDeFutebol> {
	public int compare(TimeDeFutebol time1, TimeDeFutebol time2) {
		return (time1.getNome().compareTo(time2.getNome()));
	}
}
