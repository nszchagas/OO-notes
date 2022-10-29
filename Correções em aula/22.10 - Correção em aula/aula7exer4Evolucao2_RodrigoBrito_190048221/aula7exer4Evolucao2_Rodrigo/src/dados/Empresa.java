package dados;

import java.util.ArrayList;

public class Empresa {
	private ArrayList<FuncionarioRegular> funcionarios;
	private ArrayList<Pessoa> pessoas;
	private ArrayList<GerenteDeEquipe> gerentes;
	private ArrayList<PrestadorDeServicos> servidores;

	public Empresa() {
		pessoas = new ArrayList<Pessoa>();
		gerentes = new ArrayList<GerenteDeEquipe>();
		funcionarios = new ArrayList<FuncionarioRegular>();
		servidores = new ArrayList<PrestadorDeServicos>();
	}

	public ArrayList<GerenteDeEquipe> getGerentes() {
		return gerentes;
	}

	public ArrayList<FuncionarioRegular> getFuncionarios() {
		return funcionarios;
	}

	public ArrayList<PrestadorDeServicos> getServidores() {
		return servidores;
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(FuncionarioRegular funcionario) {
		this.funcionarios.add(funcionario);
		this.pessoas.add(funcionario);
	}

	public void setPessoas(GerenteDeEquipe gerente) {
		this.gerentes.add(gerente);
		this.pessoas.add(gerente);
	}

	public void setPessoas(PrestadorDeServicos servidor) {
		this.servidores.add(servidor);
		this.pessoas.add(servidor);
	}

}
