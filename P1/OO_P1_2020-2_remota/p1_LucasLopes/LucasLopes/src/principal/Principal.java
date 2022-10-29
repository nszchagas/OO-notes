//Nome Completo: Lucas Gomes Lopes   Data da Prova: 20/10/2020
package principal;

import dados.Grupo;
import dados.Contaminada;
import dados.NaoContaminada;
import validacao.Validacao;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		char opcao;
		Grupo grupo = new Grupo();

		if (Validacao.validaEscolha() == '1')
			grupo.setPessoa(new NaoContaminada(Validacao.validaNome(), Validacao.validaGenero(),
					Validacao.validaCodigo(grupo), Validacao.validaIdade()));
		else
			grupo.setPessoa(new Contaminada(Validacao.validaNome(), Validacao.validaGenero(),
					Validacao.validaCodigo(grupo), Validacao.validaSituacaoSaude()));
		
		do {
			opcao = Validacao.validaMenu();
			switch(opcao) {
			case '1':
				if (Validacao.validaEscolha() == '1')
					grupo.setPessoa(new NaoContaminada(Validacao.validaNome(), Validacao.validaGenero(),
							Validacao.validaCodigo(grupo), Validacao.validaIdade()));
				else
					grupo.setPessoa(new Contaminada(Validacao.validaNome(), Validacao.validaGenero(),
							Validacao.validaCodigo(grupo), Validacao.validaSituacaoSaude()));
				break;
			case '2':
				Visao.mostraCadastros(grupo);				
			}
		}while(opcao != '0');
		
		Visao.apresentaResumoDados(grupo);

	}

}
