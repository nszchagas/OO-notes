package principal;

import dados.Empresa;
import dados.FuncionarioRegular;
import dados.GerenteDeEquipe;
import dados.PrestadorDeServicos;
import saida.Saida;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		int opcao;
		do {
			opcao = Validacao.validaMenuDeFuncionarios();
			switch (opcao) {
			case 0:
				do {
					opcao = Validacao.validaMenu();
					Saida.resultado(opcao, empresa);
				} while (opcao != 0);

				break;
			case 1:
				FuncionarioRegular regular = new FuncionarioRegular(Validacao.validaNome(),
						Validacao.validaCpf(empresa), Validacao.validaDataDeNascimento());
				empresa.setPessoas(regular);
				break;
			case 2:
				PrestadorDeServicos servidor = new PrestadorDeServicos(Validacao.validaNome(),
						Validacao.validaCpf(empresa), Validacao.validaDataDeNascimento(),
						Validacao.validaHorasTrabalhadas());
				empresa.setPessoas(servidor);
				break;
			case 3:
				GerenteDeEquipe gerente = new GerenteDeEquipe(Validacao.validaNome(), Validacao.validaCpf(empresa),
						Validacao.validaDataDeNascimento(), Validacao.validaProjetos());
				empresa.setPessoas(gerente);
			}
		} while (opcao != 0);
		Saida.exibirRelatorio(empresa.getPessoas());
	}
}
