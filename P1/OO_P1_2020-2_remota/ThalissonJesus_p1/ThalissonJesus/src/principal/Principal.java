package principal;

import dados.Feminino;
import dados.GrupoPessoas;
import dados.Masculino;
import saida.Saida;
import validacao.Valida;

public class Principal {

	public static void main(String[] args) {
		GrupoPessoas grupo = new GrupoPessoas();
		int opcao = 1;
		do {
			switch (opcao) {
			case 1:
				switch (Valida.validaGenero()) {
				case 'M':
					grupo.addPessoa(new Masculino(Valida.validaId(grupo.getPessoas()), Valida.validaNome(), Valida.validaSaude(), Valida.validaIdade()));
					break;
				default:
					grupo.addPessoa(new Feminino(Valida.validaId(grupo.getPessoas()), Valida.validaNome(), Valida.validaSaude(), Valida.validaSituacaoGestante()));
				}
				break;
			case 2:
				Saida.mostraRelatorioRegistros(grupo.getPessoas());
			}
		} while ((opcao = Valida.validaOpcao()) != 0);
		Saida.mostraRelatorioFinal(grupo);
	}

}
