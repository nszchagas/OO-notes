package visao;

import javax.swing.JOptionPane;

import dados.Pais;
import dados.Cidade;
import validacao.Validacao;

public class Saida {

	static void exibirMensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibirMensagemDeAviso(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro!", JOptionPane.WARNING_MESSAGE);
	}

	public static void exibirMensagemDeErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro!", JOptionPane.ERROR_MESSAGE);
	}

	// CIDADES COM A QUANTIDADE DE CONTAMINADOS MAIOR OU IGUAL A PESQUISADA
	public static void exibirPesquisa(Pais mundo) {
		int contaminados = Validacao.validaInt("Infome a quantidade de contaminados:", "PESQUISA");

		if (mundo.isContaminadosMaior(contaminados)) {
			limpaTela(40);
			System.out.println("Cidades com quantidade de contaminados maior ou igual a " + contaminados + ":\n");
			System.out.format("%-15s%-10s%-15s%-20s\n", "Cidade", "Estado", "Contaminados", "Mortos");
			mundo.mostraContaminadas(contaminados);
		} else
			exibirMensagem("Nao ha cidades com uma quantidade de contaminados maior ou igual a quantidade pesquisada ("
					+ contaminados + ").", "PESQUISA");
	}

	// RELATORIO COM OS DADOS CADASTRADOS
	public static void exibirRelatorio(Pais mundo) {
		limpaTela(40);
		if (mundo.getCidades().isEmpty())
			System.out.println("Nao houveram cadastrados.");
		else {
			System.out.println("Cadastros:\n");
			System.out.format("%-15s%-10s%-15s%-20s\n", "Cidade", "Estado", "Contaminados", "Mortos");
			for (Cidade pais : mundo.getCidades())
				System.out.print(pais);
		}
	}

	static void limpaTela(int linhasPuladas) {
		for (int aux = 0; aux < linhasPuladas; aux++)
			System.out.println();
	}

}
