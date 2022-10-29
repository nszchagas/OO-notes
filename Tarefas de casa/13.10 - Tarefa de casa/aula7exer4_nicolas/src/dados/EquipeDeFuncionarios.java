package dados;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class EquipeDeFuncionarios {

	protected ArrayList<Pessoa> funcionarios;

	public EquipeDeFuncionarios() {
		funcionarios = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getFuncionarios() {
		return this.funcionarios;
	}

	public void addFuncionario(Pessoa pessoa) {
		this.funcionarios.add(pessoa);
	}

	public ArrayList<Pessoa> getGerencia() {
		ArrayList<Pessoa> gerencia = new ArrayList<Pessoa>();
		for (Pessoa pessoa : this.getFuncionarios())
			if (pessoa instanceof Gerente)
				gerencia.add(pessoa);
		return gerencia;
	}

	public ArrayList<Pessoa> getPrestadoresServicos() {
		ArrayList<Pessoa> prestadores = new ArrayList<Pessoa>();
		for (Pessoa pessoa : this.getFuncionarios())
			if (pessoa instanceof PrestadorServicos)
				prestadores.add(pessoa);
		return prestadores;
	}

	public ArrayList<Pessoa> getFuncionariosRegulares() {
		ArrayList<Pessoa> regulares = new ArrayList<Pessoa>();
		for (Pessoa pessoa : this.getFuncionarios())
			if (pessoa instanceof FuncionarioRegular)
				regulares.add(pessoa);
		return regulares;
	}

	public static float calculaSalarioCategoria(ArrayList<Pessoa> funcionarios) {
		float salario = 0f;
		for (Pessoa pessoa : funcionarios)
			salario += pessoa.getSalario();
		return salario;
	}

}
