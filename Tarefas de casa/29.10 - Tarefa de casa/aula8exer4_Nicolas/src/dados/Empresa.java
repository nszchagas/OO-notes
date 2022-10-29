package dados;

import java.util.Collections;
import java.util.Vector;

import interfaces.AnaliseDados;

public class Empresa implements AnaliseDados {

	private Vector<Empregado> empregados;

	public Empresa() {
		empregados = new Vector<Empregado>();
	}

	public Empresa(Empresa empresa) {
		this.empregados = empresa.getEmpregados();
	}

	public void addEmpregado(Empregado empregado) {
		this.getEmpregados().add(empregado);
	}

	public Vector<Object> getEmpregadoPorMatricula(int matricula) {
		Vector<Object> empregados = new Vector<Object>();
		for (Empregado empregado : this.getEmpregados())
			if (empregado.getMatricula().equals(matricula))
				empregados.add(empregado);
		return empregados;
	}

	public Vector<Empregado> getEmpregados() {
		return this.empregados;
	}

	public Vector<Integer> getMatriculas() {
		Vector<Integer> matriculas = new Vector<Integer>();
		for (Empregado empregado : this.getEmpregados())
			matriculas.add(empregado.getMatricula());
		return matriculas;
	}

	public Vector<Float> getSalarios() {
		Vector<Float> salarios = new Vector<Float>();
		for (Empregado empregado : this.getEmpregados())
			salarios.add(empregado.getSalario());
		return salarios;
	}

	@Override
	public float[] getMaiorEMenor() {
		Vector<Float> ordenado = new Vector<Float>(this.getSalarios());
		Collections.sort(ordenado);
		return new float[] { ordenado.elementAt(ordenado.size() - 1), ordenado.elementAt(0) };
	}

	@Override
	public Vector<Object> getDuplicados(int matriculaProcurada) {
		Vector<Object> empregados = new Vector<Object>();
		for (Empregado empregado : this.getEmpregados())
			if (empregado.getMatricula().equals(matriculaProcurada))
				empregados.add(empregado);
		return empregados;
	}

	@Override
	public float getSoma(char tipo) {
		// tipo = 'f' float(salarios) ou 'i' inteiro(matriculas) (Empresa)

		float soma = 0f;
		for (Empregado empregado : this.getEmpregados())
			soma += (tipo == 'f') ? empregado.getSalario() : empregado.getSalario();
		return soma;
	}

	@Override
	public float getMedia(char tipo) {
		if (this.getEmpregados().size() > 0)
			return getSoma(tipo) / this.getEmpregados().size();
		else
			return 0;
	}

}
