package saida;

import java.text.DecimalFormat;

import dados.Empresa;
import dados.Funcionario;
import dados.Pessoa;
import validacao.Validacao;

public class Visao {
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

	public static void mostraRelatorio(Empresa empresa, int qtdFuncionarioRegular, int qtdPrestadorServicos, int qtdGerente, float salarioFuncionarioRegular, float salarioPrestadorServico, float salarioGerente) {
		if (empresa.getFuncionarios().isEmpty()) {
			Visao.mostraMensagem("Nenhum funcionario cadastrado!");
			return;
		}

		int opcaoMenu;

		while ((opcaoMenu = Validacao.validaMenuRelatorio()) != '0') {
			Visao.limpaTela(2);
			switch (opcaoMenu) {
			case '1':
				mostraQuantidadeFuncionarios(empresa, qtdFuncionarioRegular, qtdPrestadorServicos, qtdGerente);
				break;
			case '2':
				mostraTotalSalarialFuncionarios(empresa, salarioFuncionarioRegular, salarioPrestadorServico, salarioGerente);
			}
		}
		limpaTela(2);
	}

	private static void mostraTotalSalarialFuncionarios(Empresa empresa, float salarioFuncionarioRegular, float salarioPrestadorServico, float salarioGerente) {
		double total = 0;
		DecimalFormat mascara = new DecimalFormat("#,##0.00");
		String formato = "%-26sR$ %-13s";
		
		for (Funcionario funcionario : empresa.getFuncionarios()) {
			total += funcionario.calculaSalario();
		}

		Visao.limpaTela(30);
		
		mostraMensagem("TOTAL SALARIAL POR CATEGORIA:\n\n");
		mostraMensagem(String.format(formato, "Funcionarios regulares: " , mascara.format(salarioFuncionarioRegular)));
		mostraMensagem(String.format(formato, "Prestadores de servicos: " , mascara.format(salarioPrestadorServico)));
		mostraMensagem(String.format(formato, "Gerentes: " , mascara.format(salarioGerente)));
		Visao.limpaTela(2);
		mostraMensagem(String.format(formato, "TOTAL: " , mascara.format(total)));
		
		Visao.limpaTela(2);
	}

	private static void mostraQuantidadeFuncionarios(Empresa empresa, int qtdFuncionarioRegular, int qtdPrestadorServicos, int qtdGerente) {
		Visao.limpaTela(30);
		
		String formato = "%-26s %-13s";
		
		mostraMensagem("QUANTIDADE DE FUNCIONARIOS:\n\n");
		mostraMensagem(String.format(formato, "Funcionarios regulares: " , qtdFuncionarioRegular));
		mostraMensagem(String.format(formato, "Prestador de servicos: " , qtdPrestadorServicos));
		mostraMensagem(String.format(formato, "Gerentes: " , qtdGerente));
		Visao.limpaTela(2);
		mostraMensagem(String.format(formato, "TOTAL: " , empresa.getFuncionarios().size()));
		
		Visao.limpaTela(2);
	}
	
	public static void mostraTodosRegistros(Empresa empresa) {
		mostraMensagem(String.format("%-15s%-15s%-15s%-15s%-22s%s", "NOME", "NASCIMENTO", "CPF", 
				"SALARIO", "HORAS TRABALHADAS", "QUANTIDADE PROJETOS"));
		for (Pessoa pessoa : empresa.getFuncionarios()) {
			System.out.println(pessoa);
		}
	}
}

/*OBS:
 * 
 * -> Melhoramento da apresentacao dos menus e dos relatorios de quantidade de funcionarios e de total salarial por categoria
 * 
 * 
 * 
 */

