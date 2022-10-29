package validacao;

import java.util.ArrayList;
import java.util.InputMismatchException;

import dados.Pessoa;
import entrada.Leitura;
import saida.Visao;

public class Validacao {
	public static StringBuilder validaNome() {
		String nome = null;
		StringBuilder nomeMutavel = new StringBuilder();
		do {
			System.out.println("Digite o nome da pessoa:");
			nome = Leitura.lerString();

			if (nome.trim().length() <= 2) {
				System.out.println("Digite um nome que tenha mais de 2 caracteres ");
			}

		} while (nome.trim().length() <= 2);
		nomeMutavel.append(nome);
		return nomeMutavel;
	}

	public static String validaSituacao() {
		char situacao = 0;
		String situacaoString = null;
		boolean erro = false;
		do {
			erro = false;
			System.out.println(
					"Digite a situacao da pessoa:digite T para contaminada em tratamento, F para contaminada falecida, C para contaminada Curada e S para sem contaminacao");
			situacao = Leitura.lerChar();

			if (situacao != 'T' && situacao != 'F' && situacao != 'C' && situacao != 'S') {
				System.out.println(
						"Situacao invalida , digite T para contaminada em tratamento, F para contaminada falecida, C para contaminada Curada e S para sem contaminacao ");
				erro = true;
			}

		} while (erro);
		if (situacao == 'T') {
			situacaoString = "CONTAMINADA EM TRATAMENTO";
		}
		if (situacao == 'F') {
			situacaoString = "CONTAMINADA FALECIDA";
		}
		if (situacao == 'C') {
			situacaoString = "CONTAMINADA CURADA";
		}
		if (situacao == 'S') {
			situacaoString = "SEM CONTAMINACAO";
		}
		return situacaoString;
	}

	public static Integer validaIdPessoa(ArrayList<Pessoa> populacao) {
		int idPessoa = 0;
		final int MAIOR = 100;
		boolean erro = false;
		do {
			try {
				erro = false;
				System.out.println("Insira o Id de pessoa");
				idPessoa = Leitura.lerInt();
				if (idPessoa <= MAIOR) {
					erro = true;
					System.out.println("Digite um valor maior que 100");
				}
				for (Pessoa pessoa : populacao) {
					if (pessoa.getIdPessoa() == idPessoa) {
						System.out.println("Id ja cadastrado");
						erro = true;
					}
				}
			}

			catch (InputMismatchException e) {
				System.out.println("Entrada invalida");
				erro = true;
			}
		} while (erro);
		return idPessoa;
	}

	public static Integer validaIdadeHomem() {
		int idade = 0;
		boolean erro = false;
		do {
			try {
				erro = false;
				System.out.println("Insira a idade da pessoa");
				idade = Leitura.lerInt();
				if (idade < 0 || idade > 150) {
					erro = true;
					System.out.println("Digite um valor maior que 100");
				}
			}

			catch (InputMismatchException e) {
				System.out.println("Entrada invalida");
				erro = true;
			}
		} while (erro);
		return idade;
	}

	public static String validaGravidez() {
		char gravidez = 0;
		String gravidezExtenso = null;
		boolean erro = false;
		do {
			erro = false;
			System.out.println("Digite se a pessoa ja foi gestante: s para sim n para nao e t para nao tem certeza");
			gravidez = Leitura.lerChar();

			if (gravidez != 'T' && gravidez != 'N' && gravidez != 'S') {
				System.out.println("Situacao invalida , digite s para sim n para nao e t para nao tem certeza ");
				erro = true;
			}

		} while (erro);
		if (gravidez == 'T') {
			gravidezExtenso = "NAO TEM CERTEZA";
		}
		if (gravidez == 'N') {
			gravidezExtenso = "NAO";
		}
		if (gravidez == 'S') {
			gravidezExtenso = "SIM";
		}
		return gravidezExtenso;
	}

	public static Integer validaTipoCadastro() {
		int opcao;

		do {
			Visao.exibirTipoCadastro();

			try {
				opcao = Leitura.lerInt();
				if (opcao < 1 || opcao > 2) {
					System.err.println("Valor Invalido! Insira um numero de 1 a 2");
					opcao = validaTipoCadastro();

				}
			} catch (InputMismatchException e) {
				System.err.println("Valor Invalido! Insira apenas um numero");
				opcao = validaTipoCadastro();
			}
		} while (opcao < 0 || opcao > 2);

		return opcao;
	}

	public static Integer validaMenu() {
		int opcao;

		do {
			Visao.exibirMenu();

			try {
				opcao = Leitura.lerInt();
				if (opcao < 0 || opcao > 2) {
					System.err.println("Valor Invalido! Insira um numero de 0 a 2");
					opcao = validaMenu();

				}
			} catch (InputMismatchException e) {
				System.err.println("Valor Invalido! Insira apenas um numero");
				opcao = validaMenu();
			}
		} while (opcao < 0 || opcao > 2);
		return opcao;
	}
}
