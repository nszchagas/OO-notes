package saida;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Vector;

import dados.*;
import validacao.Validacao;

public class Visao {

	public static void mostraMensagem(String msg) {
		System.out.println(msg);
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++) {
			System.out.println();
		}
	}

	private static void mostraNomes(Grupo grupo) {
		int indice = 1;
		DecimalFormat mascara = new DecimalFormat("00");
		String formato = "%-10s%-30s\n";

		System.out.format(formato, "Indice", "Nome");
		for (Pessoa pessoa : grupo.getNomes()) {
			System.out.format(formato, mascara.format(indice++), pessoa.getNome());
		}
	}

	public static void mostraRelatorioInsercao(Grupo grupo) {
		Visao.mostraMensagem("Nomes cadastrados por ordem de cadastro");
		Visao.mostraNomes(grupo);
	}

	public static void mostraRelatorioInsercaoInverso(Grupo grupo) {
		Collections.reverse(grupo.getNomes());
		Visao.mostraMensagem("Nomes cadastrados por ordem inversa de cadastro");
		Visao.mostraNomes(grupo);
	}

	public static void mostraRelatorio(Grupo grupo) {
		int opcaoRelatorio;

		while ((opcaoRelatorio = Validacao.validaRelatorio()) != '0') {
			Visao.limpaTela(50);
			switch (opcaoRelatorio) {
			case '1':
				Visao.mostraRelatorioInsercao(grupo);
				break;
			case '2':
				Visao.mostraRelatorioInsercaoInverso(grupo);
			}
			Visao.limpaTela(2);
		}
	}
}