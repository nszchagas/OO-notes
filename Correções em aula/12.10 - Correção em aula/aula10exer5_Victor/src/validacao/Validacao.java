package validacao;

import leitura.Leitura;
import visao.Visao;

public class Validacao {
	public static int validaDDD() {
		int ddd = 0;

		do {
			try {
				ddd = Integer.parseInt(Leitura.lerString("Digite o DDD desta cidade."));
				if (ddd < 10) {
					Visao.mostraMensagemAviso("DDD Inválido. Digite DDD maior que 10.");
				}
			} catch (NumberFormatException e) {
				Visao.mostraMensagemAviso("Insira algum valor numerico");
			} catch (NullPointerException e) {
				if (Visao.confirmar("Deseja cancelar ?") == 0)
					throw e;
				return validaDDD();
			}
		} while (ddd < 10);
		return ddd;
	}

	public static String validaNome() {
		String nome;

		do {
			try {
				nome = Leitura.lerString("Digite o nome da cidade.");
				if (nome.isEmpty())
					Visao.mostraMensagemAviso("O nome nao pode ser em branco");
			} catch (NullPointerException e) {
				if (Visao.confirmar("Deseja cancelar ?") == 0)
					throw e;
				return validaNome();
			}
		} while (nome.isEmpty());
		return nome;
	}
}
