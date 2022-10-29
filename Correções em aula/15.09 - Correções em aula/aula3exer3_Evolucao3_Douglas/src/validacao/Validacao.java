package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import saida.Visao;

public class Validacao {

	public static String validaNome() {
		String nome = Leitura.lerNome();

		while (nome.length() < 3) {
			Visao.limpaTela(2);
			System.out.print("Nome invalido! O nome deve ter pelo menos 3 caracteres.\nDigite o nome novamente: ");
			nome = Leitura.lerNome();
		}

		return nome;
	}

	public static int validaIdade() {
		boolean erro = false;
		int idade = 0;

		do {
			try {
				idade = Leitura.lerIdade();

				if (idade <= 0 || idade >= 151) {
					Visao.limpaTela(2);
					System.out.println("Valor invalido! Tente novamente.");
					erro = true;
				} else {
					erro = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Ocorreu um  erro. Tente novamente:");
				erro = true;
			}
		} while (erro);

		return idade;
	}

	public static float validaAltura() {
		boolean erro = false;
		float altura = 0f;

		do {
			try {
				altura = Leitura.lerAltura();

				if (altura <= 0.4 || altura >= 2.6) {
					Visao.limpaTela(2);
					System.out.println("Valor invalido! Tente novamente:");
					erro = true;
				} else
					erro = false;
			} catch (InputMismatchException excecao) {
				System.out.println("Ocorreu um  erro. Tente novamente:");
				erro = true;
			}
		} while (erro);

		return altura;
	}

	public static char validaCaractere(String resposta) {
		char caractereResposta = ' ';

		do {
			System.out.println("Deseja continuar cadastrando? [s] para SIM e [n] para NAO");
			resposta = Leitura.lerResposta();

			if (resposta.length() == 1) {
				caractereResposta = resposta.charAt(0);
			} else {
				System.out.println("Opção inválida! Informe apenas UM caractere.");
			}
		} while (resposta.length() > 1);

		return caractereResposta;
	}

	public static boolean validaContinua(int contaPessoa, int limite) {
		char opcao;
		String resposta = "";
		
		if (contaPessoa == limite) {
			Visao.limpaTela(2);
			System.out.println("Limite de [" + limite + "] pessoa(s) atingido.");
			return false;
		}

		opcao = validaCaractere(resposta);

		while ((opcao != 's') && (opcao != 'n')) {
			Visao.limpaTela(30);
			System.out.print("Opcao invalida! Continuar cadastrando?\nDigite [s] para SIM e [n] para nao: ");
			opcao = validaCaractere(Leitura.lerResposta());
		}

		Visao.limpaTela(20);
		
		return ((opcao == 's') ? true : false);
	}

}
