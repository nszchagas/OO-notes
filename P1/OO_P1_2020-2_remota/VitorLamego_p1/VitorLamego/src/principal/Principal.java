// Nome Completo: Vitor Magalhães Lamego			// Data da Prova: 20/10/2020

package principal;

import dados.*;
import saida.Visao;
import servicos.Servicos;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		
		int opcaoMenu;
		Populacao populacao = new Populacao();
		Pessoa pessoa;
		int identificador = 101;
		
		pessoa = Servicos.registraPessoa(identificador++);
		populacao.setPopulacao(pessoa);
		
		do {
			Visao.limpaConsole(5);
			opcaoMenu = Validacao.validaOpcaoMenuPrincipal();
			
			switch(opcaoMenu) {
			case 1:
				pessoa = Servicos.registraPessoa(identificador++);
				populacao.setPopulacao(pessoa);
				break;
			
			case 2:
				Visao.mostraRelatorio(populacao);
				
			}
			
		} while (opcaoMenu != 0);
		
		Visao.resumoRegistros(populacao);
	}
}
