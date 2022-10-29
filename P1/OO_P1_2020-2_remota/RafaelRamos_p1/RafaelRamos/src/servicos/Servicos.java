package servicos;

import dados.Homem;
import dados.Mulher;
import dados.Pessoa;
import dados.Populacao;

public class Servicos {

	public static int[] calculaContaminados(Populacao populacao) {
		int contaminados[] = new int[5];

		/*
		 * CONTAMINADOS[0] = PESSOA CONTAMINADA CURADA
		 * CONTAMINADOS[1] = PESSOA CONTAMINADA EM TRATAMENTO
		 * CONTAMINADOS[2] = PESSOA CONTAMINADA QUE FALECEU
		 * CONTAMINADOS[3] = HOMEM SEM CONTAMINACAO 
		 * CONTAMINADOS[4] = MULHER SEM CONTAMINACAO
		 */

		for (Pessoa pessoa : populacao.getPopulacao()) {
			if (pessoa instanceof Homem) {
				if (pessoa.getSaude() == 'C') {
					contaminados[0]++;
				} else if (pessoa.getSaude() == 'T') {
					contaminados[1]++;
				} else if (pessoa.getSaude() == 'F')
					contaminados[2]++;
				else
					contaminados[3]++;
			} else if (pessoa instanceof Mulher) {
				if (pessoa.getSaude() == 'C') {
					contaminados[0]++;
				} else if (pessoa.getSaude() == 'T') {
					contaminados[1]++;
				} else if (pessoa.getSaude() == 'F')
					contaminados[2]++;
				else
					contaminados[4]++;
			}

		}
		return contaminados;
	}
}
