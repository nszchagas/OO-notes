package visao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import dados.Baleia;
import dados.Elefante;
import dados.Macaco;
import dados.Mamifero;
import validacao.Validacao;

public class Visao {

	// escolher tipo de animal para cadastrar //

	public static Macaco cadastraMacaco() {
		Mamifero animal = cadastraMamifero();

		if (animal == null) {
			cadastraAnimal();
			return null;
		}
		String porte = cadastraPorte();
		if (porte == null) {
			cadastraAnimal();
			return null;
		}

		return new Macaco(animal, porte);
	}

	public static Elefante cadastraElefante() {

		Mamifero animal = cadastraMamifero();
		if (animal == null) {
			cadastraAnimal();
			return null;
		}

		float peso = cadastraPeso();
		if (peso == -1) {
			cadastraAnimal();
			return null;
		}

		String habitat = cadastraHabitat();
		if (habitat == null) {
			cadastraAnimal();
			return null;
		}

		return new Elefante(animal, peso, habitat);
	}

	public static Baleia cadastraBaleia() {

		Mamifero animal = cadastraMamifero();
		if (animal == null) {
			cadastraAnimal();
			return null;
		}

		float peso = cadastraPeso();
		if (peso == -1) {
			cadastraAnimal();
			return null;
		}

		return new Baleia(animal, peso);
	}

	public static Mamifero cadastraMamifero() {

		String especie = cadastraEspecie();
		if (especie == null) {
			cadastraAnimal();
			return null;
		}
		float tamanho = cadastraTamanho();

		if (tamanho == -1) {
			cadastraAnimal();
			return null;
		}

		int idadeAmamentacao = cadastraIdade("amamentacao");

		if (idadeAmamentacao == -1) {
			cadastraAnimal();
			return null;
		}
		int idadeVida = cadastraIdade("vida");
		if (idadeVida == -1) {
			cadastraAnimal();
			return null;
		}

		return new Mamifero(especie, tamanho, idadeAmamentacao, idadeVida);
	}

	public static String cadastraEspecie() {
		String especie = "";
		do {
			String texto = JOptionPane.showInputDialog(null, "Cadastre a especie do animal", "Cadastro",
					JOptionPane.QUESTION_MESSAGE);
			if (texto != null)
				especie = texto.trim();
			else
				return null;

		} while (!Validacao.isEspecie(especie));

		return especie;
	}

	private static String cadastraPorte() {
		String porte;
		do {
			String texto = mensagemEntrada("Cadastre o porte do animal (pequeno, medio ou grande):");
			if (texto != null)
				porte = texto.trim();
			else
				return null;
		} while (!Validacao.isPorte(porte));

		return porte;
	}

	private static float cadastraTamanho() {
		String texto;
		float tamanho = 0f;
		boolean erro = true;

		while (erro) {
			try {
				do {
					texto = mensagemEntrada("Cadastre o tamanho estimado para essa especie, em metros:");
					if (texto != null)
						tamanho = Float.parseFloat(texto);
					else
						return -1f;
				} while (!Validacao.isTamanho(tamanho));
				erro = false;
			} catch (InputMismatchException e) {
				erro = true;
				mostraMensagemErro("Ocorreu um erro! Insira apenas numeros!");
			} catch (NumberFormatException e) {
				erro = true;
				mostraMensagemErro("Ocorreu um erro! Utilize ponto (.) para separar a parte decimal do seu numero");
			}
		}

		return tamanho;
	}

	private static int cadastraIdade(String tipo) {

		int idade = 0;
		boolean erro = true;
		while (erro) {
			try {
				do {
					String texto = mensagemEntrada("Cadastre o tempo medio de " + tipo + " para especie, em anos:");
					if (texto != null)
						idade = Integer.parseInt(texto);
					else
						return -1;

				} while (!Validacao.isIdade(idade));

				erro = false;
			} catch (InputMismatchException e) {
				erro = true;
				mostraMensagemErro("Ocorreu um erro! Insira apenas numeros!");
			} catch (NumberFormatException e) {
				erro = true;
				mostraMensagemErro("Ocorreu um erro! Insira um numero inteiro.");
			}
		}

		return idade;
	}

	private static float cadastraPeso() {
		float peso = 0f;
		boolean erro = true;

		while (erro) {
			try {
				do {
					String texto = mensagemEntrada("Cadastre o peso estimado para essa especie, em quilogramas (kg):");
					if (texto != null)
						peso = Float.parseFloat(texto);
					else
						return -1;
				} while (!Validacao.isPeso(peso));

				erro = false;
			} catch (InputMismatchException e) {
				erro = true;
				mostraMensagemErro("Ocorreu um erro! Insira apenas numeros!");
			} catch (NumberFormatException e) {
				erro = true;
				mostraMensagemErro("Ocorreu um erro! Utilize ponto (.) para separar a parte decimal do seu numero.");
			}
		}

		return peso;

	}

	public static String cadastraHabitat() {
		String habitat;
		do {
			String texto = mensagemEntrada("Cadastre o habitat natural do animal:");
			if (texto != null)
				habitat = texto.trim();
			else
				return null;
		} while (!Validacao.isHabitat(habitat));
		return habitat;
	}

	public static Mamifero cadastraAnimal() {
		String[] opcoes = new String[] { "Macaco", "Elefante", "Baleia", "Cancelar cadastro" };

		switch (mostraMenuOpcoes("Qual tipo de animal deseja cadastrar?", opcoes, "Cadastro")) {
		case 0:
			return cadastraMacaco();
		case 1:
			return cadastraElefante();
		case 2:
			return cadastraBaleia();
		case 3:
			if (confirmaOpcao("Deseja encerrar cadastro?") == 0)
				return null;
			else
				return cadastraAnimal();
		}

		return null;
	}

	// controle continuar //

	public static boolean desejaContinuar(int numCadastros) {
		final int MAX = 500;
		if (numCadastros >= MAX) {
			mostraMensagem("Quantidade maxima de cadastros atingida", "Cadastro");
			return false;
		} else
			return (confirmaOpcao("Deseja cadastrar um novo animal?") == 0);
	}

	// saida de dados //

	private static void imprimeCabecalho() {
		System.out.println(
				" Tipo     | Especie                        | Tamanho (m) | Tempo de amamentacao (anos) | Tempo de vida (anos) | Porte      | Peso (kg)  | Habitat Natural             |");
	}

	public static void mostraAnimais(ArrayList<Mamifero> lista) {
		if (lista.size() > 0)
			if (confirmaOpcao("Deseja visualizar tabela com animais cadastrados?") == 0) {
				imprimeCabecalho();
				imprimeLinhaHorizontal(165);
				for (Mamifero animal : lista)
					System.out.println(animal);
			}
		mostraMensagem("Programa encerrado com sucesso. Foram feitos " + lista.size() + " cadastros.",
				"Programa encerrado");
	}

	// servicos //

	public static void imprimeLinhaHorizontal(int tamanho) {
		for (int cont = 0; cont > tamanho; cont++)
			System.out.print("-");
	}

	public static String ajustaTexto(String texto, int tamanho) {
		StringBuilder str = new StringBuilder("");
		str.append(" ").append(texto);
		for (int cont = texto.length() + 1; cont < tamanho; cont++)
			str.append(" ");
		str.append("|");
		return str.toString();
	}

	// mensagens da caixa de dialogo //

	private static int confirmaOpcao(String mensagem) {
		UIManager.put("OptionPane.noButtonText", "Não");
		UIManager.put("OptionPane.yesButtonText", "Sim");
		return JOptionPane.showConfirmDialog(null, mensagem, "Confirmacao", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
	}

	public static void mostraMensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}

	private static String mensagemEntrada(String mensagem) {

		return JOptionPane.showInputDialog(null, mensagem, "Cadastro", JOptionPane.QUESTION_MESSAGE);

	}

	private static void mostraMensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	private static int mostraMenuOpcoes(String mensagem, String[] opcoes, String titulo) {
		return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[opcoes.length - 1]);
	}

}
