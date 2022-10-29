package principal;

import javax.swing.JFrame;

import dados.Populacao;
import visao.JanelaPrincipal;

public class Principal {

	public static void main(String[] args) {
		Populacao populacao = new Populacao();
		JFrame janela = new JanelaPrincipal(populacao);
		janela.setVisible(true);
	}

}
