package servicos;

import dados.GrupoPessoa;
import dados.Homem;
import dados.Mulher;
import saida.Visao;
import validacao.Validacao;

public class Servicos {

	public static void registraPessoa(GrupoPessoa grupoPessoa) {
		Visao.limpaTela(40);
		switch (Validacao.validaMenuRegistro()) {
		case '1':
			registraMulher(grupoPessoa);
			break;
		case '2':
			registraHomem(grupoPessoa);
		}
		Visao.mostraMensagem("\nPessoa cadastada com sucesso!\n");
	}

	public static void registraHomem(GrupoPessoa grupoPessoa) {
		Homem homem = new Homem(Validacao.validaId(grupoPessoa), Validacao.validaNomeCompleto(), Validacao.validaIdade(), Validacao.validaSituacaoSaude());
		grupoPessoa.setPessoas(homem);
	}

	public static void registraMulher(GrupoPessoa grupoPessoa) {
		Mulher mulher = new Mulher(Validacao.validaId(grupoPessoa), Validacao.validaNomeCompleto(), Validacao.validaFoiGestante(), Validacao.validaSituacaoSaude());
		grupoPessoa.setPessoas(mulher);
	}

}
