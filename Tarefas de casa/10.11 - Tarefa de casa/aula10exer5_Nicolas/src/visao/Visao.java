package visao;

import java.util.List;

import javax.swing.JOptionPane;

import dados.Cidade;
import leitura.Leitura;
import validacao.Validacao;

public class Visao {

	public static String registraNome() {
		String entrada = null;
		boolean erro = true;
		while (erro) {
			try {
				do {
					entrada = Leitura.leEntrada("Digite o nome da cidade", "Cadastro").trim();
				} while (!Validacao.isNome(entrada));
				erro = false;

			} catch (NullPointerException e) {
				if (perguntaSimOuNao("Cancelar esse cadastro?", "Sair"))
					return null;
				else
					erro = true;
			}
		}
		return entrada;

	}

	public static int registraDDD() {
		int DDD = 0;
		String entrada;
		boolean erro = true;
		while (erro) {
			try {
				do {
					entrada = Leitura.leEntrada("Cadastre o DDD:", "Cadastro");
					if (entrada == null)
						throw new NullPointerException();
					else
						DDD = Integer.parseInt(entrada.trim());
				} while (!Validacao.isDDD(DDD));
				erro = false;
			} catch (NumberFormatException e) {
				mostraMsg("Digite apenas numeros inteiros.", JOptionPane.ERROR_MESSAGE);
				erro = true;
			}

			catch (NullPointerException err) {
				if (perguntaSimOuNao("Cancelar esse cadastro?", "Sair"))
					return -1;
				else
					erro = true;
			}
		}
		return DDD;

	}

	public static void mostraTabela(List<Cidade> cidades) {
		limpaTela(30);
		if (cidades.size() > 0) {
			String formato = "| %-3s | %-60s |\n";
			System.out.format(formato, "DDD", "Nome");
			for (int aux = 0; aux < 70; aux++)
				System.out.print("-");
			limpaTela(1);
			for (Cidade cidade : cidades)
				System.out.println(cidade);
		} else
			mostraMsg("Primeiro cadastre uma cidade.", JOptionPane.INFORMATION_MESSAGE);
	}

	public static boolean perguntaSimOuNao(String mensagem, String titulo) {
		return (JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == 0);
	}

	public static int mostraMenu(String mensagem, String[] opcoes) {
		return JOptionPane.showOptionDialog(null, mensagem, "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}

	public static void mostraMsg(String msg, int tipo) {
		String titulo = (tipo == JOptionPane.ERROR_MESSAGE) ? "Erro" : "Atencao";
		JOptionPane.showMessageDialog(null, msg, titulo, tipo, null);
	}

	private static void limpaTela(int linhas) {
		for (int aux = 0; aux < linhas; aux++)
			System.out.println();
	}

}
