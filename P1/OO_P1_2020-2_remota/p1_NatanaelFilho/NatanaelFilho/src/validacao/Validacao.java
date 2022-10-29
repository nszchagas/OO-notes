package validacao;

import java.util.InputMismatchException;

import dados.Grupo;
import dados.Pessoa;
import dados.PessoaContaminada;
import leitura.Leitor;
import saida.Visao;

public class Validacao {

	public static int validaIndice(String menu) {
		int opcao = -1;
		boolean erro = true;
		Visao.limpaTela(30);
		Visao.mostraMensagem(menu);
		try {
			Visao.mostraMensagem("opcao: ");
			opcao = Leitor.lerInt();
			if (opcao >= 0 && opcao <= 2)
				erro = false;
			else
				Visao.mensagemDeErro("Opcao invalido! insira opcao entre 0 e 3");
		} catch (InputMismatchException e) {
			Visao.mensagemDeErro("Erro de compatibilidade de entrada!");
			erro = true;
		}
		return erro ? validaIndice(menu) : opcao;
	}

	public static int validaIndentificador(Grupo grupo) {
		final int MINIMO = 1;
		int indentificador = -1;
		boolean erro = true;
		Visao.mostraMensagem("insira indentificador do paciente: ");
		try {
			indentificador = Leitor.lerInt();
			if (indentificador < MINIMO)
				Visao.mensagemDeErro("Erro! indentificador deve ser maior ou igual a " + MINIMO);
			else
				erro = false;
		} catch (InputMismatchException e) {
			Visao.mensagemDeErro("Erro de compatibilidade de entrada!");
			erro = true;
		}
		for (Pessoa pessoa : grupo.getGrupoSaudavel()) {
			if (indentificador == pessoa.getIndentificador()) {
				Visao.mensagemDeErro("Erro! indentificador cadastrado anteriormente");
				erro = true;
				break;
			}
		}
		for (PessoaContaminada pessoa : grupo.getGrupoContaminado()) {
			if (indentificador == pessoa.getIndentificador()) {
				Visao.mensagemDeErro("Erro! indentificador cadastrado anteriormente");
				erro = true;
				break;
			}

		}

		return erro ? validaIndentificador(grupo) : indentificador;
	}

	public static String validaNome() {
		StringBuilder nome = new StringBuilder();
		Visao.limpaTela(2);
		while (true) {
			Visao.mostraMensagem("Insira nome completo : ");
			nome.append(Leitor.lerString());
			if (nome.length() == 0) {
				Visao.mensagemDeErro("Invalido! o programa nao aceita nome vazio.");
			} else if (nome.toString().length() == nome.toString().replace(" ", "").length()) {
				Visao.mensagemDeErro("Invalido! o nome devera ser completo.");
			} else
				return nome.toString();
			nome.setLength(0);
		}
	}

	public static char validaSexo() {
		Visao.mostraMensagem("sexo da pessoa: ");
		char sexo = Leitor.lerChar();
		if (sexo == 'M' || sexo == 'F')
			return sexo;
		Visao.mensagemDeErro("Erro! digite M para masculino ou F para feminino.");
		return validaSexo();
	}

	public static Integer validaIdade() {
		final int MINIMO = 0, MAXIMO = 130;
		int idade = -1;
		boolean erro = true;
		Visao.mostraMensagem("idade da pessoa: ");
		try {
			idade = Leitor.lerInt();
			if (idade < MINIMO || idade > MAXIMO)
				Visao.mensagemDeErro("Erro! idade devera ser " + MINIMO + " <= idade <= " + MAXIMO);
			else
				erro = false;
		} catch (InputMismatchException excecao) {
			Visao.mensagemDeErro("Erro! entrada incompativel");
			erro = true;
		}

		return erro ? validaIdade() : idade;
	}

	public static char validaSituacao() {
		Visao.mostraMensagem("insira situacao de pessoa contaminada: ");
		char situacao = Leitor.lerChar();
		if (situacao == 'E' || situacao == 'F' || situacao == 'C')
			return situacao;
		Visao.mensagemDeErro("Erro! situacao devera ser E-em tratamento, F-falecido ou C-curado.");
		return validaSituacao();
	}

}
