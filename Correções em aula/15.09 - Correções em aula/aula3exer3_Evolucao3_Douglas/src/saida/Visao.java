package saida;

import java.text.DecimalFormat;

import dados.Grupo;
import dados.Pessoa;

public class Visao {

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}

	public static void mostraDados(Grupo grupo) {
		DecimalFormat centesimo = new DecimalFormat("0.00");

		System.out.println("Dados da(s) [" + grupo.getGrupo().length + "] pessoa(s) cadastrada(s):");

		for (Pessoa pessoa : grupo.getGrupo()) {
			System.out.println("Idade: " + pessoa.getIdade()
							+ "\t\tAltura: " + centesimo.format(pessoa.getAltura())
							+ "\t\tNome: " + pessoa.getNome());
		}
	}
}
