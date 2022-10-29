package validacao;

import java.util.InputMismatchException;

import dados.GrupoPessoas;
import dados.PessoaContaminada;
import dados.PessoaNaoContaminada;
import leitura.Leitura;
import saida.Visao;

public class Validacao {

	public static String validaNome() {
		String nome;

		Visao.msgConsole("Informe o nome completo:");
		nome = Leitura.lerString();

		if (nome == null || nome.isEmpty() || nome.length() <= 3 || !nome.contains(" ")) {
			Visao.msgConsole("O nome nao pode ser imcompleto ou nulo ou vazia ou menor que tres caracteres! Tente novamente.");
			return validaNome();
		}

		return nome;
	}

	public static int validaContinua() {
		int resp;

		Visao.msgConsole("[1] - Novo Cadastro\n[2] - Mostrar todos os cadastros\n[0] - Encerrar");
		
		try {
			resp = Leitura.lerCaractere();

			if (resp < 0 || resp > 2) {
				Visao.msgConsole("Opcao invalida! Tente novamente.");
				return validaContinua();
			}
		} catch (InputMismatchException e) {
			Visao.msgErro();
			return validaContinua();
		}

		return resp;
	}

	public static int validaCaso() {
		int opcao;
		Visao.msgConsole("[1] - Pessoa Contaminada\n[2] - Pessoa NAO contaminada\nSelecione uma opcao:");

		try {
			opcao = Leitura.lerInteiro();

			if (opcao != 1 && opcao != 2) {
				Visao.msgConsole("Opcao invalida! Tente novamente.");
				return validaCaso();
			}
		} catch (InputMismatchException e) {
			Visao.msgErro();
			return validaCaso();
		}

		return opcao;
	}

	public static Character validaGenero() {
		char genero;

		Visao.msgConsole("Informe o genero: [M/m] - Masculino | [F/f] - Feminino");
		genero = Leitura.lerCaractere();

		if (genero != 'M' && genero != 'F') {
			Visao.msgConsole("Opcao invalida! Tente novamente.");
			return validaGenero();
		}

		return genero;
	}

	public static Integer validaId(int minimo, GrupoPessoas grupo) {
		int id;

		Visao.msgConsole("Informe a identificador: [No minimo " + minimo + "]");

		try {
			id = Leitura.lerInteiro();

			if (id < minimo || validaIdUnico(grupo, id)) {
				Visao.msgConsole("O identificador nao pode ser repetido ou menor que " + id + "! Tente novamente.");
				return validaId(minimo, grupo);
			}

		} catch (InputMismatchException e) {
			Visao.msgErro();
			return validaId(minimo, grupo);
		}

		return id;
	}

	private static boolean validaIdUnico(GrupoPessoas grupo, int id) {
		for (PessoaContaminada pessoaContaminada : grupo.getPessoasContaminadas()) {
			if (pessoaContaminada.getId() == id)
				return true;
		}

		for (PessoaNaoContaminada pessoaNaoContaminada : grupo.getPessoasNaoContaminadas()) {
			if (pessoaNaoContaminada.getId() == id)
				return true;
		}
		return false;
	}

	public static Character validaAtualSituacaoSaude() {
		char opcao;

		Visao.msgConsole("[E] - Em tratamento\n[F] - Falecido\n[C] - Curado\nInforme a situacao de saude: ");
		opcao = Leitura.lerCaractere();

		if (opcao != 'E' && opcao != 'F' && opcao != 'C') {
			Visao.msgConsole("Opcao invalida! Tente novamente.");
			return validaAtualSituacaoSaude();
		}

		return opcao;
	}

	public static int validaIdade() {
		int idade;

		Visao.msgConsole("Informe a idade:");

		try {
			idade = Leitura.lerInteiro();

			if (idade < 0 || idade > 130) {
				Visao.msgConsole("A idade nao pode ser menor que [0] ou maior que [130]! Tente novamente.");
				return validaIdade();
			}
		} catch (InputMismatchException e) {
			Visao.msgErro();
			return validaIdade();
		}

		return idade;
	}

}
