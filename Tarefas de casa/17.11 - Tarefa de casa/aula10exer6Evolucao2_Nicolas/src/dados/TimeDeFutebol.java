package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TimeDeFutebol {
	private StringBuilder nome;
	private ArrayList<Integer> anosCampeao;

	public TimeDeFutebol(String nomeRecebido) {
		nome = new StringBuilder(nomeRecebido);
		anosCampeao = new ArrayList<Integer>();
	}

	public void addAno(int ano) {
		this.anosCampeao.add(ano);
	}

	public ArrayList<Integer> getAnos() {
		return this.anosCampeao;
	}

	public String getNome() {
		return this.nome.toString();
	}

	public void ordenaAnos() {
		Collections.sort(this.getAnos(), new Comparator<Integer>() {
			public int compare(Integer ano1, Integer ano2) {
				return -ano1.compareTo(ano2);
			}
		});
	}

	public String toString() {

		String formato = "| %-35s | %-75s |";

		return String.format(formato, this.getNome(),
				(this.getAnos().size() > 0) ? this.getAnos().toString() : "Ainda nao foi campeao brasileiro!");

	}

	@Override
	public boolean equals(Object timeB) {
		try {
			return this.getNome().equalsIgnoreCase(((TimeDeFutebol) timeB).getNome());
		} catch (ClassCastException e) {
			return false;
		}

	}

}
