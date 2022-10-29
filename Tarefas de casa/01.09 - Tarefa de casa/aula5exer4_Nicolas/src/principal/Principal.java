package principal;

import java.util.Vector;

import dados.Pessoa;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		Vector<Pessoa> vetorDePessoas = new Vector<Pessoa>();

		while (Visao.verificaIniciarCadastros()) {

			do {
				vetorDePessoas.add(new Pessoa(Visao.cadastraNome()));
			} while (Visao.verificaContinuar());

			Visao.imprimeResultados(vetorDePessoas);

		}

		Visao.programaEncerrado();
		

	}

}
