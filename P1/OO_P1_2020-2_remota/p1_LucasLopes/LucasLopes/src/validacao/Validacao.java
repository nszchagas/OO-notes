package validacao;

import leitura.Leitor;
import visao.Visao;
import java.util.InputMismatchException;
import dados.Grupo;

public class Validacao {
	
	public static String validaNome() {
		String nome;
		
		Visao.apresentaMensagem("Digite o nome completo:");
		nome = Leitor.leString();
		if(nome.length() <= 3 || nome == null) {
			Visao.apresentaMensagemErro("Invalido! Nome deve possuir mais de 3 caracteres!");
			return validaNome();
		}
		Visao.limpaTela(5);
		return nome;
	}
	
	public static String validaGenero() {
		char genero;
		
		Visao.apresentaMensagem("Digite o genero: (M = Masculino / F = Feminino)");
		genero = Leitor.leChar();
		switch(genero) {
		case 'M':
			return "Masculino";
		case 'F':
			return "Feminino";
		default:
			Visao.apresentaMensagemErro("Invalido! Digite M ou F!");
			return validaGenero();
		}
		
	}
	
	public static int validaCodigo(Grupo grupo) {
		final int MINIMO = 1;
		int codigo;
		
		Visao.apresentaMensagem("Digite o codigo: (Valor deve ser no minimo " + MINIMO + ")");
		try {
			codigo = Leitor.leInt();
		}catch(InputMismatchException ex) {
			Visao.apresentaMensagemErro("Invalido! Digite APENAS numeros!");
			return validaCodigo(grupo);
		}
		if(codigo < MINIMO) {
			Visao.apresentaMensagemErro("Invalido! Codigo deve ser no minimo " + MINIMO + "!");
			return validaCodigo(grupo);
		}else if(grupo.checaIgualdadeCodigo(codigo)) {
			Visao.apresentaMensagemErro("Invalido! Codigo ja cadastrado!");
			return validaCodigo(grupo);
		}
		Visao.limpaTela(5);
		return codigo;
	}
	
	public static int validaIdade() {
		final int IDADEMINIMA = 0;
		final int IDADEMAXIMA = 130;
		int idade;
		
		Visao.apresentaMensagem("Digite a idade: (Deve ser no minimo " + IDADEMINIMA + " e no maximo " + IDADEMAXIMA + ")");
		try {
			idade = Leitor.leInt();
		}catch(InputMismatchException ex) {
			Visao.apresentaMensagemErro("Invalido! Digite APENAS numeros!");
			return validaIdade();
		}
		if(idade < IDADEMINIMA || idade > IDADEMAXIMA) {
			Visao.apresentaMensagemErro("Invalido!Idade deve ser no minimo " + IDADEMINIMA + " e no maximo " + IDADEMAXIMA + "!");
			return validaIdade();
		}
		Visao.limpaTela(5);
		return idade;
	}
	
	public static String validaSituacaoSaude() {
		char situacao;
		
		Visao.apresentaMenuSituacoes();
		situacao = Leitor.leChar();
		switch(situacao) {
		case 'E':
			return "Em tratamento";
		case 'F':
			return "Falecido";
		case 'C':
			return "Curado";
		default:
			Visao.apresentaMensagemErro("Invalido! Digite E, F ou C!");
			return validaSituacaoSaude();
		}
	}
	
	public static char validaMenu() {
		char opcao;
		
		Visao.apresentaMenu();
		opcao = Leitor.leChar();
		switch(opcao) {
		case '1':
		case '2':
		case '0':
			return opcao;
		default:
			Visao.apresentaMensagemErro("Invalido! Digite 1, 2 ou 0!");
			return validaMenu();
		}
	}
	
	public static char validaEscolha() {
		char escolha;
		
		Visao.apresentaEscolhaPessoa();
		escolha = Leitor.leChar();
		switch(escolha) {
		case '1':
		case '2':
			return escolha;
		default:
			Visao.apresentaMensagemErro("Invalido! Digite 1 ou 2!");
			return validaEscolha();
		}
		
	}

}
