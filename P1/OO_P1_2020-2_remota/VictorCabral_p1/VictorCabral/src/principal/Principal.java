// Nome Completo: Victor de Souza Cabral       Data da Prova: 20/10/2020
package principal;

import dados.Populacao;
import dados.Masculino;
import dados.Feminino;
import validacao.Validacao;
import saida.Visao;

public class Principal {

	public static void main(String[] args) {
		int opcao;
		Populacao populacao = new Populacao();

		Visao.mensagemInicial();
		do {
			if (Validacao.validaSexo() == 'M') {
				Masculino masculino = new Masculino(Validacao.validaCodigo(populacao), Validacao.validaNome(),
						Validacao.validaSituacaoSaude(), Validacao.validaIdade());
				populacao.setGrupoMasculino(masculino);
				populacao.setPopulacao(masculino);
				}
				else {
			    Feminino feminino = new Feminino(Validacao.validaCodigo(populacao), Validacao.validaNome(),
							Validacao.validaSituacaoSaude(), Validacao.validaHistoricoGestante());
				populacao.setGrupoFeminino(feminino);
				populacao.setPopulacao(feminino);
				}
			
			opcao = Validacao.validaMenuInicial();
			switch (opcao) {
			case 1:
				if (Validacao.validaSexo() == 'M') {
				Masculino masculino = new Masculino(Validacao.validaCodigo(populacao), Validacao.validaNome(),
						Validacao.validaSituacaoSaude(), Validacao.validaIdade());
				populacao.setGrupoMasculino(masculino);
				populacao.setPopulacao(masculino);
				}
				else {
			    Feminino feminino = new Feminino(Validacao.validaCodigo(populacao), Validacao.validaNome(),
							Validacao.validaSituacaoSaude(), Validacao.validaHistoricoGestante());
				populacao.setGrupoFeminino(feminino);
				populacao.setPopulacao(feminino);
				}
				break;
			case 2:
				Visao.tabela(opcao, populacao);
				break;
			}
			Visao.limpaTela(2);
		} while (opcao != 0);
		Visao.limpaTela(40);

	}
}
