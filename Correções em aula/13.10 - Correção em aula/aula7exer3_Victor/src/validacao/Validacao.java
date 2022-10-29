package validacao;

import java.util.InputMismatchException;

import dados.*;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static int validaIdade(String mensagem, int minimo, int maximo) {
		// Declaracoes
		int idade = 0;

		// Instrucoes
		do {
			try {
				System.out.println(mensagem);
				idade = Leitura.leiaInt();
				Visao.limpaTela(2);
				if (idade <= minimo || idade >= maximo)
					System.err.println("Valor invalido! A idade deste animal tem que ser maior que  " + minimo + " e menor que "
							+ maximo);
			} catch (InputMismatchException excecao) {
				System.err.println("Valor incoerente! Tente novamente.");
			}
		} while (idade <= minimo || idade >= maximo);
		return idade;
	}

	public static String validaDescricao(String mensagem) {
		// Declaracoes
		String descricao;

		// Instrucoes
		do {
			System.out.println(mensagem);
				descricao = Leitura.leiaString();
				Visao.limpaTela(2);
				if (descricao.isEmpty()) 
					System.err.println("A descricao nao pode ser vazia! Tente novamente: ");
		} while (descricao.isEmpty());

		return descricao;
	}
	
	public static float validaFloat(String mensagem, float maximo) {
		// Declaracoes
		float valor = -1f;

		// Instrucoes
		do {
			try {
				System.out.println(mensagem);
				valor = Leitura.leiaFloat();
				Visao.limpaTela(2);
				if (valor <= 0f || valor >= maximo)
					System.err.println(
							"Valor invalido! O valor deve ser maior que 0 e menor que " + maximo);
			} catch (InputMismatchException excecao) {
				System.err.println("Valor incoerente! Tente novamente: ");
			}
		} while (valor < 0f || valor >= maximo);
		return valor;
	}
	
	public static char validaPorte(String mensagem) {
		// Declaracoes
		char porte = 0;

		// Instrucoes
		do {
				System.out.println(mensagem);
				porte = Leitura.leiaChar();
				Visao.limpaTela(2);
				if (!("PMG").contains(Character.toString(porte))) {
					System.err.println("O porte so pode ser pequeno('P'), medio('M') ou grande('G')! Tente novamente: ");
				}
		} while (!("PMG").contains(Character.toString(porte)));

		return porte;
	}
	public static char validaMenu(GrupoMamiferos grupoMamiferos) {
		// Declaracoes
		char opcao;

		// Instrucoes
		do {
			Visao.mostraMenu(grupoMamiferos);
			opcao = Leitura.leiaChar();
			Visao.limpaTela(2);
			if (!("0123").contains(Character.toString(opcao)))
				System.err.println("Opcao invalida!");
		} while (!("0123").contains(Character.toString(opcao)));
		return (opcao);
	}
}
