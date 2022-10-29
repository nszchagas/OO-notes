package principal;

import dados.*;
import saida.Visao;
import servicos.Servicos;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		// Declaracoes
		final int MAXIMO = 500;
		char escolha;
		GrupoMamiferos grupoMamiferos = new GrupoMamiferos();

		// Instrucoes
		do {
			escolha = Validacao.validaMenu(grupoMamiferos);
			switch (escolha) {
			case '0':
				Servicos.registraMacaco(grupoMamiferos);
				break;
			case '1':
				Servicos.registraElefante(grupoMamiferos);
				break;
			case '2':
				Servicos.registraBaleia(grupoMamiferos);
			}
		} while (grupoMamiferos.getGrupoMamiferos().size() != MAXIMO && escolha != '3');
		Visao.mostraAnimais(grupoMamiferos);
	}
}
