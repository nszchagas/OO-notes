package leitura;

import javax.swing.JOptionPane;

public class Leitura {
	public static String lerString(Object mensagem, String titulo, int tipoMensagem) {
		return JOptionPane.showInputDialog(null, mensagem, titulo, tipoMensagem);
	}

	public static int lerConfirmacao(String mensagem, String titulo, int tipoMensagem) {
		return JOptionPane.showConfirmDialog(null, mensagem, titulo, tipoMensagem);
	}

	public static Object lerOpcao(Object mensagem, String titulo, int tipoMensagem, Object[] opcoes) {
		return JOptionPane.showInputDialog(null, mensagem, titulo, tipoMensagem, null, opcoes, null);
	}
}
