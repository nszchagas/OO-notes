package saida;

import java.text.DecimalFormat;

import dados.GrupoPessoa;
import dados.Pessoa;

public class Visao {
	
	public static void limpaTela(int linhas) {
		for(int pulos = 0; pulos < linhas; pulos++)
			System.out.println();
	}

	public static void mostraTabela(GrupoPessoa grupoCovid) {
		limpaTela(20);
		System.out.format("%-15s%-15s%-15s%-15s%-15s\n", "ID", "NOME", "GENERO", "IDADE", "SAUDE");
		for (Pessoa pessoa : grupoCovid.getGrupoCovid()) {
			System.out.println(pessoa);
		}
		
	}

	public static void mostraMenuPessoa() {
		mostraMsg("[1] - Pessoa que tem ou já teve COVID");
		mostraMsg("[2] - Pessoa que nunca teve COVID");
		
	}

	public static void mostraMsgErro(String string) {
		System.err.println(string);
		
	}

	public static void mostraMenuInicial() {
		limpaTela(2);
		mostraMsg("[1] - Cadastrar uma pessoa");
		mostraMsg("[2] - Mostrar todos cadastrados");
		mostraMsg("[0] - Fechar programa");		
	}

	public static void mostraMsg(String string) {
		System.out.println(string);
		
	}

	public static void mostraFinal(GrupoPessoa grupoCovid) {
		limpaTela(50);
		DecimalFormat fomato = new DecimalFormat("00");
		mostraMsg(String.format("%-7s%s", fomato.format(grupoCovid.getQtdNaoContaminados()), "= NAO CONTAMINADOS"));
		mostraMsg(String.format("%-7s%s", fomato.format(grupoCovid.getQtdContaminadosEmTratamento()), "= CONTAMINADOS EM TRATAMENTO"));
		mostraMsg(String.format("%-7s%s", fomato.format(grupoCovid.getQtdContaminadosCurados()), "= CONTAMINADOS CURADOS"));
		mostraMsg(String.format("%-7s%s", fomato.format(grupoCovid.getQtdMulheresFalecidas()), "= MULHERES CONTAMINADAS FALECIDAS"));
		mostraMsg(String.format("%-7s%s", fomato.format(grupoCovid.getGrupoCovid().size()), "= TOTAL DE PESSOAS CADASTRADAS"));		
	}

}
