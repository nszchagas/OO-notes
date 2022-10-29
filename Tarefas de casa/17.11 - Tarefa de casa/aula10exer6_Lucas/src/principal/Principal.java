package principal;

import javax.swing.JOptionPane;

import dados.ColecaoTimes;
import dados.TimeDeFutebol;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		ColecaoTimes colecao = new ColecaoTimes();
		boolean sair = false;

		while (!sair) {
			switch (JOptionPane.showOptionDialog(null, "Escolha uma opcao", "Menu", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new String[] { "Cadastrar um time", "Visualizar times cadastrados", "Sair" },
					"Cadastrar um time")) {
			case 0:
				boolean erro = true;
				while (erro) {
					TimeDeFutebol time;
					try {
						time = new TimeDeFutebol(Visao.registraNome(colecao));
						boolean cadastraTitulo = Visao.perguntaSimOuNao("Deseja cadastrar um titulo para esse time?",
								"Cadastro");
						while (cadastraTitulo) {
							int ano = Visao.registraAno(time);
							if (ano != -1) {
								time.addAno(ano);
								cadastraTitulo = Visao.perguntaSimOuNao("Deseja cadastrar um titulo para esse time?",
										"Cadastro");

							} else
								cadastraTitulo = !Visao.perguntaSimOuNao(
										"Deseja encerrar o cadastro de titulos para esse time?", "Cancelar");

						}
						colecao.addTime(time);
						erro = false;
					} catch (NullPointerException e) {
						if (Visao.perguntaSimOuNao("Cancelar esse cadastro?", "Cancelar"))
							break;
						else
							erro = true;
					}
				}
				break;
			case 1:
				Visao.mostraTimes(colecao);
				break;
			case 2:
				sair = Visao.perguntaSimOuNao("Deseja mesmo sair?", "Sair");
				break;
			case -1:
				Visao.mostraMensagem("Para encerrar o programa escolha a opcao \"Sair\" no menu.", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
				sair = false;
			}

		}
	}
}
