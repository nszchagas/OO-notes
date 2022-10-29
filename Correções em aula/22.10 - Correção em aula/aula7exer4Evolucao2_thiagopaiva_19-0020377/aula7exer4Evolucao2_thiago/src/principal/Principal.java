package principal;

import dados.Empresa;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		int opcaoMenu;

		do {
			opcaoMenu = Validacao.validaMenuCadastro();
			switch (opcaoMenu) {
			case '1':
				Visao.registraFuncionarioRegular(empresa);
				break;
			case '2':
				Visao.registraPrestadorServicos(empresa);
				break;
			case '3':
				Visao.registraGerente(empresa);
				break;
			case '0':
				Visao.mostraRelatorio(empresa);
			}
		} while (opcaoMenu != '0');

	}
}
