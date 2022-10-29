package saida;

import dados.*;

public class Saida {
	public static void apresentaMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	public static void limpaTela(int qtd) {
		for (int i = 0; i < qtd; i++)
			System.out.println();
	}

	public static void apresentaRelatorio(ColecaoEventos colecaoEventos) {
		limpaTela(20);
		
		String formato = "%-10s|%-20s|%-20s\n";

		System.out.format(formato, "ANO", "EVENTO", "PRESIDENTE");
		for(Evento evento : colecaoEventos.getColecaoEventos()) 
			System.out.format(formato, evento.getAno(), evento.getEvento(), evento.getPresidente());
	}

}
