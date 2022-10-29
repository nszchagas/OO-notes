package leitura;

import java.util.InputMismatchException;
import java.util.Scanner;

import dados.ListaDePessoas;
import servicos.Validacao;

public class Leitura {

	public static String lerString() {
		return new Scanner(System.in).nextLine().trim();
	}

	public static int lerInt() {
		return new Scanner(System.in).nextInt();
	}

	public static StringBuilder lerNome() {
		String nome;

		do {
			System.out.println("Informe o nome");
			nome = lerString();
		} while (Validacao.validaNome(nome));

		return new StringBuilder().append(nome);
	}

	public static int lerOpcao() {
		String opcao = lerString();

		if (Validacao.validaOpcao(opcao))
			return lerOpcao();
		else
			return Integer.parseInt(opcao);

	}

	public static int lerTipoCadastro() {
		int tipo = 0;
		boolean erro = false;

		do {
			try {
				tipo = lerInt();
				erro = Validacao.validaTipo(tipo);
			} catch (InputMismatchException e) {
				System.err.println("Erro! Digite somente valores numericos!");
				erro = true;
			}
		} while (erro);

		return tipo;
	}

	public static char lerGenero() {
		String genero;

		do {
			System.out.println("Informe o genero (M para masculino e F para feminino)");
			genero = lerString().toUpperCase();
		} while (Validacao.validaGenero(genero));

		return genero.charAt(0);
	}

	public static int lerId(ListaDePessoas lista) {
		int id = 0;
		boolean erro = false;

		do {
			try {
				System.out.println("Informe o identificador");
				id = lerInt();
				erro = Validacao.validaId(id, lista);
			} catch (InputMismatchException e) {
				System.err.println("Erro! Digite somente valores numericos!");
				erro = true;
			}
		} while (erro);

		return id;
	}

	public static int lerIdade() {
		int idade = -1;
		boolean erro = false;

		do {
			try {
				System.out.println("Informe a idade");
				idade = lerInt();
				erro = Validacao.validaIdade(idade);
			} catch (InputMismatchException e) {
				System.err.println("Erro! Digite somente valores numericos!");
				erro = true;
			}
		} while (erro);

		return idade;
	}
	
	public static char lerSituacao() {
		String situacao;
		
		do {
			System.out.println("Informe sua situacao de saude:");
			System.out.println("[E] em tratamento\n[F] falecido\n[C] curado");
			situacao = lerString().toUpperCase();
		} while (Validacao.validaSituacao(situacao));
		
		return situacao.charAt(0);
	}
}
