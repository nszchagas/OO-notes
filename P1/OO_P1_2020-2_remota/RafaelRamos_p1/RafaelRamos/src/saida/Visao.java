package saida;

import java.text.DecimalFormat;

import dados.Pessoa;
import dados.Populacao;
import servicos.Servicos;

public class Visao {
	public static void mostraMsg(String mensagem) {
		System.out.println(mensagem);
	}

	public static void mostraMsgErro(String mensagem) {
		System.err.println(mensagem);
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}

	public static void mostraRelatorioRegistros(Populacao populacao) {
		limpaTela(2);
		//CABEÇALHO
		System.out.format("%-15s%-35s%-30s%-20s%-20s%-2s", "NUMERO CADASTRO", "|       NOME COMPLETO","| ESTADO DE SAUDE","| IDADE","| FOI GESTANTE","|");
		mostraMsg("\n=========================================================================================================================");
		//CORPO
		for(Pessoa pessoa : populacao.getPopulacao()) {
			System.out.println(pessoa);
		}
		limpaTela(1);
	}
	public static void mostraAnaliseContaminados(Populacao populacao) {
		int contaminados[] = Servicos.calculaContaminados(populacao);
		DecimalFormat mascara = new DecimalFormat("00");
		limpaTela(40);
		mostraMsg(mascara.format(contaminados[0]) + " = CONTAMINADOS(AS) CURADOS(AS)");
		mostraMsg(mascara.format(contaminados[1]) + " = CONTAMINADOS(AS) EM TRATAMENTO");
		mostraMsg(mascara.format(contaminados[2]) + " = CONTAMINADOS(AS) FALECIDOS(AS)");
		mostraMsg(mascara.format(contaminados[3]) + " = HOMENS SEM CONTAMINACAO");
		mostraMsg(mascara.format(contaminados[4]) + " = MULHERES SEM CONTAMINACAO");
		mostraMsg(mascara.format(populacao.getPopulacao().size()) + " = TOTAL DE REGISTRO DE PESSOAS");
	}
}
