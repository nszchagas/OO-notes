package leitura;

import javax.swing.JOptionPane;

import visao.Visao;

public class Leitura {

	public static String janelaEntrada(String mensagem, String titulo) {
		String saida = null;
		while (saida == null || saida.isEmpty()) {
			saida = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
			if (saida == null || saida.isEmpty())
				Visao.mostraMensagemAviso("O preenchimento desse campo e obrigatorio.");
		}
		return saida;
	}
}
