package validacao;

import java.util.ArrayList;
import java.util.InputMismatchException;

import dados.Homem;
import dados.Mulher;
import dados.Pessoa;
import leitura.Leitura;
import saida.Saida;

public class Validacao {
	public static Pessoa validaPessoa(ArrayList<Pessoa> grupo) {
		StringBuilder nome = validaNome();
		String situacao = validaSituacao();
		Integer codigo = validaCodigo(grupo);
		String sexo = validaSexo();
		Homem homem;
		Mulher mulher;
		if (sexo.equals("M")) {
			homem = new Homem(nome, situacao, codigo, validaIdade());
			return homem;
		} else {
			mulher = new Mulher(nome, situacao, codigo, validaSituacaoGestante());
			return mulher;
		}
	}

	private static Integer validaCodigo(ArrayList<Pessoa> grupo) {
		final int MAIOR = 100;
		Integer codigo = 0;
		Boolean erro = false;
		Integer codigos[] = new Integer[grupo.size()];

		for (int aux = 0; aux < codigos.length; aux++)
			codigos[aux] = grupo.get(aux).getCodigo();

		do {
			erro = false;
			try {
				System.out.print("Digite o codigo: ");
				codigo = Leitura.getInt();
				if (codigo <= MAIOR) {
					erro = true;
					System.out.println("Digite um valor maior que 100.");
				}
				for (int aux = 0; aux < codigos.length; aux++)
					if (codigo == codigos[aux]) {
						erro = true;
						System.out.println("Codigo ja cadastrado");
					}
			} catch (InputMismatchException e) {
				erro = true;
				System.out.println("Digite um valor inteiro.");
			}
		} while (erro);
		return codigo;
	}

	private static String validaSituacaoGestante() {
		String situacaoGestante = "";
		do {
			Saida.menuGestante();
			situacaoGestante = Leitura.getString().toUpperCase();
			if (!validaPadrao(situacaoGestante, "SNT"))
				System.out.println("Digite apenas as opcoes indicadas.");
		} while (!validaPadrao(situacaoGestante, "SNT"));
		return situacaoGestante;
	}

	private static Integer validaIdade() {
		Integer idade = 0;
		Boolean erro = false;
		do {
			erro = false;
			try {
				System.out.print("Digite a idade do homem: ");
				idade = Leitura.getInt();
				if (idade < 0 || idade > 150) {
					erro = true;
					System.out.println("Insira um valor entre 0 e 150.");
				}
			} catch (InputMismatchException e) {
				erro = true;
				System.out.println("Insira um valor inteiro.");
			}
		} while (erro);
		return idade;
	}

	private static String validaSexo() {
		String sexo;
		Boolean erro = false;
		do {
			System.out.print("Digite o sexo da pessoa [M/F]: ");
			sexo = Leitura.getString().toUpperCase();
			if (sexo.equals("M") || sexo.equals("F"))
				return sexo;
			else {
				erro = true;
				System.out.println("Digite apenas um caractere. [M/F]");
			}
		} while (erro);
		return sexo;
	}

	public static StringBuilder validaNome() {
		StringBuilder nome = new StringBuilder();
		do {
			System.out.print("Digite o nome: ");
			nome.append(Leitura.getString().toUpperCase());
			if (nome.length() < 2)
				System.out.println("Nome devera ter no minimo 2 caracteres.");
		} while (nome.length() < 2);
		return nome;
	}

	public static String validaSituacao() {
		String situacao = "";
		do {
			Saida.menuSituacao();
			situacao = Leitura.getString().toUpperCase();
			if (!validaPadrao(situacao, "TFCS"))
				System.out.println("Insira apenas as opcoes indicadas.");
		} while (!validaPadrao(situacao, "TFCS"));
		return situacao;
	}

	private static boolean validaPadrao(String situacao, String padrao) {
		if (padrao.contains(situacao))
			return true;
		return false;
	}

	public static int validaOpcao() {
		int opcao = 0;
		Boolean erro = false;
		do {
			try {
				erro = false;
				opcao = Leitura.getInt();
				if (opcao < 0 || opcao > 2) {
					erro = true;
					System.out.println("Digite apenas as opcoes indicadas");
				}
			} catch (InputMismatchException e) {
				erro = true;
				System.out.println("Digite um numero inteiro.");
			}
		} while (erro);
		return opcao;
	}

	public static boolean validaContinua() {
		char operacao;
		do {
			Saida.limpaTela(40);
			System.out.print("Deseja continuar cadastrando? [S/n]: ");
			operacao = Leitura.getValidacao();
			if (operacao != 'S' && operacao != 'N')
				System.out.println("Operação invalida, tente novamente!");
		} while (operacao != 'S' && operacao != 'N');
		return ((operacao == 'S') ? true : false);
	}
}
