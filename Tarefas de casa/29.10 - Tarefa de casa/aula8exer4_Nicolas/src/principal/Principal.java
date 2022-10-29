package principal;

import dados.Empresa;
import dados.TerrenosDaCidade;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {

		Empresa empresa = new Empresa();
		TerrenosDaCidade terrenos = new TerrenosDaCidade();

		boolean sair = false;
		do {

			switch (Visao.mostraMenu("Escolha uma opcao", new String[] { "Cadastro", "Analise dos dados", "Sair" })) {

			case 0:
				Visao.efetuaCadastros(empresa, terrenos);
				break;

			case 1:
				String analise = Visao.analisaDados(empresa, terrenos);
				if (analise != null)
					Visao.mostraMensagem(analise);
				break;

			default:
				sair = Visao.perguntaSimOuNao("Deseja mesmo sair?", "Sair");
			}

		} while (!sair);

		Visao.mostraDados(empresa, terrenos);

	}
}
