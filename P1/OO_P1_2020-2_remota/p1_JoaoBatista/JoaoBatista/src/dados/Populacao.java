package dados;

import java.util.ArrayList;

public class Populacao {
	private ArrayList<PessoaContaminada> populacaoC;
	private ArrayList<PessoaNaoContaminada> populacaoNC;
	
	public Populacao() {
		this.populacaoC = new ArrayList<PessoaContaminada>();
		this.populacaoNC = new ArrayList<PessoaNaoContaminada>();
	}
	
	public void addPessoaContaminada(PessoaContaminada pessoa){
		this.populacaoC.add(pessoa);
	}
	
	public ArrayList<PessoaContaminada> getPopulacaoContamin() {
		return populacaoC;
	}
	
	public void addPessoaNaoContaminada(PessoaNaoContaminada pessoa){
		this.populacaoNC.add(pessoa);
	}
	
	public ArrayList<PessoaNaoContaminada> getPessoaNaoContaminada() {
		return populacaoNC;
	}
}
