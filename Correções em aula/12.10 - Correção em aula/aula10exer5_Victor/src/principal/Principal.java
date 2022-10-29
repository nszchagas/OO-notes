/** Síntese
 * Objetivo: guardar e mostrar dados de cidades
 * Entrada: cidades e DDDs
 * Saída: listagem das cidades cadastradas em ordem
 */

package principal;

import dados.*;
import validacao.Validacao;
import visao.Visao;

public class Principal {
	public static void main(String[] args) {
		// DECLARACOES
		Colecao listaCidades = new Colecao();
		int resposta = 1;

		do {
			try {
				resposta = Visao.confirmar("Deseja registrar uma cidade?");
				if (resposta == 0)
					listaCidades.cadastrarCidade(new Cidade(Validacao.validaNome(), Validacao.validaDDD()));
				else if (Visao.confirmar("Deseja encerrar o programa?") != 0)
						resposta = 0;
				

			} catch (NullPointerException e) {
				Visao.mostraMensagemAviso("Operacao encerrada!");
			}
		} while (resposta == 0);

		Visao.mostraResultado(listaCidades);
	}
}
