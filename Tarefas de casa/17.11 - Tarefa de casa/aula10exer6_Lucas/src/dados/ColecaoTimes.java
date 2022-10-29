package dados;

import java.util.ArrayList;

public class ColecaoTimes {

	private ArrayList<TimeDeFutebol> colecao;

	public ColecaoTimes() {
		colecao = new ArrayList<TimeDeFutebol>();
	}

	public void addTime(TimeDeFutebol time) {
		time.ordenaAnos();
		this.colecao.add(time);

	}

	public ArrayList<TimeDeFutebol> getTimes() {
		return this.colecao;
	}

}
