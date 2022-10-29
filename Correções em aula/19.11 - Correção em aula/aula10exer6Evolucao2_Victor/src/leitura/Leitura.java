package leitura;

import javax.swing.JOptionPane;

public class Leitura {
	public static String lerString(String message) {
		return JOptionPane.showInputDialog(null, message, "Registro", JOptionPane.PLAIN_MESSAGE).trim();
	}
}
