//Nome Completo: Matheus Calixto Vaz Pinheiro 		//Data da prova:20/10/2020

package principal;

import saida.Saida;
import validacao.Validacao;
import dados.*;

public class Principal {

	public static void main(String[] args) {
		int escolha = 0;
		Populacao populacao = new Populacao();
		escolha = Validacao.validaMenuInicio();
		switch(escolha) {
			case 1:
				PessoaContaminada pessoaContaminada = new PessoaContaminada(Validacao.validaNome(), Validacao.validaGenero(), Validacao.validaIndentificador(populacao), Validacao.validaSituacao());
				populacao.setPopulacao(pessoaContaminada);
				break;
			case 2:
				PessoaNaoContaminada pessoaNaoContaminada = new PessoaNaoContaminada(Validacao.validaNome(), Validacao.validaGenero(), Validacao.validaIndentificador(populacao), Validacao.validaIdade());
				populacao.setPopulacao(pessoaNaoContaminada);
				break;
		}
		do {
			Saida.limpaTela(30);
			escolha = Validacao.validaMenuFinal();
			switch(escolha) {
				case 1:
					Saida.limpaTela(30);
					escolha = Validacao.validaMenuInicio();
					switch(escolha) {
						case 1:
							PessoaContaminada pessoaContaminada = new PessoaContaminada(Validacao.validaNome(), Validacao.validaGenero(), Validacao.validaIndentificador(populacao), Validacao.validaSituacao());
							populacao.setPopulacao(pessoaContaminada);
							break;
						case 2:
							PessoaNaoContaminada pessoaNaoContaminada = new PessoaNaoContaminada(Validacao.validaNome(), Validacao.validaGenero(), Validacao.validaIndentificador(populacao), Validacao.validaIdade());
							populacao.setPopulacao(pessoaNaoContaminada);
							break;
					}
				case 2:
					Saida.mostraPessoasCadastradas(populacao);
					break;
				case 0:
					Saida.limpaTela(50);
					Saida.mostraContagemPessoas(populacao);					
			}
			
			
		}while(escolha != 0);
		
	}
}
