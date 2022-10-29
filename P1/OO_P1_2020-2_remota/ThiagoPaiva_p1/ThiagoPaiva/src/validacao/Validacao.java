package validacao;

import dados.GrupoPessoa;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static char validaChar(String mensagem, String caracteresValidos) {
		char caracter;

		Visao.mostraMensagem(mensagem);
		caracter = Leitura.leiaChar();

		if (!caracteresValidos.contains(Character.toString(caracter))) {
			Visao.mostraMensagemErro("Opcao invalida!");
			return validaChar(mensagem, caracteresValidos);
		}

		return caracter;
	}

	public static int validaInt(String mensagem, final int MIN, final int MAX) {
		int valor;

		Visao.mostraMensagem(mensagem);
		try {
			valor = Leitura.leiaInt();
			if (MIN == MAX) {
				if (valor < MIN) {
					Visao.mostraMensagemErro("A entrada deve ser um valor maior ou igual a " + MIN);
					return validaInt(mensagem, MIN, MAX);
				}
			} else {
				if (valor < MIN || valor > MAX) {
					Visao.mostraMensagemErro("A entrada deve ser um numero entre " + MIN + " e " + MAX);
					return validaInt(mensagem, MIN, MAX);
				}
			}
		} catch (Exception e) {
			Visao.mostraMensagemErro("Entrada incoerente! Digite um numero");
			return validaInt(mensagem, MIN, MAX);
		}
		return valor;
	}

	public static String validaString(String mensagem, String nomeValor, final int QTD_CARACTERES_MIN) {
		String valor;

		Visao.mostraMensagem(mensagem);
		valor = Leitura.leiaString();

		if (valor.isEmpty() || valor.replaceAll(" ", "").length() < QTD_CARACTERES_MIN) {
			Visao.mostraMensagemErro(nomeValor + " deve ter pelo menos " + QTD_CARACTERES_MIN + " caracteres!");
			return validaString(mensagem, nomeValor, QTD_CARACTERES_MIN);
		}
		return valor;
	}

	public static String validaStringAlfabetica(String mensagem, String nomeValor, final int QTD_CARACTERES_MIN) {
		String valor;

		valor = validaString(mensagem, nomeValor, QTD_CARACTERES_MIN);
		if (containsCaracterNaoAlfabetico(valor)) {
			Visao.mostraMensagemErro(nomeValor + " só pode ter caracteres alfabeticos!");
			return validaStringAlfabetica(mensagem, nomeValor, QTD_CARACTERES_MIN);
		}
		return valor;
	}

	private static boolean containsCaracterNaoAlfabetico(String valor) {
		for (char caracter : valor.toCharArray()) {
			if (!Character.isLetter(caracter) && caracter != ' ')
				return true;
		}
		return false;
	}

	public static char validaMenu() {
		Visao.limpaTela(2);
		Visao.mostraMensagem("[1] - Registro novo\n[2] - Relatório de todos registros\n[0] - Sair");
		return validaChar("Escolha uma das opcoes", "012");
	}

	public static int validaMenuRegistro() {
		Visao.mostraMensagem("[1] - Registar pessoa do sexo feminino\n[2] - Registrar pessoa do sexo masculino");
		return validaChar("Escolha uma das opcoes", "12");
	}

	public static int validaId(GrupoPessoa grupoPessoa) {
		final int MAIOR = 101;
		int id = validaInt("Digite o codigo de identificação", MAIOR, MAIOR);

		if (grupoPessoa.isPessoaCadastrada(id)) {
			Visao.mostraMensagemErro("Pessoa já cadastrada!");
			return validaId(grupoPessoa);
		}
		return id;
	}

	public static StringBuilder validaNomeCompleto() {
		String nomeCompleto = validaStringAlfabetica("Digite o nome completo da pessoa", "O nome", 3);

		if (nomeCompleto.split("[ ]+").length < 2) {
			Visao.mostraMensagemErro("Digite o nome e o sobrenome da pessoa!");
			return validaNomeCompleto();
		}
		return new StringBuilder(nomeCompleto);
	}

	public static int validaIdade() {
		return validaInt("Digite a idade da pessoa", 0, 150);
	}

	public static char validaSituacaoSaude() {
		Visao.mostraMensagem("Situação de saude");
		Visao.mostraMensagem("[T] - Contaminada em Tratamento\n[F] - Contaminada Falecida\n[C] - Contaminada Curada\n[S] - Sem Contaminação");
		return validaChar("Escolha uma das opcoes", "TFCS");
	}

	public static char validaFoiGestante() {
		Visao.mostraMensagem("A pessoa ja foi gestante?");
		Visao.mostraMensagem("[S] - Sim\n[N] - Não\n[T] - Não tem certeza");
		return validaChar("Escolha uma das opcoes", "SNT");
	}

}
