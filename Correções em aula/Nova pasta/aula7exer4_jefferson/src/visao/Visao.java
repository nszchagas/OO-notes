package visao;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dados.Empresa;
import dados.Funcionario;
import dados.FuncionarioRegular;
import dados.Gerente;
import dados.PrestadorDeServicos;
import validacao.Validacao;

public class Visao {

	// menus

	public static void menuPrincipal(Empresa empresa) {

		int opcao;
		boolean sair = false;
		String[] opcoes = new String[] { "Cadastrar funcionario", "Visualizar funcionarios por categoria",
				"Visualizar total de funcionarios e salario por categoria", "Encerrar o programa" };

		while (!sair) {
			if (empresa.getFuncionarios().size() > 0) {

				opcao = mostraMenu("Escolha a opcao desejada:", "Menu", opcoes);

				switch (opcao) {
				case 0:
					menuCadastroFuncionario(empresa);
					break;
				case 1:
					menuApresentacaoFuncionario(empresa);
					break;
				case 2:
					menuDadosCategoria(empresa);
					break;
				case 3:
					sair = (mostraConfirmacao("Deseja mesmo sair?", "Sair") == 0);
					break;
				}

			} else {
				mostraAviso("Cadastre um novo funcionario para acessar as funcionalidades do programa.", "Cadastro");
				menuCadastroFuncionario(empresa);
			}
		}

	}

	private static void menuCadastroFuncionario(Empresa empresa) {
		switch (menuFuncionario(new String[] { "Regular", "Prestador de servicos", "Gerente", "Voltar" })) {
		case 0:
			empresa.addFuncionario(new FuncionarioRegular(cadastraFuncionario(empresa)));
			break;
		case 1:
			empresa.addFuncionario(
					new PrestadorDeServicos(cadastraFuncionario(empresa), cadastraInteiro("horas trabalhadas")));
			break;
		case 2:
			empresa.addFuncionario(
					new Gerente(cadastraFuncionario(empresa), cadastraInteiro("projetos desenvolvidos")));
			break;
		case 3:
			break;
		}
	}

	private static int menuFuncionario(String[] opcoes) {
		return mostraMenu("Escolha o tipo de funcionario desejado:", "Menu", opcoes);
	}

	// cadastro

	private static Funcionario cadastraFuncionario(Empresa empresa) {
		return new Funcionario(cadastraNome(), cadastraCpf(empresa), cadastraData());
	}

	private static String cadastraNome() {
		String nome;
		do {
			nome = janelaDeEntrada("Cadastre o nome do funcionario:", "Cadastro");
		} while (!Validacao.isNome(nome));
		return nome;
	}

	private static String cadastraCpf(Empresa empresa) {
		String cpf;

		do {
			cpf = janelaDeEntrada("Cadastre o CPF do funcionario", "Cadastro");
		} while (!Validacao.isCpf(empresa, cpf));

		return cpf;
	}

	private static String cadastraData() {
		String data;

		do {
			data = janelaDeEntrada("Cadastre a data de nascimento do funcionario no formato dd/mm/aaaa.", "Cadastro");
		} while (!Validacao.isData(data));

		return data;
	}

	private static int cadastraInteiro(String tipo) {
		int numero = 0;
		boolean erro = true;
		final int MIN = 0;
		final int MAX = (tipo == "horas trabalhadas") ? 220 : 500;

		while (erro) {
			try {
				do {
					numero = Integer.parseInt(
							janelaDeEntrada("Cadastre a quantidade de " + tipo + " pelo funcionario", "Cadastro"));
				} while (!Validacao.isNumero(numero, MIN, MAX));
				erro = false;
			} catch (NumberFormatException e) {
				mostraMensagemErro("Ocorreu um erro. Digite apenas numeros inteiros.", "Erro");
				erro = true;
			}
		}
		return numero;
	}

	// apresentacao de dados //

	private static void menuApresentacaoFuncionario(Empresa empresa) {
		switch (menuFuncionario(new String[] { "Regular", "Prestador de servicos", "Gerente", "Todos", "Voltar" })) {
		case 0:
			mostraTabela(empresa.getRegulares());
			break;
		case 1:
			mostraTabela(empresa.getPrestadores());
			break;
		case 2:
			mostraTabela(empresa.getGerentes());
			break;
		case 3:
			mostraTabela(empresa.getFuncionarios());
			break;
		case 4:
			break;
		}
	}

	private static void menuDadosCategoria(Empresa empresa) {
		switch (menuFuncionario(new String[] { "Regular", "Prestador de servicos", "Gerente", "Todos", "Voltar" })) {
		case 0:
			mostraTotalCategoria(empresa.getRegulares());
			break;
		case 1:
			mostraTotalCategoria(empresa.getPrestadores());
			break;
		case 2:
			mostraTotalCategoria(empresa.getGerentes());
			break;
		case 3:
			mostraTotalCategoria(empresa.getFuncionarios());
			break;
		case 4:
			break;
		}
	}

	private static void mostraTotalCategoria(ArrayList<Funcionario> equipe) {
		mostraMensagem(
				"Total de funcionarios: " + equipe.size() + "\nSalario da categoria: "
						+ new DecimalFormat("0.00").format(Empresa.getSalarioPorCategoria(equipe)),
				"Total de funcionarios");
	}

	private static void mostraTabela(ArrayList<Funcionario> equipe) {
		if (equipe.size() > 0) {
			limpaTela(30);
			String formato = "| %-24s | %-50s | %-11s | %-18s | %-17s | %-18s | %-11s";
			System.out.format(formato, "CATEGORIA", "NOME", "CPF", "DATA DE NASCIMENTO", "HORAS TRABALHADAS",
					"NUMERO DE PROJETOS", "SALARIO");
			limpaTela(1);
			imprimeLinha(180);
			for (Funcionario funcionario : equipe)
				System.out.println(funcionario);
			imprimeLinha(180);
			System.out.format(formato, "TOTAL: " + equipe.size(), "", "", "", "", "",
					"TOTAL: " + new DecimalFormat("0.00").format(Empresa.getSalarioPorCategoria(equipe)));
			limpaTela(1);
			imprimeLinha(180);
		} else
			mostraAviso("Não ha funcionarios cadastrados nessa categoria", "Aviso");
	}

	// mensagens //

	private static int mostraConfirmacao(String mensagem, String titulo) {
		return JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE);
	}

	private static int mostraMenu(String mensagem, String titulo, String[] opcoes) {
		return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[opcoes.length - 1]);
	}

	private static void mostraAviso(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	private static void mostraMensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public static void mostraMensagemErro(String mensagem, String titulo) {
		JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
	}

	private static String janelaDeEntrada(String mensagem, String titulo) {
		String entrada;
		do {
			entrada = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
			if (entrada == null)
				mostraAviso("Esse campo nao pode ser deixado em branco.", "Atencao!");
		} while (entrada == null);
		return entrada;
	}

	private static void limpaTela(int linhasPuladas) {
		for (int aux = 0; aux < linhasPuladas; aux++)
			System.out.println();
	}

	private static void imprimeLinha(int tamanho) {
		for (int cont = 0; cont < tamanho; cont++)
			System.out.print("-");
		System.out.println();
	}

}
