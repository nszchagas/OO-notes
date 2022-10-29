package validacao;

import java.util.InputMismatchException;

import dados.GrupoDePessoas;
import leitura.Leitura;

public class Validacao {
	final static int MINIMO = 1;

	public static int validaInt(int min, int max, String solicitacao) {
		int numero;

		System.out.print(solicitacao);
		try {
			numero = Leitura.lerInt();
			while (numero < min || numero > max) {
				System.err.println("\nInforme um numero de " + min + " a " + max + ".");
				numero = validaInt(min, max, solicitacao);
			}
		} catch (InputMismatchException e) {
			System.err.println("\nEntrada invalida! Insira apenas um numero inteiro.");
			numero = validaInt(min, max, solicitacao);
		}

		return numero;
	}

	public static StringBuilder validaNome() {
		String nomeLido;

		System.out.print("Informe o nome do funcionario: ");
		do {
			nomeLido = Leitura.lerLinha();
			if (nomeLido.split(" ").length == 1 || nomeLido.length() < 3) {
				System.err.println("Nome invalido, insira no minimo 3 caracteres e insira também o sobrenome.");
			}
		} while (nomeLido.split(" ").length == 1 || nomeLido.length() < 3);

		return new StringBuilder().append(nomeLido);
	}

	public static char validaGenero() {
		char genero;

		System.out.print("Informe o sexo ('M' para masculino ou 'F' para feminino): ");
		genero = Leitura.lerChar();

		while (genero != 'M' && genero != 'F') {
			System.err.print("Sexo invalido, informe apenas 'M' ou 'F': ");
			genero = Leitura.lerChar();
		}

		return genero;
	}

	public static int validaIdentificador(GrupoDePessoas grupo) {
		int identificador;

		System.out.print("Informe o numero identificador: ");
		try {
			identificador = Leitura.lerInt();
			while (identificador < MINIMO || !grupo.verificaDisponibilidadeIdentificador(identificador)) {
				System.out.println("O identificador deve ser um numero maior que 0 e nao pode ser repetido.");
				identificador = validaIdentificador(grupo);
			}
		} catch (Exception e) {
			System.err.println("\nEntrada invalida! Insira apenas um numero inteiro.");
			identificador = validaIdentificador(grupo);
		}

		return identificador;
	}

	public static char validaSituacao() {
		char situacao;

		System.out.println("\nSituacoes de saude:");
		System.out.println("E - Em tratamento\nF - Falecido\nC - Curado");
		System.out.print("Informe a situacao de saude: ");
		situacao = Leitura.lerChar();

		while (situacao != 'E' && situacao != 'F' && situacao != 'C') {
			System.err.print("Situacao invalida, informe apenas 'E' ou 'F' ou 'C': ");
			situacao = Leitura.lerChar();
		}

		return situacao;
	}

}