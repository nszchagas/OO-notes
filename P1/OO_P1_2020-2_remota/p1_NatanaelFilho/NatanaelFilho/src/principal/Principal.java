package principal;

import dados.Grupo;
import dados.Pessoa;
import dados.PessoaContaminada;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	// Nome Completo: Natanael Fernandes Coelho Filho
	// Data da Prova: 20/10/2020
	public static void main(String[] args) {
		Grupo grupo;
		int indice;
		do {
			grupo = new Grupo();
			do {
				indice = Validacao.validaIndice(Visao.mostraMenuDeCadastramento());
				switch (indice) {
				case 1:
					grupo.setPessoaSaudavel(new Pessoa(Validacao.validaNome(), Validacao.validaSexo(),
							Validacao.validaIndentificador(grupo), Validacao.validaIdade()));
					break;
				case 2:
					grupo.setPessoaContaminada(new PessoaContaminada(Validacao.validaNome(), Validacao.validaSexo(),
							Validacao.validaIndentificador(grupo), Validacao.validaIdade(),
							Validacao.validaSituacao()));
				}
			} while (indice != 0);

			do {
				indice = Validacao.validaIndice(Visao.mostraMenuDeRelatorio());

				switch (indice) {
				case 1:
					Visao.mostraMensagem("Novo Registro de pessoas\n\n");
					break;
				case 2:
					Visao.mostraPessoasCadastradas(grupo);
					break;
				}

			} while (indice != 0 && indice != 1);
		} while (indice != 0);
		Visao.ResultadoFinal(grupo);

	}

}
