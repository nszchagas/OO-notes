package principal;

import dados.Passageiro;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {

		int contadorDePassageiros = 0;
		while (Visao.registraDesejoContinuar()) {
			Passageiro passageiro1 = new Passageiro(Visao.cadastraNome());
			Visao.mostraResultado(passageiro1);
			contadorDePassageiros++;
		}

		Visao.programaEncerrado(contadorDePassageiros);

	}
}
