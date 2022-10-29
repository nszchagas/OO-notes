package saida;

import java.text.DecimalFormat;

import dados.GrupoPessoas;
import dados.PessoaContaminada;
import dados.PessoaNaoContaminada;

public class Visao {

	public static void msgConsole(String msg) {
		System.out.println(msg);
	}

	public static void msgErro() {
		msgConsole("Entrada invalida! Tente novamente.");
	}

	public static void mostraCadastros(GrupoPessoas grupo) {
		msgConsole("Identificador\t\tNome completo\t\tGênero\t\tIdade\t\tSituação de saúde");
		
		for (PessoaContaminada pessoaContaminada : grupo.getPessoasContaminadas()) {
			Visao.msgConsole(pessoaContaminada.toString());
		}
		
		for (PessoaNaoContaminada pessoaNaoContaminada : grupo.getPessoasNaoContaminadas()) {
			Visao.msgConsole(pessoaNaoContaminada.toString());
		}
		
		limpaConsole(3);
		
	}

	public static void limpaConsole(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
		
	}
	
}
