package saida;

import java.text.DecimalFormat;
import java.util.ArrayList;
import dados.Empresa;
import dados.Pessoa;
import validacao.Validacao;

public class Saida {

	public static void solicitarNome() {
		System.out.print("\nInforme o nome do funcionario: ");
	}

	public static void informarNomeInvalido() {
		System.err.println("\nNome invalido! Informe tambem o sobrenome.");
	}

	public static void solicitarCpf() {
		System.out.print("\nInforme o CPF do funcionario: ");
	}

	public static void informarCpfInvalido() {
		System.err.println("\nCPF invalido! Informe exatamente 11 digitos. Apenas digitos sao permitidos.");
	}

	public static void informarCpfRetido() {
		System.err.println(
				"\nCPF ja foi cadastrado! Informe um cpf unico com exatamente 11 digitos. Apenas digitos sao permitidos.");
	}

	public static void solicitarDiaDeNascimento() {
		System.out.print("Informe o numero correspondente ao dia de nascimento: ");
	}

	public static void informarDiaDeNascimentoInvalido() {
		System.err.println("\nDia de nascimento invalido! Informe um dia maior que 0 e menor que 31.");
	}

	public static void solicitarMesDeNascimento() {
		System.out.println("\n(Janeiro = 1; Dezembro = 12;)");
		System.out.print("Informe o numero correspondente ao mes de nascimento: ");
	}

	public static void informarMesDeNascimentoInvalido() {
		System.err.println("\nMes de nascimento invalido! Informe um mes maior que 0 e menor que 13.");
	}

	public static void solicitarAnoDeNascimento() {
		System.out.print("Informe o numero correspondente ao ano de nascimento: ");
	}

	public static void informarAnoDeNascimentoInvalido() {
		System.err.println("\nAno de nascimento invalido! Informe um ano maior que 0 e menor que 2021.");
	}

	public static void informarExcecaoInt() {
		System.err.println("\nEntrada invalida! Insira apenas um numero inteiro.");
	}

	public static void solicitarHorasTrabalhadas() {
		System.out.print("Informe a quantidade de horas trabalhadas: ");
	}

	public static void informarHorasTrabalhadasInvalida() {
		System.err.print("Quantidade de horas trabalhadas invalida, insira um valor maior que 0 e menor que 221");
	}

	public static void solicitarQuantidadeDeProjetos() {
		System.out.print("Informe a quantidade de projetos trabalhados: ");
	}

	public static void informarQuantidadeDeProjetosInvalido() {
		System.err.print("Quantidade de projetos invalido, insira um valor maior ou igual a 0 e menor que 100");
	}

	public static void exibirMensagemCadastroDeFuncionario() {
		System.out.println("CADASTRO DE FUNCIONARIO");
	}

	public static void exibirRelatorio(ArrayList<Pessoa> pessoas) {
		String formato = "%-20s %-20s %-20s %-20s %-20s\n";
		System.out.format(formato, "NOME", "NASCIMENTO", "CPF", "HORAS TRABALHADAS", "PROJETOS");
		System.out
				.println("==========================================================================================");
		for (Pessoa funcionario : pessoas)
			System.out.println(funcionario);
	}

	public static void exibirMenuDeFuncionarios() {
		System.out.println("\nInforme a opcao desejada:");
		System.out.println("1 - CADASTRAR FUNCIONARIO REGULAR");
		System.out.println("2 - CADASTRAR PRESTADOR DE SERVICOS");
		System.out.println("3 - CADASTRAR GERENTE DE EQUIPE");
		System.out.println("0 - ENCERRAR CADASTRO");
	}

	public static void exibirMenu() {
		Saida.limpaTela(1);
		System.out.println("Informe a opcao desejada:");
		System.out.println("1 - VISUALIZAR O TOTAL DE FUNCIONARIOS CADASTRADOS EM CADA CATEGORIA");
		System.out.println("2 - VISUALIZAR O TOTAL SALARIAL A SER PAGO PARA CADA CATEGORIA");
		System.out.println("0 - ENCERRAR O PROGRAMA");
	}

	public static void resultado(int opcao, Empresa empresa) {

		String formato = "%-20s%-10s\n";
		DecimalFormat mascara = new DecimalFormat("0.00");
		Saida.limpaTela(40);
		if (opcao == 1) {
			System.out.format(formato, "CATEGORIA", "FUNCIONARIOS");
			System.out.format(formato, "REGULAR", empresa.getFuncionarios().size() + " Funcionarios regulares");
			System.out.format(formato, "PRESTADOR", empresa.getServidores().size() + " Prestadores de servico");
			System.out.format(formato, "GERENTE", empresa.getGerentes().size() + " Gerentes de equipe ");
			limpaTela(2);
			System.out.println("Total:" + (empresa.getFuncionarios().size() + empresa.getServidores().size()
					+ empresa.getGerentes().size()));
		}
		if (opcao == 2) {
			System.out.format(formato, "CATEGORIA", "FUNCIONARIOS");
			System.out.format(formato, "REGULAR",
					"R$" + mascara.format(Validacao.validaSalarioFuncionarios(empresa.getFuncionarios())));
			System.out.format(formato, "PRESTADOR",
					"R$" + mascara.format(Validacao.validaSalarioServidores(empresa.getServidores())));
			System.out.format(formato, "GERENTE",
					"R$" + mascara.format(Validacao.validaSalarioGerentes(empresa.getGerentes())));
			limpaTela(2);
			System.out.println("Total: R$" + (Validacao.validaSalarioFuncionarios(empresa.getFuncionarios())
					+ Validacao.validaSalarioServidores(empresa.getServidores())
					+ Validacao.validaSalarioGerentes(empresa.getGerentes())));
		}
		Saida.limpaTela(2);
	}

	public static void limpaTela(int linhasPuladas) {
		for (int aux = 0; aux < linhasPuladas; aux++)
			System.out.println();
	}

}
