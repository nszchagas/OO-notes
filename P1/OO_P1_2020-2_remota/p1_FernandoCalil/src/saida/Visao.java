package saida;

import dados.Cadastro;
import dados.Pessoa;

public class Visao {

	public static void pulaLinhas(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}

	public static void limpaTela() {
		for (int i = 0; i < 50; i++)
			System.out.println();
	}

	public static void apresentaMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	public static void mostraOpcoes() {
		System.out.println(
				"Escolha uma opcao:\n\t[1] - Novo cadastro.\n\t[2] - Mostrar todos os cadastros.\n\t[0] - Encerrar cadastro.");
	}

	public static void mostraCadastros(Cadastro cadastrados) {

		Visao.limpaTela();
		String formato = "%-15s%-25s%-18s%-10s%-15s\n";
		System.out.format(formato, "Identificador |", "Nome Completo |", "Genero |", "Idade |", "Situacao de saude");
		for (Pessoa pessoa : cadastrados.getCadastros())
			System.out.print(pessoa.toString());
	}
}
