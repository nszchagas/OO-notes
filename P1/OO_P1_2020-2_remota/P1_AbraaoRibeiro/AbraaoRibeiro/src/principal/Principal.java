package principal;


import dados.GrupoExaminado;
import dados.Pessoa;
import dados.PessoaContaminada;
import dados.PessoaSaudavel;
import saida.Visao;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		final int MINIMO = 1;
		GrupoExaminado grupoExaminado = new GrupoExaminado();
		int opcao = -1;
		do {
			opcao = Validacao.validaOpcao();

			switch (opcao){
			case 1: {
				switch (Validacao.validaTipoPessoa()) {
				case 1: {
					grupoExaminado.setGrupo(new PessoaSaudavel(Validacao.validaNome(), Validacao.validaGenero(), Validacao.validaIdentificador(grupoExaminado, MINIMO), Validacao.validaIdade()));
				break;
				}
				case 2:{
					grupoExaminado.setGrupo(new PessoaContaminada(Validacao.validaNome(), Validacao.validaGenero(), Validacao.validaIdentificador(grupoExaminado, MINIMO), Validacao.validaSituacao()));
					break;
				}
				}
			}
			case 2:{
				Visao.mostrarTabela(grupoExaminado);
				break;
			}
			}
			if (opcao == 0 && grupoExaminado.getPessoas().isEmpty()) {
				Visao.limpaTela(30);
				System.out.println("nenhuma pessoa foi cadatrada. cadastre uma pessoa antes de sair");
				opcao=1;
			}
		} while (opcao  != 0);
		Visao.limpaTela(50);
		Visao.mostrarDadosFinais(grupoExaminado);
		
	}

}
