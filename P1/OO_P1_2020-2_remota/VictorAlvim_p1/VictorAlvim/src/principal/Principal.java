// Nome Completo: Victor Buendia Cruz de Alvim		 Data da Prova: 20/10/2020
package principal;

import dados.Cadastros;
import servicos.Servicos;
import validacao.Validacao;
import visao.Saida;

public class Principal {
	public static void main(String[] args) {
		final int MAIOR = 100;
		int identificador = MAIOR;
		Cadastros cadastros = new Cadastros();
		
		Saida.mensagem("===============CADASTRO DE PESSOAS COVID-19================");
		Saida.mensagem("-> Pessoa de identificador numero "+identificador);
		Servicos.cadastrarPessoa(cadastros, identificador);
		identificador++;
		
		do {
			Saida.limpaTela(40);
			
			switch(Saida.mostraMenu()) {
			
			case 1: //cadastrar nova pessoa
				Saida.limpaTela(3);
				Saida.mensagem("-> Pessoa de identificador numero "+identificador);
				Servicos.cadastrarPessoa(cadastros, identificador);
				identificador++;
				break;
				
			case 2: //ver lista de todos os registros
				Saida.relatorioTodosRegistros(cadastros);
			}
			
		}while(Validacao.validaContinua());
		
		Saida.mostraSomatorioFinal(cadastros);
	}
}
