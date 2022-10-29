package valicao;

import dados.Pessoa;
import dados.Populacao;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static String validaNome (String mensagem) {
		String nome;
		
		do {
			nome = Leitura.lerEntradaComEspaco(mensagem);
			if (nome.length() < 3 || isNomeComLetras(nome)) {
				Visao.mostraMensagemErro("Erro, o nome deve possuir ao menos 3 caracteres nao possuir numerais.");
			}
		} while (nome.length() < 3 || isNomeComLetras(nome));
		return nome;
	}
	
	public static int validaInteiro (String mensagem, int min, int max) {
		int valor = min - 1;
		
		do {
			try {
				valor = Integer.parseInt(Leitura.lerEntrada(mensagem));
				if (valor < min || valor > max) {
					Visao.mostraMensagemErro("Erro, o valor deve estar entre " + min + " e " + max + ".");
				}
			} catch (NumberFormatException e) {
				Visao.mostraMensagemErro("Erro, o valor dever ser numerico.");
			}
		} while (valor < min || valor > max);
		return valor;
	}
 
	public static int validaIdentificacao (String mensagem, Populacao populacao) {
		final int MINIMO = 1;
		int identificacao = MINIMO - 1;
		
		do {
			try {
				identificacao = Integer.parseInt(Leitura.lerEntrada(mensagem));
				if (identificacao < 1 || isIdentificacaoRepetida(identificacao, populacao)) {
					Visao.mostraMensagemErro("Erro, a identificacao deve ser no minimo " + MINIMO + " e ser unica.");
				}
			} catch (NumberFormatException e) {
				Visao.mostraMensagemErro("Erro, o valor dever ser numerico.");
			}
		} while (identificacao < 1 || isIdentificacaoRepetida(identificacao, populacao));
		return identificacao;
	}
	
	public static char validaEstadoSaude (String mensagem) {
		char estadoSaude;
		
		do {
			estadoSaude = Leitura.lerEntrada(mensagem).toUpperCase().charAt(0);
			if (estadoSaude != 'E' && estadoSaude != 'F' && estadoSaude != 'C') {
				Visao.mostraMensagemErro("Erro, estado de saude invalido, apenas [E]m tratamento, [F]alecido ou [C]urado");
			}
		} while (estadoSaude != 'E' && estadoSaude != 'F' && estadoSaude != 'C');
		return estadoSaude;
	}
	
	public static char validaGenero (String mensagem) {
		char genero;
		
		do {
			genero = Leitura.lerEntrada(mensagem).toUpperCase().charAt(0);
			if (genero != 'M' && genero != 'F') {
				Visao.mostraMensagemErro("Erro, genero invalido, apenas [M]asculino ou [F]eminino.");
			}
		} while (genero != 'M' && genero != 'F');
		return genero;
	}
	
	private static boolean isIdentificacaoRepetida (int identificacao, Populacao populacao) {
		for (Pessoa pessoa : populacao.getPopulacao()) {
			if (pessoa.getIdentificacao().equals(identificacao)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isNomeComLetras (String nome) {
		for (char c : nome.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
}
