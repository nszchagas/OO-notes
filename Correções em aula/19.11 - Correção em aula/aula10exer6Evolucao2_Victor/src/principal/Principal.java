package principal;

import dados.*;
import saida.Saida;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		int escolha = 0;
		ColecaoTime colecaoTime =  new ColecaoTime();

		do {
			try {
				escolha = Saida.mostraMenu();
				if (colecaoTime.getColecaoTime().size() == 0 && escolha != 0)
					Saida.mostraErro("Cadastre ao menos um time");
				else {
					switch (escolha) {
					case 0:
						TimeDeFutebol time = new TimeDeFutebol(Validacao.validaNome());						
						while (Validacao.validaOutroTitulo()) {
							time.addAno(Validacao.validaAno());
						}
						colecaoTime.setColecaoTime(time);
						Saida.mostraUltimoCadastro(time);
						break;
					case 1:
						Saida.mostraCadastros(colecaoTime.getColecaoTime());
					}
				}	
			}catch (NullPointerException ex) {
				Saida.mostraMensagem("Cadastro cancelado", "Cadastro de Time");
			}
		} while (colecaoTime.getColecaoTime().isEmpty() || escolha == 0 || escolha == 1);
		
		Saida.mostraMensagemConsole("Numero de times cadastrados: " + colecaoTime.getColecaoTime().size());
	}
}
