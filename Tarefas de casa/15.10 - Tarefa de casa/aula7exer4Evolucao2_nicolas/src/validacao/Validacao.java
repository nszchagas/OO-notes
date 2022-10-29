package validacao;

import java.util.Calendar;

import dados.Empresa;
import visao.Visao;

public class Validacao {

	public static boolean isNome(String nome) {
		String[] nomesSeparados = nome.trim().split(" ");
		if (nomesSeparados.length > 1) {
			for (String texto : nomesSeparados) {
				if (texto.length() < 2) {
					Visao.mostraMensagemErro("Cada nome deve ter pelo menos dois caracteres", "Valor invalido");
					return false;
				}
			}
		} else {
			Visao.mostraMensagemErro("Nome invalido! Informe tambem o sobrenome.", "Valor invalido");
			return false;
		}

		return true;

	}

	public static boolean isCpf(Empresa empresa, String cpf) {

		if (verificaDigitosCpf(cpf)) {
			if (empresa.getCpfsCadastrados().contains(cpf)) {
				Visao.mostraMensagemErro("CPF ja inserido! Insira outro.", "Valor invalido");
				return false;
			} else
				return true;
		} else
			return false;

	}

	public static boolean isData(String data) {

		int dia, mes, ano;
		if (data.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
			final int ANO_MAX = Calendar.getInstance().get(Calendar.YEAR) - 16;
			final int ANO_MIN = Calendar.getInstance().get(Calendar.YEAR) - 90;

			dia = Integer.parseInt(data.split("/")[0]);
			mes = Integer.parseInt(data.split("/")[1]);
			ano = Integer.parseInt(data.split("/")[2]);

			if (ano > ANO_MAX || ano < ANO_MIN) {
				Visao.mostraMensagemErro("Insira ano entre " + ANO_MIN + " e " + ANO_MAX, "Valor invalido");
				return false;
			} else if (dia > 31 || dia < 1) {
				Visao.mostraMensagemErro("Insira dia entre 1 e 31", "Valor invalido");
				return false;
			} else if (mes > 12 || mes < 1) {
				Visao.mostraMensagemErro("Insira mes entre 1 e 12 (janeiro a dezembro).", "Valor invalido");
				return false;
			}
		} else {
			Visao.mostraMensagemErro("Insira data no formato dd/mm/aaaa, com as barras separando os numeros.",
					"Valor invalido");
			return false;
		}

		return true;

	}

	public static boolean isNumero(float numero, int MIN, int MAX) {
		if (numero < MIN || numero > MAX)
			Visao.mostraMensagemErro("O valor inserido deve estar entre " + MIN + " e " + MAX, "Valor invalido");
		return (numero >= MIN && numero <= MAX);
	}

	private static boolean verificaDigitosCpf(String cpf) {

		boolean valido = false;
		float calculoDigitos = 0f;
		if (cpf.matches("[0-9]{11}")) {
			for (int contador = 0; contador < 9; contador++)
				calculoDigitos += Integer.valueOf(Character.getNumericValue(cpf.charAt(contador))) * (10 - contador);
			if (calculoDigitos * 10 % 11 == Character.getNumericValue(cpf.charAt(9)))
				valido = true;
			if (!valido)
				Visao.mostraMensagemErro("O CPF inserido e invalido. Insira novamente.", "Valor invalido");
		} else
			Visao.mostraMensagemErro("CPF invalido! Informe exatamente 11 caracteres numericos.", "Valor invalido");

		return valido;
	}
}
