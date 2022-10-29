package principal;

import dados.GrupoPessoas;
import dados.Homem;
import dados.Mulher;
import leitura.Leitura;
import saida.Visao;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		int option;
		GrupoPessoas grupoPessoas = new GrupoPessoas();
		
		do {	
			Visao.menuPrincipal();
			option = Leitura.leiaInt();
			
			switch(option) {
			case 0:
				System.exit(0);
				break;
			case 1: 
				menuEscolherSexo(option, grupoPessoas);
				break;
			case 2:
				Visao.mostraRelatorio(grupoPessoas);
			}
		}while(option != 0);
	}
	
	public static void cadastraHomem(GrupoPessoas grupoPessoas) {
		Homem homem = new Homem(Validacao.validaNome(), Validacao.validaSituacaoSaude(), Validacao.validaIdade(0, 150));
		grupoPessoas.setGrupoPessoas(homem);
	}
	
	public static void cadastraMulher(GrupoPessoas grupoPessoas) {
		Mulher mulher = new Mulher(Validacao.validaNome(), Validacao.validaSituacaoSaude(), Validacao.validaGestante());
		grupoPessoas.setGrupoPessoas(mulher);
	}
	
	public static void menuEscolherSexo(int option, GrupoPessoas grupoPessoas) {
		System.out.println("Selecione o Sexo:\n1 - Masculino\n 2 - Feminino");
		option = Leitura.leiaInt();
		
		switch(option) {
		case 1:
			cadastraHomem(grupoPessoas);
			break;
		case 2:
			cadastraMulher(grupoPessoas);
		}
		
	}

}
