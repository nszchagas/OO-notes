package principal;

import dados.*;
import saida.Saida;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		ColecaoEventos colecaoEventos;

		colecaoEventos = new ColecaoEventos(new Evento(Validacao.validaEvento(), Validacao.validaPresidente(),Validacao.validaAno()));
		while (Validacao.validaContinua()) {
			colecaoEventos.addEvento(new Evento(Validacao.validaEvento(), Validacao.validaPresidente(),Validacao.validaAno()));
		}
		
		Saida.apresentaRelatorio(colecaoEventos);
	}

}
