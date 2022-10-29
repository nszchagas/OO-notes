package saida;

import dados.Populacao;

public class Saida {
	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
	
	public static void mostraMenu() {
		limpaTela(3);
		System.out.println("[1] - Cadastrar pessoa.");
		System.out.println("[2] - Mostrar todos cadastros.");
		System.out.println("[0] - Encerrar programa.");
		System.out.print("Digite a opcao: ");
	}

	public static void mostraOpcoesPessoa() {
		limpaTela(30);
		System.out.println("[1] - Cadastrar pessoa saudavel.");
		System.out.println("[2] - Cadastrar pessoa contaminada.");
		System.out.print("Digite a opcao: ");
		
	}

	public static void mostraCadastros(Populacao populacao) {
		limpaTela(50);
		System.out.println("Todos cadastros feitos ate agora: ");
		System.out.println(populacao);
	}

	public static void mostraTotal(Populacao populacao) {
		limpaTela(50);
		
		System.out.println("Cadastros realizados: ");
		System.out.println(populacao.nSaudaveis() + " = NÃO CONTAMINADOS");
		System.out.println(populacao.nContaminados('E') + " = CONTAMINADOS EM TRATAMENTO");
		System.out.println(populacao.nContaminados('C') + " = CONTAMINADOS CURADOS");
		System.out.println(populacao.nFalecidos('F') + " = MULHERES CONTAMINADAS FALECIDAS");
		System.out.println(populacao.nFalecidos('M') + " = HOMENS CONTAMINADOS FALECIDOS");
		System.out.println(populacao.nPessoas() + " = TOTAL DE PESSOAS CADASTRAS");
	}
}
