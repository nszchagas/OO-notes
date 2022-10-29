package principal;

import javax.swing.JOptionPane;

import dados.Time;
import visao.Visao;

public class Principal {
	public static void main(String[] args) {

		boolean sair = false;
		Time time = null;
		do {

			switch (Visao.mostraMenu("Escolha uma opcao",
					new String[] { "Cadastrar um time", "Visualizar ultimo time cadastrado" })) {
			case 0:
				boolean erro = true;
				while (erro) {
					try {
						time = new Time(Visao.registraNome().trim());
						while (Visao
								.mostraConfirmacao("Deseja cadastrar um ano de obtenção de titulo para esse time?")) {
							int ano = Visao.registraAno(time);
							if (ano == -1)
								throw new NullPointerException();
							time.addAno(ano);
						}
						Visao.mostraTime(time);
						erro = false;
					} catch (NullPointerException e) {
						if (Visao.mostraConfirmacao("Deseja cancelar esse cadastro?"))
							break;
						erro = true;
					}
				}
				break;
			case 1:
				if (time != null)
					Visao.mostraTime(time);
				else
					Visao.mostraMensagem("Cadastre um time para acessar essa opcao", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				break;
			case -1:
				sair = Visao.mostraConfirmacao("Deseja mesmo sair?");

			}

		} while (!sair);

	}
}
