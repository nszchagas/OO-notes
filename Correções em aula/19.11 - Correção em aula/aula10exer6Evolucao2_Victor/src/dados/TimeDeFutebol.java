package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeDeFutebol {
	private StringBuilder nome;
	private List<Integer> anosCampeao;

	public TimeDeFutebol(String pNome) {
		nome = new StringBuilder(pNome);
		anosCampeao = new ArrayList<Integer>();
	}

	public void addAno(int ano) {
		this.anosCampeao.add(ano);
	}

	public Integer getAnosCampeao(int i) {
		return this.anosCampeao.get(i);
	}

	public List<Integer> getAnosCampeao() {
		return this.anosCampeao;
	}

	public String getNome() {
		return this.nome.toString();
	}

	public String toString() {
		StringBuilder apresentacaoTime = new StringBuilder(
				String.format("%-3s%-20s", "", this.getNome().toString().toUpperCase()));
		if (this.getAnosCampeao().isEmpty()) {
			apresentacaoTime.append("Ainda nao foi campeao brasileiro");
		} else {
			Collections.sort(this.getAnosCampeao(), Collections.reverseOrder());
			for (Integer ano : this.anosCampeao) {
				apresentacaoTime.append(ano + " ");
			}
		}
		return apresentacaoTime.toString();
	}
}
