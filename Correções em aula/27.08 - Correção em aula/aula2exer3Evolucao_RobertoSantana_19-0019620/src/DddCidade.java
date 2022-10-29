import java.util.Scanner;

public class DddCidade {

	public static void main(String[] args) {
		// DECLARACOES
		int ddd=0;

		// INSTRUCOES
		System.out.println("Por favor, insira o DDD de uma capital do Centro-Oeste brasileiro:");
		ddd = validaDdd(ddd);

		limparTela();

		// RESPOSTA AO USUARIO
		switch (ddd) {
		case 61: {
			System.out.println("DDD " + ddd + " correspondente a Brasilia\n\n\n\n");
			break;
		}
		case 62: {
			System.out.println("DDD " + ddd + " correspondente a Goiania\n\n\n\n");
			break;
		}
		case 65: {
			System.out.println("DDD " + ddd + " correspondente a Cuiaba\n\n\n\n");
			break;
		}
		case 67: {
			System.out.println("DDD " + ddd + " correspondente a Campo Grande\n\n\n\n");
			break;
		}
		default:
			System.out.println("DDD " + ddd + " não pertence a uma capital do centro-oeste brasileiro\n\n\n\n");
		}
	}

	// ********************************************FUNCOES******************************************************
	// LIMPAR CONSOLE
	public static void limparTela() {
		for (int i = 0; i < 30; i++)
			System.out.println();
	}

	// FUNCAO QUE VALIDA O DDD
	public static int validaDdd(int ddd) {
		Scanner ler = new Scanner(System.in);
		ddd = ler.nextInt(); //leitura isolada

		final int DDDMAX = 100;
		final int DDDMIN = 10; // parâmetros
		while (ddd <= DDDMIN || ddd >= DDDMAX) {
			System.out.println("DDD " + ddd + " invalido em territorio brasileiro. Informe um valor maior que " + DDDMIN
					+ " e menor que " + DDDMAX + ":");
			ddd = ler.nextInt();
		}

		return ddd;
	}

}
