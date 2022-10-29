package visao;

import dados.Grupo;
import dados.Pessoa;
import java.text.DecimalFormat;

public class Visao {
	public static void limpaTela(int qtd) {
		for(int i = 0; i < qtd; i++) {
			System.out.println();
		}
	}
	
	public static void apresentaMensagem(String mensagem) {
		System.out.println(mensagem);
	}
	
	public static void apresentaMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
	
	public static void apresentaMenuSituacoes() {
		System.out.println("Digite uma opcao:");
		System.out.println("E - Em tratamento");
		System.out.println("F - Falecido");
		System.out.println("C - Curado");
	}
	
	public static void apresentaMenu() {
		System.out.println("Digite sua opcao:");
		System.out.println("1 - Novo Cadastro");
		System.out.println("2 - Mostrar Todos os Cadastros");
		System.out.println("0 - Encerrar");
	}
	
	public static void apresentaEscolhaPessoa() {
		System.out.println("Escolha o tipo de pessoa para o cadastro");
		System.out.println("1 - Nao Contaminada");
		System.out.println("2 - Contaminada");
	}
	
	public static void mostraCadastros(Grupo grupo) {
		String formato = "%-15s|%-20s|%-10s|%-10s|%s\n";
		
		Visao.limpaTela(5);
		System.out.format(formato, "Identificador", "Nome", "Genero", "Idade", "Situacao");
		for(Pessoa pessoa : grupo.getGrupo()) {
			System.out.println(pessoa);
		}
		Visao.limpaTela(5);	
	}
	
	public static void apresentaResumoDados(Grupo grupo) {
		DecimalFormat formata = new DecimalFormat("00");
		
		limpaTela(50);
		System.out.println(formata.format(grupo.qtdQtdNaoContaminados()) +  " = NÃO CONTAMINADOS");
		System.out.println(formata.format(grupo.getQtdContaminadosTratamento()) +  " = CONTAMINADOS EM TRATAMENTO");
		System.out.println(formata.format(grupo.getQtdContaminadosCurados()) +  " = CONTAMINADOS CURADOS");
		System.out.println(formata.format(grupo.getMulheresContaminadasFalecidas()) +  " = MULHERES CONTAMINADAS FALECIDAS");
		System.out.println(formata.format(grupo.getHomensContaminadosFalecidos()) +  " = HOMENS CONTAMINADOS FALECIDOS");
		System.out.println("--------------------------------------------");
		System.out.println(formata.format(grupo.getGrupo().size()) +  " = TOTAL DE PESSOAS CADASTRADAS" + 
				"");

	}

}
