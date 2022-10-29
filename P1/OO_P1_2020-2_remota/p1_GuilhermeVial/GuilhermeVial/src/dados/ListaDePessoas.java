package dados;

import java.util.ArrayList;

public class ListaDePessoas {

	private ArrayList<Pessoas> lista;

	public ListaDePessoas() {
		this.lista = new ArrayList<Pessoas>();
	}

	public void addPessoaNaoContaminada(PessoaNaoContaminada pessoa) {
		this.lista.add(pessoa);
	}

	public void addPessoaContaminada(PessoaContaminada pessoa) {
		this.lista.add(pessoa);
	}

	public boolean validaRepeticaoId(int id) {
		for (Pessoas pessoa : this.lista) {
			if (pessoa.getId() == id) {
				System.err.println("Este identificador ja foi cadastrado");
				return true;
			}
		}
		return false;
	}

	public int getTotalNaoContaminado() {
		int i = 0;

		for (Pessoas pessoa : this.lista) {
			if (pessoa instanceof PessoaNaoContaminada) {
				i++;
			}
		}
		return i;
	}

	public int getTotalContaminado(char escolha) {
		int i = 0;

		for (Pessoas pessoa : this.lista) {
			if (pessoa instanceof PessoaContaminada && ((PessoaContaminada) pessoa).getSituacao() == escolha) {
				i++;
			}
		}
		return i;

	}
	
	public int getFalecidosGenero(char genero) {
		int i = 0;
		
		for (Pessoas pessoa : this.lista) {
			if (pessoa instanceof PessoaContaminada && ((PessoaContaminada) pessoa).getGenero() == genero && ((PessoaContaminada) pessoa).getSituacao() == 'F') {
				i++;
			}
		}
		return i;
	}
	
	public ArrayList<Pessoas> getLista(){
		return this.lista;
	}
}
