package principal;

import dados.Grupo;
import dados.Pessoa;
import saida.Saida;

public class Principal {
	public static void main(String[] args) {
		// Declaracoes
		final int MAXIMO = 3;
		Grupo grupo = new Grupo(MAXIMO);
		int aux = 0;
		// Instruções
		while (aux < MAXIMO && Saida.verificaContinuarCadastro()) {
			Saida.mostraMensagemCadastro(aux);
			Pessoa pessoa = new Pessoa(Saida.cadastraNome(), Saida.cadastraIdade(), Saida.cadastraAltura());
			grupo.guardaPessoaNoGrupo(pessoa, aux);
			aux++;
			Saida.limpaTela(40);
		}
		Saida.limpaTela(40);
		if (aux == MAXIMO)
			Saida.mostraMensagemCapacidadeMax(MAXIMO);
		if (grupo.getGrupo()[0] != null)
			Saida.mostraTabela(grupo);

		Saida.mostraMensagemProgramaEncerrado();

	}
}
