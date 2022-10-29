package principal;

import java.util.Locale;
import java.util.Scanner;
import java.text.DecimalFormat;

public class SexoPeso {
	
	//atributos viriam aqui

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		// DECLARACOES
		final int QTDPESSOAS = 20; //variáveis locais
		String sexo;
		float peso;
		float pesoMax = 0f;
		float pesoMin = 1000f;
		float somaPesoMasc = 0f;
		int qtdMasc = 0;

		// INSTRUCOES
		for (int i = 0; i < QTDPESSOAS; i++) {

			System.out.println(
					"Digite o peso da " + (i + 1) + "ª pessoa (Peso deve ser maior do que 0 e menor do que 1000kg): ");
			peso = validaPeso(lerPeso());
			System.out.println("Digite o sexo da " + (i + 1) + "ª pessoa (masculino/feminino):");
			sexo = validaSexo(lerSexo());

			if (peso > pesoMax) {
				pesoMax = peso;

			}
			if (peso < pesoMin) {
				pesoMin = peso;
			}
			if (sexo.equalsIgnoreCase("masculino")) {
				somaPesoMasc += peso;
				qtdMasc++;
			}
		}

		limpaTela(30);
		mostraResultados(pesoMax, pesoMin, somaPesoMasc, QTDPESSOAS, qtdMasc);
		
	}

	public static void limpaTela(int qtd) {
		for (int i = 0; i < qtd; i++) {
			System.out.println();
		}
	}

	public static String lerSexo() {
		Scanner ler = new Scanner(System.in);
		return ler.next();

	}

	public static float lerPeso() {
		Scanner ler = new Scanner(System.in);
		return ler.nextFloat();
	}

	public static String validaSexo(String sexo) {
		while (!sexo.equalsIgnoreCase("masculino") && !sexo.equalsIgnoreCase("feminino")) {
			System.out.println("Sexo invalido! Digite novamente (masculino/feminino): ");
			sexo = lerSexo();
		}
		return sexo;
	}

	public static float validaPeso(float peso) {
		while (peso <= 0f || peso >= 1000f) {
			System.out.println("Peso invalido! Peso deve ser maior do que zero e menor do que 1000kg:");
			peso = lerPeso();
		}
		return peso;
	}

	public static void mostraResultados(float pesoMax, float pesoMin, float somaPesoMasc, int qtdPessoas, int qtdMasc) {
		DecimalFormat formata = new DecimalFormat("0.00");
		
		
		if(somaPesoMasc == 0) {
			System.out.println("A media dos pesos dos homens e 0 ");
		}else {
			System.out.println("A media dos pesos dos homens e: " + formata.format(somaPesoMasc / (qtdMasc)));
		}

		System.out.println("Maior peso: " + formata.format(pesoMax) + " kg");
		System.out.println("Menor peso: " + formata.format(pesoMin) + " kg");
		System.out.println("A quantidade de mulheres e: " + (qtdPessoas - qtdMasc));
	}

}
