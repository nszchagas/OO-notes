package principal;

import java.util.Scanner;

/* SÌntese:
 * Objetivo: calcular o numero de vogais em uma frase digitada pelo usuario. 
 * 			O processo sera repetido ate o usuario digitar a palavra de saida.
 * Entrada: Frase (String)
 * Saida: Frase digitada e o numero de cada vogal.
 *  
 */

public class VerificaVogais {
	public static void main(String[] args) {

		// declaracoes

		String frase = "";
		final String PALAVRAFINAL = "sair";
		Scanner scan = new Scanner(System.in).useDelimiter("\n");

		// instrucoes

		System.out.println("Esse programa faz a contagem do numero de cada vogal em uma frase. "
				+ "Para encerrar o programa digite \"" + PALAVRAFINAL + "\" para encerrar o programa.\n");

		while (frase.trim().equalsIgnoreCase(PALAVRAFINAL) == false) { // trim remove os espacos antes de comparar as
																		// Strings

			do {
				System.out.println("Digite uma frase (ou sair, para encerrar o programa):");
				frase = scan.next();
			} while (validaEntrada(frase) == false);

			if (frase.trim().equalsIgnoreCase(PALAVRAFINAL) == true)
				break;

			limpaTela();
			frase = frase.substring(0, frase.length() - 1); // a String e guardada com o "\n", retirei-no da ultima
															// posicao para imprimir a
															// string na tela sem pular linha
			System.out.println("A frase digitada foi: \"" + frase + "\"");
			contaVogais(frase);

		}

		System.out.println("Programa encerrado!");

	}

	public static void contaVogais(String texto) {

		int numeroAs = texto.length() - texto.replaceAll("[Aa¡·¿‡√„¬‚]", "").length(); // retira da String todos os
																						// chars que tem a (Acentuado ou
																						// nao) e ve o tamanho. A
																						// diferenca de tamanho para a
																						// String anterior conrresponde
																						// a quantidade de "a"s
		int numeroEs = texto.length() - texto.replaceAll("[Ee…È Í]", "").length();
		int numeroIs = texto.length() - texto.replaceAll("[IiÕi]", "").length();
		int numeroOs = texto.length() - texto.replaceAll("[Oo”Û’ı‘Ù]", "").length();
		int numeroUs = texto.length() - texto.replaceAll("[Uu⁄˙]", "").length();

		for (int cont = 0; cont < 50; cont++)
			System.out.print("-");

		System.out.println("\n\tVogal\t | Numero de ocorrencias");
		System.out.println("\t A \t |\t" + numeroAs);
		System.out.println("\t E \t |\t" + numeroEs);
		System.out.println("\t I \t |\t" + numeroIs);
		System.out.println("\t O \t |\t" + numeroOs);
		System.out.println("\t U \t |\t" + numeroUs);
		System.out.println("\tTotal    |\t" + (numeroAs + numeroEs + numeroIs + numeroOs + numeroUs));

		for (int cont = 0; cont < 50; cont++)
			System.out.print("-");

		System.out.println("\n\n\n");

	}

	public static boolean validaEntrada(String texto) {

		if (texto.trim().length() == 0) { // trim() retira os espacos, se retirar os espacos e nao sobrar a nada a frase
											// nao e valida
			System.out.println("A frase digitada contem apenas espacos, tente novamente. ");
			return false;
		}

		else
			return true;

	}

	public static void limpaTela() {
		for (int cont = 0; cont < 50; cont++)
			System.out.println();
	}

}
