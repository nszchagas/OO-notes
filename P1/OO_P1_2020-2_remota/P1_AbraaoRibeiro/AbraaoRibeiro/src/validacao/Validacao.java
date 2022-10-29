package validacao;

import java.util.ArrayList;
import java.util.InputMismatchException;

import dados.GrupoExaminado;
import dados.Pessoa;
import leitura.Leitura;
import saida.Visao;

public class Validacao {

	public static int validaOpcao() {
		int opcao = -1;
		do {
			try {
				System.out.println("Escolhauma opcao");
				System.out.println("[1] Novo cadastro\n[2] Mostrar todos cadastros\n[0] Encerrar");
				opcao = Leitura.lerInt();
			} catch (InputMismatchException e) {
				System.err.println("Erro !! tipo de dado invalidao");
			}
			if (opcao < 0 || opcao > 2) {
				System.err.println("Numero digitado nao corresponde a uma das opcoes");
			}
		} while (opcao < 0 || opcao > 2);
		return opcao;
	}

	public static int validaTipoPessoa() {
		int opcao = -1;
		do {
			try {
				System.out.println("Escolhauma opcao das opcoes para fazer o cadastro");
				System.out.println("[1]Paciente nao contamindo  \n[2]Paciente COntaminado ");
				opcao = Leitura.lerInt();
			} catch (InputMismatchException e) {
				System.err.println("Erro !! tipo de dado invalidao");
			}
			if (opcao < 0 || opcao > 2) {
				System.err.println("Numero digitado nao corresponde a uma das opcoes");
			}
		} while (opcao < 0 || opcao > 2);
		return opcao;
	}

	public static StringBuilder validaNome() {
		StringBuilder nome = new StringBuilder();
		do {
			nome.append(Leitura.lerString());
			if (nome.length() < 3) {
				System.out.println("Seu nome é muito pequeno Tente outra vez");
			}
		} while (nome.length() < 3);
		return nome;
	}

	public static char validaGenero() {
		char genero;
		do {
			System.out.println("Digite o sexo da pessoa M para masculino e F para feminino");
			genero = Leitura.lerChar();
			if (genero != 'M' && genero != 'F')
				System.out.println("voce digitou uma opcao invalida");
		} while (genero != 'M' && genero != 'F');
		return genero;
	}

	public static int validaIdade() {
		int idade = -1;
		do {
			try {
				System.out.println("Digite a idade da pessoa entre 0 e 130 anos");
				idade = Leitura.lerInt();
				if (idade < 0 && idade > 130)
					System.out.println("Numero digitado nao corresponde a uma idade");
			} catch (InputMismatchException e) {
				System.out.println("Tipo d edado invalido tente novamente");
			}
		} while (idade < 0 && idade > 130);
		return idade;
	}

	public static int validaIdentificador(GrupoExaminado grupoExaminado, final int MINIMO) {
		int identificador = 0;
		do {
			try {
				System.out.println("Digite a identificacao da pessoa maior que 1");
				identificador = Leitura.lerInt();
				if (identificador < MINIMO) {
					System.out.println("NUmero de identificacao muito pequeno");
				}
			} catch (InputMismatchException e) {
				System.out.println("Tipo de dado invalido tente novamente");
			}
		} while (identificador < 0 && identificador > 130 && isIgual(grupoExaminado, identificador));
		return identificador;
	}

	private static boolean isIgual(GrupoExaminado grupoExaminado, int identificador) {
		for (Pessoa pessoa : grupoExaminado.getPessoas()) {
			if (pessoa.getIdentificador() == identificador) {
				System.out.println("Identificador igual ao de outra pessoa, digite novamente");
				return true;
			}

		}

		return false;
	}

	public static String validaSituacao() {
		char situacao;
		do {
			situacao = Leitura.lerChar();
			if (situacao != 'E' && situacao != 'F' && situacao != 'C') {
				System.out.println("opcao digitda é invalida");
			}
		} while (situacao != 'E' && situacao != 'F' && situacao != 'C');
		switch (situacao) {
		case 'E': {
			return "Em Tratamento";
		}
		case 'F': {
			return "falecimento";
		}

		}
		return "Curado";
	}
}