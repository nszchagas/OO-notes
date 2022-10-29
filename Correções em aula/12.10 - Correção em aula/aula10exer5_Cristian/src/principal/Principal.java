package principal;

import javax.swing.JOptionPane;
import dados.ColecaoCidades;
import visao.Visao;

import java.util.*;

public class Principal {
	public static void main(String[] args) {
		ColecaoCidades colecao = new ColecaoCidades();

		List listaCidades = colecao.getCidades();

		int resposta;

		do {

			resposta = JOptionPane.showConfirmDialog(null, "Deseja registra uma cidade?", "Pergunta",
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

			if (resposta == 0) {
				Visao.cadastraCidade(colecao);
			}

		} while (resposta != -1 && resposta != 1);

		Collections.sort(listaCidades);

		Visao.mostraCidadesCadastradas(colecao);

	}
}