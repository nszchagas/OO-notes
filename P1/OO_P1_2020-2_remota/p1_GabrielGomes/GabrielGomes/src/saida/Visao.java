package saida;

import dados.Populacao;

public class Visao {

	public static void mostraMenu(Populacao populacao) {
		Visao.limpaTela(3);
		mostraMensagem("Total Registrados: " + populacao.getPopulacao().size()
				+ "\nEscolha uma das opcoes a seguir \n[0] - Encerrar\n[1] - Novo cadastro\n[2] - Mostrar todos cadastros\n");
	}
	
	public static void mostraMensagem(String mensagem) {
		System.out.println(mensagem);
	}
	
	public static void mostraMensagemErro (String mensagem) {
		System.err.println(mensagem);
	}
	
	public static void limpaTela(int linhas) {
		for(int i = 0; i < linhas; i ++) {
			System.out.println();
		}
	}
	
}
