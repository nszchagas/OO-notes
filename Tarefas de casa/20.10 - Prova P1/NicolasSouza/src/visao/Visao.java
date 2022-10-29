package visao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dados.Homem;
import dados.Mulher;
import dados.Pessoa;
import dados.Populacao;
import validacao.Validacao;

public class Visao {

	public static void menuPrincipal(Populacao populacao) {

		int opcao;
		boolean sair = false;
		String[] opcoes = new String[] { "Registro novo", "Relatorio de todos os registros ", "Sair" };

		while (!sair) {
			if (populacao.getPopulacao().size() > 0) {

				opcao = mostraJanelaOpcoes("Escolha a opcao desejada:", "Menu", opcoes);
				switch (opcao) {
				case 0:
					populacao.addPessoa(cadastraPessoa(populacao));
					break;
				case 1:
					mostraTabela(populacao.getPopulacao());
					break;
				case 2:
					sair = (perguntaSimOuNao("Deseja mesmo sair?", "Confirmacao") == 0);
					break;
				}

			} else {
				mostraAviso(
						"Essa aplicacao cadastra os dados de uma populacao e suas respectivas situacoes de saude, em realacao a contaminacao pelo corona vírus. Para inicia-lo voce deve fazer o cadastro de uma pessoa.",
						"Cadastro");
				populacao.addPessoa(cadastraPessoa(populacao));
			}


		}

	}

	public static Pessoa cadastraPessoa(Populacao populacao) {
		Pessoa pessoa = new Pessoa(cadastraNome(), cadastraCodigo(populacao), cadastraSituacaoSaude());
		if (cadastraSexo() == 0)
			return new Homem(pessoa, cadastraIdade());
		else
			return new Mulher(pessoa, cadastraGestacao());

	}

	public static void mostraDados(Populacao populacao) {
		String formato = "%02d = %s";
		limpaTela(40);
		System.out.format(formato, populacao.getQuantidadePessoasSituacao('C', 'T'), "CONTAMINADOS CURADOS\n");
		System.out.format(formato, populacao.getQuantidadePessoasSituacao('T', 'T'), "CONTAMINADOS EM TRATAMENTO\n");
		System.out.format(formato, populacao.getQuantidadePessoasSituacao('F', 'T'), "CONTAMINADOS FALECIDOS\n");
		System.out.format(formato, populacao.getQuantidadePessoasSituacao('S', 'M'), "HOMENS SEM CONTAMINACAO\n");
		System.out.format(formato, populacao.getQuantidadePessoasSituacao('S', 'F'), "MULHERES SEM CONTAMINACAO\n");
		imprimeLinha(35);
		System.out.format(formato, populacao.getPopulacao().size(), "TOTAL DE REGISTROS DE PESSOAS\n");

	}

	public static void mostraTabela(ArrayList<Pessoa> populacao) {
		limpaTela(40);

		String formato = "| %-13s | %-33s | %-28s | %-5s | %-15s |";
		imprimeLinha(108);
		System.out.format(formato, "IDENTIFICADOR", "NOME COMPLETO", "SITUACAO DE SAUDE", "IDADE", "GESTANTE");
		limpaTela(1);
		imprimeLinha(108);
		for (Pessoa pessoa : populacao)
			System.out.println(pessoa);
		imprimeLinha(108);

	}

	public static StringBuilder cadastraNome() {
		String nome;
		do {
			nome = janelaDeEntrada("Cadastre o nome completo da pessoa:", "Cadastro").trim();
		} while (!Validacao.isNome(nome));
		return new StringBuilder(nome);
	}

	public static int cadastraSexo() {
		String[] opcoes = { "Masculino", "Feminino" };
		return mostraJanelaOpcoes("Qual e o sexo da pessoa?", "Cadastro", opcoes);
	}

	public static int cadastraCodigo(Populacao populacao) {
		int codigo = 0;
		boolean erro = true;
		while (erro) {
			try {
				do {
					codigo = Integer.parseInt(janelaDeEntrada("Cadastre o codigo da pessoa:", "Cadastro"));

				} while (!Validacao.isCodigo(populacao, codigo));
				erro = false;
			} catch (NumberFormatException e) {
				mostraMensagemErro("Ocorreu um erro. Digite apenas numeros inteiros.", "Erro");
				erro = true;
			}
		}
		return codigo;
	}

	public static int cadastraIdade() {
		int idade = 0;
		boolean erro = true;
		while (erro) {
			try {
				do {
					idade = Integer.parseInt(janelaDeEntrada("Cadastre a idade da pessoa:", "Cadastro"));

				} while (!Validacao.isIdade(idade));
				erro = false;
			} catch (NumberFormatException e) {
				mostraMensagemErro("Ocorreu um erro. Digite apenas numeros inteiros.", "Erro");
				erro = true;
			}
		}
		return idade;
	}

	public static char cadastraSituacaoSaude() {
		String[] opcoes = { "Contaminada em tratamento", "Contaminada falecida", "Contaminada curada",
				"Sem contaminacao" };
		switch (mostraJanelaOpcoes("Insira a situacao de saude da pessoa:", "Cadastro", opcoes)) {
		case 0:
			return 'T';
		case 1:
			return 'F';
		case 2:
			return 'C';
		case 3:
			return 'S';
		}
		return 'M';
	}

	public static char cadastraGestacao() {
		String[] opcoes = { "Sim", "Nao", "Nao tem certeza" };
		switch (mostraJanelaOpcoes("Ja esteve gravida?", "Cadastro", opcoes)) {
		case 0:
			return 'S';
		case 1:
			return 'N';
		case 2:
			return 'T';
		}
		return 'M';
	}

	private static int perguntaSimOuNao(String mensagem, String titulo) {
		return JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
	}

	private static int mostraJanelaOpcoes(String mensagem, String titulo, String[] opcoes) {
		return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[opcoes.length - 1]);
	}

	private static void mostraAdvertencia(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.WARNING_MESSAGE);
	}

	private static void mostraAviso(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void mostraMensagemErro(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
	}

	private static String janelaDeEntrada(String mensagem, String titulo) {
		String entrada;
		do {
			entrada = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
			if (entrada == null)
				mostraAdvertencia("Esse campo nao pode ser deixado em branco.", "Atencao!");
		} while (entrada == null);
		return entrada;
	}

	private static void imprimeLinha(int tamanho) {
		for (int cont = 0; cont < tamanho; cont++)
			System.out.print("-");
		limpaTela(1);
	}

	private static void limpaTela(int linhas) {
		for (int cont = 0; cont < linhas; cont++)
			System.out.println();
	}

}
