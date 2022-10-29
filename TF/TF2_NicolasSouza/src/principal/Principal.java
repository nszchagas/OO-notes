package principal;

import javax.swing.JFrame;
import dao.PessoaDAO;
import visao.JanelaPrincipal;

public class Principal {

	public static void main(String[] args) {
		new PessoaDAO().criaBD();
		JFrame janela = new JanelaPrincipal();
		janela.setVisible(true);

	}

}
