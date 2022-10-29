package dados;

import validacao.Validacao;

public class PessoaSaudavel extends Pessoa{
	private Integer idade;
	
	public PessoaSaudavel(StringBuilder nome, Character genero, Integer identificador,Integer idade) {
		super(nome, genero, identificador);
		setIdade(idade);	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String toString() {
		return String.format("%-18s%-18s%-30s%-24s%-24s\n",getIdentificador(),getNome(),getGenero(),this.idade,getIdentificador(),"X");
		
	}
}
