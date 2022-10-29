package saida;

import java.text.DecimalFormat;

import dados.Turma;
import validacao.Validacao;

public class Visao {

	public static void mostraRelatorio(Turma turma) {

		DecimalFormat mascara = new DecimalFormat("0.00");

		limpaConsole(35);
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("MATRICULA\t\t\tNOME\t\t\t\tMEDIA FINAL");
		System.out.println("---------------------------------------------------------------------------------");

		for (int i = 0; i < turma.getTurma().size(); i++) {
			System.out.println(turma.getAluno(i).toString());
		}
		System.out.println("\n\nMEDIA GERAL: " + mascara.format(Validacao.validaMediaGeral(turma)));
	}

	public static void limpaConsole(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();

	}
}
