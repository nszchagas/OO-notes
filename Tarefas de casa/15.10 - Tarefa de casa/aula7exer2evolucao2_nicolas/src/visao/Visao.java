package visao;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dados.Galeria;
import dados.Pintor;
import dados.Quadro;
import validacao.Validacao;

public class Visao {
	public static void mostraMensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static String janelaEntrada(String mensagem, String titulo) {
		String texto;
		do {
			texto = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
			if (texto == null)
				mostraMensagemErro("O preenchimento desse campo e obrigatorio");
		} while (texto == null);
		return texto;
	}

	public static String janelaEntradaComCancelar(String mensagem, String titulo) {
		return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);

	}

	public static void mostraMensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static void menuInicial(Galeria galeria) {
		String[] opcoes = new String[] { "Cadastrar Novo Quadro", "Cadastrar Novo Pintor",
				"Listar Quadro(s) de um Pintor", "Mostrar todo(s) Quadro(s)", "Encerrar Programa" };
		boolean sair = false;
		while (!sair) {
			switch (mostraMenu(opcoes, "Escolha a opcao desejada", "Menu inicial")) {
			case 0:
				if (galeria.getListaPintores().isEmpty())
					Visao.mostraMensagemErro("Erro, e necessario registrar ao menos 1 pintor para acessar a opcao.");
				else
					registraQuadro(galeria);
				break;
			case 1:
				galeria.addPintor(registraPintor(galeria));
				break;
			case 2:
				if (galeria.getListaQuadros().isEmpty())
					Visao.mostraMensagemErro("Erro, e necessario registrar ao menos 1 quadro para acessar a opcao.");
				else
					mostraQuadrosNome(galeria,
							janelaEntrada("Insira o nome do pintor para a pesquisa:", "Pesquisar quadros por pintor"));
				break;
			case 3:
				if (galeria.getListaQuadros().isEmpty())
					Visao.mostraMensagemErro("Erro, e necessario registrar ao menos 1 quadro para acessar a opcao.");
				else
					mostraQuadros(galeria.getListaQuadros());
				break;
			case 4:
				sair = perguntaSimOuNao("Deseja mesmo sair?", "Sair");

				break;
			}
		}
	}

	public static boolean perguntaSimOuNao(String mensagem, String titulo) {
		return (JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION) == 0);
	}

	public static String cadastraNome() {
		return janelaEntrada("Insira o nome do pintor:", "Cadastro");
	}

	public static int mostraMenu(String[] opcoes, String mensagem, String titulo) {
		return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, opcoes, opcoes[opcoes.length - 1]);
	}

	public static Pintor registraPintor(Galeria galeria) {
		return (new Pintor(Validacao.validaNome("Determine o nome do Pintor:"),
				Validacao.validaCodigoPessoal(galeria, "Determine o codigo do Pintor:"),
				Validacao.validaAno("Determine o ano de nascimento do pintor:")));
	}

	public static Integer leCodigoPesquisa(String mensagem) {
		Integer valor = -1;

		String codigo = Visao.janelaEntradaComCancelar(mensagem, "Cadastro");
		if (codigo != null) {
			try {
				valor = Integer.parseInt(codigo);
			} catch (NumberFormatException e) {
				Visao.mostraMensagemErro("Erro, a entrada deve ser numerica.");
				valor = Validacao.validaInteiro(mensagem);
			}
		}
		return valor;
	}

	public static void registraQuadro(Galeria galeria) {

		boolean sair = false;

		if (perguntaSimOuNao("O quadro pertence a pintor ja cadastrado?", "Cadastro")) {
			while (!sair) {
				limpaTela(50);
				mostraPintores(galeria);
				int codigo = leCodigoPesquisa(
						"Confira os codigos dos pintores cadastrados na console e insira o codigo do pintor desejado.");
				if (codigo != -1) {
					Pintor pintor = galeria.getPintorPorCodigo(codigo);
					if (pintor != null) {
						galeria.addQuadro(new Quadro(
								Validacao.validaCodigoQuadro(galeria, "Determine o codigo do Quadro:"), pintor,
								Validacao.validaPreco("Determine o preco do quadro: [0 caso tenha sido doado]"),
								Validacao.validaAno("Determine o ano da compra do quadro:")));
						sair = true;
					} else {
						mostraMensagemErro("O codigo inserido nao pertence a nenhum pintor");
						sair = perguntaSimOuNao("Retornar ao menu inicial?", "Sair");
					}

				} else
					sair = true;

			}
		}

		else
			galeria.addQuadro(new Quadro(Validacao.validaCodigoQuadro(galeria, "Determine o codigo do Quadro:"),
					registraPintor(galeria),
					Validacao.validaPreco("Determine o preco do quadro: [0 caso tenha sido doado]"),
					Validacao.validaAno("Determine o ano da compra do quadro:")));
		limpaTela(50);
	}

	public static void mostraPintores(Galeria galeria) {
		System.out.format("| %-6s | %-47s | \n", "CODIGO", "NOME DO PINTOR");
		for (Pintor pintor : galeria.getListaPintores())
			System.out.println(pintor);
	}

	public static void mostraQuadros(ArrayList<Quadro> quadros) {
		System.out.format("| %-30s | %-30s | %-20s | %-20s |\n", "CODIGO QUADRO", "NOME DO PINTOR", "PRECO",
				"ANO AQUISICAO");
		for (Quadro quadro : quadros)
			System.out.println(quadro);
	}

	public static void mostraQuadrosNome(Galeria galeria, String nome) {

		limpaTela(50);
		if (galeria.getPintoresPorNome(nome) == null) {
			mostraMensagem("Nenhum pintor com o nome [" + nome + "] foi encontrado.", "Pintor nao encontrado");
		}

		for (Pintor pintor : galeria.getPintoresPorNome(nome)) {
			limpaTela(2);
			System.out.println("Quadro(s) encontrado(s) do [" + nome + "].");
			System.out.format("%-8s%-30s%-30s%-20s%-20s\n", "INDICE", "IDENTIFICACAO QUADRO", "IDENTIFICACAO PINTOR",
					"PRECO", "ANO AQUISICAO");

			if (galeria.getQuadrosPorPintor(pintor.getCodigo()) == null)
				mostraMensagem("Nenhum quadro encontrado para o pintor [" + nome + "].", "Quadro nao encontrado");
			else {
				for (Quadro quadro : galeria.getQuadrosPorPintor(pintor.getCodigo()))
					System.out.println(quadro);
				System.out.println("Soma total dos valores dos quadros: "
						+ new DecimalFormat("0.00").format(galeria.getPrecoQuadrosPintor(pintor)));
			}
		}

		limpaTela(2);

	}

	public static void limpaTela(int qtd) {
		for (int i = 0; i < qtd; i++)
			System.out.println();
	}
}
