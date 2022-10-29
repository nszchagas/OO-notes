package visao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dados.Pessoa;
import dados.Populacao;

public class Visao {

	public static void mostraDados(Populacao populacao) {
		String formato = "%02d = %s";
		limpaTela(40);
		System.out.format(formato, populacao.getQuantidadePessoasSituacao('C'), "CONTAMINADOS CURADOS\n");
		System.out.format(formato, populacao.getQuantidadePessoasSituacao('T'), "CONTAMINADOS EM TRATAMENTO\n");
		System.out.format(formato, populacao.getQuantidadePessoasSituacao('F'), "CONTAMINADOS FALECIDOS\n");
		System.out.format(formato, populacao.getQuantidadePessoasSituacao('S', 'M'), "HOMENS SEM CONTAMINACAO\n");
		System.out.format(formato, populacao.getQuantidadePessoasSituacao('S', 'F'), "MULHERES SEM CONTAMINACAO\n");
		imprimeLinha(35);
		System.out.format(formato, populacao.getPopulacao().size(), "TOTAL DE REGISTROS DE PESSOAS\n");

	}

	public static void mostraTabela(ArrayList<Pessoa> populacao) {
		limpaTela(40);

		if (populacao.size() > 0) {
			String formato = "| %-13s | %-33s | %-28s | %-5s | %-15s |";
			imprimeLinha(108);
			System.out.format(formato, "IDENTIFICADOR", "NOME COMPLETO", "SITUACAO DE SAUDE", "IDADE", "GESTANTE");
			limpaTela(1);
			imprimeLinha(108);
			for (Pessoa pessoa : populacao)
				System.out.println(pessoa);
			imprimeLinha(108);
		} else
			mostraMensagemErro("Nenhum cadastro foi encontrado", "Erro");
	}

	public static void mostraMensagemErro(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
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
