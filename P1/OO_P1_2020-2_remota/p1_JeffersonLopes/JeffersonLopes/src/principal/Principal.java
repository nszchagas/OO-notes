//Nome Completo: Jefferson Fillipe de Souza Lopes, Data da Prova: 20/10/2020
package principal;

import dados.GrupoDePessoas;
import dados.Contaminada;
import dados.NaoContaminada;
import saida.Saida;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		int opcao;

		GrupoDePessoas grupo = new GrupoDePessoas();
		do {
			Saida.menuCadastroDePessoa();
			opcao = Validacao.validaInt(1, 2, "Informe a opcao desejada: ");
			switch (opcao) {
			case 1: // CONTAMINADA
				grupo.addPessoa(new Contaminada(Validacao.validaNome(), Validacao.validaGenero(),
						Validacao.validaIdentificador(grupo), Validacao.validaSituacao()));
				break;
			case 2: // NAO CONTAMINADA
				grupo.addPessoa(new NaoContaminada(Validacao.validaNome(), Validacao.validaGenero(),
						Validacao.validaIdentificador(grupo), Validacao.validaInt(0, 130, "Informe a idade: ")));
			}
			Saida.exibirMenu();
			opcao = Validacao.validaInt(1, 2, "Informe a opcao desejada: ");

		} while (opcao != 0);

	}
}
