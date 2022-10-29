// Nome Completo: Lucas Braun Vieira Xavier		Data da Prova: 20/10/2020

package principal;

import dados.Populacao;
import saida.Saida;
import servicos.Servicos;

public class CadastraPessoasPandemia {
	public static void main(String[] args) {
		Populacao populacao = new Populacao();
		int opcao = 1;
					
		do {
			switch (opcao) {
			case 1:
				Servicos.escolherPessoa(populacao);
				break;
			case 2:
				Saida.mostraCadastros(populacao);				
			}
			Saida.mostraMenu();
			opcao = Servicos.getOpcaoMenu(0, 2);
		} while (opcao != 0);
		
		Saida.mostraTotal(populacao);
	}

}
