// Nome Completo: Brenno Oliveira Silva Data da Prova:20/10/2020
package principal;

import dados.GrupoPessoa;
import dados.PessoaContaminada;
import dados.PessoaNaoContaminada;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	
	public static void main(String[] args) {
		final int MINIMO = 1;
		int entrada = 1;
		GrupoPessoa grupoCovid = new GrupoPessoa();
		
		
		do{			
			switch (entrada) {
			case 1:
				switch (Validacao.validaCadastro()) {
				case 1:
					grupoCovid.setGrupoCovid(new PessoaContaminada(Validacao.validaIdentificacao(MINIMO, grupoCovid), Validacao.validaNome(), 
												Validacao.validaGenero(), Validacao.validaSituacao()));
					break;
				case 2:
					grupoCovid.setGrupoCovid(new PessoaNaoContaminada(Validacao.validaIdentificacao(MINIMO, grupoCovid), Validacao.validaNome(), 
							Validacao.validaGenero(), Validacao.validaIdade()));
					break;
				}
				break;
			case 2:
				Visao.mostraTabela(grupoCovid);
				break;				
			}
			entrada = Validacao.validaContinua();
		}while(entrada != 0);
		
		Visao.mostraFinal(grupoCovid);
	}
}
