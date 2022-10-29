package validacao;

import java.util.Calendar;

import dados.Data;
import visao.Visao;

public class Validacao {

	public static boolean isNome(String nome) {
		String[] nomes = nome.trim().split(" ");
		boolean valido = false;
		for (String nomeSeparado : nomes)
			valido = (nomeSeparado.length() >= 3);
		if (!valido)
			Visao.mostraMensagemErro("Valor invalido! Cada nome deve ter pelo menos 3 caracteres");
		return valido;
	}

	public static boolean isContinua(int opcao, String msg, int opcaoSair) {
		if (opcao == opcaoSair)
			return false;
		else
			return (Visao.confirmaMensagem(msg) == 0);
	}

	public static boolean isCpf(String cpf) {

		boolean valido = false;
		float calculoDigitos = 0f;
		if (cpf.matches("[0-9]{11}")) {
			for (int contador = 0; contador < 9; contador++)
				calculoDigitos += Integer.valueOf(Character.getNumericValue(cpf.charAt(contador))) * (10 - contador);
			if (calculoDigitos * 10 % 11 == Character.getNumericValue(cpf.charAt(9)))
				valido = true;
			if (!valido)
				Visao.mostraMensagemErro("O CPF inserido e invalido. Insira novamente.");
		} else
			Visao.mostraMensagemErro("O CPF deve possuir 11 digitos numericos. Digite novamente.");

		return valido;

	}

	public static boolean isData(String data) {

		if (data.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
			final int ANO_MAX = Calendar.getInstance().get(Calendar.YEAR) - 16;
			final int ANO_MIN = Calendar.getInstance().get(Calendar.YEAR) - 90;

			Data aniversario = Data.getDataDeString(data);

			if (aniversario.ano > ANO_MAX || aniversario.ano < ANO_MIN) {
				Visao.mostraMensagemErro("Insira ano entre " + ANO_MIN + " e " + ANO_MAX);
				return false;
			} else if (aniversario.dia > 31 || aniversario.dia < 1) {
				Visao.mostraMensagemErro("Insira dia entre 1 e 31");
				return false;
			} else if (aniversario.mes > 12 || aniversario.mes < 1) {
				Visao.mostraMensagemErro("Insira mes entre 1 e 12 (janeiro a dezembro).");
				return false;
			}
		} else {
			Visao.mostraMensagemErro("Insira data no formato dd/mm/aaaa, com as barras separando os numeros.");
			return false;
		}

		return true;

	}

	public static boolean isNumero(int numero, int MAX) {
		if (numero < 0 || numero > MAX)
			Visao.mostraMensagemErro("Insira um valor entre 0 e " + MAX);
		return (numero >= 0 && numero <= MAX);
	}

}
