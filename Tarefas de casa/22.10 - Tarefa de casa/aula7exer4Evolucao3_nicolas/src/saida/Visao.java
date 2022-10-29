package saida;

import java.text.DecimalFormat;

import dados.Empresa;
import dados.Funcionario;
import dados.Gerente;
import dados.PrestadorServicos;
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

	public static void mostraRelatorio(Empresa empresa) {
		if (empresa.getFuncionarios().isEmpty()) {
			Visao.mostraMensagem("Nenhum funcionario cadastrado!");
			return;
		}

		int opcaoMenu;

		while ((opcaoMenu = Validacao.validaMenuRelatorio()) != '0') {
			Visao.limpaTela(2);
			switch (opcaoMenu) {
			case '1':
				mostraQuantidadeFuncionarios(empresa);
				break;
			case '2':
				mostraTotalSalarialFuncionarios(empresa);
			}
		}
	}

	private static void mostraTotalSalarialFuncionarios(Empresa empresa) {
		float[] salariosRegularPrestadorGerente = { 0f, 0f, 0f };

		double total = 0;
		DecimalFormat mascara = new DecimalFormat("#,##0.00");

		for (Funcionario funcionario : empresa.getFuncionarios()) {
			salariosRegularPrestadorGerente = funcionario.calculaSalarioCategorias(salariosRegularPrestadorGerente);
			total += funcionario.calculaSalario();
		}

		Visao.limpaTela(30);
		mostraMensagem("Total salarial dos funcionarios regulares igual a R$ "
				+ mascara.format(salariosRegularPrestadorGerente[0]));
		mostraMensagem("Total salarial dos prestadores de servicos igual a R$ "
				+ mascara.format(salariosRegularPrestadorGerente[1]));
		mostraMensagem("Total salarial dos gerentes igual a R$ " + mascara.format(salariosRegularPrestadorGerente[2]));
		mostraMensagem("Total salarial de todos os funcionarios igual a " + mascara.format(total));
	}

	private static void mostraQuantidadeFuncionarios(Empresa empresa) {
		int[] qtdRegularPrestadorGerente = { 0, 0, 0 };

		for (Funcionario funcionario : empresa.getFuncionarios()) {
			qtdRegularPrestadorGerente = funcionario.contaFuncionariosCategorias(qtdRegularPrestadorGerente);
		}

		Visao.limpaTela(30);
		mostraMensagem("Quantidade de funcionario regular igual a " + qtdRegularPrestadorGerente[0]);
		mostraMensagem("Quantidade de prestador de servicos igual a " + qtdRegularPrestadorGerente[1]);
		mostraMensagem("Quantidade de gerente igual a " + qtdRegularPrestadorGerente[2]);
		mostraMensagem("Total de funcionarios igual a " + empresa.getFuncionarios().size());
	}

	public static void registraFuncionarioRegular(Empresa empresa) {
		Funcionario funcionario = new Funcionario(Validacao.validaNome(), Validacao.validaDataNascimento(),
				Validacao.validaCpf(empresa));
		empresa.setFuncionarios(funcionario);
	}

	public static void registraPrestadorServicos(Empresa empresa) {
		PrestadorServicos prestadorServicos = new PrestadorServicos(Validacao.validaNome(),
				Validacao.validaDataNascimento(), Validacao.validaCpf(empresa), Validacao.validaHorasTrabalhadas());
		empresa.setFuncionarios(prestadorServicos);
	}

	public static void registraGerente(Empresa empresa) {
		Gerente gerente = new Gerente(Validacao.validaNome(), Validacao.validaDataNascimento(),
				Validacao.validaCpf(empresa), Validacao.validaQuantidadeProjetos());
		empresa.setFuncionarios(gerente);
	}
}
