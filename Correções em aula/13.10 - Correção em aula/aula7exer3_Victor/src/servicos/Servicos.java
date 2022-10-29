package servicos;

import dados.*;
import validacao.Validacao;

public class Servicos {
	public static void registraMacaco(GrupoMamiferos grupoMamiferos) {
		Macaco macaco = new Macaco(Validacao.validaIdade("Digite a idade de vida do macaco", 0, 60),
				Validacao.validaIdade("Digite a idade geral de amamentacao materna do macaco (em anos)", 0, 60),
				Validacao.validaDescricao("Descreva brevemente a especie do macaco"),
				Validacao.validaFloat("Digite o tamanho normal do macaco na fase adulta (valor em metros):", 1.7f),
				Validacao.validaPorte("Digite o porte desse macaco ('P' = pequeno, 'M' =  medio ou 'G' = grande)"));
		grupoMamiferos.setGrupoMamiferos(macaco);
	}

	public static void registraElefante(GrupoMamiferos grupoMamiferos) {
		Elefante elefante = new Elefante(Validacao.validaIdade("Digite a idade de vida do elefante", 0, 60),
				Validacao.validaIdade("Digite a idade geral de amamentação materna do elefante (em anos)", 0, 60),
				Validacao.validaDescricao("Descreva brevemente a especie do elefante"),
				Validacao.validaFloat("Digite o tamanho normal do elefante na fase adulta (valor em metros):", 4f),
				Validacao.validaFloat("Digite o peso do elefante (em toneladas)", 6f),
				Validacao.validaDescricao("Descreva o habitat natural desse elefante"));
		grupoMamiferos.setGrupoMamiferos(elefante);
	}

	public static void registraBaleia(GrupoMamiferos grupoMamiferos) {
		Baleia baleia = new Baleia(Validacao.validaIdade("Digite a idade de vida da baleia", 0, 211),
				Validacao.validaIdade("Digite a idade geral de amamentação materna da baleia (em anos)", 0, 211),
				Validacao.validaDescricao("Descreva brevemente a especie da baleia"),
				Validacao.validaFloat("Digite o comprimento normal da baleia na fase adulta (valor em metros):", 33f),
				Validacao.validaFloat("Digite o peso da baleia (em toneladas)", 190f));
		grupoMamiferos.setGrupoMamiferos(baleia);
	}
}
