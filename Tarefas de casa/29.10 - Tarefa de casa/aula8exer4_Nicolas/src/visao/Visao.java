package visao;

import java.text.DecimalFormat;
import java.util.Arrays;

import javax.swing.JOptionPane;

import dados.Empregado;
import dados.Empresa;
import dados.Terreno;
import dados.TerrenosDaCidade;
import interfaces.AnaliseDados;
import leitura.Leitura;
import validacao.Validacao;

public class Visao {

	public static void efetuaCadastros(Empresa empresa, TerrenosDaCidade terrenos) {

		switch (Visao.mostraMenu("Escolha o tipo de cadastro", new String[] { "Terreno", "Empregado", "Cancelar" })) {

		case 0:
			terrenos.addTerreno(new Terreno(cadastraEndereco(), cadastraArea(), cadastraPreco()));
			break;
		case 1:
			empresa.addEmpregado(new Empregado(cadastraMatricula(empresa), cadastraNome(), cadastraSalario()));
			break;
		default:

		}
	}

	public static StringBuilder cadastraNome() {

		String nome;
		do {
			nome = Leitura.janelaEntrada("Insira o nome do empregado", "Cadastro");
		} while (!Validacao.isNome(nome));

		return new StringBuilder(nome);

	}

	public static StringBuilder cadastraEndereco() {

		return new StringBuilder(Leitura.janelaEntrada("Insira o endereco do terreno", "Cadastro")); // na entrada já
																										// foi impedido
																										// de ser null,
																										// e pode ser
																										// vazio

	}

	public static Integer cadastraMatricula(Empresa empresa) {

		int matricula = 0;

		boolean erro = true;
		while (erro) {
			try {
				do {
					matricula = Integer.parseInt(Leitura.janelaEntrada("Digite a matricula do empregado", "Cadastro"));
				} while (!Validacao.isMatricula(matricula, empresa));
				erro = false;
			} catch (NumberFormatException e) {
				mostraMensagemErro("Insira apenas numeros inteiros!");
				erro = true;
			}
		}
		return matricula;

	}

	public static Integer cadastraArea() {

		int area = 0;

		boolean erro = true;
		while (erro) {
			try {
				do {
					area = Integer.parseInt(
							Leitura.janelaEntrada("Digite a area do terreno, em metros quadrados", "Cadastro"));
				} while (!Validacao.isArea(area));
				erro = false;
			} catch (NumberFormatException e) {
				mostraMensagemErro("Insira apenas numeros inteiros!");
				erro = true;
			}
		}
		return area;

	}

	public static Float cadastraSalario() {
		float salario = 0;

		boolean erro = true;
		while (erro) {
			try {
				do {
					salario = Integer.parseInt(Leitura.janelaEntrada("Digite a o salario do empregado", "Cadastro"));
				} while (!Validacao.isValorDinheiro(salario));
				erro = false;
			} catch (NumberFormatException e) {
				mostraMensagemErro("Insira apenas numero! Utilize ponto (.) para separar as casas decimais.");
				erro = true;
			}
		}
		return salario;
	}

	public static Float cadastraPreco() {
		float preco = 0;

		boolean erro = true;
		while (erro) {
			try {
				do {
					preco = Integer.parseInt(Leitura.janelaEntrada("Digite a o valor do terreno", "Cadastro"));
				} while (!Validacao.isValorDinheiro(preco));
				erro = false;
			} catch (NumberFormatException e) {
				mostraMensagemErro("Insira apenas numero! Utilize ponto (.) para separar as casas decimais.");
				erro = true;
			}
		}
		return preco;
	}

	public static String analisaDados(Empresa empresa, TerrenosDaCidade terrenos) {

		AnaliseDados analise;
		String inteiroAnalisado, floatAnalisado;

		// tipo = 'f' float(valores) ou 'i' inteiro(areas) (Terrenos)
		// tipo = 'f' float(salarios) ou 'i' inteiro(matriculas) (Empresa)

		int tipo = Visao.mostraMenu("Escolha a colecao de dados para analisar",
				new String[] { "Terreno", "Empregado", "Cancelar" });
		switch (tipo) {

		case 0:
			inteiroAnalisado = "area de terreno";
			floatAnalisado = "preco de terreno";
			if (terrenos.getTerrenos().size() > 0) {
				analise = new TerrenosDaCidade(terrenos);
				break;
			} else {
				mostraMensagemAviso("Cadastre um terreno primeiro!");
				return null;

			}
		case 1:
			inteiroAnalisado = "matricula de empregado";
			floatAnalisado = "salario de empregado";
			if (empresa.getEmpregados().size() > 0) {
				analise = new Empresa(empresa);
				break;
			} else {
				mostraMensagemAviso("Cadastre um empregado primeiro!");
				return null;
			}

		default:
			return null;

		}

		String[] opcoes = { "Maior e menor valor registrado para " + floatAnalisado, // 0
				"Media entre os valores registrados para " + floatAnalisado, // 1
				"Media entre os valores registrados para " + inteiroAnalisado, // 2
				"Soma dos valores registrados para " + floatAnalisado, // 3
				"Soma dos valores registrados para " + inteiroAnalisado, // 4
				"Verificar se um valor foi cadastrado para " + inteiroAnalisado // 5
		};

		String opcao = (String) JOptionPane.showInputDialog(null, "Selecione o tipo de analise a ser feita", "Analise",
				JOptionPane.PLAIN_MESSAGE, null, opcoes, null);

		switch (Arrays.asList(opcoes).indexOf(opcao)) {
		case 0:
			return "Maior " + floatAnalisado + ": " + new DecimalFormat("0.00").format(analise.getMaiorEMenor()[0])
					+ "\nMenor " + floatAnalisado + ": "
					+ new DecimalFormat("0.00").format(analise.getMaiorEMenor()[1]);
		case 1:
			return "Media entre os valores registrados para " + floatAnalisado + ": "
					+ new DecimalFormat("0.00").format(analise.getMedia('f'));
		case 2:
			return "Media entre os valores registrados para " + inteiroAnalisado + ": "
					+ new DecimalFormat("0.00").format(analise.getMedia('i'));
		case 3:
			return "Soma dos valores registrados para " + floatAnalisado + ": "
					+ new DecimalFormat("0.00").format(analise.getSoma('f'));
		case 4:
			return "Soma dos valores registrados para " + inteiroAnalisado + ": "
					+ new DecimalFormat("0.00").format(analise.getSoma('i'));
		case 5:
			int numero = registraInteiro(
					"Insira um numero para pesquisar entre os valores cadastrados para " + inteiroAnalisado, "Analise");
			if (analise.getDuplicados(numero) != null && analise.getDuplicados(numero).size() > 0) {
				limpaTela(50);

				if (tipo == 0)
					mostraCabecalhoTerrenos();
				else
					mostraCabecalhoEmpresa();

				for (Object valorDuplo : analise.getDuplicados(numero))
					System.out.println(valorDuplo);
				return "Ha duplicidade nos cadastros. Confira na console os valores registrados com o valor " + numero
						+ " para " + inteiroAnalisado;
			}

			else
				return "Valor procurado: " + numero + "\nNao foi encontrado nenhum registro com esse valor.";

		default:
			return null;
		}

	}

	public static void mostraCabecalhoTerrenos() {
		String formato = "%-11s | %-80s | %s\n";
		System.out.format(formato, "Area (m²)", "Endereco", "Valor (R$)");
		linhaHorizontal(110);
	}

	public static void mostraCabecalhoEmpresa() {
		String formato = "%-11s | %-80s | %s\n";
		System.out.format(formato, "Matricula", "Nome", "Salario (R$)");
		linhaHorizontal(110);
	}

	public static void mostraDados(Empresa empresa, TerrenosDaCidade terrenos) {
		limpaTela(50);
		if (empresa.getEmpregados().size() > 0) {

			System.out.println("EMPREGADOS CADASTRADOS");
			mostraCabecalhoEmpresa();
			for (Empregado empregado : empresa.getEmpregados())
				System.out.print(empregado);
			limpaTela(3);
		}
		if (terrenos.getTerrenos().size() > 0) {
			System.out.println("TERRENOS CADASTRADOS");
			mostraCabecalhoTerrenos();
			for (Terreno terreno : terrenos.getTerrenos())
				System.out.print(terreno);
		}

	}

	public static int registraInteiro(String mensagem, String titulo) {
		int numero = 0;
		boolean erro = true;

		while (erro) {
			try {
				numero = Integer.parseInt(Leitura.janelaEntrada(mensagem, titulo));
				erro = false;
			} catch (NumberFormatException e) {
				erro = true;
				mostraMensagemAviso("Insira apenas numeros inteiros");
			}
		}
		return numero;
	}

	public static void mostraMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
	}

	public static void mostraMensagemAviso(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.WARNING_MESSAGE, null);
	}

	public static void mostraMensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE, null);
	}

	public static int mostraMenu(String mensagem, String[] opcoes) {
		int opcao;
		do {
			opcao = JOptionPane.showOptionDialog(null, mensagem, "Menu", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[opcoes.length - 1]);
			if (opcao == -1)
				mostraMensagemAviso("Selecione uma opcao");
		} while (opcao == -1);
		return opcao;

	}

	public static boolean perguntaSimOuNao(String mensagem, String titulo) {
		int opcao;
		do {
			opcao = JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (opcao == -1)
				mostraMensagemAviso("Selecione uma opcao");
		} while (opcao == -1);
		return (opcao == 0);
	}

	private static void limpaTela(int tamanho) {
		for (int aux = 0; aux < tamanho; aux++)
			System.out.println();
	}

	private static void linhaHorizontal(int tamanho) {
		for (int aux = 0; aux < tamanho; aux++)
			System.out.print("-");
		System.out.println();
	}
}
