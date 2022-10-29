package validacao;

import java.util.InputMismatchException;
import java.util.Vector;

import dados.Pessoa;
import leitura.Ler;
import saida.Saida;

public class Valida {
	public static int validaOpcao() {
		int opcao;
		do {
			Saida.mostraMensagem("Informe a opcao desejada.\n[1] Cadastrar nova pessoa\n[2] Apresentar relatorio\n[0] Sair");
			try {
				opcao = Ler.lerInt();
			} catch (InputMismatchException e) {
				Saida.mostraErro("Opcao invalida.\nOpcao deve ser um numero inteiro");
				opcao = validaOpcao();
			}
		} while (!isOpcaoValida(opcao, 0, 3));
		return opcao;
	}

	private static boolean isOpcaoValida(int opcao, final int MIN, final int MAX) {
		if (opcao >= MIN && opcao <= MAX)
			return true;
		Saida.mostraErro("Informe o numero dos colchetes correspondentes a opcao desejada.");
		return false;
	}

	public static int validaId(Vector<Pessoa> pessoas) {
		int id;
		do {
			Saida.mostraMensagem("Informe o identificador da pessoa:");
			try {
				id = Ler.lerInt();
			} catch (InputMismatchException e) {
				Saida.mostraErro("Identificador deve ser um numero inteiro");
				id = validaId(pessoas);
			}
		} while (!isIdValido(id) || !isIdUnico(pessoas, id));
		return id;
	}

	private static boolean isIdUnico(Vector<Pessoa> grupoPessoas, int id) {
		for (Pessoa pessoa : grupoPessoas)
			if (pessoa.getId() == id) {
				Saida.mostraErro("Identificador invalido.\nEsse identificador ja esta em uso");
				return false;
			}
		return true;
	}

	private static boolean isIdValido(int id) {
		final int MAIOR = 100;
		if (id > MAIOR)
			return true;
		Saida.mostraErro("Identificador deve ser maior que " + MAIOR + ".");
		return false;
	}

	public static StringBuilder validaNome() {
		String nome;
		do {
			Saida.mostraMensagem("Digite o nome completo da pessoa:");
			nome = Ler.lerString();
		} while (!isNomeValido(nome));
		return new StringBuilder(nome);
	}

	private static boolean isNomeValido(String nome) {
		if (nome == null || nome.length() < 2) {
			Saida.mostraErro("Nome invalido.\nNome deve conter mais do que 2 caracteres.");
			return false;
		}
		return true;
	}

	public static char validaSaude() {
		char situacao;
		do {
			Saida.mostraMensagem("Informe a situacao de saude da pessoa:");
			Saida.mostraMensagem(
					"[T] - Contaminada em tratamento\n[F] - Contaminada falecida\n[C] - Contaminada curada\n[S] - Sem contaminacao");
			situacao = Ler.lerChar();
		} while (!isSituacaoSaudeValida(situacao));
		return situacao;
	}

	private static boolean isSituacaoSaudeValida(char situacaoSaude) {
		final char[] POSSIVEIS = { 'T', 'F', 'C', 'S' };
		for (char situacao : POSSIVEIS) {
			if (situacao == situacaoSaude)
				return true;
		}
		Saida.mostraErro("Situacao invalida.\nDigite a letra que esta dentro dos colchetes da opcao desejada.");
		return false;
	}

	public static char validaGenero() {
		char genero;
		do {
			Saida.mostraMensagem("Informe o genero da pessoa:");
			Saida.mostraMensagem("[F] - Feminino\n[M] - Masculino");
			genero = Ler.lerChar();
		} while (!isGeneroValido(genero));
		return genero;
	}

	private static boolean isGeneroValido(char genero) {
		if (genero == 'M' || genero == 'F')
			return true;
		Saida.mostraErro("Genero invalido.\nDigite a letra que esta dentro dos colchetes da opcao desejada.");
		return false;
	}

	public static int validaIdade() {
		int idade;
		do {
			Saida.mostraMensagem("Informe a idade da pessoa:");
			try {
				idade = Ler.lerInt();
			} catch (InputMismatchException e) {
				Saida.mostraErro("Idade invalida.\nIdade deve ser um numero inteiro");
				idade = validaIdade();
			}
		} while (!isIdadeValida(idade));
		return idade;
	}

	private static boolean isIdadeValida(int idade) {
		final int MINIMO = -1, MAXIMO = 151;
		if (idade > MINIMO && idade < MAXIMO)
			return true;
		Saida.mostraErro("Idade invalida.\nIdade deve estar entre " + MINIMO + " e " + MAXIMO + ".");
		return false;
	}

	public static char validaSituacaoGestante() {
		char situacao;
		do {
			Saida.mostraMensagem("Informe se a pessoa ja foi gestante:");
			Saida.mostraMensagem("[S] - Sim\n[N] - Nao\n[T] - Nao tem certeza");
			situacao = Ler.lerChar();
		} while (!isSituacaoGestanteValida(situacao));
		return situacao;
	}

	private static boolean isSituacaoGestanteValida(char escolhida) {
		if (escolhida == 'S' || escolhida == 'N' || escolhida == 'T')
			return true;
		Saida.mostraErro("Opcao invalida.\nDigite a letra que esta dentro dos colchetes da opcao desejada.");
		return false;
	}
}
