// Nome Completo:Victor Hugo Carvalho Silva  Data da Prova:20/10/2020

package principal;

import dados.*;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		char escolhaCadastro;
		char opcao = 0;
		GrupoPessoas grupoPessoas = new GrupoPessoas();

		do {
			if (grupoPessoas.getGrupoPessoas().size() == 0 || opcao == '1') {
				escolhaCadastro = Validacao.validaChar(Visao.menuCadastro(), "01");
				if (escolhaCadastro == '0')
					registraHomem(grupoPessoas);
				else
					registraMulher(grupoPessoas);
			}
			opcao = Validacao.validaChar(Visao.menu(), "012");
			if (opcao == '2')
				Visao.mostraCadastros(grupoPessoas);
		} while (opcao != '0');
		Visao.mostraResultados(grupoPessoas);
	}

	// Outros metodos
	public static void registraHomem(GrupoPessoas grupoPessoas) {
		Homem homem = new Homem(Validacao.validaIdentificador(grupoPessoas), Validacao.validaNome(),
				Validacao.validaChar(Visao.opcoesSituacoesSaude(), "TFCS"),
				Validacao.validaInt("Digite a idade do homem:", 0, 150));
		grupoPessoas.setGrupoPessoas(homem);
	}

	public static void registraMulher(GrupoPessoas grupoPessoas) {
		Mulher mulher = new Mulher(Validacao.validaIdentificador(grupoPessoas), Validacao.validaNome(),
				Validacao.validaChar(Visao.opcoesSituacoesSaude(), "TFCS"),
				Validacao.validaChar(Visao.opcoesGestante(), "SNT"));
		grupoPessoas.setGrupoPessoas(mulher);
	}
}
