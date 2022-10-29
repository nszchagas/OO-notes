package leitura;

import javax.swing.JOptionPane;

public class Leitura {

	public static int lerMenuOpcoes(String[] opcoes) {
		return JOptionPane.showOptionDialog(null, "Selecione uma opcao:", "MENU", 0, JOptionPane.INFORMATION_MESSAGE,
				null, opcoes, opcoes[0]);
	}

	public static String lerShowInputDialog(String msg, String titulo) {
		return JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.QUESTION_MESSAGE);
	}
}