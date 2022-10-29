package principal;

import dados.Homem;
import dados.Mulher;
import dados.Populacao;
import saida.Visao;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		//Nome Completo: RAFAEL CLEYDSON DA SILVA RAMOS    Data da prova: 20/10/2020
		char menu = '1', sexo;
		Populacao populacao = new Populacao();

		do {
			if (menu == '1') {
				sexo = Validacao.validaSexo();
				switch (sexo) {
				case 'M':
					populacao.setPessoa(new Homem(Validacao.validaNome(), Validacao.validaNumCadastro(populacao),
							Validacao.validaSaude(), Validacao.validaIdade()));
					break;
				case 'F':
					populacao.setPessoa(new Mulher(Validacao.validaNome(), Validacao.validaNumCadastro(populacao),
							Validacao.validaSaude(), Validacao.validaGestante()));
					break;
				}
			} else
				Visao.mostraRelatorioRegistros(populacao);
		} while ((menu = Validacao.validaMenu()) != '0');

		Visao.mostraAnaliseContaminados(populacao);
	}

}
