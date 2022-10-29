package saida;

public class Saida {
	public static void solicitarNome() {
		System.out.println("Digite o seu nome inteiro:");
	}

	public static void nomeInvalido() {
		limpaTela(1);
		System.out.println("Nome invalido, digite mais de uma palavra.");
	}

	public static void entradaVaziaInvalida() {
		limpaTela(1);
		System.out.println("Entrada vazia e invalida. Digite o nome completo.");
	}

	public static void verificarContinuacao() {
		limpaTela(2);
		System.out.println("Deseja informar outro nome? Se sim, digite 'S'. Se nao, digite 'N'.");
	}

	public static void digiteApenasUmCaractere() {
		limpaTela(1);
		System.out.println("Entrada invalida. Digite apenas um caractere.");
	}

	public static void digiteUmCaractereValido() {
		limpaTela(1);
		System.out.println("Entrada invalida. Digite apenas 'S' ou 'N'.");
	}

	public static void nomeConcatenado(StringBuilder primeiroNome, StringBuilder ultimoNome) {
		ultimoNome.append("/").append(primeiroNome);
		System.out.println(ultimoNome);
	}

	public static void limpaTela(int linhasPuladas) {
		for (int aux = 0; aux < linhasPuladas; aux++) {
			System.out.println();
		}
	}
}
