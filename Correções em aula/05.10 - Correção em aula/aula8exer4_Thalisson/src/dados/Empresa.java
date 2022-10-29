package dados;

import java.util.ArrayList;

import interfaces.AnalisaDados;

public class Empresa implements AnalisaDados {
	private ArrayList<Empregado> empregados;

	public Empresa() {
		empregados = new ArrayList<Empregado>();
	}

	public void addEmpregado(Empregado empregado) {
		empregados.add(empregado);
	}

	public ArrayList<Empregado> getEmpregados() {
		return empregados;
	}

	public ArrayList<Empregado> getEmpregadosPorMatricula(int matricula) {
		ArrayList<Empregado> matriculasIguais = new ArrayList<Empregado>();
		for (Empregado empregado : empregados) {
			if (empregado.getMatricula() == matricula)
				matriculasIguais.add(empregado);
		}
		return matriculasIguais;
	}

	public float calculaMaiorReal(char atributo) {
		float maior = 0.0f;
		switch (atributo) {
		case 's':
			for (Empregado empregado : empregados) {
				if (empregado.getSalario() > maior)
					maior = empregado.getSalario();
			}
			break;
		case 'm':
			for (Empregado empregado : empregados) {
				if (empregado.getMatricula() > maior)
					maior = empregado.getMatricula();
			}
		}

		return maior;
	}


	public float calculaMenorReal(char atributo) {
		float menor = 1e9f;
		switch (atributo) {
		case 's':
			for (Empregado empregado : empregados) {
				if (empregado.getSalario() < menor)
					menor = empregado.getSalario();
			}
			break;
		case 'm':
			for (Empregado empregado : empregados) {
				if (empregado.getMatricula() < menor)
					menor = empregado.getMatricula();
			}
		}
		return menor;
	}


	public boolean isValorDuplicado(int matricula) {
		return !getEmpregadosPorMatricula(matricula).isEmpty();
	}


	public double calculaSomatorio(char atributo) {
		double soma = 0.0;
		if (atributo == 's') {
			for (Empregado empregado : empregados)
				soma += empregado.getSalario();
		} else if (atributo == 'm') {
			for (Empregado empregado : empregados)
				soma += empregado.getMatricula();
		}

		return soma;
	}


	public double calculaMedia(char atributo) {
		if (empregados.size() == 0)
			return 0.0f;
		return calculaSomatorio(atributo) / empregados.size();
	}
}
