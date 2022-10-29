package dados;

import java.util.ArrayList;

public class Empresa {
	private ArrayList<Funcionario> funcionarios;

	public Empresa() {
		this.funcionarios = new ArrayList<Funcionario>();
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario funcionario) {
		this.funcionarios.add(funcionario);
	}

	public boolean isFuncionarioCadastrado(String cpf) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf().equals(cpf))
				return true;
		}
		return false;
	}

}
