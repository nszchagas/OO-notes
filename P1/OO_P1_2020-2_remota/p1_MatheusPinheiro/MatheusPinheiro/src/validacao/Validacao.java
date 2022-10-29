package validacao;

import java.util.InputMismatchException;

import dados.*;
import leitura.Leitura;
import saida.Saida;

public class Validacao {
	public static int validaMenuFinal() {
		int escolha = 0;
		final int MAX = 2;
		do {
			try {
				Saida.mostraMenuResultado();
				escolha = Leitura.getInt();
				if(escolha <0 || escolha > MAX) {
					Saida.mensagemEntradaInvalida(" deve ser um inteiro, entre 0 e 2, referente a sua escolha!");
				}
			}catch(InputMismatchException e) {
				Saida.mensagemTipoEntradaInvalida("deve ser um inteiro, entre 0 e 2, referente a sua escolha!");
			}
		}while(escolha <0 || escolha > MAX);
		return escolha;
	}
	public static int validaMenuInicio() {
		int escolha = 0;
		final int MAX = 2;
		do {
			try {
				Saida.mostraMenuCadastro();
				escolha = Leitura.getInt();
				if(escolha <1 || escolha > MAX) {
					Saida.mensagemEntradaInvalida(" deve ser um inteiro, entre 0 e 2, referente a sua escolha!");
				}
			}catch(InputMismatchException e) {
				Saida.mensagemTipoEntradaInvalida("deve ser um inteiro, entre 0 e 2, referente a sua escolha!");
			}
		}while(escolha <1 || escolha > MAX);
		return escolha;
	}
	
	public static String validaSituacao() {
		//Declaracoes
		char situacao = ' ';
		
		//Instrucoes
		do {
			Saida.solicitacaoDados(" a situacao da pessoa: 'E' para em tratamento, 'F' para falecido, 'C' para curado.");	
			situacao = Leitura.getString().charAt(0);
			
			if(situacao != 'E' && situacao != 'F' && situacao != 'C') {
				System.out.println("Escolha invalida!");
			}
		}while(situacao != 'E' && situacao != 'F' && situacao != 'C');
		
		return ((situacao == 'E') ? "Em tratamento" : ((situacao == 'F') ? "Falecido" : "Curado"));
	}
	
	public static int validaIdade() {
		int idade = 0;
		final int MAX = 130;
		
		do {
			try {
				Saida.solicitacaoDados(" a idade: ");
				idade = Leitura.getInt();
				if(idade<0 || idade > MAX) {
					Saida.mensagemEntradaInvalida(" deve ter no minino 0 e no maximo 130!");
				}
			}catch(InputMismatchException e) {
				Saida.mensagemTipoEntradaInvalida(" deve ser um inteiro! De no minimo 0 e no maximo 130");
			}
		}while(idade<0 || idade > MAX);
		return idade;
	}
	public static int validaIndentificador(Populacao populacao) {
		int identificador = 0;
		
		do {
			try {
				Saida.solicitacaoDados(" o numero identificador:");
				identificador = Leitura.getInt();
				if(identificador < 1) {
					Saida.mensagemEntradaInvalida(" deve ser no minimo 1");
				}
				if(validaExistenciaIdentificador(populacao, identificador)) {
					Saida.mensagemEntradaInvalida(" identificacao ja cadastrada! Cadastre outra!");
				}
			}catch(InputMismatchException e) {
				Saida.mensagemTipoEntradaInvalida(" deve ser um inteiro, com valor maior ou igual a 1 e unico");
			}
		}while(identificador < 0 || validaExistenciaIdentificador(populacao, identificador));
		return identificador;
	}
	public static boolean validaExistenciaIdentificador(Populacao populacao, int identificador) {
		for(Pessoa pessoa : populacao.getPopulacao())
			if(pessoa.getIdentificador() == identificador)
				return true;
		return false;
	}
	public static String validaNome() {
		String linha = " ";
		do {
			Saida.solicitacaoDados(" o nome:");
			linha = Leitura.getString();
			if(validaDigito(linha)) {
				Saida.mensagemEntradaInvalida("Deve ser o nome inteiro, sem algarismos");
			}
			if(linha.length() < 4) {
				Saida.mensagemEntradaInvalida("Deve ser o nome inteiro, deve ter mais de 3 caracteres");
			}
		}while(linha.length() < 4 || validaDigito(linha));
		
		return linha;
	}
	public static String validaGenero() {
		//Declaracoes
		char genero = ' ';
		
		//Instrucoes
		do {
			Saida.solicitacaoDados(" o genero da pessoa cadastrada: 'M' para Masculino e 'F' para Femenino");
			genero = Leitura.getString().charAt(0);
			
			if(genero != 'M' && genero != 'F') {
				System.out.println("Escolha invalida!");
			}
		}while(genero != 'M' && genero != 'F');
		
		return ((genero =='M') ? "Masculino" : "Femenino");	
	}
	public static boolean validaDigito(String linha) {
		for(char c : linha.toCharArray())
			if(Character.isDigit(c))
				return true;	
		return false;
	}
}
