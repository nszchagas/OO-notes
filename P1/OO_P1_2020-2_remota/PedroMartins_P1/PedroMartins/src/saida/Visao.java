package saida;

import dados.Hospital;
import dados.Pessoa;

public class Visao {

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}

	public static void mostraDados(Hospital pacientes) {
		String formato = "%-30s%-30s%-35s%-30s%-20s%-20s\n";
		System.out.format(formato, "IDENTIFICADOR", "NOME", "SAUDE", "SEXO", "IDADE", "GESTACAO");
		for (int aux = 0; aux < 185; aux++)
			System.out.print("-");
		limpaTela(1);
		for (Pessoa pessoa : pacientes.getPessoa()) {
			System.out.println(pessoa.toString());
		}
	}

}
