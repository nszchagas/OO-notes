package principal;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Síntese:
 * Objetivo: receber o sexo (masculino ou feminino) e peso de 20 pessoas, mostrar o maior e o menor peso recebidos, 
 * 						a média dos pesos dos homens e o número de mulheres que participaram.
 * Entrada: Peso e sexo de vinte pessoas;
 * Saíde: Maior peso, menor peso, média dos pesos masculinos e número de mulheres
 * 
 */

public class PesosMasculinoFeminino {

	public static void main(String[] args) {

		// declaracoes

		final int MAX = 20;
		float[] pesos = new float[MAX];
		float mediaHomens = 0;
		int mulheres = 0;
		Scanner scan = new Scanner(System.in);
		String sexo[] = new String[MAX];
		DecimalFormat mascara = new DecimalFormat("#0.00");

		// instrucoes

		for (int contador = 0; contador < MAX; contador++) {

			do {
				System.out.println("Insira abaixo o peso da " + (contador + 1) + "ª pessoa cadastrada");
				pesos[contador] = scan.nextFloat();

			} while (validaPeso(pesos[contador]) == false); // nao aceita pesos menores ou iguais a zero

			do {
				System.out.println("Insira o sexo da " + (contador + 1)
						+ "ª pessoa cadastrada (feminino ou masculino) com todas as letras minusculas:");
				sexo[contador] = scan.next();
			} while (validaSexo(sexo[contador]) == false); // nao aceita sexo diferente de masculino ou feminino em
															// minusculas

			if (sexo[contador].equals("feminino") == true)

				mulheres += 1; // conta mais uma mulher

			else
				mediaHomens += pesos[contador]; // adiciona mais um peso no peso dos homens
			limpaTela(); // limpa tela antes de pedir outro valor
		}

		Arrays.sort(pesos); // ordena o vetor, maior peso esta na ultima coordenada (MAX-1) e o menor na
							// primeira (0)
		mediaHomens /= (MAX - mulheres); // soma / nº de homens (= total - mulheres)

		for (int aux = 0; aux < 70; aux++)
			System.out.print("-"); // imprime uma linha na tela, para deixar mais organizado

		System.out.println("\nMedia de peso dos homens cadastrados: " + mascara.format(mediaHomens)
				+ "\nQuantidade de mulheres cadastradas: " + mulheres + "\nMaior peso cadastrado: "
				+ mascara.format(pesos[MAX - 1]) + "\nMenor peso cadastrado: " + mascara.format(pesos[0]));

		for (int aux = 0; aux < 70; aux++)
			System.out.print("-"); // imprime uma linha na tela, para deixar mais organizado
	}

	public static boolean validaSexo(String sexo) {

		if ((sexo.equals("masculino") || sexo.equals("feminino")) == true)
			return true;
		else {
			System.out.println("Insira um sexo valido (feminino ou masculino) em letras minusculas:");
			return false;
		}

	}

	public static boolean validaPeso(float peso) {
		if (peso > 0) {

			return true;

		} else
			System.out.println("Insira um peso valido (maior do que zero)");
		return false;
	}

	public static void limpaTela() {
		for (int i = 0; i < 50; i++)
			System.out.println();
	}
}
