package visao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;

import dados.Galeria;
import dados.Pintor;
import dados.Quadro;
import leitura.Leitura;
import validacao.Validacao;

public class Visao {

	public static Pintor cadastraPintor(Galeria galeria) {
		Pintor pintor = new Pintor(cadastraNome(), cadastraCodigo("pintor", galeria), cadastraAno("pintor"));
		galeria.addPintor(pintor);
		return pintor;
	}

	public static void cadastraQuadro(Galeria galeria, Pintor pintor) {
		mostraMensagem("Cadastre o quadro do pintor: " + pintor.getNome());
		galeria.addQuadro(
				new Quadro(pintor, cadastraCodigo("quadro", galeria), cadastraAno("quadro"), cadastraPreco()));
	}

	// cadastros

	public static float cadastraPreco() {
		float preco = 0f;
		boolean erro = true;
		while (erro) {
			try {
				do {
					mostraMensagem("Cadastre o preco do quadro:");
					preco = Leitura.leNumero();
				} while (!Validacao.isPreco(preco));
				erro = false;
			} catch (InputMismatchException e) {
				mensagemValorIncoerente();
				erro = true;
			}
		}
		return preco;
	}

	public static String cadastraNome() {
		String nome;
		do {
			mostraMensagem("Insira um nome para o pintor:");
			nome = Leitura.leString();
		} while (!Validacao.isNome(nome));
		return nome;
	}

	public static int cadastraCodigo(String tipo, Galeria galeria) {
		int codigo = 0;
		boolean erro = true;
		while (erro) {
			try {
				do {
					mostraMensagem("Cadastre um codigo para o " + tipo);
					codigo = (int) Leitura.leNumero();
				} while ((tipo == "pintor") ? !Validacao.isCodigoValidoPintor(codigo, galeria)
						: !Validacao.isCodigoValidoQuadro(codigo, galeria));
				erro = false;
			} catch (InputMismatchException e) {
				mensagemValorIncoerente();
				erro = true;
			}
		}
		return codigo;
	}

	public static int cadastraAno(String tipo) {
		int ano = 0;
		boolean erro = true;
		while (erro) {
			try {
				do {
					mostraMensagem((tipo == "pintor") ? "Insira ano de nascimento do pintor:"
							: "Insira ano de aquisicao do quadro:");
					ano = (int) Leitura.leNumero();
				} while (!Validacao.isAno(ano));
				erro = false;
			} catch (InputMismatchException e) {
				mensagemValorIncoerente();
				erro = true;
			}
		}

		return ano;
	}

	// menus

	public static boolean mostraMenuInicial(Galeria galeria) {
		limpaTela(5);
		mostraOpcoesMenuInicial();
		boolean continuar = true;

		switch (perguntaOpcao(4)) {

		case 0:
			continuar = false;
			encerraPrograma();
			break;
		case 1:
			mostraMenuQuadro(galeria);
			break;
		case 2:
			cadastraPintor(galeria);
			break;
		case 3:
			mostraQuadrosPintor(galeria);
			break;
		case 4:
			mostraQuadros(galeria.getQuadros());
			break;
		}
		return continuar;
	}

	private static int perguntaOpcao(int MAX) {

		boolean erro = true;
		int opcao = -1;
		while (erro) {
			try {
				do {
					mostraMensagem("Digite a opcao desejada:");
					opcao = (int) Leitura.leNumero();
				} while (!Validacao.isOpcao(opcao, MAX));
				erro = false;
			} catch (InputMismatchException e) {
				mensagemValorIncoerente();
				erro = true;
			}
		}

		return opcao;
	}

	private static void mostraOpcoesMenuInicial() {
		mostraMensagem("Escolha a opcao desejada:");
		mostraMensagem("[1] - Cadastrar um novo quadro.");
		mostraMensagem("[2] - Cadastrar um novo pintor.");
		mostraMensagem("[3] - Listar quadros, e respectivos valores deles, de um pintor (pesquisa por nome).");
		mostraMensagem("[4] - Mostrar todos os quadros cadastrados.");
		mostraMensagem("[0] - Encerrar o programa.");
	}

	private static void mostraOpcoesMenuCadastroQuadro() {
		mostraMensagem("Escolha a opcao:");
		mostraMensagem("[1] - Inserir quadro pelo nome de um pintor ja cadastrado.");
		mostraMensagem("[2] - Inserir novo pintor.");
		mostraMensagem("[3] - Verificar pintores cadastrados.");
		mostraMensagem("[0] - Retornar ao menu anterior");
	}

	public static void mostraMenuQuadro(Galeria galeria) {
		limpaTela(5);
		mostraOpcoesMenuCadastroQuadro();

		limpaTela(3);
		switch (perguntaOpcao(3)) {

		case 0:
			break;
		case 1:
			Pintor pintor;
			pintor = galeria.getPintorPorNome(cadastraNome());
			if (pintor == null) {
				mostraMensagem("Pintor nao encontrado.");
			} else
				cadastraQuadro(galeria, pintor);
			break;
		case 2:
			cadastraQuadro(galeria, cadastraPintor(galeria));
			break;
		case 3:
			mostraPintores(galeria);
			break;

		}

	}

	// apresentacao de dados

	public static void mostraQuadros(ArrayList<Quadro> quadros) {
		limpaTela(30);

		if (quadros.size() > 0) {
			mostraMensagem("Quadros cadastrados");
			mostraMensagem("  CODIGO    |  ANO DE AQUISICAO  | PINTOR                                    | PRECO ");
			for (int pos = 0; pos < quadros.size(); pos++)
				imprimeLinhaQuadro(quadros.get(pos));

		} else
			mostraMensagem("Nenhum quadro cadastrado.");

	}

	public static void mostraPintores(Galeria galeria) {
		limpaTela(30);

		if (galeria.getPintores().size() > 0) {
			mostraMensagem("Pintores cadastrados:");
			mostraMensagem("  CODIGO    | NOME                                      ");
			for (int pos = 0; pos < galeria.getQuadros().size(); pos++)
				imprimeLinhaPintor(galeria.getPintores().get(pos));
		} else
			mostraMensagem("Nenhum pintor cadastrado.");

	}

	public static void mostraQuadrosPintor(Galeria galeria) {

		limpaTela(30);
		mostraMensagem("Insira nome do pintor a ser procurado:");
		String nomeProcurado = Leitura.leString();
		ArrayList<Quadro> quadros = galeria.getQuadrosPorNome(nomeProcurado);
		if (quadros.size() == 0)
			mostraMensagem("Nenhum quadro pelo nome procurado: " + nomeProcurado);
		else
			mostraQuadros(quadros);

		float total = 0f;
		
		for (int cont = 0; cont < quadros.size(); cont++)
			total += quadros.get(cont).getPreco();

		mostraMensagem("Valor total dos quadros desse pintor: " + new DecimalFormat("0.00").format(total));

	}

	private static void imprimeLinhaPintor(Pintor pintor) {
		ajustaTexto(pintor.getCodigo().toString(), 12);
		mostraMensagem(pintor.getNome().toUpperCase());

	}

	private static void imprimeLinhaQuadro(Quadro quadro) {
		ajustaTexto(quadro.getCodigo().toString(), 12);
		ajustaTexto(quadro.getAnoDeAquisicao().toString(), 20);
		ajustaTexto(quadro.getPintor().getNome().toUpperCase(), 43);
		mostraMensagem(new DecimalFormat("0.00").format(quadro.getPreco()));

	}

	// mensagens

	public static void mensagemValorIncoerente() {
		mostraMensagem("Ocorreu um erro. Digite apenas numeros.");
	}

	public static void mensagemValorInvalido(String parametro) {
		mostraMensagem("O valor inserido esta de acordo com o parametro exigido: " + parametro);
	}

	public static void mostraMensagem(String msg) {
		System.out.println(msg);
	}

	public static void encerraPrograma() {
		mostraMensagem("Programa encerrado com sucesso!");
	}

	// funcionalidades

	private static void ajustaTexto(String texto, int tamanho) {
		System.out.print(" " + texto);
		for (int cont = texto.length() + 1; cont < tamanho; cont++)
			System.out.print(" ");
		System.out.print("|");
	}

	public static void limpaTela(int linhas) {
		for (int cont = 0; cont < linhas; cont++)
			System.out.println();
	}

}
