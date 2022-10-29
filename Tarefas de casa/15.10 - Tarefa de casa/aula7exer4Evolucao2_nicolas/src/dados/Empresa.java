package dados;

import java.util.ArrayList;

public class Empresa {
	private ArrayList<Funcionario> funcionarios;

	public Empresa() {
		this.funcionarios = new ArrayList<Funcionario>();
	}

	public void addFuncionario(Funcionario funcionario) {
		this.getFuncionarios().add(funcionario);
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public ArrayList<Funcionario> getGerentes() {
		ArrayList<Funcionario> gerentes = new ArrayList<Funcionario>();
		for (Funcionario funcionario : this.getFuncionarios())
			if (funcionario instanceof Gerente)
				gerentes.add(funcionario);
		return gerentes;
	}

	public ArrayList<Funcionario> getPrestadores() {
		ArrayList<Funcionario> prestadores = new ArrayList<Funcionario>();
		for (Funcionario funcionario : this.getFuncionarios())
			if (funcionario instanceof PrestadorDeServicos)
				prestadores.add(funcionario);
		return prestadores;
	}

	public ArrayList<Funcionario> getRegulares() {
		ArrayList<Funcionario> regulares = new ArrayList<Funcionario>();
		for (Funcionario funcionario : this.getFuncionarios())
			if (funcionario instanceof FuncionarioRegular)
				regulares.add(funcionario);
		return regulares;
	}

	public static float getSalarioPorCategoria(ArrayList<Funcionario> equipe) {
		float total = 0F;
		for (Funcionario funcionario : equipe)
			total += funcionario.getSalario();
		return total;
	}

	public ArrayList<String> getCpfsCadastrados() {
		ArrayList<String> cpfs = new ArrayList<String>();
		for (Funcionario funcionario : this.getFuncionarios())
			cpfs.add(funcionario.getCpf());
		return cpfs;
	}

}
