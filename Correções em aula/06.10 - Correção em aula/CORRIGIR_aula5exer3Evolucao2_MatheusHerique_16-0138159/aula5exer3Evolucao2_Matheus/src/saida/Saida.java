package saida;

import java.text.DecimalFormat;

public class Saida {
	// Apresenta o resultado final
	public static void imprimeResultado(final int MAXIMO, int totalHabitantes, int menorIdade, float maiorSalario,
			float mediaFilhos, float mediaSalarios, float mediaHomens, int pessoasSalarioMaiorMedia) {
		// Declaracoes
		DecimalFormat centesimo = new DecimalFormat("0.00");

		// Instrucoes
		limpaTela(20);
		if (totalHabitantes == MAXIMO) {
			System.out.println("Maximo de cadastros alcancado!");
			limpaTela(1);
		}
		if (totalHabitantes == 0)
			System.out.println("Nenhum habitante da cidade foi cadastrado!\nRelatorio de analise sem dados");
		else {
			System.out.println("Foram feitos " + totalHabitantes + " cadastros!");
			System.out.println("Relatorio de analise dos dados cadastrados:\n");
			System.out.println("Menor idade registrada: \t" + menorIdade);
			System.out.println("Maior salario registrado:\tR$" + centesimo.format(maiorSalario));
			System.out.println("Media do número de filhos:\t" + centesimo.format(mediaFilhos));
			System.out.println("Media do salario das pessoas registradas:\tR$" + centesimo.format(mediaSalarios));
			System.out.println("Media dos homens com salario superior a R$300,00:\tR$" + centesimo.format(mediaHomens));
			System.out.println("Quantidade de pessoas que tem salario maior que a media das pessoas registradas:\t"
					+ pessoasSalarioMaiorMedia);
		}
	}

	// Salta quantidade de linhas desejadas
	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
}
