package Principal;

//objetivo: scanear uma frase e fazer um programa pra analisar a frase e contar cada vogal, depois mostrar a quantidade de vogais e quantas de cada tem.

import java.util.Scanner;

public class ContaVogal {

	public static void main(String[] args) {
		// Declaracoes
		String frase;
		String end = new String("!");
		int tamanho = 0;
		int[] valores = new int[6];
		Scanner lerFrase = new Scanner(System.in);

		// Instrucoes
		do {
			limpaTela(2);
			System.out.println("Digite sua frase ( Digite '!' para terminar o programa): ");
			frase = lerFrase.nextLine();
			if (frase.compareTo(end) != 0) {

				tamanho = frase.length();

				tamanho = validaEspaco(frase, tamanho, lerFrase);

				valores = contaVogal(frase);
				limpaTela(30);

				System.out.println("Frase: " + frase + "\t\tTamanho da frase: " + tamanho + "\nQuantidade de A: "
						+ valores[0] + "\t\tQuantidade de O: " + valores[3] + "\nQuantidade de E: " + valores[1]
						+ "\t\tQuantidade de U: " + valores[4] + "\nQuantidade de I: " + valores[2]
						+ "\t\tTotal de vogais: " + valores[5]);
			} else {
				System.out.println("Programa terminado, obrigado!");
			}
		} while (frase.compareToIgnoreCase(end) != 0);
		lerFrase.close();
	}

	// limpaTela
	public static void limpaTela(int qtLinhas) {
		for (int pula = 0; pula < qtLinhas; pula++) {
			System.out.print("\n");
		}
	}

	// contar vogais
	public static int[] contaVogal(String frase) {
		// Declaracoes
		int A = 0, E = 0, I = 0, O = 0, U = 0, todas = 0;
		char letra;
		// Instrucoes
		for (int aux = 0; aux < frase.length(); aux++) {
			letra = frase.charAt(aux);
			switch (Character.toLowerCase(letra)) {
			case 'a':
				A += 1;
				todas += 1;
				break;
			case 'e':
				E += 1;
				todas += 1;
				break;
			case 'i':
				I += 1;
				todas += 1;
				break;
			case 'o':
				O += 1;
				todas += 1;
				break;
			case 'u':
				U += 1;
				todas += 1;
				break;
			}

		}
		int valores[] = new int[] { A, E, I, O, U, todas };
		return valores;
	}

	// validaEspaco e tamanho
	public static int validaEspaco(String frase, int tamanho, Scanner lerFrase) {
		int espaco = 0;
		// instrucoes
		do {
			for (int aux = 0; aux < frase.length(); aux++) {
				char analise = frase.charAt(aux);
				if (analise != ' ') {
					espaco += 1;
				}
				if (analise == ' ')
					tamanho = tamanho - 1;
			}
			if (frase.length() == 0 || espaco == 0) {
				System.out.println("Frase tem que conter dados, digite sua frase!");
				frase = lerFrase.nextLine();
			}
		} while (frase.length() == 0 || espaco == 0);
		return tamanho;
	}

}
