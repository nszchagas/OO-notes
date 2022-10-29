package dados;

import java.text.DecimalFormat;

public class Pessoa {
	private StringBuilder nome;
	private Character genero;
	private Integer codigo;
	
	public Pessoa(StringBuilder nome, char gen, int cod) {
		this.setNome(nome);
		this.setGenero(gen);
		this.setCodigo(cod);
	}
	
	public void setNome(StringBuilder nome) {
		this.nome = nome;
		
	}
	
	public void setGenero(char gen) {
		this.genero = gen;
		
	}

	public void setCodigo(int cod) {
		this.codigo = cod;	
	}

	public StringBuilder getNome() {
		return nome;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getGenero() {
		if(genero == 'M')
			return "MASCULINO";
		else
			return "FEMININO";
	}
	
	public String toString() {
		return (this.getNome()+"\t|\t"+this.getGenero()+"\t|\t"+this.getCodigo());
	}
}
