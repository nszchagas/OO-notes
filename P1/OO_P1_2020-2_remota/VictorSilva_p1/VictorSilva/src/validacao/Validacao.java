package validacao;

import java.util.InputMismatchException;

import dados.*;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static int validaInt(String msg, int min, int max) {
		int inteiro = min - 1;

		do {
			try {
				System.out.println(msg);
				inteiro = Leitura.lerInt();
				Visao.limpaTela(2);
				if (inteiro < min || inteiro > max) {
					System.err.println("O valor deve ser entre " + min + " e " + max);
				}
			} catch (InputMismatchException excecao) {
				System.err.println("Valor incoerente!Deve ser inteiro");
			}
		} while (inteiro < min || inteiro > max);
		return inteiro;
	}

	public static int validaIdentificador(GrupoPessoas grupoPessoas) {
		int identificador;
		final int MAIOR = 101;

		do {
			identificador = validaInt("Digite o identificador dessa pessoa:", MAIOR, 2147483647);
			if (verificaRepete(grupoPessoas, identificador))
				System.err.println("O identificador deve ser unico");
		} while (verificaRepete(grupoPessoas, identificador));

		return identificador;
	}

	public static String validaNome() {
		String nome;

		do {
			System.out.println("Digite o nome da pessoa:");
			nome = Leitura.lerString();
			Visao.limpaTela(2);
			if (nome.length() <= 2)
				System.err.println("O nome tem que possuir mais que 2 caracteres!");
		} while (nome.length() <= 2);

		return nome;
	}

	public static char validaChar(String msg, String opcoes) {
		char caracter;

		do {
			System.out.println(msg);
			caracter = Leitura.lerChar();
			Visao.limpaTela(2);
			if (!(opcoes).contains(Character.toString(caracter)))
				System.err.println("Opcao invalida!");
		} while (!(opcoes).contains(Character.toString(caracter)));
		return (caracter);

	}

	public static boolean verificaRepete(GrupoPessoas grupoPessoas, int identificador) {
		if (grupoPessoas.getGrupoPessoas().size() > 0) {
			for (Pessoa pessoa : grupoPessoas.getGrupoPessoas()) {
				if (identificador == pessoa.getIdentificador())
					return true;
			}
		}
		return false;
	}
}
