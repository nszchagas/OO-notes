package dados;

import java.text.DecimalFormat;

public class PessoaContaminada extends Pessoa{
	private Character situacao;

	public PessoaContaminada(Integer identificacao, StringBuilder nome, Character genero, Character situacao) {
		super(identificacao, nome, genero);
		setSituacao(situacao);
	}

	public Character getSituacao() {
		return situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}
	
	public String toString() {
		DecimalFormat formatoID = new DecimalFormat("00000000");
		if(this.getGenero() == 'F')
			return(String.format("%-15s%-15s%-15s%-15s%-15s", formatoID.format(this.getIdentificacao()), this.getNome(), 
					"FEMININO", "----", this.getSituacao()));
		
		return(String.format("%-15s%-15s%-15s%-15s%-15s", formatoID.format(this.getIdentificacao()), this.getNome(), 
															"MASCULINO", "----", this.getSituacao()));
	}
}
