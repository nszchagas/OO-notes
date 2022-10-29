package saida;

import java.text.DecimalFormat;
import java.util.Vector;

import dados.GrupoDePessoas;
import dados.Pessoa;
import validacao.Validacao;

public class Visao {

	public static void mostraNomesOrdem(Vector<Pessoa> grupo) {
		DecimalFormat mascara = new DecimalFormat("00");
		mostraMensagem("Nomes cadastrados por ordem de cadastro");
		mostraCabecalho();
		for (int contador = 0; contador < grupo.size(); contador++) {
			ajustaTextoEspaco("  " + mascara.format(contador + 1), 20);
			System.out.println("|  " + grupo.elementAt(contador).getNome());
		}
	}
	
	public static void mostraNomesInverso(Vector<Pessoa> grupo) {
		DecimalFormat mascara = new DecimalFormat("00");
		mostraMensagem("Nomes cadastrados por ordem inversa de cadastro");
		mostraCabecalho();
		for (int contador = grupo.size() - 1; contador >= 0; contador--) {
			ajustaTextoEspaco(mascara.format(contador + 1), 20);
			System.out.println("|  " + grupo.elementAt(contador).getNome());
		}
	}
	
	public static void mensagemProgramaEncerrado(int numCadastros) {		
		mostraMensagem("Programa encerrado. A ultima lista teve " + numCadastros + " nome(s) cadastrado(s).");
	}
	

	public static void mostraRelatorio(GrupoDePessoas grupo) {

		limpaTela(50);
		if (grupo.getPessoas().size() > 0) {
			int opcaoRelatorio;
			mostraMensagem("Foram cadastradas " + grupo.getPessoas().size() + " pessoas.");

			while ((opcaoRelatorio = Validacao.validaRelatorio()) != '0') {
				Visao.limpaTela(50);
				switch (opcaoRelatorio) {
				case '1':
					mostraNomesOrdem(grupo.getPessoas());
					break;
				case '2':
					mostraNomesInverso(grupo.getPessoas());
				}
				Visao.limpaTela(2);
			}
		}
	}
	
	private static void ajustaTextoEspaco(String texto, int espaco) {
		System.out.print("  ");
		System.out.print(texto);
		for (int contador = texto.length() + 2; contador < espaco; contador++)
			System.out.print(" ");
	}

	private static void mostraCabecalho() {
		System.out.println(" Numero de cadastro | Nome  ");

	}

	public static void limpaTela(int linhas) {
		for (int cont = 0; cont < linhas; cont++)
			System.out.println();
	}

	public static void mostraMensagem(String msg) {
		System.out.println(msg);
	}
}