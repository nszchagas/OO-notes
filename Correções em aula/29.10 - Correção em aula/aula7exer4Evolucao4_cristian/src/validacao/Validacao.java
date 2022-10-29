package validacao;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dados.Empresa;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static char validaChar(String msg, String caracteresValidos) {
		char caracter;

		Visao.mostraMensagem(msg);
		caracter = Leitura.leiaChar();
		if (!caracteresValidos.contains(caracter + "")) {
			Visao.mostraMensagemErro("Opcao invalida!");
			return validaChar(msg, caracteresValidos);
		}

		return caracter;
	}

	public static String validaString(String msg, final int QTD_CARACTERES) {
		String valor;

		Visao.mostraMensagem(msg);
		valor = Leitura.leiaString();

		if (valor.isEmpty() || valor.replaceAll(" ", "").length() < QTD_CARACTERES) {
			Visao.mostraMensagemErro("A entrada deve ter pelo menos " + QTD_CARACTERES + "caracteres!");
			return validaString(msg, QTD_CARACTERES);
		}

		return valor;
	}

	public static String validaStringAlfabetica(String msg, final int QTD_CARACTERES) {
		String valor;

		valor = validaString(msg, QTD_CARACTERES);
		if (containsCaracterNaoAlfabetico(valor)) {
			Visao.mostraMensagemErro("A entrada só pode ter caracteres alfabeticos!");
			return validaStringAlfabetica(msg, QTD_CARACTERES);
		}
		return valor;
	}

	private static boolean containsCaracterNaoAlfabetico(String valor) {
		for (char caracter : valor.toCharArray()) {
			if (!Character.isAlphabetic(caracter) && caracter != ' ')
				return true;
		}
		return false;
	}

	public static int validaInt(String msg, final int MIN, final int MAX) {
		int valor;

		Visao.mostraMensagem(msg);
		try {
			valor = Leitura.leiaInt();
			if (valor < MIN || valor > MAX) {
				Visao.mostraMensagemErro("A entrada deve ser um numero entre " + MIN + " e " + MAX);
				return validaInt(msg, MIN, MAX);
			}
		} catch (Exception e) {
			Visao.mostraMensagemErro("Entrada incoerente! Digite um numero");
			return validaInt(msg, MIN, MAX);
		}

		return valor;
	}

	public static float validaFloat(String msg, final float MIN, final float MAX) {
		float valor;
		DecimalFormat df = new DecimalFormat("#,##0.00");

		Visao.mostraMensagem(msg);
		try {
			valor = Leitura.leiaFloat();
			if (valor < MIN || valor > MAX) {
				Visao.mostraMensagemErro(
						"A entrada deve ser um numero entre " + df.format(MIN) + " e " + df.format(MAX));
				return validaFloat(msg, MIN, MAX);
			}
		} catch (Exception e) {
			Visao.mostraMensagemErro("A entrada deve ser um numero");
			return validaFloat(msg, MIN, MAX);
		}

		return valor;
	}

	public static int validaMenuCadastro() {
		Visao.mostraMensagem("Opcoes de cadastro:\n");
		Visao.mostraMensagem("[1] - Funcionario Regular\n[2] - Prestador de Servicos\n[3] - Gerente\n[0] - Sair");
		return validaChar("\nEscolha uma das opcoes", "0123");
	}

	public static String validaNome() {
		return validaStringAlfabetica("Digite o nome do funcionario", 3);
	}

	public static String validaDataNascimento() {
		int dia = validaInt("Digite o dia do nascimento", 0, 31);
		int mes = validaInt("Digite o mes do nascimento", 1, 12);
		int ano = validaInt("Digite o ano do nascimneto", 1900, 2020);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		sdf.setLenient(false);
		try {
			sdf.parse(dia + "/" + mes + "/" + ano);
		} catch (ParseException e) {
			Visao.mostraMensagemErro("Data invalida!");
			return validaDataNascimento();
		}

		return dia + "/" + mes + "/" + ano;
	}

	public static String validaCpf(Empresa empresa) {
		String cpf = validaString("Digite o CPF do funcionario", 11);

		if (!cpf.matches("[0-9]{11}")) {
			Visao.mostraMensagemErro("O CPF deve conter 11 digitos");
			return validaCpf(empresa);
		}
		if (empresa.isFuncionarioCadastrado(cpf)) {
			Visao.mostraMensagemErro("Funcionario já cadastrado!");
			return validaCpf(empresa);
		}
		return cpf;
	}

	public static float validaHorasTrabalhadas() {
		return validaFloat("Digite a quantidade de horas trabalhadas no mes", 0, 720);
	}

	public static int validaQuantidadeProjetos() {
		return validaInt("Digite a quantidade de projetos feitos", 0, 50);
	}

	public static int validaMenuRelatorio() {
		Visao.mostraMensagem("Opcoes de relatorio:\n");
		Visao.mostraMensagem("[1] - Total de funcionarios\n[2] - Total Salarial\n[0] - Encerrar Programa");
		return validaChar("\nEscolha uma das opcoes", "012");
	}

}
