package visao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

import dados.ColecaoTimes;
import dados.TimeDeFutebol;
import leitura.Leitura;
import validacao.Validacao;

public class Visao {
	private static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}

	private static void linhaHorizontal(int tamanho) {
		for (int i = 0; i < tamanho; i++)
			System.out.print("-");
		limpaTela(1);
	}

	public static String registraNome(ColecaoTimes times) {
		String nome = "";

		try {
			do {
				nome = Leitura.leEntrada("Digite o nome do time:", "Cadastro").trim();
			} while (!Validacao.isNome(nome, times));
		} catch (NullPointerException e) {
			return null;
		}
		return nome;
	}

	public static int registraAno(TimeDeFutebol time) {

		int ano = -1;
		boolean erro = true;
		while (erro) {
			try {
				do {
					ano = Integer.parseInt(
							Leitura.leEntrada("Digite o ano no qual o time: " + time.getNome() + " obteve um titulo:",
									"Cadastro").trim());
				} while (!Validacao.isAno(ano, time.getAnos()));
				erro = false;
			} catch (NullPointerException emBranco) {
				return -1;
			} catch (NumberFormatException erroFormato) {
				mostraMensagem("Digite apenas numeros inteiros", "Erro", JOptionPane.ERROR_MESSAGE);
				erro = true;
			}
		}
		return ano;

	}

	public static void mostraTimes(ColecaoTimes colecao) {

		if (colecao.getTimes().size() > 0) {

			int opcao = JOptionPane.showOptionDialog(null, "Escolha a ordem de visualizacao", "Visualizacao",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					new String[] { "Alfabetica", "Cadastro" }, "Alfabetica");
			limpaTela(30);
			switch (opcao) {

			case -1:
				if (perguntaSimOuNao("Deseja mesmo cancelar a visualizacao?", "Cancelar"))
					break;

			case 0:
				ArrayList<TimeDeFutebol> timesOrdenados = new ArrayList<TimeDeFutebol>(colecao.getTimes());
				Collections.sort(timesOrdenados, new Comparator<TimeDeFutebol>() {

					public int compare(TimeDeFutebol timeA, TimeDeFutebol timeB) {
						return timeA.getNome().compareTo(timeB.getNome());
					};

				});

				mostraTabela(timesOrdenados);

				break;

			case 1:
				mostraTabela(colecao.getTimes());
			}

		} else
			mostraMensagem("Nenhum time cadastrado", "Aviso", JOptionPane.WARNING_MESSAGE);

	}

	private static void mostraTabela(ArrayList<TimeDeFutebol> lista) {
		System.out.format("| %-35s | %-75s |\n", "Nome", "Titulos");
		linhaHorizontal(105);
		for (TimeDeFutebol time : lista)
			System.out.println(time);

	}

	public static void mostraMensagem(String msg, String titulo, int tipo) {
		JOptionPane.showMessageDialog(null, msg, titulo, tipo);
	}

	public static boolean perguntaSimOuNao(String mensagem, String titulo) {
		return JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == 0;
	}

}
