package servicos;

import java.util.InputMismatchException;

import dados.Contaminado;
import dados.Pessoa;
import dados.Populacao;
import dados.Saudavel;
import leitura.Leitura;
import saida.Saida;
import validacao.Validacao;

public class Servicos {

	public static int getOpcaoMenu(int opcMin, int opcMax) {
		int opcao = -1;
		boolean erro;

		do {
			erro = false;
			try {
				opcao = Leitura.lerInt();
				erro = Validacao.validaOpcaoMenu(opcao, opcMin, opcMax);

			} catch (InputMismatchException ex) {
				System.out.println("Digite um valor numerico.");
				erro = true;
			}
		} while (erro);
		return opcao;
	}

	public static void escolherPessoa(Populacao populacao) {
		Saida.mostraOpcoesPessoa();
		int opcao = getOpcaoMenu(1, 2);
		cadastrarPessoa(populacao, opcao);
	}

	public static void cadastrarPessoa(Populacao populacao, int opcao) {
		switch (opcao) {
		case 1:
			populacao.addPessoa(new Saudavel(getPessoa(populacao), getIdade()));
			break;
		case 2:
			populacao.addPessoa(new Contaminado(getPessoa(populacao), getSituacao()));
		}
	}

	public static Pessoa getPessoa(Populacao populacao) {
		return new Pessoa(getNome(), getGenero(), getIdentificador(populacao));
	}

	public static String getNome() {
		String nome;

		Saida.limpaTela(1);
		System.out.println("Digite o nome completo da pessoa: ");
		do {
			nome = Leitura.lerString().trim();
		} while (Validacao.validaNome(nome));
		return nome;
	}

	public static char getGenero() {
		String genero;

		Saida.limpaTela(1);
		System.out.println("Digite o genero da pessoa (F ou M): ");
		do {
			genero = Leitura.lerString().trim().toUpperCase();
		} while (Validacao.validaGenero(genero));
		return genero.charAt(0);
	}

	public static int getIdentificador(Populacao populacao) {
		int id = -1;
		boolean erro;

		Saida.limpaTela(1);
		System.out.println("Digite o codigo identificador unico da pessoa: ");
		do {
			erro = false;
			try {
				id = Leitura.lerInt();
				erro = Validacao.validaIdentificador(id, populacao);
			} catch (InputMismatchException ex) {
				erro = true;
				System.out.println("Entrada invalida. Digite um numero inteiro.");
			}
		} while (erro);
		return id;
	}

	public static int getIdade() {
		int idade = -1;
		boolean erro;

		Saida.limpaTela(1);
		System.out.println("Digite a idade da pessoa: ");
		do {
			erro = false;
			try {
				idade = Leitura.lerInt();
				erro = Validacao.validaIdade(idade);
			} catch (InputMismatchException ex) {
				erro = true;
				System.out.println("Entrada invalida. Digite um numero inteiro.");
			}
		} while (erro);
		return idade;
	}

	public static char getSituacao() {
		String situacao;

		Saida.limpaTela(1);
		System.out.println("Digite a situacao da pessoa (E - em tratamento, F - falecido, C - curado): ");
		do {
			situacao = Leitura.lerString().trim().toUpperCase();
		} while (Validacao.validaSituacao(situacao));
		return situacao.charAt(0);
	}

}
