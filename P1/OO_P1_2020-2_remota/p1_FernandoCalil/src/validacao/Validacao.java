package validacao;

import java.util.InputMismatchException;
import dados.*;
import entrada.Leitura;
import saida.Visao;

public class Validacao {

	public static int isOpcao() {
		int opcao = -1;

		Visao.pulaLinhas(3);
		while (opcao < 0 || opcao > 2) {
			Visao.mostraOpcoes();
			try {
				opcao = Leitura.leInt();
				if (opcao < 0 || opcao > 2)
					Visao.apresentaMensagem("Opcao [" + opcao + "] nao e uma opcao valida.");
			} catch (InputMismatchException e) {
				Visao.apresentaMensagem("Opcao invalida. A opcao deve ser um numero");
				Visao.pulaLinhas(2);
			}
		}
		return opcao;
	}

	public static StringBuilder isNome() {
		StringBuilder nome = new StringBuilder();

		Visao.limpaTela();
		while (nome.length() < 3) {
			Visao.apresentaMensagem("Digite o nome da pessoa a ser cadastrada: ");
			nome.replace(0, nome.length(), Leitura.leString());
			if (nome.length() < 3) {
				Visao.pulaLinhas(2);
				Visao.apresentaMensagem("O nome [" + nome + "] nao e valido. O nome deve ser maior que 3 caracteres");
			}
		}

		return nome;
	}

	public static boolean isContaminado() {
		char estado = '0';

		Visao.limpaTela();
		do {
			try {
				Visao.apresentaMensagem(
						"A pessoa que vai ser cadastrada esta contaminada?\n\tDigite [S] para sim\n\tDigite [N] para nao");
				estado = Leitura.leChar();
				if (estado != 'S' && estado != 'N')
					Visao.apresentaMensagem("Escolha [" + estado + "] invalida.");
			} catch (InputMismatchException e) {
				Visao.apresentaMensagem("Resposta [" + estado + "] invalida.");
				Visao.pulaLinhas(2);
			}
		} while (estado != 'S' && estado != 'N');

		return (estado == 'N');
	}

	public static boolean isRepetido(Cadastro cadastrados, int codigo) {

		for (Pessoa pessoa : cadastrados.getCadastros())
			if (codigo == pessoa.getIdentificacao()) {
				Visao.apresentaMensagem("Codigo ja esta cadastrado.");
				return true;
			}

		return false;
	}

	public static int isIdentificacao(Cadastro cadastrados) {
		final int MINIMO = 1;
		int identificacao = 0;

		Visao.limpaTela();
		do {
			try {
				Visao.apresentaMensagem("Digite o numero de identificacao da pessoa cadastrada: ");
				identificacao = Leitura.leInt();
				if (identificacao < MINIMO) {
					Visao.apresentaMensagem(
							"Escolha invalida. A identificacao deve ser um numero maior que " + (MINIMO - 1) + ".");
					identificacao = 0;
				}
			} catch (InputMismatchException e) {
				Visao.apresentaMensagem(
						"Resposta invalida. A identificacao deve ser um numero maior que " + (MINIMO - 1) + ".");
				Visao.pulaLinhas(2);
			}
		} while (identificacao < MINIMO || isRepetido(cadastrados, identificacao));

		return identificacao;
	}

	public static char isSituacao() {
		char situacao = '0';

		Visao.limpaTela();
		do {
			try {
				Visao.apresentaMensagem(
						"Digite a situacao de contaminacao da pessoa:\n\tDigite [F] para falecido.\n\tDigite [E] para em tratamento.\n\tDigite [C] para curado");
				situacao = Leitura.leChar();
				if (situacao != 'F' && situacao != 'E' && situacao != 'C')
					Visao.apresentaMensagem("A situacao [" + situacao + "] nao e uma situacao valida.");
			} catch (InputMismatchException e) {
				Visao.apresentaMensagem("A situacao [" + situacao + "] nao e uma situacao valida.");
				Visao.pulaLinhas(2);
			}
		} while (situacao != 'F' && situacao != 'E' && situacao != 'C');

		return situacao;
	}

	public static int isIdade() {
		final int IDADEMINIMA = 0;
		final int IDADEMAXIMA = 130;
		int idade = -1;

		Visao.limpaTela();
		do {
			try {
				Visao.apresentaMensagem("Digite a idade da pessoa cadastrada: ");
				idade = Leitura.leInt();
				if (idade < IDADEMINIMA || idade > IDADEMAXIMA) {
					Visao.apresentaMensagem("Idade invalida.\nA idade deve ser um numero maior ou igual a "
							+ IDADEMINIMA + " e menor ou igual a " + IDADEMAXIMA);
					idade = -1;
				}
			} catch (InputMismatchException e) {
				Visao.apresentaMensagem("Idade invalida.\nA idade deve ser um numero maior ou igual a " + IDADEMINIMA
						+ " e menor ou igual a " + IDADEMAXIMA);
				Visao.pulaLinhas(2);
			}
		} while (idade < IDADEMINIMA || idade > IDADEMAXIMA);

		return idade;
	}

	public static char isGenero() {
		char genero = '0';

		Visao.limpaTela();
		do {
			try {
				Visao.apresentaMensagem(
						"Digite o genero da pessoa cadastrada:\n\tDigite [F] para feminino.\n\tDigite [M] para Masculino.");
				genero = Leitura.leChar();
				if (genero != 'F' && genero != 'M')
					Visao.apresentaMensagem("Genero [" + genero + "] nao e um genero valido.");
			} catch (InputMismatchException e) {
				Visao.apresentaMensagem("Genero [" + genero + "] nao e um genero valido.");
				Visao.pulaLinhas(2);
			}
		} while (genero != 'F' && genero != 'M');

		return genero;
	}

}
