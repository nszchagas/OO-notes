package saida;

import java.util.Vector;

import dados.GrupoPessoas;
import dados.Pessoa;

public final class Saida {
	public static void limpaTela(int quantidade) {
		while (quantidade-- > 0)
			System.out.println();
	}

	public static void mostraMensagem(String msg) {
		limpaTela(2);
		System.out.println(msg);
	}

	public static void mostraErro(String msg) {
		System.err.println(msg);
	}

	private static void mostraCabecalho() {
		limpaTela(50);
		String formato = "%-18.18s %-20.20s %-30.30s %-10.10s %s";
		System.out.println(
				String.format(formato, "Identificador", "Nome completo", "Situacao de saude", "Idade", "Situacao gestante"));
		mostraLinha(95);
	}
	
	public static void mostraRelatorioRegistros(Vector<Pessoa> grupo) {
		mostraCabecalho();
		for (Pessoa pessoa: grupo)
			System.out.println(pessoa);
	}
	
	public static void mostraRelatorioFinal(GrupoPessoas pessoas) {
		limpaTela(40);
		System.out.println(String.format("%02d = %s", pessoas.somaSituacaoSaude('C'), "CONTAMINADOS CURADOS"));
		System.out.println(String.format("%02d = %s", pessoas.somaSituacaoSaude('T'), "CONTAMINADOS EM TRATAMENTO"));
		System.out.println(String.format("%02d = %s", pessoas.somaSituacaoSaude('F'), "CONTAMINADOS FALECIDOS"));
		System.out.println(String.format("%02d = %s", pessoas.somaSituacaoSaude('S', 'H'), "HOMENS SEM CONTAMINACAO"));
		System.out.println(String.format("%02d = %s", pessoas.somaSituacaoSaude('S', 'M'), "MULHERES SEM CONTAMINACAO"));
		mostraLinha(30);
		System.out.println(String.format("%02d = %s", pessoas.getPessoas().size(), "TOTAL DE REGISTRO DE PESSOAS"));
	}

	private static void mostraLinha(int qtd) {
		while (qtd-- > 0)
			System.out.print("-");
		System.out.println();
	}
}
