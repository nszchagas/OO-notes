package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static StringBuilder validaNome() {
		String nome;
		StringBuilder nomeDinamico = new StringBuilder();
		
		do {
			System.out.print("\nDigite o seu nome completo: ");
			nome = Leitura.lerString();
			
			if(nome.length() <= 2 || nome == null)
				System.err.println("Tamanho inválido !! Informe o seu nome completo");
			
			if (nome.split(" ")[0].equals(nome))
				System.err.println("Informe o seu sobrenome também !!");
			
		} while(nome.length() <= 2 || nome == null || nome.split(" ")[0].equals(nome) );
		
		nomeDinamico.append(nome);
		return nomeDinamico;
	}
	
	public static char validaSituacaoSaude() {
		char situacao;
		
		do {
			Visao.menuSituacao();
			System.out.print("Digite uma das alternativas acima !! Respeite a letra designada para cada opção: ");
			situacao = Leitura.lerCaracter();
			
			if (situacao != 'T' && situacao != 'F' && situacao != 'C' && situacao != 'S')
				System.err.println("Alternativa inválida !! Se atente para as opções dadas e digite apenas a letra adequada.");
			
		} while(situacao != 'T' && situacao != 'F' && situacao != 'C' && situacao != 'S');

		
		return situacao;
	}
	
	public static int validaIdade() {
		int idade;
		
		do {
			try {
				System.out.print("\nDigite a sua idade em anos completos (para bebê que não completou 1 ano completo, digie zero) : ");
				idade = Leitura.lerInteiro();
				
				if (idade < 0 || idade > 150)
					System.err.println("Não são aceitas idades menores que 0 e maiores que 150 !! Digite uma idade válida");
				
			} catch (InputMismatchException e) {
				System.err.println("Entrada com tipo inválido !! Digite apenas o número da sua idade");
				idade = -1;
			}
		} while(idade < 0 || idade > 150);
		
		return idade;
	}
	
	public static char validaGestacao() {
		char gestacao;
		
		do {
			Visao.menuGestacao();
			System.out.print("Digite uma das alternativas acima !! Respeite a letra designada para cada opção: ");
			gestacao = Leitura.lerCaracter();
			
			if (gestacao != 'S' && gestacao != 'N' && gestacao != 'T' )
				System.err.println("Alternativa inválida !! Se atente para as opções dadas e digite apenas a letra adequada.");
			
		} while(gestacao != 'T' && gestacao != 'S' && gestacao != 'N');
		
		return gestacao;
	}
	

	
	public static int validaOpcaoSexo() {
		int opcao;
		
		do {
			try {
				Visao.menuSexo();
				System.out.print("Digite uma das opções acima !! (Somente o número): ");
				opcao = Leitura.lerInteiro();
				
				if (opcao != 1 && opcao != 2)
					System.err.println("Opcao invalida !! Digite '1' para homem, '2' para mulher !!");
			} catch(InputMismatchException e) {
				System.err.println("Formato inválido !! Digite apenas o numero correspondente a opcao que deseja");
				opcao = 0;
			}
		} while(opcao != 1 && opcao != 2);
		
		return opcao;
	} 
	
	public static int validaOpcaoMenuPrincipal() {
		int opcao; 
		
		do {
			try {
				Visao.exibirMenuPrincipal();
				System.out.print("Digite uma das opções acima !! (Somente o número): ");
				opcao = Leitura.lerInteiro();
				
				if (opcao != 1 && opcao != 2 && opcao != 0 )
					System.err.println("Opcao invalida !! Digite somenete o numero da opcao desejada");
				
			} catch(InputMismatchException e) {
				System.err.println("Formato inválido !! Digite apenas o numero correspondente a opcao que deseja");
				opcao = -1;
			}
		} while(opcao != 1 && opcao != 2 && opcao != 0 );
		
		return opcao;
	}
}
