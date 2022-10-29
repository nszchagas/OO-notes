package visao;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import dados.Data;
import dados.EquipeDeFuncionarios;
import dados.FuncionarioRegular;
import dados.Gerente;
import dados.Pessoa;
import dados.PrestadorServicos;
import validacao.Validacao;

public class Visao {

	public static int menuPrincipal(EquipeDeFuncionarios funcionarios) {

		String[] opcoes = new String[] { "Cadastrar gerente", "Cadastrar prestador de servicos",
				"Cadastrar funcionario regular", "Cancelar cadastro" };

		int opcao = Visao.mostraOpcoes(opcoes, "Escolha uma opcao para efetuar o cadastro.", "Cadastro");
		switch (opcao) {
		case 0:
			funcionarios.addFuncionario(Visao.cadastraGerente());
			break;
		case 1:
			funcionarios.addFuncionario(Visao.cadastraPrestador());
			break;
		case 2:
			funcionarios.addFuncionario(Visao.cadastraFuncionarioRegular());
			break;
		case 3:
			if (Visao.confirmaMensagem("Deseja mesmo cancelar o cadastro?") == 0)
				break;
			menuPrincipal(funcionarios);
		}
		return opcao;
	}

	public static int menuVisualizacao(EquipeDeFuncionarios funcionarios) {

		String[] opcoes = new String[] { "Visualizar gerentes", "Visualizar prestadores de servicos",
				"Visualizar funcionarios regulares", "Visualizar todos os funcionarios cadastrados",
				"Sair sem visualizar dados" };

		int opcao = Visao.mostraOpcoes(opcoes,
				"Escolha qual categoria de dados você deseja visualizar. Serao mostrados os funcionarios cadastrados e o salario total da categoria.",
				"Visualizacao de dados");
		switch (opcao) {
		case 0:
			visualizarCategoria(funcionarios.getGerencia());
			break;
		case 1:
			visualizarCategoria(funcionarios.getPrestadoresServicos());
			break;
		case 2:
			visualizarCategoria(funcionarios.getFuncionariosRegulares());
			break;
		case 3:
			visualizarCategoria(funcionarios.getFuncionarios());
			break;
		case 4:
			if (Visao.confirmaMensagem("Deseja mesmo sair?") == 0)
				break;
		}
		return opcao;
	}

	public static void visualizarCategoria(ArrayList<Pessoa> lista) {
		if (lista.size() > 0) {
			imprimeCabecalho();
			for (Pessoa pessoa : lista)
				System.out.println(pessoa);
			imprimeLinhaHorizontal(130);
			limpaTela(1);
			String formato = "|%-51s |%-20s |%-13s |%-14s |%-22s| ";
			System.out.format(formato, "TOTAL: " + new DecimalFormat("000").format(lista.size()), " ", " ",
					new DecimalFormat("0.00").format(EquipeDeFuncionarios.calculaSalarioCategoria(lista)), "  ");

			System.out.format("%90s     ", "Total de funcionarios da categoria: ", lista.size());
			limpaTela(1);
			imprimeLinhaHorizontal(130);
		} else
			mostraMensagemErro("Não há nenhum funcionario cadastrado nessa categoria.");
	}

	public static void visualizarGeral(EquipeDeFuncionarios equipe) {
		System.out.println("teste");
		if (equipe.getFuncionarios().size() > 0) {
			System.out.format("%90s     %.2f", "Salario total dos funcionarios cadastrados: ",
					EquipeDeFuncionarios.calculaSalarioCategoria(equipe.getFuncionarios()));
			System.out.format("%90s     %d", "Quantidade de funcionarios cadastrados: ",
					equipe.getFuncionarios().size());
		}
	}

	public static void imprimeCabecalho() {
		limpaTela(30);
		String formato = "|%-51s |%-20s |%-13s |%-14s |%-22s| ";
		System.out.format(formato, " NOME", " DATA DE NASCIMENTO", " CPF", " SALARIO (R$)", " CATEGORIA ");
		System.out.println();
		imprimeLinhaHorizontal(130);
		System.out.println();
	}

	public static Pessoa cadastraPessoa() {
		return new Pessoa(cadastraNome(), cadastraCpf(), cadastraDataNascimento());
	}

	public static Gerente cadastraGerente() {
		return new Gerente(cadastraPessoa(), cadastraNumero("projetos desenvolvidos"));
	}

	public static PrestadorServicos cadastraPrestador() {
		return new PrestadorServicos(cadastraPessoa(), cadastraNumero("horas trabalhadas"));
	}

	public static FuncionarioRegular cadastraFuncionarioRegular() {
		return new FuncionarioRegular(cadastraPessoa());
	}

	public static String cadastraNome() {
		String nome;
		do {
			nome = registraValor("Digite o nome do funcionario: ");
		} while (!Validacao.isNome(nome));
		return nome;
	}

	public static long cadastraCpf() {

		String cpf;
		do {
			cpf = registraValor("Digite o CPF do funcionario: ");
		} while (!Validacao.isCpf(cpf));
		Long cpfNumerico = Long.parseLong(cpf);
		return cpfNumerico;
	}

	public static int cadastraNumero(String tipo) {
		boolean erro = true;
		int numero = 0;
		final int MAX = (tipo == "horas trabalhadas") ? 220 : 200;

		while (erro) {
			try {
				do {
					numero = Integer.parseInt(
							registraValor("Insira um valor para a quantidade de " + tipo + " pelo funcionario."));
				} while (!Validacao.isNumero(numero, MAX));
				erro = false;
			} catch (NumberFormatException e) {
				mostraMensagemErro("Ocorreu um erro. Insira apenas numeros (inteiros).");
				erro = true;
			}
		}
		return numero;
	}

	public static Data cadastraDataNascimento() {
		String data;
		do {
			data = registraValor("Digite a data de nascimento do funcionario (no formato dd/mm/aaaa): ");
		} while (!Validacao.isData(data));

		Data aniversario = Data.getDataDeString(data);

		return aniversario;
	}

	public static String registraValor(String mensagem) {
		UIManager.put("OptionPAne.cancelButtonText", "Cancelar");
		String texto = null;
		do {
			texto = JOptionPane.showInputDialog(null, mensagem, "Cadastro", JOptionPane.QUESTION_MESSAGE);
			if (texto == null)
				mostraMensagemErro("Esse campo e de preenchimento obrigatorio!");
		} while (texto == null);
		return texto;

	}

	public static void mostraMensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static int confirmaMensagem(String mensagem) {
		UIManager.put("OptionPane.noButtonText", "Nao");
		UIManager.put("OptionPane.yesButtonText", "Sim");
		return JOptionPane.showConfirmDialog(null, mensagem, "Confirmacao", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
	}

	public static int mostraOpcoes(String[] opcoes, String mensagem, String titulo) {

		return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[opcoes.length - 1]);
	}

	public static void limpaTela(int linhas) {
		for (int cont = 0; cont < linhas; cont++)
			System.out.println();
	}

	public static void imprimeLinhaHorizontal(int tamanho) {
		for (int cont = 0; cont < tamanho; cont++)
			System.out.print("-");
	}
}
