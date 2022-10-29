package dados;

import java.util.ArrayList;

public class Time {

	private ArrayList<Integer> anosDosTitulos;
	private String nomeDoTime;

	public Time(String nome) {
		this.nomeDoTime = nome;
		anosDosTitulos = new ArrayList<Integer>();
	}

	public void addAno(int ano) {
		anosDosTitulos.add(ano);
	}

	public ArrayList<Integer> getAnos() {
		return this.anosDosTitulos;
	}

	public String getNome() {
		return this.nomeDoTime;
	}


}
