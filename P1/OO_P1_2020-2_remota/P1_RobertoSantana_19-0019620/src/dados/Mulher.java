package dados;

public class Mulher extends Pessoa {
	private boolean gestante;

	public Mulher(int codigo, StringBuilder nome, char situacao, boolean gestante) {
		super(codigo, nome, situacao);
		setGestante(gestante);
	}

	public boolean getGestante() {
		return gestante;
	}

	public void setGestante(boolean gestante) {
		this.gestante = gestante;
	}
	
	public String toString() {
		String formato = "%-20s%-30s%-20s%-13s%-10s\n";
		String situacao = null;
		
		switch (this.getSituacao()) {
		case 'T':{
			situacao = "Contaminado em Tratamento";
			break;
		}
		case 'F':{
			situacao = "Contaminada Falecida";
			break;
		}
		case 'C':{
			situacao = "Contaminada e Curada";
			break;
		}
		case 'S':{
			situacao = "Nao contaminada";
		}
		}
		return String.format(formato, this.getCodigo(),
				this.getNome(),
				situacao,
				"--",
				(this.getGestante()) ? "Sim" : "Nao");
	}
	
}
