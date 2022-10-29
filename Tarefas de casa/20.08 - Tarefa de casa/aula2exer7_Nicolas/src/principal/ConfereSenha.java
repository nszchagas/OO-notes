package principal;

import java.util.Scanner;
import java.util.Timer;

/*
 * Síntese: 
 * Objetivo: cadastrar senha de 3 a 5 digitos. Em seguida, outro usuário 
 * ira tentar validar a senha, com 9 chances. Caso nenhuma senha esteja certa, o programa encerra em 10 segundos
 * Entrada: senha cadastrada
 */
public class ConfereSenha {
	public static void main(String[] args) {
		// declaracoes

		final int TENTATIVASMAX = 9, TEMPO = 10;
		String senhaCadastrada, tentativaSenha = " ";
		Scanner scan = new Scanner(System.in).useDelimiter("\n"); // para escanear os espacos tambem

		// instrucoes
		
		do {
			System.out.println(
					"Cadastre uma senha: \n>Sua senha deve conter entre 3 e 5 caracteres e nao pode conter espacos.");

			senhaCadastrada = scan.nextLine();
			limpaTela();
		} while (validaSenha(senhaCadastrada) == false); // criacao da senha

		for (int tentativa = 0; tentativa < TENTATIVASMAX; tentativa++) {
			System.out.println(
					"Tentativa nº: " + (tentativa + 1) + " de " + TENTATIVASMAX + "\nInsira a senha cadastrada:");
			tentativaSenha = scan.nextLine();
			limpaTela();

			if (testaSenha(tentativaSenha, senhaCadastrada) == true)
				break;

			if (tentativa < (TENTATIVASMAX - 1))
				System.out.println("Tente novamente.");
			// se tentativa for errada imprimir tente novamente
			else if (tentativa == (TENTATIVASMAX - 1)) {
				System.out
						.println("Tentativas esgotadas. O computador irá se auto destruir em " + TEMPO + " segundos.");
				imprimeTemporizador(TEMPO);

			}

		}

	}

	public static boolean validaSenha(String senha) {
		if (senha.contains(" ") == true || senha.length() < 3 || senha.length() > 5) {
			System.out.println("A senha digitada nao esta de acordo com o exigido. Digite novamente:");
			return false;
		} else
			return true;
	}

	public static boolean testaSenha(String tentativa, String senhaCadastrada) {

		if (tentativa.equals(senhaCadastrada) == true) {
			System.out.println("Parabens, senha correta!");
			return true;
		} else {
			System.out.println("Senha invalida!");
			return false;
		}
	}

	public static void esperaSegundos(int tempo) {

		try {
			Thread.sleep(tempo * 1000); // pausa o programa por 1000*tempo milisegundos, ja que o tempo está em segundos
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt(); // try e catch lidam com os erros que podem acontecer
		}

	}

	public static void imprimeTemporizador(int tempo) {
		for (int contador = tempo; contador > 0; contador--) {
			System.out.println(contador);
			esperaSegundos(1); // a cada segundo imprime o tempo na tela, conta de tempo até 0.
		}
	}

	public static void limpaTela() {
		for (int cont = 0; cont < 50; cont++)
			System.out.println();
	}

}
