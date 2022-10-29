package validacao;

import java.sql.SQLException;

import dados.Pessoa;
import dao.PessoaDAO;
import visao.Visao;

public class Validacao {

	public static boolean isCodigo(int codigo) {
		final int MAIOR = 100;
		if (codigo <= MAIOR)
			Visao.mostraMensagemErro("O ID deve ser maior do que " + MAIOR, "Valor inválido");
		return codigo > MAIOR;
	}

	public static boolean isNome(String nome) {
		String[] nomesSeparados = nome.split(" ");
		if (nomesSeparados.length < 2) {
			Visao.mostraMensagemErro("Insira o nome completo.", "Erro");

			return false;
		} else {
			for (String texto : nomesSeparados) {
				if (texto.length() < 2) {
					new SQLException();

					Visao.mostraMensagemErro("Nome inválido! Cada nome deve possuir pelo menos 2 caracateres", "Erro");
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isIdade(float numero) {
		final int MIN = 0, MAX = 150;
		if (numero < MIN || numero > MAX)
			Visao.mostraMensagemErro("A idade inserida deve estar entre " + MIN + " e " + MAX, "Valor invalido");
		return (numero >= MIN && numero <= MAX);
	}

	public static boolean isRepetida(Pessoa pessoa) {
		return new PessoaDAO().getPessoas().contains(pessoa);
	}
}
