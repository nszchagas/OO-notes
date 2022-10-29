package leitura;

import javax.swing.JOptionPane;

public class Leitura {

	public static String leEntrada(String msg, String titulo) {
		return JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.QUESTION_MESSAGE);
	}
}
