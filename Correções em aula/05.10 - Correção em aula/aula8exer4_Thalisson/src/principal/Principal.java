package principal;

import dados.Empregado;
import dados.Empresa;
import dados.GrupoTerrenos;
import dados.Terreno;
import saida.Saida;
import validacao.Valida;

public class Principal {

	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		GrupoTerrenos gpTerrenos = new GrupoTerrenos();

		int escolha;

		do {
			switch ((escolha = Valida.validaEscolhaMenu("Cadastrar dados", "Analisar dados"))) {
			case 0:
				gerenciaCadastro(empresa, gpTerrenos, Valida.validaEscolhaMenu("Empregado", "Terreno"));
				break;
			case 1:
				gerenciaAnalise(empresa, gpTerrenos, Valida.validaEscolhaMenu("Empregados", "Terrenos"));
			}
		} while (escolha != -1);

		Saida.apresentaDados(empresa, gpTerrenos);
	}

	private static void gerenciaCadastro(Empresa empresa, GrupoTerrenos gpTerrenos, int tipo) { // nao é necessário,
																								// colocar dentro do
																								// menu principal
		switch (tipo) {
		case 0:
			// gerar uum try catch null caso o usuário aperte cancelar no cadastro
			empresa.addEmpregado(
					new Empregado(Valida.validaMatricula(empresa), Valida.validaNome(), Valida.validaSalario()));
			break;
		case 1:
			gpTerrenos.addTerrenos(new Terreno(Valida.validaEndereco(), Valida.validaArea(), Valida.validaPreco()));
		}
	}

	private static void gerenciaAnalise(Empresa empresa, GrupoTerrenos gpTerrenos, int tipo) {
		if ((tipo == 0 && empresa.getEmpregados().isEmpty()) || (tipo == 1 && gpTerrenos.getTerrenos().isEmpty())) {
			Saida.mostraMensagem("Nenhum dado cadastrado para essa opcao.", "Atencao", 2);
			return;
		}
		if (tipo != -1) {
			switch (Valida.validaEscolhaMenu("Menor e maior valor real", "Existencia de duplicidade de inteiros",
					"Somatorio de dados numericos", "Media de dados numericos")) {
			case 0:
				Saida.mostraMenorMaiorReal((tipo == 0 ? empresa : gpTerrenos), tipo);
				break;
			case 1:
				if (tipo == 0)
					Saida.mostraDuplicatas(empresa);
				else
					Saida.mostraDuplicatas(gpTerrenos);
				break;
			case 2:
				Saida.mostraSomatorio((tipo == 0 ? empresa : gpTerrenos), tipo);
				break;
			case 3:
				Saida.mostraMedia((tipo == 0 ? empresa : gpTerrenos), tipo);
			}
		}
	}
}
