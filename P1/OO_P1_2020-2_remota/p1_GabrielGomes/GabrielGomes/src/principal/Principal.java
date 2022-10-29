//Nome Completo: Gabriel Luiz de Souza Gomes       Data da Prova: 20/10/2020

package principal;


import dados.PessoaSaudavel;
import dados.Populacao;
import leitura.Leitura;
import saida.Visao;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		
		final int MINIMO = 1;
		char escolha;
		
		Populacao populacao = new Populacao();
		
		do {
			
			escolha = Validacao.validaMenu(populacao);
			
			switch (escolha) {
			case '0':
				break;
			case '1':
				
				Visao.mostraMensagem("A pessoa esta saudavel? s ou n");
				if(Leitura.lerEntrada() == "s")
					PessoaSaudavel.registraPessoa(populacao);
				break;
			case '2':
				//Baleia.registraBaleia(grupoMamiferos);
				break;
			}
			
		}while(escolha != '0');

	}

}
