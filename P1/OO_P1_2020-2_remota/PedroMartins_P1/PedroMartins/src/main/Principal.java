// Nome Completo:Pedro Lucas Cassiano Martins 		 Data da Prova: 20/10/2020

package main;

import java.util.ArrayList;

import dados.Hospital;
import dados.Pessoa;
import valida.Valida;

public class Principal {

	public static void main(String[] args) {
		// Declaracoes
		Integer idade;
		StringBuffer gestacao;
		Hospital pacientes = new Hospital();

		// Instrucoes

		do {
			Pessoa pessoa = new Pessoa(Valida.isIdentificador(pacientes), Valida.isNome(), Valida.isSaude(),
					Valida.isSexo());

			pacientes.setPessoa(pessoa);
			if (pessoa.getSexo().equals("MASCULINO")) {
				idade = Pessoa.pegaIdade(Valida.isIdade(), pessoa);
			}
			if (pessoa.getSexo().equals("FEMININO")) {
				gestacao = Pessoa.pegaGestacao(Valida.isGestante(), pessoa);
			}

		} while (Valida.isContinua(pacientes));

	}

}
