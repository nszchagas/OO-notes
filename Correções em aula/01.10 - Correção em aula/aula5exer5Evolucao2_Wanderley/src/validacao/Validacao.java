package validacao;

import java.util.InputMismatchException;

import dados.Turma;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static String validaNome() {

		String nome;

		System.out.println("\n-------------------------------CADASTRO-------------------------------");

		do {
			System.out.print("Digite o nome completo do aluno: ");
			nome = Leitura.leString();

			if (nome.isEmpty() || nome == null) {
				System.out.println("\nNome invalido !! Nao eh aceito deixar esse campo em branco");
			} else if (nome.length() < 5 || !nome.contains(" ")) {
				System.out.println("\nNome invalido !! O nome deve estar completo");
			}

		} while (nome.isEmpty() || nome == null || nome.length() < 5 || !nome.contains(" "));

		return nome;
	}

	public static int validaMatricula(Turma turma) {

		int matricula = 0;
		boolean erro;
		final int MAX = 1000;

		do {
			try {
				erro = false;
				System.out.print("Digite a matricula do aluno: ");
				matricula = Leitura.leInteiro();

				if (matricula <= MAX) {
					System.out.println(
							"\nNumero de matricula invalido, deve ser maior que " + MAX + " !! Digite novamente.");
					erro = true;
				} else {
					int i = 0;
					while (!erro && i < turma.getTurma().size()) {
						if (turma.getTurma().get(i).getMatricula() == matricula) {
							System.out.println(
									"\nMatricula ja existente !! Impossivel cadastrar outro aluno com a mesma matricula.");
							erro = true;
						}
						i++;
					}
				}

			} catch (InputMismatchException e) {
				System.out.println("\nFormato de matricula invalido !! Digite somente os numeros da matricula");
				erro = true;
			}
		} while (erro);

		return matricula;
	}

	public static float validaMedia() {
		float media = -1f;
		boolean erro;

		do {
			try {
				erro = false;
				System.out.print("Digite a media final do aluno: ");
				media = Leitura.leFloat();

				if (media < 0 || media > 10) {
					System.out.println("\nMedia invalida !! O valor deve estar entre 0 e 10 !!");
					erro = true;
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"Formato invalido de media !! Se atente ao numero inserido. Caso escreva numero decimal utilize ',' e nao '.' !!\n");
				erro = true;
			}
		} while (erro);
		Visao.limpaConsole(1);

		return media;

	}

	public static boolean isContinuaCadastro() {
		char continua;
		boolean erro;

		do {
			erro = false;
			System.out.print("Deseja cadastrar mais um aluno? Digite 'S' ou 'N' para escolher: ");
			continua = Leitura.leCaracter();

			if (continua != 'S' && continua != 'N') {
				System.out.println("Opcao invalida !!\n");
				erro = true;
			}
		} while (erro);

		if (continua == 'S') {
			Visao.limpaConsole(20);
			return true;
		}
		return false;
	}

	public static float validaMediaGeral(Turma turma) {
		float soma = 0f;

		for (int i = 0; i < turma.getTurma().size(); i++)
			soma += turma.getTurma().get(i).getMediaAritmetica();

		return soma / turma.getTurma().size();
	}
}
