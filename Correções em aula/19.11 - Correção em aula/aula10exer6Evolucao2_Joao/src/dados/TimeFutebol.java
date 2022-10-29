package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import colecionadores.OrdenaAnos;

public class TimeFutebol {
	private StringBuilder nome;
	private List<Integer> anosCampeao;
	
	public TimeFutebol(String nome) {
		this.nome = new StringBuilder(nome);
		anosCampeao = new ArrayList<Integer>();
	}
	
	public void setAno (int ano) {
		this.anosCampeao.add(ano);
	}
	
	public String getNome () {
		return this.nome.toString();
	}
	
	public List<Integer> getAnosCampeao () {
		return this.anosCampeao;
	}
	
	@Override
	public String toString() {
		String string = "";
		if (getAnosCampeao().size() == 0) {
			string = "Ainda não foi campeão brasileiro";
		}
		else {
			Collections.sort(getAnosCampeao(), new OrdenaAnos());
			for (int i = 0; i < getAnosCampeao().size(); i++) {
				string += getAnosCampeao().get(i) + (i == getAnosCampeao().size() - 1 ? "" : ", ");
			}
		}
		return String.format("%-30s%s", getNome().toUpperCase(), string);
	}
}
