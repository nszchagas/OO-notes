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

public class SexoPeso {

	public static void main(String[] args) {

		// DECLARACOES
		final int QTDPESSOAS = 5;
		String sexo;
		float mediaPesosHomens = 0f;
		float[] peso = new float[QTDPESSOAS];
		int qtdFem = 0;

		// INSTRUCOES
		for (int i = 0; i < QTDPESSOAS; i++) {

			sexo = leValidaSexo(i);
			peso[i] = leValidaPeso(i);

			if (sexo.equalsIgnoreCase("feminino"))
				qtdFem += 1;
			else
				mediaPesosHomens += peso[i];

			limpaTela();

		}

		// PESO MAX E MIN
		Arrays.sort(peso); // organiza o array, o menor peso vai para a posicao 0 e o maior para a posicao
							// QTDPESSOAS-1

		if (QTDPESSOAS != qtdFem) // evita a divisao por zero
			mediaPesosHomens /= (QTDPESSOAS - qtdFem);

		// IMPRESSAO

		apresentaDados(peso[QTDPESSOAS - 1], peso[0], mediaPesosHomens, qtdFem);

	}

	public static String leValidaSexo(int numeroDaPessoa) {
		String sexo;
		Scanner ler = new Scanner(System.in);

		do {
			System.out.println("Digite o sexo da " + (numeroDaPessoa + 1) + "ª pessoa (masculino/feminino):");
			sexo = ler.next();
			if (!(sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("feminino"))) {
				System.out.println("O sexo digitado nao e valido, insira novamente apos a proxima mensagem.\n");
			}

		} while (!(sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("feminino")));

		return sexo;
	}

	public static float leValidaPeso(int numeroDaPessoa) {
		float peso;
		Scanner ler = new Scanner(System.in);

		do {
			System.out.println("Digite o peso da " + (numeroDaPessoa + 1) + "ª pessoa (em kg):");
			peso = ler.nextFloat();
			if (peso <= 0 || peso >= 500) {
				System.out.println("O peso digitado nao e valido, insira novamente apos a proxima mensagem.\n");
			}

		} while (peso <= 0 || peso >= 500);

		return peso;
	}

	public static void apresentaDados(float pesoMax, float pesoMin, float mediaPesosMasc, int qtdFem) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		System.out.println("O maior peso informado foi: " + mascara.format(pesoMax) + " quilogramas (kg).");
		System.out.println("\nO menor peso informado foi: " + mascara.format(pesoMin) + " quilogramas (kg).");
		System.out
				.println("\nA media dos pesos dos homens e: " + mascara.format(mediaPesosMasc) + " quilogramas (kg).");
		System.out.println("\nA quantidade de mulheres e: " + qtdFem);
	}

	public static void limpaTela() {
		for (int aux = 0; aux < 50; aux++)
			System.out.println();
	}

}
