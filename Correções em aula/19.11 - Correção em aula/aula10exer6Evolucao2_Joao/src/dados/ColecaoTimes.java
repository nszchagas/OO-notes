package dados;

import java.util.ArrayList;
import java.util.List;

public class ColecaoTimes {
	private List<TimeFutebol> colecaoTimes;
	
	public ColecaoTimes () {
		this.colecaoTimes = new ArrayList<TimeFutebol>();
	}

	public List<TimeFutebol> getColecaoTimes () {
		return colecaoTimes;
	}

	public void setColecaoTimes (TimeFutebol time) {
		this.colecaoTimes.add(time);
	}
}
