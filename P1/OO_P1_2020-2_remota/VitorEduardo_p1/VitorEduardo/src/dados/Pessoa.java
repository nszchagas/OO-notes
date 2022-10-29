package dados;

public class Pessoa {
	private String nome;
	private String sit_saude;
	
	public Pessoa(String nome, String sit_saude) {
		setNome(nome);
		setSituacaoSaude(sit_saude);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSituacaoSaude() {
		return sit_saude;
	}
	
	public void setSituacaoSaude(String sit_saude) {
		this.sit_saude = sit_saude;
	}
	
	public Integer numeroCadastro() {
		Integer num_cadastro = 100;
		return num_cadastro++;
	}
}
