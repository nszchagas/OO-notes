//Nome completo: Joao Pedro Moura Oliveira        Data da Prova: 20/10/2020
package principal;

import dados.Populacao;
import saida.Visao;
import servicos.Servicos;
import valicao.Validacao;

public class Principal {
	public static void main (String [] args) {
		// Atributos
		Populacao populacao = new Populacao();
		int escolha;
		
		// Metodos
		Servicos.registraNovaPessoa(populacao);
		Visao.limpaTela(50);
		do {
			String [] opcoes = {"[1] - Registrar Novo Cadastro", "[2] - Mostrar todos os Cadastros", "[0] - Encerrar"};
			Visao.mostraMenu(opcoes);
			escolha = Validacao.validaInteiro("Escolha uma opcao:", 0, 2);
			Visao.limpaTela(50);
			switch (escolha) {
			case 1:
				Servicos.registraNovaPessoa(populacao);
				break;
			case 2:
				if (!populacao.getPopulacao().isEmpty()) {
					Visao.mostraRegistros(populacao);
				}
				else {
					Visao.mostraMensagemErro("Erro, deve se registrar ao menos uma Pessoa.");
				}
			}
		} while (escolha != 0);
		Visao.mostraResultadoFinal(populacao);
	}
}
