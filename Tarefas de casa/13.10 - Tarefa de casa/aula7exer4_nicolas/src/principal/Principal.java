package principal;

import dados.EquipeDeFuncionarios;
import validacao.Validacao;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {

		EquipeDeFuncionarios funcionarios = new EquipeDeFuncionarios();

		int opcao;
		do {
			opcao = Visao.menuPrincipal(funcionarios);
		} while (Validacao.isContinua(opcao, "Deseja cadastrar outro funcionario?", 3));

		do {
			opcao = Visao.menuVisualizacao(funcionarios);
		} while (Validacao.isContinua(opcao, "Deseja visualizar outros dados?", 4));

	}

}
