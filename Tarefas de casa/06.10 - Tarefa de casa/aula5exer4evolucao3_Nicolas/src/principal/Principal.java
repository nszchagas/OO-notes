package principal;

import dados.Grupo;
import dados.Pessoa;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {

		do {
			Grupo grupo = new Grupo();

			do {

				Pessoa pessoa = new Pessoa(Validacao.validaNome());
				grupo.setNomes(pessoa);
				Visao.limpaTela(2);
			} while (Validacao.validaCadastroNome());
			Visao.limpaTela(50);
			Visao.mostraRelatorio(grupo);
			Visao.mostraMensagem("A ultima lista teve " + grupo.getNomes().size() + " nomes cadastrados");

		} while (Validacao.validaNovoGrupo());
	}
}
