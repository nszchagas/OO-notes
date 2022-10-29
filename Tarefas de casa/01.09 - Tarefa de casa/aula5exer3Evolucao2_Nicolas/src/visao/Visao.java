package visao;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import dados.GrupoHabitantes;
import dados.Habitante;
import leitura.Leitura;
import servicos.Servicos;
import validacao.Validacao;

public class Visao {

	// controle de fluxo

	public static boolean verificaCadastrar(int numCadastro) {
		char opcao = 'K';
		final int MAX = 2;
		if (numCadastro >= MAX) {
			mostraMensagem("Maximo de cadastros alcancado!");
			return false;
		} else {
			do {
				mostraMensagem("Deseja cadastrar um novo habitante?\nDigite 'S' para sim e 'N' para nao");
				opcao = Leitura.leituraChar();
				Visao.limpaTela(2);

			} while (!Validacao.isContinua(opcao));
			if (opcao == 'S')
				mostraMensagem("Insira os dados do " + (numCadastro + 1) + "º habitante:");
		}
		return (opcao == 'S');
	}

	// inserção de dados

	public static Habitante cadastraHabitante() {
		return new Habitante(cadastraSalario(), cadastraIdade(), cadastraSexo(), cadastraNumFilhos());
	}

	private static float cadastraSalario() {
		float salario = -1f;
		boolean erro = true;

		while (erro) {
			try {
				do {
					cadastreDadoHabitante("salario");
					salario = Leitura.leituraFloat();
					Visao.limpaTela(2);
				} while (!Validacao.isSalario(salario));
				erro = false;
			} catch (InputMismatchException excecao) {
				mensagemValorIncoerente();
				erro = true;
			}
		}
		return salario;
	}

	public static int cadastraIdade() {
		int idade = 0;
		boolean erro = true;

		while (erro) {
			try {
				do {
					cadastreDadoHabitante("idade");
					idade = Leitura.leituraInt();
					Visao.limpaTela(2);
				} while (!Validacao.isIdade(idade));
				erro = false;
			} catch (InputMismatchException excecao) {
				mensagemValorIncoerente();
				erro = true;
			}
		}
		return idade;
	}

	public static char cadastraSexo() {
		char sexo;

		do {
			cadastreDadoHabitante("sexo (masculino ou feminino)");
			sexo = Leitura.leituraChar();
			Visao.limpaTela(2);
		} while (!Validacao.isSexo(sexo));
		return sexo;
	}

	public static int cadastraNumFilhos() {
		int numeroFilhos = -1;
		boolean erro = true;

		while (erro) {
			try {
				do {
					cadastreDadoHabitante("numero de filhos");
					numeroFilhos = Leitura.leituraInt();
					Visao.limpaTela(2);
				} while (!Validacao.isNumeroFilhos(numeroFilhos));
				erro = false;
			} catch (InputMismatchException excecao) {
				mensagemValorIncoerente();
				erro = true;
			}
		}
		limpaTela(50);
		return numeroFilhos;
	}

	// apresentação de resultados

	public static void imprimeResultado(GrupoHabitantes grupo) {
		limpaTela(5);
		if (grupo.getHabitantes().size() > 0) {
			imprimeCabecalho();
			imprimeLinhas(grupo);
		}
		mostraMensagem("Programa encerrado com sucesso. Foram feitos " + grupo.getHabitantes().size() + " cadastros.\n");
	}

	private static void imprimeCabecalho() {
		mostraMensagem("                         ----- RESULTADO DO PROCESSAMENTO DE DADOS   ------\n\n");
		
		ajustaTextoTamanho("          Calculo realizado", 60);
		mostraMensagem("  Resultado");
		for (int cont = 0 ; cont < 80 ; cont ++)
			System.out.print("-");
		limpaTela(1);
	}

	private static void imprimeLinhas(GrupoHabitantes grupo) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		ajustaTextoTamanho("Menor idade registrada", 60);
		mostraMensagem(Servicos.getMenorIdade(grupo).toString());
		ajustaTextoTamanho("Maior salario registrado", 60);
		mostraMensagem(mascara.format(Servicos.getMaiorSalario(grupo)));

		ajustaTextoTamanho("Media do número de filhos", 60);
		mostraMensagem(mascara.format(Servicos.getMediaFilhos(grupo)));

		ajustaTextoTamanho("Media do salario das pessoas registradas (em reais)", 60);
		mostraMensagem(mascara.format(Servicos.getMediaSalario(grupo)));

		ajustaTextoTamanho("Media salarial dos homens com salario superior a R$300,00", 60);
		mostraMensagem(mascara.format(Servicos.getMediaHomensAcimaMin(grupo)));

		ajustaTextoTamanho("Quantidade de pessoas com salario acima da media", 60);
		mostraMensagem(Servicos.getPessoasAcimaMediaSalarial(grupo).toString());

	}

	// metodos reutilizaveis //

	private static void cadastreDadoHabitante(String dado) {
		mostraMensagem("Cadastre um valor para " + dado + " do habitante.");
	}

	private static void mensagemValorIncoerente() {
		mostraMensagem("Ocorreu um erro! Digite apenas numeros.");
	}

	public static void mensagemInvalido(String texto) {
		mostraMensagem("O valor inserido nao e valido, nao esta de acordo com os parametros: deve " + texto);
	}

	private static void ajustaTextoTamanho(String texto, int tamanho) {
		System.out.print(texto);
		for (int contador = texto.length(); contador < tamanho; contador++)
			System.out.print(" ");
		System.out.print("| ");
	}

	private static void mostraMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	private static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}

}
