package principal;

import dados.Nome;
import leitura.Leitor;
import saida.Saida;
import validacao.Validacao;

public class SeparaNome {

	public static void main(String[] args) {

		Nome nome;
		
		do {
			System.out.println("Digite o seu nome completo:");
			nome = new Nome(Validacao.validaNome(Leitor.lerNome()));
			Saida.apresentaNomes(nome.getNomes());
			System.out.println("Deseja cadastrar outro nome? (S para sim e N para nao)");
		}while(Validacao.validaEscolha(Leitor.lerEscolha()));

	}

}
