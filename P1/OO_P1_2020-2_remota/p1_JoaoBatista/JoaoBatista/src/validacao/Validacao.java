package validacao;

import java.util.ArrayList;
import java.util.InputMismatchException;

import dados.PessoaContaminada;
import dados.PessoaNaoContaminada;
import dados.Populacao;
import leitura.Leitura;
import principal.Principal;
import saida.Saida;

public class Validacao {

		public static StringBuilder validaNome() {
			String nome;
	
			Saida.solicitarInput("o nome completo da pessoa");
			do {
				nome = Leitura.scanString();
				if (nome.isEmpty() || nome.isBlank())
					Saida.entradaInvalida("Entrada nao pode estar vazia");
				
				else if(nome.split(" ")[0].length()<3)
					Saida.entradaInvalida("Nome deve ter um minimo de 3 caracteres");
				
				else if(!nome.contains(" "))
					Saida.entradaInvalida("Nome completo deve consistir em mais de uma palavra");
	
			} while (nome.isEmpty() || nome.isBlank() || !nome.contains(" ") || nome.split(" ")[0].length()<3);
	
			return new StringBuilder (nome);
		}
		

		public static int validaCodigo(Populacao populacao) {
			final int MINIMO = 1;
			int cod;

			Saida.solicitarInput("o codigo identificador da pessoa");
			do {
				try {
					cod = Leitura.scanInt();
					if (cod < 1) {
						Saida.entradaInvalida("Identificador deve maior que "+MINIMO);	
						cod = validaCodigo(populacao);
					}
					
					else if (codigoExiste(cod, populacao)) {
						Saida.entradaInvalida("Identificador nao disponivel");	
						cod = validaCodigo(populacao);
					}
						
				} catch (InputMismatchException exception) {
					Saida.entradaInvalida("Identificador deve ser um numero");
					cod = validaCodigo(populacao);
				}

			} while (cod < 1 || codigoExiste(cod, populacao));

			return cod;
		}

		private static boolean codigoExiste(int cod, Populacao populacao) {
			for(PessoaContaminada pessoa: populacao.getPopulacaoContamin()) {
				if(cod == pessoa.getCodigo())
					return true;
			}
			for(PessoaNaoContaminada pessoa: populacao.getPessoaNaoContaminada()) {
				if(cod == pessoa.getCodigo())
					return true;
			}
			
			return false;
		}


		public static char validaOpcaoMenu() {
			char opcao;
	
			do {
				try {
					opcao = Leitura.scanChar();

					if (opcao < '0' || opcao > '2') {
						Saida.entradaInvalida("Opcao invalida, escolha uma das opcoes do menu");
						opcao = validaOpcaoMenu();
					}
						
				}catch(StringIndexOutOfBoundsException except) {
					Saida.entradaInvalida("Entrada nao pode estar vazia");
					opcao = validaOpcaoMenu();
				}
				
			} while (opcao < '0' || opcao > '2');
	
			return opcao;
		}
		
		public static char validaOpcaoEstado() {
			char opcao;
			
			do {
				try {
					Saida.imprimeOpcoesEstado();
					opcao = Leitura.scanChar();

					if (opcao != 'E' && opcao != 'C' && opcao != 'F') {
						Saida.entradaInvalida("Opcao invalida, escolha uma das opcoes do menu");
						opcao = validaOpcaoEstado();
					}
						
				}catch(StringIndexOutOfBoundsException except) {
					Saida.entradaInvalida("Entrada nao pode estar vazia");
					opcao = validaOpcaoEstado();
				}
				
			} while (opcao != 'E' && opcao != 'C' && opcao != 'F');
	
			return opcao;
		}
		
		public static int validaIdade() {
			int idade;

			Saida.solicitarInput("a idade da pessoa");
			do {
				try {
					idade = Leitura.scanInt();
					if (idade < 0 || idade > 130) {
						Saida.entradaInvalida("Idade deve estar entre 0 (para menores de 1 ano) e 130");	
						idade = validaIdade();
					}
						
				} catch (InputMismatchException exception) {
					Saida.entradaInvalida("Idade deve ser um numero");
					idade = validaIdade();
				}

			} while (idade < 0 || idade > 130);

			return idade;
		}
		
		public static char validaOpcaoContaminacao() {
			char opcao;
	
			Saida.solicitarInput("'C' caso a pessoa esteja contaminada e 'N' caso contrario");;
			do {
				try {
					opcao = Leitura.scanChar();
					
					if (opcao != 'C' && opcao != 'N') {
						Saida.entradaInvalida("Opcao invalida");
						opcao = validaOpcaoContaminacao();
					}
						
				}catch(StringIndexOutOfBoundsException except) {
					Saida.entradaInvalida("Entrada nao pode estar vazia");
					opcao = validaOpcaoContaminacao();
				}

			} while (opcao != 'C' && opcao != 'N');
	
			return opcao;
		}
		
		public static char validaGenero() {
			char opcao;
	
			Saida.solicitarInput("o genero da pessoa ('M' para masculino e 'F' para feminino)");;
			do {
				try {
					opcao = Leitura.scanChar();
					
					if (opcao != 'M' && opcao != 'F') {
						Saida.entradaInvalida("Opcao invalida");
						opcao = validaGenero();
					}
						
				}catch(StringIndexOutOfBoundsException except) {
					Saida.entradaInvalida("Entrada nao pode estar vazia");
					opcao = validaGenero();
				}

			} while (opcao != 'M' && opcao != 'F');
	
			return opcao;
		}
		
		public static void validaPessoa(Populacao populacao) {
			Saida.novoCadastro();
			char opcao = Validacao.validaOpcaoContaminacao();
			switch(opcao) {
				case 'N':
					populacao.addPessoaNaoContaminada(new PessoaNaoContaminada(Validacao.validaNome(), Validacao.validaGenero(), Validacao.validaCodigo(populacao), Validacao.validaIdade()));
					break;
				case 'C':
					populacao.addPessoaContaminada(new PessoaContaminada(Validacao.validaNome(), Validacao.validaGenero(), Validacao.validaCodigo(populacao), Validacao.validaOpcaoEstado()));
			}
			Saida.limpaTela(20);
		}
		
}
	
