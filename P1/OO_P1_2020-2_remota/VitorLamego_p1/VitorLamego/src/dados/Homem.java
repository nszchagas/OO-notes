package dados;

import servicos.Servicos;

public class Homem extends Pessoa{
	private Integer idade;
	
	public Homem(StringBuilder nomeCompleto, char estadoSaude, int idade, int identificador) {
		super(nomeCompleto, estadoSaude, identificador);
		setIdade(idade);
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public String toString() {
		String situacao = Servicos.tranformaCaracterEstadoSaude(this.getEstadoSaude());
		String formato = "%-20s%-20s%-30s%-20s%-20s\n";
		return String.format(formato,this.getIdentificador(), this.getNomeCompleto(), situacao, this.getIdade(), "-----");
	}
}
