package dados;

public class Mulher extends Pessoa {
	String gestante;
	
	public Mulher(String nome, String sit_saude, String gestante) {
		super(nome, sit_saude);
		
	}
	
	public String getGestante() {
		return gestante;
	}
	
	public void setGestante(String gestante) {
		this.gestante = gestante;
	}
	
	public String toString() {
		String formato = "%-3s%-35s%-15s%-20s%-25s%\n";
		return String.format(formato ,"", this.getNome(), this.getSituacaoSaude(), '-', this.getGestante());
	}

}
