package principal;

import dados.ColecaoTimes;
import dados.TimeFutebol;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		// Atributos
		ColecaoTimes colecaoTimes = new ColecaoTimes();
		int escolha;
		
		// Metodos
		do {
			String [] opcao = {"Registrar Time", "Mostrar Registros", "Sair"};
			escolha = Visao.mostraMenu("Escolha uma das opcoes.", opcao);
			switch (escolha) {
			case 0:
				try {
					TimeFutebol time = new TimeFutebol(Validacao.validaNome("Insira o nome de Time.", "Registra Time", colecaoTimes));
					while (Visao.mostraMenuConfirmacao("Deseja registrar um ano de vitoria ?", "Registra Time") == 0) {
						time.setAno(Validacao.validaAno("Digite o ano de vitoria do Time.", "Registra Time"));
					}
					colecaoTimes.setColecaoTimes(time);
				}
				catch (NullPointerException ex) {
					Visao.mostraMensagem("Cadastro cancelado com sucesso.");
				}
				break;
			case 1:
				if (!colecaoTimes.getColecaoTimes().isEmpty())
					Visao.mostraMenuRegistros(colecaoTimes);
				else
					Visao.mostraMensagemErro("Error, e necessario registrar ao menos 1 time para acessar esta opcao");
			}
		} while (escolha != -1 && escolha != 2);
		Visao.mostraMensagemConsole(colecaoTimes);
	}
}
