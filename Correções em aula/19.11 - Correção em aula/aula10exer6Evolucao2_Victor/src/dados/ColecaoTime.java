package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColecaoTime {
	private List<TimeDeFutebol> times;

	public ColecaoTime() {
		this.times = new ArrayList<TimeDeFutebol>();
	}

	public List<TimeDeFutebol> getColecaoTime() {
		return Collections.unmodifiableList(times);
	}

	public void setColecaoTime(TimeDeFutebol time) {
		this.times.add(time);
	}
}
