package saida;

import java.text.DecimalFormat;
import dados.Pessoa;
import dados.Populacao;

public class Visao {
	public static void mostraMenu (String [] opcoes) {
		for (String opcao : opcoes) {
			mostraMensagem(opcao);
		}
	}
	
	public static void mostraMensagem (String mensagem) {
		System.out.println(mensagem);
	}
	
	public static void mostraMensagemErro (String mensagem) {
		System.err.println(mensagem);
	}
	
	public static void mostraRegistros (Populacao populacao) {
		limpaTela(50);
		System.out.format("%-30s%-50s%-30s%-20s%-50s\n", "IDENTIFICACAO", "NOME", "GENERO", "IDADE", "SITUACAO DE SAUDE");
		for (Pessoa pessoa : populacao.getPopulacao()) {
			System.out.println(pessoa);
		}
	}
	
	public static void mostraResultadoFinal (Populacao populacao) {
		DecimalFormat mascara = new DecimalFormat("00");
		mostraMensagem(mascara.format(populacao.qtdNaoContaminados()) + " = NÃO CONTAMINADOS");
		mostraMensagem(mascara.format(populacao.qtdContaminadosTratamento()) + " = CONTAMINADOS EM TRATAMENTO");
		mostraMensagem(mascara.format(populacao.qtdContaminadosCurados()) + " = CONTAMINADOS CURADOS");
		mostraMensagem(mascara.format(populacao.qtdMulheresFalecidas()) + " = MULHERES CONTAMINADAS FALECIDAS");
		mostraMensagem(mascara.format(populacao.qtdHomensFalecidos()) + " = HOMENS CONTAMINADOS FALECIDOS");
		mostraMensagem(mascara.format(populacao.getPopulacao().size()) + " = TOTAL DE PESSOAS CADASTRAS");
	}
	
	public static void limpaTela (int qtd) {
		for (int i = 0; i < qtd; i++) {
			System.out.println();
		}
	}
}
