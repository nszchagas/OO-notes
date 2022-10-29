package principal;
// Nome Completo: Thiago Sampaio de Paiva		Data da Prova: 20/10/2020

import dados.GrupoPessoa;
import saida.Visao;
import servicos.Servicos;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		GrupoPessoa grupoPessoa = new GrupoPessoa();
		char opcaoMenu = '1';

		do {
			switch (opcaoMenu) {
			case '1':
				Servicos.registraPessoa(grupoPessoa);
				break;
			case '2':
				Visao.mostraRelatorioRegistro(grupoPessoa);
			}
		} while ((opcaoMenu = Validacao.validaMenu()) != '0');
		
		Visao.mostraRelatorioNumerico(grupoPessoa);
	}
}
