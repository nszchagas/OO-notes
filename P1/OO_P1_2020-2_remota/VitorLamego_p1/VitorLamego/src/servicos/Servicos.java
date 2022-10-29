package servicos;

import validacao.Validacao;
import dados.*;
import saida.Visao;

public class Servicos {
	public static Pessoa registraPessoa(int identificador) {
		int opcaoSexo;
		
		Visao.limpaConsole(5);
		System.out.println("--------------------REGISTRO--------------------");
		opcaoSexo = Validacao.validaOpcaoSexo();
		
		if (opcaoSexo == 1) {
			Homem homem = new Homem(Validacao.validaNome(), Validacao.validaSituacaoSaude(), Validacao.validaIdade(), identificador);
			return homem;
		}
		
		Mulher mulher = new Mulher(Validacao.validaNome(), Validacao.validaSituacaoSaude(), Validacao.validaGestacao(), identificador);
		return mulher;
	
	}
	
	public static String transformaCaracterGestacao(char gestao) {
		if (gestao == 'S')
			return "Sim";
		
		if (gestao == 'N')
			return "Não";
		
		return "Não tenho certeza";
	}
	
	public static String tranformaCaracterEstadoSaude(char situacao) {
		if (situacao == 'T')
			return "Contaminada em Tratamento";
		else if(situacao == 'F')
			return "Contaminada Falecida";
		else if(situacao == 'C')
			return "Contaminada Curada";
		else
			return "Sem Contaminação";
	}
}
