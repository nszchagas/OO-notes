package visao;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import dados.Time;
import leitura.Leitura;
import validacao.Validacao;

public class Visao {

	public static String registraNome() {
		String nome = "";

		try {
			do {
				nome = Leitura.leEntrada("Digite o nome do time:", "Cadastro").trim();
			} while (!Validacao.isNome(nome));
		} catch (NullPointerException e) {
			return null;
		}
		return nome;
	}

	public static int registraAno(Time time) {

		int ano = -1;
		boolean erro = true;
		while (erro) {
			try {
				do {
					ano = Integer.parseInt(
							Leitura.leEntrada("Digite o ano no qual o time: " + time.getNome() + " obteve um titulo:",
									"Cadastro").trim());
				} while (!Validacao.isAno(ano, time));
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

	public static void mostraTime(Time time) {

		if (time.getAnos().size() > 0) {
			limpaTela(50);
			ArrayList<Integer> anosCrescente = new ArrayList<Integer>(time.getAnos());
			System.out.println("Titulos do " + time.getNome().toUpperCase());
			Collections.sort(anosCrescente);
			for (Integer ano : anosCrescente)
				System.out.println((anosCrescente.indexOf(ano) + 1) + "º titulo: " + ano);
		} else
			System.out.println("O time " + time.getNome().toUpperCase() + " ainda nao foi campeao brasileiro.");
	}

	public static void mostraMensagem(String mensagem, String titulo, int tipo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, tipo, null);
	}

	public static int mostraMenu(String mensagem, String[] opcoes) {
		return JOptionPane.showOptionDialog(null, mensagem, "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}

	public static boolean mostraConfirmacao(String mensagem) {

		return JOptionPane.showConfirmDialog(null, mensagem, "Confirmacao", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null) == 0;

	}

	public static void limpaTela(int linhas) {
		for (int aux = 0; aux < linhas; aux++)
			System.out.println();
	}
}
