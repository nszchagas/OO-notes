package saida;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import comparadores.OrdenaNomeTime;
import dados.*;

public class Saida {
	public static void limpaTela(int n) {
		for (int i = 0; i < n; i++)
			System.out.println();
	}

	public static void mostraMensagemConsole(String msg) {
		limpaTela(5);
		System.out.println(msg);
	}

	public static int mostraOpcoes(String msg, String title, String[] options) {
		return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	}

	public static int mostraMenu() {
		String opcoes[] = { "Cadastrar time", "Mostrar times", "Sair" };
		return (mostraOpcoes("Escolha a opcao desejada", "Menu", opcoes));
	}

	public static void mostraTimes(List<TimeDeFutebol> colecaoTimes) {
		int indice = 0;
		DecimalFormat mascara = new DecimalFormat("00");
		limpaTela(30);
		System.out.format("\n%-5s%-20s%-20s\n", '#', "NOME", "Ano Campeao Brasileiro");
		for (TimeDeFutebol time : colecaoTimes) {
			System.out.println(mascara.format(++indice) + time);
		}
	}

	public static void mostraUltimoCadastro(TimeDeFutebol time) {
		limpaTela(30);
		System.out.format("%-3s%-20s%-20s\n","", "NOME", "ANOS DOS TITULOS");
		System.out.print(time);
	}
	
	public static void mostraCadastros(List<TimeDeFutebol> colecaoTimes) {
		int escolhas;
		String[] opcao = { "Ordem alfabetica", "Ordem de cadastro", "Voltar" };
		List<TimeDeFutebol> listaOrdemAlterada = new ArrayList<TimeDeFutebol>(colecaoTimes);
		OrdenaNomeTime ordemNomeTime = new OrdenaNomeTime();

		do {
			escolhas = mostraOpcoes("Apresentar em ordem:", "Apresentacao dos times", opcao);
			switch (escolhas) {
			case 0:
				Collections.sort(listaOrdemAlterada, ordemNomeTime);
				mostraTimes(listaOrdemAlterada);
				break;
			case 1:
				mostraTimes(colecaoTimes);
			}
		} while (escolhas != 2 && escolhas != -1);
	}

	public static void mostraMensagem(String msg, String titulo) {
		JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void mostraErro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static int perguntaOutroTitulo() {
		return JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais um titulo?", "Cadastro de Time",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
}
