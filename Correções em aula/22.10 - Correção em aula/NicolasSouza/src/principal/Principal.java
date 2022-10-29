// Nome Completo: Nicolas Chagas Souza        Data da Prova: 20/10/2020   
package principal;

import dados.Populacao;
import visao.Visao;

public class Principal {
	public static void main(String[] args) {

		Populacao populacao = new Populacao();
		Visao.menuPrincipal(populacao);
		Visao.mostraDados(populacao);

	}
}
