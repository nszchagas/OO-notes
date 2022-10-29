package dados;

public class Saudavel extends Pessoa{
	private Integer idade;
	
	public Saudavel(String pNome, char pGenero, int pId, int pIdade) {
		super(pNome, pGenero, pId);
		this.setIdade(pIdade);
	}
	
	public Saudavel(Pessoa pPessoa, int pIdade) {
		super(pPessoa);
		this.setIdade(pIdade);
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public String toString() { // Identificador, Nome completo, Gênero por extenso, Idade e Situação
		String formato = "%-3d\t%-20s\t%-8s\t%-5d\t%-10s%n";
		String str = String.format(formato, getIdentificador(), getNomeCompleto(), getGeneroString(), getIdade(), "---");
		return str;
	}
}
