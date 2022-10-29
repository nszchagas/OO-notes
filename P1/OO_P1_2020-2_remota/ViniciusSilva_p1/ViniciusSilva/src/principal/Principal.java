//Vinicius Roriz Meireles Silva 20/10/2020

package principal;

import dados.Registros;
import servicos.Servicos;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		Registros registros = new Registros();
		
		do{
			switch(Validacao.validaSexo()){
				case 'm':
					Servicos.cadastraHomem(registros);
					break;
				case 'f':
					Servicos.cadastraMulher(registros);
					break;
			}
		}while(Validacao.validaOpcao(registros));


	}

}
