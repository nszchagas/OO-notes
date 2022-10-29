package principal;

import dados.Pais;
import dados.Cidade;
import validacao.Validacao;
import visao.Saida;

public class Principal {
	public static void main(String[] args) {
		Pais mundo = new Pais();
		int opcao;

		do {
			try {
				switch (opcao = Validacao.validaMenuCadastral()) {
				case 0:
					StringBuilder cidade;
					int qtd_contaminados;
					mundo.addCidade(new Cidade(cidade = Validacao.validaCidade(), Validacao.validaEstado(mundo, cidade),
							qtd_contaminados = Validacao.validaContaminados(),
							Validacao.validaMortos(qtd_contaminados)));
					break;
				case 1:
					Saida.exibirPesquisa(mundo);
					break;
				default: // ENCERRAMENTO DO PROGRAMA (SOMENTE QUANDO CLICAR NO 'X')
					Saida.exibirRelatorio(mundo);
					opcao = -2;
				}
			} catch (NullPointerException excecao) {
				opcao = -1;
			}
		} while (opcao != -2);

	}
}