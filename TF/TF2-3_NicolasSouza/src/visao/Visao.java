package visao;

import javax.swing.JOptionPane;

import dao.PessoaDAO;

public class Visao {

	static void mostraDados() { // só é usada no pacote visao

		String formato = "\t\t\t\t\t %02d = %s";

		limpaTela(40);
		System.out.format(formato, new PessoaDAO().getQtdSituacao('C'), "CONTAMINADOS CURADOS\n");
		System.out.format(formato, new PessoaDAO().getQtdSituacao('T'), "CONTAMINADOS EM TRATAMENTO\n");
		System.out.format(formato, new PessoaDAO().getQtdSituacao('F'), "CONTAMINADOS FALECIDOS\n");
		System.out.format(formato, new PessoaDAO().getQtdSituacao('S', 'M'), "HOMENS SEM CONTAMINACAO\n");
		System.out.format(formato, new PessoaDAO().getQtdSituacao('S', 'F'), "MULHERES SEM CONTAMINACAO\n");
		System.out.print("\t\t\t\t\t ");
		imprimeLinha(35);
		mostraMsgVermelha(
				String.format(formato, new PessoaDAO().getPessoas().size(), "TOTAL DE REGISTROS DE PESSOAS\n"));

	}

	public static void mostraMensagemErro(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
	}

	private static void mostraMsgVermelha(String msg) {
		System.err.print(msg);
	}

	private static void imprimeLinha(int tamanho) {
		for (int cont = 0; cont < tamanho; cont++)
			System.out.print("-");
		limpaTela(1);
	}

	private static void limpaTela(int linhas) {
		for (int cont = 0; cont < linhas; cont++)
			System.out.println();
	}

}
