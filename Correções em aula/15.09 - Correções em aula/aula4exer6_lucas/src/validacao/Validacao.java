package validacao;

import leitura.Leitor;

public class Validacao {
	
	public static String validaNome(String nome) {
		while(nome.isEmpty()) {
			System.out.println("Campo não pode estar vazio! Informe um nome:");
			nome =  Leitor.lerNome();
		}
		return nome;
	}
	
	public static boolean validaEscolha(char escolha) {
		while(escolha != 's' && escolha != 'n') {
			System.out.println("Digite S para cadastrar e N para sair:");
			escolha = Leitor.lerEscolha();
		}
		
		return escolha == 's';
	}

}
