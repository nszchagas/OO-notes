package dados;

import java.util.ArrayList;
import interfaces.AnalisaDados;

public class ColecaoEmpregados implements AnalisaDados{
	private ArrayList<Empregado> colecaoEmpregados;
	
	public ColecaoEmpregados () {
		this.colecaoEmpregados = new ArrayList<Empregado>();
	}

	public ArrayList<Empregado> getColecaoEmpregados () {
		return colecaoEmpregados;
	}

	public void setColecaoEmpregados (Empregado empregado) {
		this.colecaoEmpregados.add(empregado);
	}

	
	public float achaMenorValor() {
		float menorValor = colecaoEmpregados.get(0).getSalario();
		for (Empregado empregado : this.colecaoEmpregados) {
			if (empregado.getSalario() <= menorValor) {
				menorValor = empregado.getSalario();
			}
		}
		return menorValor;
	}

	
	public float achaMaiorValor() {
		float maiorValor = colecaoEmpregados.get(0).getSalario();
		for (Empregado empregado : this.colecaoEmpregados) {
			if (empregado.getSalario() >= maiorValor) {
				maiorValor = empregado.getSalario();
			}
		}
		return maiorValor;
	}

	
	public boolean isInteiroRepetido(int valor) {
		for (Empregado empregado : this.colecaoEmpregados) {
			if (empregado.getMatricula().equals(valor)) {
				return true;
			}
		}
		return false;
	}

	
	public float calculaSomatorio() {
		float total = 0f;
		for (Empregado empregado : this.colecaoEmpregados) {
			total += empregado.getSalario();
		}
		return total;
	}

	
	public float calculaMedia() {
		return calculaSomatorio() / this.colecaoEmpregados.size();
	}
}