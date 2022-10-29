package principal;
// ROBERTO GABRIEL MANGABEIRA SANTANA / 190019620
import dados.Grupo;
import dados.Homem;
import dados.Mulher;
import validacao.Validacao;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		Grupo grupo = new Grupo();
		final int MAIOR = 100;
		char escolha;
		
		Visao.mostraMenu(0);
		escolha = Validacao.validaChar("12", "Insira uma opcao: ");
		if (escolha == '1')
			grupo.addPessoa(new Homem(Validacao.validaInt(MAIOR,200 , "Insira o codigo dessa Pessoa: "),
					Validacao.validaString("NOME: "),
					Validacao.validaChar("TFCS", "Insira a Situacao: "),
					Validacao.validaInt(0, 150, "Insira a Idade:")));
		else
			grupo.addPessoa(new Mulher(Validacao.validaInt(MAIOR,200 , "Insira o codigo dessa Pessoa: "),
					Validacao.validaString("NOME: "),
					Validacao.validaChar("TFCS", "Insira a Situacao: "),
					Validacao.validaGestacao()));	
		
		do {
			
			Visao.mostraMenu(1);
			escolha = Validacao.validaChar("012", "Insira uma opcao: ");
			
			switch(escolha) {
			case '1':{
				Visao.mostraMenu(0);
				if (Validacao.validaChar("12", "Insira uma opcao: ") == 'M') {
					if (escolha == '1')
						grupo.addPessoa(new Homem(Validacao.validaInt(MAIOR,200 , "Insira o codigo dessa Pessoa: "),
								Validacao.validaString("NOME: "),
								Validacao.validaChar("TFCS", "Insira a Situacao: "),
								Validacao.validaInt(0, 150, "Insira a Idade:")));
				}
				else {
					grupo.addPessoa(new Mulher(Validacao.validaInt(MAIOR,200 , "Insira o codigo dessa Pessoa: "),
							Validacao.validaString("NOME: "),
							Validacao.validaChar("TFCS", "Insira a Situacao: "),
							Validacao.validaGestacao()));
				}
				break;
			}
			case '2': {
				Visao.mostraRelatorio(grupo);
				break;
			}
			}
		} while (escolha != '0');
		
		Visao.mostraResultado(grupo);
	}

}
