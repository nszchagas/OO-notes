package servicos;

import dados.Cadastros;
import dados.Homem;
import dados.Mulher;
import dados.Pessoa;
import validacao.Validacao;
import visao.Saida;

public class Servicos {
	public static int somarSituacaoDeSaude(Cadastros cadastros, char situacaoSaude) {
		int soma = 0;
		
		for(Pessoa pessoa : cadastros.getCadastros()) {
			if(pessoa.getSituacaoSaude() == situacaoSaude) {
				soma++;
			}
		}
		
		return soma;
	}
	
	public static int[] somarSituacaoDeSaude(Cadastros cadastros) {
		int soma[] = {0,0,0,0,0};
		
		for(Pessoa pessoa : cadastros.getCadastros()) {
			switch(pessoa.getSituacaoSaude()) {
			case 'C':
				soma[0]++;
				break;
			case 'T':
				soma[1]++;
				break;
			case 'F':
				soma[2]++;
				break;
			case 'S':
				if(pessoa instanceof Homem) {
					soma[3]++;
				}
				else {
					soma[4]++;
				}
			}
			
		}
		return soma;
	}
	
	public static void cadastrarPessoa(Cadastros cadastros, int identificador) {
		String nome;
		char situacaoSaude;
		int idade;
		char gestante;
		char sexo;
		
		Saida.mensagem("Insira o nome da pessoa:");
		nome = Validacao.validaNome();
		
		Saida.limpaTela(3);
		Saida.mensagem("Insira a situacao de saude dela:");
		Saida.mostrarSituacoesSaude();
		situacaoSaude = Validacao.validaCaracter("TFCS");
		
		Saida.limpaTela(3);
		Saida.mensagem("Qual o sexo da pessoa cadastrada? [M/F]");
		sexo = Validacao.validaCaracter("MF");
		
		Saida.limpaTela(3);
		if(sexo == 'M') {
			Saida.mensagem("Qual a idade em anos do homem cadastrado?");
			idade = Validacao.validaInt(0, 150);
			
			cadastros.setCadastros(new Homem(identificador, nome, situacaoSaude, idade));
		}
		else {
			Saida.mensagem("A mulher cadastrada esta gravida?");
			Saida.mostrarSituacoesGravidez();
			gestante = Validacao.validaCaracter("SNT");
			cadastros.setCadastros(new Mulher(identificador, nome, situacaoSaude, gestante));
		}
	}
}
