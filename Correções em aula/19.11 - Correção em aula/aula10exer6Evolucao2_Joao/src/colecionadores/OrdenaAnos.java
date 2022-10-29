package colecionadores;

import java.util.Comparator;

public class OrdenaAnos implements Comparator<Integer> {
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
}
