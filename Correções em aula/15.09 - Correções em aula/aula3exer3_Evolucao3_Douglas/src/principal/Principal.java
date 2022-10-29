package principal;

import dados.Grupo;
import dados.Pessoa;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		// Declaracoes
		final int LIMITE = 2;
		int contaPessoa = 0;

		Grupo grupo = new Grupo(LIMITE);

		// Procedimentos
		do {
			System.out.println("Pessoa [" + (contaPessoa + 1) + "] de [" + LIMITE + "]\n");

			Pessoa pessoa = new Pessoa(Validacao.validaNome(), Validacao.validaIdade(), Validacao.validaAltura());

			grupo.setPessoaNoGrupo(pessoa, contaPessoa++); //usa e depois incrementa

			Visao.limpaTela(50);
		} while (Validacao.validaContinua(contaPessoa, LIMITE));

		Visao.mostraDados(grupo);
	}
}
