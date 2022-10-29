package principal;

import servicos.Servicos;
import validacao.Validacao;
import visao.Visao;
import dados.Loja;
import dados.Vendedor;

public class Principal {

	public static void main(String[] args) {
		//Declaracoes
		int NUMVENDEDORES = 4;
		int qtdMes;
		Vendedor vendedor[] = new Vendedor[NUMVENDEDORES];
		Loja loja;
		
		//Intrucoes
		qtdMes = Validacao.validaQtdSemanas();
		Servicos.limpaTela(10);
		for(int count=0; count<NUMVENDEDORES; ++count){
			System.out.println("Digite o total de vendas do vendedor " + (count+1));
			vendedor[count] = new Vendedor(Validacao.validaArrayTotalVendas(qtdMes));
			Servicos.limpaTela(10);
		}
		
		loja = new Loja(vendedor);
		Visao.mostraResultadoFinal(loja);
	}
}