package saida;

import java.text.DecimalFormat;

import dados.Empresa;
import dados.Funcionario;
import validacao.Validacao;

public class Saida {
	public static void mostraMensagem(String msg) {
		System.out.println(msg);
	}

	public static void mostraMensagemErro(String msg) {
		System.err.println(msg);
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++) {
			System.out.println();
		}
	}

	public static void mostraRelatorio(Empresa empresa, int qtdFuncionarioRegular, int qtdPrestadorServicos,
			int qtdGerente, float salarioFuncionarioRegular, float salarioPrestadorServico, float salarioGerente) {
		if (empresa.getFuncionarios().isEmpty()) {
			Saida.mostraMensagem("Nenhum funcionario cadastrado!");
			return;
		}

		int opcaoMenu;

		while ((opcaoMenu = Validacao.validaMenuRelatorio()) != '0') {
			Saida.limpaTela(2);
			switch (opcaoMenu) {
			case '1':
				mostraQuantidadeFuncionarios(empresa, qtdFuncionarioRegular, qtdPrestadorServicos, qtdGerente);
				break;
			case '2':
				mostraTotalSalarialFuncionarios(empresa, salarioFuncionarioRegular, salarioPrestadorServico,
						salarioGerente);
			}
		}
		limpaTela(2);
	}

	private static void mostraTotalSalarialFuncionarios(Empresa empresa, float salarioFuncionarioRegular,
			float salarioPrestadorServico, float salarioGerente) {
		double total = 0;
		DecimalFormat mascara = new DecimalFormat("#,##0.00");

		for (Funcionario funcionario : empresa.getFuncionarios()) {
			total += funcionario.calculaSalario();
		}

		Saida.limpaTela(30);
		mostraMensagem(
				"Total salarial dos funcionarios regulares igual a R$ " + mascara.format(salarioFuncionarioRegular));
		mostraMensagem(
				"Total salarial dos prestadores de servicos igual a R$ " + mascara.format(salarioPrestadorServico));
		mostraMensagem("Total salarial dos gerentes igual a R$ " + mascara.format(salarioGerente));
		mostraMensagem("Total salarial de todos os funcionarios igual a " + mascara.format(total));
		Saida.limpaTela(2);
	}

	private static void mostraQuantidadeFuncionarios(Empresa empresa, int qtdFuncionarioRegular,
			int qtdPrestadorServicos, int qtdGerente) {
		Saida.limpaTela(30);
		mostraMensagem("Quantidade de funcionario regular igual a " + qtdFuncionarioRegular);
		mostraMensagem("Quantidade de prestador de servicos igual a " + qtdPrestadorServicos);
		mostraMensagem("Quantidade de gerente igual a " + qtdGerente);
		mostraMensagem("Total de funcionarios igual a " + empresa.getFuncionarios().size());
		Saida.limpaTela(2);
	}

	public static void mostraTodosRegistros(Empresa empresa) {
		mostraMensagem(String.format("%-15s%-15s%-15s%-15s%-22s%s", "NOME", "NASCIMENTO", "CPF", "SALARIO",
				"HORAS TRABALHADAS", "QUANTIDADE PROJETOS"));
		for (Funcionario funcionario : empresa.getFuncionarios()) {
			System.out.println(funcionario);
		}
	}
}
