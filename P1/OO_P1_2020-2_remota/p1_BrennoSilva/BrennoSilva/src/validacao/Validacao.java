package validacao;

import java.util.InputMismatchException;

import dados.GrupoPessoa;
import dados.Pessoa;
import leitura.Leitura;
import saida.Visao;

public class Validacao {

	public static int validaContinua() {
		int opcao = -1;
		
		do {
			try {
				Visao.mostraMenuInicial();
				opcao = Leitura.lerInt();
				
				if(opcao != 1 && opcao != 2 && opcao != 0)
					Visao.mostraMsgErro("Valor invalido! Apenas 0, 1 e 2 sao validos");
			}catch (InputMismatchException excecao) {
				Visao.mostraMsgErro("Valor invalido! O numero nao deve estar por extenso!");
			}			
		}while(opcao != 1 && opcao != 2 && opcao != 0);
		return opcao;
	}

	public static int validaCadastro() {
		int opcao = 0;
		
		do {
			try {
				Visao.mostraMenuPessoa();
				opcao = Leitura.lerInt();
				
				if(opcao != 1 && opcao != 2)
					Visao.mostraMsgErro("Valor invalido! Apenas 1 e 2 sao validos");
			}catch (InputMismatchException excecao) {
				Visao.mostraMsgErro("Valor invalido! O numero nao deve estar por extenso!");
			}			
		}while(opcao != 1 && opcao != 2);
		return opcao;
	}

	public static int validaIdentificacao(int minimo, GrupoPessoa grupoCovid) {
		int id = 0;
		
		do {
			try {
				Visao.mostraMsg("Insira o ID da pessoa:");
				id = Leitura.lerInt();
				
				if(id < minimo)
					Visao.mostraMsgErro("Id invalido! O id deve ser maior que 0! Tente novamente!");
			}catch (InputMismatchException excecao) {
				Visao.mostraMsgErro("Valor invalido! O numero nao deve estar por extenso! Tente novamente!");
			}
		}while(id < minimo || !verificaId(id, grupoCovid));
		return id;
	}

	private static boolean verificaId(int id, GrupoPessoa grupoCovid) {
		for (Pessoa pessoa : grupoCovid.getGrupoCovid()) {
			if(id == pessoa.getIdentificacao()) {
				Visao.mostraMsgErro("ID já cadastrado! Tente novamente!");
				return false;
			}
		}
		return true;
	}

	public static StringBuilder validaNome() {
		StringBuilder nome;
		
		do {
			Visao.mostraMsg("Insira o nome da pessoa: ");
			nome = new StringBuilder(Leitura.lerString());
			
			if(nome.length() < 3)
				Visao.mostraMsgErro("O nome deve ter mais de tres caracteres!");
			if(!nome.toString().contains(" "))
				Visao.mostraMsgErro("O nome deve estar completo!");
		}while(nome.length() < 3 || !nome.toString().contains(" "));
		return nome;
	}

	public static char validaGenero() {
		char genero;
		
		do {
			Visao.mostraMsg("Insira o genero(F ou M) da pessoa: ");
			genero = Leitura.lerChar();
			
			if(genero != 'F' && genero != 'M')
				Visao.mostraMsgErro("Apenas F(feminino) e M(masculino) sao aceitos!");
		}while(genero != 'F' && genero != 'M');
		return genero;
	}

	public static char validaSituacao() {
		char situacao;
		
		do {
			Visao.mostraMsg("Insira situacao(E, F ou C) da pessoa: ");
			situacao = Leitura.lerChar();
			
			if(situacao != 'E' && situacao != 'F' && situacao != 'C')
				Visao.mostraMsgErro("Apenas E(em tratamento), F(falecido) e C(Curado) sao aceitos!");
		}while(situacao != 'E' && situacao != 'F' && situacao != 'C');
		return situacao;
	}

	public static int validaIdade() {
		int idade = -1;
		final int IDADE_MINIMA = 0;
		final int IDADE_MAXIMA = 130;
		
		do {
			try {
				Visao.mostraMsg("Insira a idade da pessoa:");
				idade = Leitura.lerInt();
				
				if(idade < IDADE_MINIMA || idade > IDADE_MAXIMA)
					Visao.mostraMsgErro("Idade invalida! A idade deve ser maior ou igual a 0 e menor ou igual a 130! Tente novamente!");
			}catch (InputMismatchException excecao) {
				Visao.mostraMsgErro("Valor invalido! O numero nao deve estar por extenso! Tente novamente!");
			}
		}while(idade < IDADE_MINIMA || idade > IDADE_MAXIMA);
		return idade;
	}

}
