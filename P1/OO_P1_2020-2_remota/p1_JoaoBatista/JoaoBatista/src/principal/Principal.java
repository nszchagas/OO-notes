// Nome Completo: Joao Victor Teixeira Batista    Data da Prova: 20/10/2020
package principal;

import java.util.ArrayList;

import dados.Pessoa;
import dados.PessoaContaminada;
import dados.PessoaNaoContaminada;
import dados.Populacao;
import leitura.Leitura;
import saida.Saida;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		Populacao populacao = new Populacao();
		
		Validacao.validaPessoa(populacao);
		
		char opcao;
		 do {
			 Saida.imprimeMenu();
			 opcao = Validacao.validaOpcaoMenu();
			 
			 switch(opcao) {
				case '1':
					Validacao.validaPessoa(populacao);
					break;
				case '2':
					Saida.imrimeTabela(populacao);
					break;
				case '0':
					Saida.limpaTela(50);
					Saida.imprimeTotais(populacao);
			 }

		 } while (opcao != '0');
		 
	}
}
