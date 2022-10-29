package saida;

import dados.*;

public class Saida {
	public static void mostraContagemPessoas(Populacao populacao) {
		String formato = "%-40s%-5s%-10s\n";
		int numeroContaminados = 0, numeroTratamento = 0, numeroCurados = 0, numeroMulherFalecida = 0, numeroHomensContaminados = 0;
		for(Pessoa pessoa : populacao.getPopulacao()) {
			if(pessoa instanceof PessoaContaminada) {
				numeroContaminados++;
				if(((PessoaContaminada)pessoa).getSituacao().equals("Falecido") ) {
					if(((PessoaContaminada)pessoa).getGenero().equals("Femenino")) {
						numeroMulherFalecida++;
					}
					if(pessoa.getGenero().equals("Masculino") ) {
						numeroHomensContaminados++;
					}
				}else {
					if(((PessoaContaminada)pessoa).getSituacao().equals("Em tratamento")) {
						numeroTratamento++;
					}else {
						if(((PessoaContaminada)pessoa).getSituacao().equals("Curados")) {
							numeroCurados++;
						}
					}
				}
			}
		}
		System.out.format(formato,(populacao.getPopulacao().size() - numeroContaminados), "=", "NAO CONTAMINADOS");
		System.out.format(formato, numeroTratamento,"=", "CONTAMINADOS EM TRATAMENTO");
		System.out.format(formato, numeroCurados,"=", "CONTAMINADOS CURADOS");
		System.out.format(formato, numeroMulherFalecida,"=", "MULHERES CONTAMINADAS FALECIDAS");
		System.out.format(formato, numeroHomensContaminados,"=", "HOMENS CONTAMINADOS FALECIDOS");
	}
	public static void mostraPessoasCadastradas(Populacao populacao) {
		String formato = "%-20s%-20s%-20s%-20s%-20s%-20s\n";
		System.out.format(formato,"IDENTIFICACAO","NOME", "GENERO", "IDADE", "SITUACAO");
		for(Pessoa pessoa : populacao.getPopulacao())
			System.out.print(pessoa);
	}
	public static void mostraMenuCadastro() {
		System.out.println("\t\t\tMENU CADASTRO\n");
		System.out.println("\t[1] - Cadastrar Pessoa contaminada\n\t[2] - Cadastrar Pessoa nao contamindada\n");
	}
	public static void mostraMenuResultado() {
		System.out.println("\t\t\tMENU\n");
		System.out.println("\t[1] - Cadastrar Novamente \n\t[2] - Aprensentar Pessoas cadastradas \n\t[0] - Encerrar progama;");
	}
	
	public static void limpaTela (int qtd) {
		for (int i = 0; i < qtd; i++)
			System.out.println();
	}
	
	public static void solicitacaoDados(String dado) {
		System.out.println("Informe " + dado);
	}
	
	public static void mensagemEntradaInvalida(String dado) {
		System.err.println("Entrada Invalida! " + dado);
	}
	
	public static void mensagemTipoEntradaInvalida(String dado) {
		System.err.println("Tipo de Entrada Invalida! "+ dado);
	}
}
