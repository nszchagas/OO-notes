package principal;

import java.text.DecimalFormat;

public class Servicos {

	public static void limpaTela(int linhas) {
		for (int aux = 0; aux < linhas; aux++)
			System.out.println();
	}

	public static void mostraDados(String nome, float altura, int idade) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		System.out.println("Os dados inseridos foram:");

		for (int cont = 0; cont < 50; cont++)
			System.out.print("-");
		System.out.println("\nNome da pessoa: " + nome);
		System.out.println("Altura da pessoa: " + mascara.format(altura) + "m.");
		System.out.println("Idade da pessoa: " + idade);

		for (int cont = 0; cont < 50; cont++)
			System.out.print("-");
			System.out.println();
	}

}
