package validacao;

import dados.Populacao;
import leitura.Leitura;
import saida.Visao;

public class Validacao {

	public static char validaMenu(Populacao populacao) {
		// Declaracoes
		char opcao;

		// Instrucoes
		Visao.mostraMenu(populacao);
		opcao = Leitura.lerEntrada().charAt(0);
		if (!("012").contains(Character.toString(opcao))) {
			Visao.mostraMensagemErro("Opcao invalida, entre com '0', 1' ou '2'");
			opcao = validaMenu(populacao);
		}
		return opcao;
	}
	
	public static String validaNome() {
		String nome = Leitura.lerEntrada();
		
		while(nome.length() < 3 || nome.isEmpty()) {
			
			Visao.mostraMensagemErro("Nome Invalido! Digite Novamente: ");
			nome = Leitura.lerEntrada();
			
		}
		
		return nome;
	}
	
}
