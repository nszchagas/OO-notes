package dados;

import java.text.DecimalFormat;

public class PessoaNaoContaminada extends Pessoa {

	private Integer idade;
	
	public PessoaNaoContaminada(String nome, Character genero, Integer id, Integer idade) {
		super(nome, genero, id);
		this.idade = idade;
	}

	public Integer getIdade() {
		return idade;
	}
	
	@Override
	public String toString() {
		DecimalFormat mascara = new DecimalFormat("00");
		
		return getId()
			+ "\t" + getNome()
			+ "\t" + getGenero()
			+ "\t" + mascara.format(getIdade())
			+ "\t"; 
	}
	
}
