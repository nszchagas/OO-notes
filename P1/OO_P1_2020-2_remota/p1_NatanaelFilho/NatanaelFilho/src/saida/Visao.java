package saida;

import dados.Grupo;
import dados.Pessoa;
import dados.PessoaContaminada;
import leitura.Leitor;

public class Visao {

	public static String mostraMenuDeCadastramento() {
		return "1 - Cadastrar pessoa nao contaminada.\n2 - Cadastrar pessoa contaminada.\n0 - Sair do cadastramento";
	}

	public static String mostraMenuDeRelatorio() {
		return "1 - Fazer outro cadastro.\n2 - Mostrar Pessoas cadastradas.\n0 - Sair do programa\n";
	}

	public static void limpaTela(int maximo) {
		for (int i = 0; i < maximo; i++)
			System.out.println();
	}

	public static void mostraPessoasCadastradas(Grupo grupo) {
		limpaTela(30);
		System.out.println("indentificador | idade | sexo | nome | situacao");
		System.out.println("---------------------------------------------------");
		for (Pessoa pessoa : grupo.getGrupoSaudavel())
			System.out.println(pessoa.toString());
		for (PessoaContaminada pessoa : grupo.getGrupoContaminado()) {
			System.out.print(pessoa.toString());
			if (pessoa.getSituacao() == 'E')
				System.out.println((" | Em tratamento"));
			if (pessoa.getSituacao() == 'C')
				System.out.println((" | Curada"));
			if (pessoa.getSituacao() == 'F')
				System.out.println((" | Falecida"));
		}
		mostraMensagem("Insira algor para prosseguir: ");
		String pause= Leitor.lerString();
	}

	public static void mostraMensagem(String string) {
		limpaTela(2);
		System.out.println(string);
	}

	public static void mensagemDeErro(String string) {
		limpaTela(2);
		System.err.println(string);
	}

	public static void ResultadoFinal(Grupo grupo) {
		limpaTela(30);
		System.out.println("No ultimo cadastro foram cadastradas: " + (grupo.getTamanhoGrupo()));
		System.out.println("Total de pessoas nao contaminadas: " + grupo.getTamangoGrupoSaudavel());
		System.out.println("Total de pessoas contaminadas: " + grupo.getTamangoGrupoContaminado());
	}

}
