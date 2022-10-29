package dados;

public class PessoaContaminada extends Pessoa {

	private Character atualSituacaoSaude;
	
	public PessoaContaminada(String nome, Character genero, Integer id, Character atualSituacaoSaude) {
		super(nome, genero, id);
		this.atualSituacaoSaude = atualSituacaoSaude;
	}
	
	public String getAtualSituacaoSaude() {
		return (atualSituacaoSaude == 'E') ? "Em Tratamento" : (atualSituacaoSaude == 'F') ? "Falecido" : "Curado";
	}
	
	@Override
	public String toString() {
		return getId()
			+ "\t" + getNome()
			+ "\t" + getGenero()
			+ "\t" 
			+ "\t" + getAtualSituacaoSaude(); 
	}

}
