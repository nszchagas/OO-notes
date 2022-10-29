package dados;

public class PessoaContaminada extends Pessoa{
	private Character estado;
	
	public PessoaContaminada(StringBuilder nome, char gen, int cod, char estado) {
		super(nome, gen, cod);
		this.setEstado(estado);
	}
	
	
	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		if(estado == 'E')
			return "EM TRATAMENTO";
		else if(estado == 'C')
			return "CURADO";
		else
			return "FALECIDO";
	}
	
	public String toString() {
		return (this.getCodigo()+"\t|\t"+this.getNome()+"\t|\t"+this.getGenero()+"\t|\t----------\t|\t"+this.getEstado());
	}
	
	
}
