package principal;

import dados.Homem;
import dados.Mulher;
import dados.Populacao;
import saida.Visao;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		int opcao1 = 0;
		int opcao2 = 0;
		opcao1 = Validacao.validaTipoCadastro();
		Populacao populacao = new Populacao();
		switch (opcao1) {
		case 1:
			Mulher mulher = new Mulher(Validacao.validaIdPessoa(populacao.getPopulacao()), Validacao.validaNome(),
					Validacao.validaSituacao(), Validacao.validaGravidez());
			populacao.setPopulacao(mulher);
			break;
		case 2:
			Homem homem = new Homem(Validacao.validaIdPessoa(populacao.getPopulacao()), Validacao.validaNome(),
					Validacao.validaSituacao(), Validacao.validaIdadeHomem());
			populacao.setPopulacao(homem);
		}
		do {
			opcao2 = Validacao.validaMenu();
			switch (opcao2) {
			case 1:
				opcao1 = Validacao.validaTipoCadastro();
				switch (opcao1) {
				case 1:
					Visao.limpaTela(25);
					Mulher mulher = new Mulher(Validacao.validaIdPessoa(populacao.getPopulacao()),
							Validacao.validaNome(), Validacao.validaSituacao(), Validacao.validaGravidez());
					populacao.setPopulacao(mulher);
					break;
				case 2:
					Visao.limpaTela(25);
					Homem homem = new Homem(Validacao.validaIdPessoa(populacao.getPopulacao()), Validacao.validaNome(),
							Validacao.validaSituacao(), Validacao.validaIdadeHomem());
					populacao.setPopulacao(homem);
				}
				break;
			case 2:
				Visao.limpaTela(40);
				Visao.mostraRegistros(populacao.getPopulacao());
				break;
			case 0:
				Visao.limpaTela(40);
				Visao.mostraProgramaEncerrado(populacao.getPopulacao());

			}

		} while (opcao2 != 0);
	}

}
