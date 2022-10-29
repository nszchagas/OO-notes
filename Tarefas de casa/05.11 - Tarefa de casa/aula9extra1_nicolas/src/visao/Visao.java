package visao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dados.Cidade;
import leitura.Leitura;
import validacao.Validacao;

public class Visao {

	// cadastro de dados

	public static String registraEstado() {
		String estado = null;
		String[] estados = { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
				"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };

		estado = ((String) JOptionPane.showInputDialog(null, "Escolha o estado", "Cadastro",
				JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]));
		if (estado == null)
			if (janelaConfirmacao("Deseja cancelar esse cadastro?", "Cancelar"))
				return null;

		return estado;

	}

	public static String registraNomeCidade() {

		String nome = "";
		boolean erro = true;

		while (erro) {

			try {
				do {
					nome = Leitura.janelaLeitura("Insira o nome da cidade:", "Cadastro");
				} while (!Validacao.isNome(nome.trim()));
				erro = false;

			} catch (NullPointerException e) {
				if (nome == null && janelaConfirmacao("Deseja cancelar esse cadastro?", "Cancelar"))
					erro = false;
				else
					erro = true;
			}
		}
		return nome;

	}

	public static int[] registraContaminacoes() {
		int quantidade[] = { 0, 0 };
		String saida;
		boolean erro = true;

		while (erro) {
			try {
				do {
					saida = Leitura.janelaLeitura("Insira quantidade de pessoas contaminadas na cidade:", "Cadastro")
							.trim();

					quantidade[0] = Integer.parseInt(saida);

				} while (!Validacao.isQuantidade(0, 13000000, quantidade[0]));
				do {
					saida = Leitura.janelaLeitura("Insira quantidade de obitos por covid-19 na cidade:", "Cadastro")
							.trim();
					quantidade[1] = Integer.parseInt(saida);

				} while (!Validacao.isQuantidade(0, quantidade[0], quantidade[1]));
				erro = false;
			} catch (NumberFormatException erroFormato) {
				mostraMensagem("Digite apenas numeros inteiros", JOptionPane.ERROR_MESSAGE);
				erro = true;
			} catch (NullPointerException erroNull) {
				if (janelaConfirmacao("Deseja cancelar esse cadastro?", "Cancelar"))
					return null;
				else
					erro = true;

			}
		}
		return quantidade;
	}

	public static int registraParametro() {
		boolean erro = true;
		String saida;
		int numero = -1;

		while (erro) {
			try {
				do {
					saida = Leitura.janelaLeitura(
							"Insira parametro de busca. \nProcurar cidades com numero de contaminacoes maior ou igual a:",
							"Cadastro").trim();
					if (saida != null)
						numero = Integer.parseInt(saida);
					else if (janelaConfirmacao("Deseja cancelar a pesquisa?", "Cancelar"))
						return -1;
					else
						erro = true;

				} while (!Validacao.isQuantidade(0, 13000000, numero));
				erro = false;
			} catch (NumberFormatException e) {
				erro = true;
				mostraMensagem("Digite apenas numeros inteiros", JOptionPane.ERROR_MESSAGE);
			}
		}
		return numero;

	}

	// saida de dados (tabelas)

	public static void mostraTabela(ArrayList<Cidade> cidades) {
		if (cidades.size() > 0) {
			limpaTela(30);
			mostraCabecalho();
			for (Cidade cidade : cidades)
				System.out.print(cidade);
		} else
			mostraMensagem("Nao ha nenhum dado cadastrado com os parametros solicitados.", JOptionPane.WARNING_MESSAGE);

	}

	public static void mostraCabecalho() {

		// | Nome | Estado | Contaminados | Falecidos |
		String formato = "| %-60s | %-6s | %-12s | %-9s | \n";
		System.out.format(formato, "Nome", "Estado", "Contaminados", "Falecidos");
		linhaHorizontal(100);
	}

	// janelas de dialogo

	public static boolean janelaConfirmacao(String mensagem, String titulo) {
		return (JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == 0); // -1 e 1 geram false (não)
	}

	public static int mostraMenu(String mensagem, String titulo, String[] opcoes) {
		return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

	}

	public static void mostraMensagem(String mensagem, final int TIPO) {
		String titulo = (TIPO == JOptionPane.ERROR_MESSAGE) ? "Erro" : "Aviso";
		JOptionPane.showMessageDialog(null, mensagem, titulo, TIPO, null);
	}

	// servicos de limpeza/organizacao console

	private static void limpaTela(int linhas) {
		for (int aux = 0; aux < linhas; aux++)
			System.out.println();
	}

	private static void linhaHorizontal(int tamanho) {
		for (int aux = 0; aux < tamanho; aux++)
			System.out.print("-");
		limpaTela(1);
	}

}
