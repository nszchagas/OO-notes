package servicos;

import dados.Contaminado;
import dados.Populacao;
import dados.Saudavel;
import saida.Visao;
import valicao.Validacao;

public class Servicos {
	public static void registraNovaPessoa (Populacao populacao) {
		String [] opcoes = {"[1] - Registrar Novo Contaminado", "[2] - Registrar Novo Saudavel"};
		Visao.mostraMenu(opcoes);
		switch (Validacao.validaInteiro("Escolha uma opcao", 1, 2)) {
		case 1:
			registraContaminado(populacao);
			break;
		case 2:
			registraSaudavel(populacao);
		}
	}
	
	private static void registraContaminado (Populacao populacao) {
		populacao.setPopulacao(new Contaminado(
			Validacao.validaNome("Digite o nome da Pessoa"), 
			Validacao.validaGenero("Digite o genero da Pessoa. [M]asculino ou [F]eminino"), 
			Validacao.validaIdentificacao("Digite o codigo de identifacao da Pessoa", populacao),
			Validacao.validaEstadoSaude("Digite o estado de saude da Pessoa. [E]m tratamento, [F]alecido ou [C]urado")
		));
	}
	
	private static void registraSaudavel (Populacao populacao) {
		populacao.setPopulacao(new Saudavel(
			Validacao.validaNome("Digite o nome da Pessoa"), 
			Validacao.validaGenero("Digite o genero da Pessoa. [M]asculino ou [F]eminino"), 
			Validacao.validaIdentificacao("Digite o codigo de identifacao da Pessoa", populacao),
			Validacao.validaInteiro("Digite a idade da Pessoa (0 sendo bebe que nao completou 1 ano de idade)", 0, 130)
		));
	}
}
