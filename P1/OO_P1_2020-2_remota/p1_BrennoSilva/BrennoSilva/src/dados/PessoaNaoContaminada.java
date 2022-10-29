package dados;

import java.text.DecimalFormat;

public class PessoaNaoContaminada extends Pessoa{
	private Integer idade;

	public PessoaNaoContaminada(Integer identificacao, StringBuilder nome, Character genero, Integer idade) {
		super(identificacao, nome, genero);
		setIdade(idade);
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public String toString() {
		DecimalFormat formatoID = new DecimalFormat("00000000");
		if(this.getGenero() == 'F')
			return(String.format("%-15s%-15s%-15s%-15s%-15s", formatoID.format(this.getIdentificacao()), this.getNome(), 
					"FEMININO", this.getIdade(), "----"));
		
		return(String.format("%-15s%-15s%-15s%-15s%-15s", formatoID.format(this.getIdentificacao()), this.getNome(), 
															"MASCULINO", this.getIdade(), "----"));
	}
}
