package saida;

import java.text.DecimalFormat;

import dados.*;

public class Visao {
	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}

	public static String opcoesSituacoesSaude() {
		return ("Digite a situacao de saude dessa pessoa:\n(T = contaminada em Tratamento, F = contaminada falecida, C = contaminada Curada e S = Sem contaminacao)");
	}

	public static String opcoesGestante() {
		return ("A mulher cadastrada ja foi gestante?\n(S = sim, N = nao ou T = nao tem certeza)");
	}

	public static String menu() {
		return ("Escolha uma das opcoes a seguir: \n0 = Sair \n1 = Registro novo \n2 = Relatorio de todos registros");
	}

	public static String menuCadastro() {
		return ("Escolha uma das opcoes a seguir: \n0 = Cadastrar Homem \n1 = Cadastrar Mulher");
	}

	public static void mostraCadastros(GrupoPessoas grupoPessoas) {
		String formato = "%-20s%-30s%-30s%-20s%-20s\n";
		System.out.format(formato, "IDENTIFICADOR", "NOME COMPLETO", "SITUACAO SAUDE", "IDADE", "GESTANTE");
		System.out.println(
				"==========================================================================================================");
		for (Pessoa pessoa : grupoPessoas.getGrupoPessoas())
			System.out.print(pessoa);
	}

	public static void mostraResultados(GrupoPessoas grupoPessoas) {
		DecimalFormat mascara = new DecimalFormat("00");
		System.out.println(grupoPessoas.getAnalise()[0] + " CONTAMINADOS CURADOS\n" + grupoPessoas.getAnalise()[1]
				+ " CONTAMINADOS EM TRATAMENTO" + grupoPessoas.getAnalise()[2] + "CONTAMINADOS FALECIDOS");
	}

}
