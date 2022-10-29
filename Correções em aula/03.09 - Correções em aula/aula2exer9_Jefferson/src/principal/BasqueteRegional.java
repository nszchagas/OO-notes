package principal;

import java.util.Scanner;
import java.text.DecimalFormat;

public class BasqueteRegional {

	public static void main(String[] args) {
		// DECLARACOES
		Scanner ler = new Scanner(System.in);

		final int QUANTIDADE_DE_EQUIPES = 5, QUANTIDADE_DE_JOGADORES = 10, IDADEMAIOR = 15;
		final float ALTURAMENOR = 1.50F;
		int idade_Jogadores[][] = new int[QUANTIDADE_DE_EQUIPES][QUANTIDADE_DE_JOGADORES], JogadoresMaiorIdade,
				totalJogadoresMaiorIdade = 0;
		float altura_Jogadores[][] = new float[QUANTIDADE_DE_EQUIPES][QUANTIDADE_DE_JOGADORES],
				somaIdadeJogadoresMaior[] = new float[QUANTIDADE_DE_EQUIPES],
				mediaIdadeJogadoresMaior[] = new float[QUANTIDADE_DE_EQUIPES], quantidadeJogadoresComAlturaMenor = 0F,
				porcentagemMenorAltura;

		// INSTRUCOES
		for (int aux_Equipe = 0; aux_Equipe < QUANTIDADE_DE_EQUIPES; aux_Equipe++) {

			// ZERAR O NUMERO DE JOGADORES COM IDADE MAIOR QUE A SOLICITADA PARA CADA EQUIPE
			JogadoresMaiorIdade = 0;
			for (int aux_Jogadores = 0; aux_Jogadores < QUANTIDADE_DE_JOGADORES; aux_Jogadores++) {
				System.out.println("\t\t-- REGISTRO DE JOGADOR --");

				// ------------------ LEITURA DA IDADE DOS JOGADORES -----------------
				System.out.println("Informe a idade (em anos) do " + (aux_Jogadores + 1) + "º jogador da "
						+ (aux_Equipe + 1) + "ª equipe:");
				idade_Jogadores[aux_Equipe][aux_Jogadores] = ler.nextInt();

				// CASO A IDADE INFORMADA NAO SEJA VALIDA, PEDIR NOVAMENTE.
				while (!validacaoIdade(idade_Jogadores[aux_Equipe][aux_Jogadores])) {
					System.out.println(
							"Idade invalida, por favor informe uma idade (em anos) que condiz com a realidade:");
					idade_Jogadores[aux_Equipe][aux_Jogadores] = ler.nextInt();
				}

				// ------------------ LEITURA DA ALTURA DOS JOGADORES -----------------
				System.out.println("Informe a altura (em metros) do " + (aux_Jogadores + 1) + "º jogador da "
						+ (aux_Equipe + 1) + "ª equipe:");
				altura_Jogadores[aux_Equipe][aux_Jogadores] = ler.nextFloat();

				// CASO A ALTURA INFORMADA NAO SEJA VALIDA, PEDIR NOVAMENTE.
				while (!validacaoAltura(altura_Jogadores[aux_Equipe][aux_Jogadores])) {
					System.out.println(
							"Altura invalida, por favor informe uma altura (em metros) que condiz com a realidade:");
					altura_Jogadores[aux_Equipe][aux_Jogadores] = ler.nextFloat();
				}

				// ---------- IDADE MAIOR DO QUE A SOLICITADA (PARA CADA EQUIPE) ------------

				// SOMAR A IDADE DOS JOGADORES QUE TIVEREM IDADE MAIOR DO QUE A SOLICITADA
				if (validarJogadoresMaior(idade_Jogadores[aux_Equipe][aux_Jogadores], IDADEMAIOR)) {
					JogadoresMaiorIdade++;
					somaIdadeJogadoresMaior[aux_Equipe] += idade_Jogadores[aux_Equipe][aux_Jogadores];
				}

				// ATRIBUIR A MEDIA DE IDADE DOS JOGADORES COM IDADE MAIOR DO QUE A SOLICITADA
				mediaIdadeJogadoresMaior[aux_Equipe] = calculoMediaIdadeMaiorEquipe(somaIdadeJogadoresMaior[aux_Equipe],
						JogadoresMaiorIdade);

				// ------ ALTURA MENOR DO QUE A SOLICITADA (ENTRE TODAS AS EQUIPES) ---------
				if (validarAlturaMenor(ALTURAMENOR, altura_Jogadores[aux_Equipe][aux_Jogadores])) {
					quantidadeJogadoresComAlturaMenor++;
				}

				limpaTela(3);
			}

			// SOMAR OS JOGADORES DE TODAS AS EQUIPES COM IDADE MAIOR QUE A SOLICITADA
			totalJogadoresMaiorIdade += JogadoresMaiorIdade;
		}

		// ATRIBUIR A PORCENTAGEM DE JOGADORES COM IDADE MENOR DO QUE A SOLICITADA ENTRE
		// TODAS AS EQUIPES
		porcentagemMenorAltura = porcentagemAlturaMenorTodasEquipes(quantidadeJogadoresComAlturaMenor,
				QUANTIDADE_DE_EQUIPES, QUANTIDADE_DE_JOGADORES);

		// LIMPAR O CONSOLE
		limpaTela(40);

		// ------------------- EXIBIR AS INFORMACOES SOLICITADAS -----------------------
		// EXIBIR A QUANTIDADE TOTAL DE JOGADORES COM IDADE MAIOR DO QUE A SOLICITADA
		exibitTotalJogadoresMaiorIdade(totalJogadoresMaiorIdade, IDADEMAIOR);

		limpaTela(1);
		// EXIBIR MEDIA DE CADA EQUIPE
		for (int aux_Equipes = 0; aux_Equipes < QUANTIDADE_DE_EQUIPES; aux_Equipes++) {
			exibirMediaEquipe(aux_Equipes, mediaIdadeJogadoresMaior[aux_Equipes], IDADEMAIOR);
		}

		limpaTela(1);
		// EXIBIR A PORCENTAGEM DE JOGADORES COM IDADE MENOR DO QUE A SOLICITADA
		exibirPorcentagemMenorAltura(ALTURAMENOR, porcentagemMenorAltura);

	}

	// ----------------------------------- METODOS -------------------------------

	// ----------------------------------- IDADE --------------------------------
	// VALIDAR IDADE INFORMADA
	static boolean validacaoIdade(int idade_Jogadores) {
		// DECLARACOES
		int IDADE_MINIMA = 0, IDADE_MAXIMA = 130;

		// INSTRUCOES
		if (idade_Jogadores <= IDADE_MINIMA || idade_Jogadores >= IDADE_MAXIMA) {
			return false;
		} else {
			return true;
		}
	}

	// VALIDAR SE JOGADOR POSSUI IDADE MAIOR DO QUE A SOLICITADA
	static boolean validarJogadoresMaior(int idade_Jogadores, final int IDADEMAIOR) {
		// INSTRUCOES
		if (idade_Jogadores <= IDADEMAIOR) {
			return false;
		} else {
			return true;
		}
	}

	// CALCULAR A MEDIA DA IDADE DOS JOGADORES COM IDADE MAIOR DO QUE A SOLICITADA
	static float calculoMediaIdadeMaiorEquipe(float somaDasIdades, int quantidadeDeJogadoresMaiorIdade) {
		// INSTRUCOES
		// EVITAR DIVISAO POR 0
		if (quantidadeDeJogadoresMaiorIdade == 0) {
			quantidadeDeJogadoresMaiorIdade = 1;
		}

		return (somaDasIdades / quantidadeDeJogadoresMaiorIdade);
	}

	// EXIBIR A QUANTIDADE DE JOGADORES COM IDADE MAIOR DO QUE A SOLICITADA
	static void exibitTotalJogadoresMaiorIdade(int totalJogadoresMaiorIdade, int IDADEMAIOR) {
		System.out.println("A quantidade de jogadores com idade maior que " + IDADEMAIOR + " anos é: "
				+ totalJogadoresMaiorIdade + ".");
	}

	// EXIBICAO DA MEDIA DE IDADE POR EQUIPE
	static void exibirMediaEquipe(int equipe, float mediaIdadeJogadoresMaior, final int IDADEMAIOR) {
		// DECLARACOES
		DecimalFormat mascara = new DecimalFormat("#0.00");

		// INSTRUCOES
		System.out.println("A media da idade dos jogadores da " + (equipe + 1) + "ª equipe com idade maior que "
				+ IDADEMAIOR + " anos é: " + mascara.format(mediaIdadeJogadoresMaior) + ".");
	}

	// ----------------------------- ALTURA -----------------------
	// VALIDAR ALTURA INFORMADA
	static boolean validacaoAltura(float altura_Jogadores) {
		float ALTURA_MINIMA = 0F, ALTURA_MAXIMA = 3.0F;

		// INSTRUCOES
		if (altura_Jogadores <= ALTURA_MINIMA || altura_Jogadores >= ALTURA_MAXIMA) {
			return false;
		} else {
			return true;
		}
	}

	// VALIDAR SE JOGADOR POSSUI ALTURA MENOR DO QUE A SOLICITADA
	static boolean validarAlturaMenor(final float ALTURAMENOR, float altura_Jogador) {
		if (altura_Jogador >= ALTURAMENOR) {
			return false;
		} else {
			return true;
		}
	}

	// CALCULO DA PORCENTAGEM DE JOGADORES COM ALTURA MENOR ENTRE TODAS AS EQUIPES
	static float porcentagemAlturaMenorTodasEquipes(float totalJogadoresMenorAltura, final int TOTALEQUIPES,
			final int TOTALJOGADORES) {
		return ((totalJogadoresMenorAltura * 100) / (TOTALEQUIPES * TOTALJOGADORES));
	}

	// EXIBIR A PORCENTAGEM DE JOGADORES COM ALTURA MENOR QUE A SOLICITADA
	static void exibirPorcentagemMenorAltura(final float ALTURAMENOR, float PorcentagemMenorAltura) {
		DecimalFormat mascara = new DecimalFormat("#0.00");
		System.out.println("A porcentagem de jogadores com altura menor que " + mascara.format(ALTURAMENOR)
				+ " metros é de: " + mascara.format(PorcentagemMenorAltura) + "%.");
	}

	// LIMPAR A TELA
	static void limpaTela(int linhasPuladas) {
		for (int aux = 0; aux < linhasPuladas; aux++) {
			System.out.println();
		}
	}
}
