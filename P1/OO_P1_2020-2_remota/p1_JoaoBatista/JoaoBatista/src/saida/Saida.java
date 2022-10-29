package saida;

import java.text.DecimalFormat;
import java.util.ArrayList;

import dados.Pessoa;
import dados.PessoaContaminada;
import dados.PessoaNaoContaminada;
import dados.Populacao;
import validacao.Validacao;

public class Saida {
	public static void solicitarInput(String msg) {
		System.out.println("Digite "+msg+":");
	}

	public static void entradaInvalida(String erro) {
		limpaTela(1);
		System.err.println(erro+". Tente novamente");
	}

	public static void verificarContaminacao() {
		System.out.println("Digite 'C' caso a pessoa esteja contaminada e 'N' caso contrario");
	}

	public static void limpaTela(int linhasPuladas) {
		for (int aux = 0; aux < linhasPuladas; aux++) {
			System.out.println();
		}
	}
	
	public static void imrimeTabela(Populacao populacao) {
		System.out.println("\tIDENTIFICADOR\t|\tNOME\t|\tGENERO\t|\tIDADE\t|\tSITUACAO DE SAUDE");
		for(PessoaContaminada pessoa: populacao.getPopulacaoContamin()) {
			System.out.println(pessoa);
		}
		for(PessoaNaoContaminada pessoa: populacao.getPessoaNaoContaminada()) {
			System.out.println(pessoa);
		}
		limpaTela(3);
	}
	
	public static void imprimeMenu() {
		DecimalFormat mascara = new DecimalFormat("0.00");
		System.out.println("[1] - Novo cadastro");
		System.out.println("[2] - Mostrar todos cadastros");
		System.out.println("[0] - Encerrar");
		
	}
	
	public static void novoCadastro() {
		System.out.println("CADASTRO DE PESSOA");
	}

	public static void imprimeOpcoesEstado() {
		System.out.println("Digite:");
		System.out.println("'E' - Se a pessoa estiver em tratamento");
		System.out.println("'F' - Se a pessoa estiver falecida");
		System.out.println("'C' - Se a pessoa estiver curada");
		
	}

	public static void imprimeTotais(Populacao populacao) {
		System.out.println(populacao.getPessoaNaoContaminada().size()+" =  NÃO CONTAMINADOS");
		System.out.println(populacao.getPopulacaoContamin().size()+" = CONTAMINADOS");
		System.out.println(populacao.getPopulacaoContamin().size()+populacao.getPessoaNaoContaminada().size()+" = TOTAL DE PESSOAS CADASTRADAS");
		
	}

}
