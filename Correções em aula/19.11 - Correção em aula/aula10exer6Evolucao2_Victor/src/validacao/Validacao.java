package validacao;

import leitura.Leitura;
import saida.Saida;

public class Validacao {	
	public static String validaNome() {
		String nome;
		boolean erro;
		
		do {
			erro = false;
			nome = Leitura.lerString("Insira o nome do time.");
			
			if (nome.isEmpty()) {
				erro = true;
				Saida.mostraErro("Nome nao pode ser vazio");
			}
		} while (erro);
		
		return nome;
	}
	
	public static int validaAno() {
		final int ANO_MIN = 1900, ANO_MAX = 2200;
		int ano = -1;
		boolean erro;
		
		do {
			erro = false;
			try {
				ano = Integer.parseInt(Leitura.lerString("Insira um ano em que o time foi campeao."));
				
				if (ano <= ANO_MIN || ano >= ANO_MAX) {
					erro = true;
					Saida.mostraErro("O ano deve estar entre " + ANO_MIN + " e " + ANO_MAX + ".");
				}
			} catch (NumberFormatException ex) {
				erro = true;
				Saida.mostraErro("Digite um numero.");
			}
		} while (erro);
		
		return ano;
	}

	public static boolean validaOutroTitulo() {
		int opcao = Saida.perguntaOutroTitulo();
		return opcao == 0;
	}
}
