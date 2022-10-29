package dados;

public class Homem extends Pessoa {
	private Integer idade;
	
	public Homem(String nome, String sit_saude, Integer idade) {
		super(nome, sit_saude);
		setIdade(idade);
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}	
	
	public String toString() {
		String formato = "%-3s%-35s%-15s%-20s%-25s%\n";
		return String.format(formato ,"", this.getNome(), this.getSituacaoSaude(), this.getIdade(), '-');
	}
}
