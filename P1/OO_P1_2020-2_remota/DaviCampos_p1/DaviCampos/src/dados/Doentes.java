package dados;

public class Doentes extends Pacientes {
	public Character estadoDeSaude;

	public Doentes(StringBuilder nomeCompleto, Character genero, Integer indentificador, Character estadoDeSaude) {
		super(nomeCompleto, genero, indentificador);
		setEstadoDeSaude(estadoDeSaude);
	}

	public Character getEstadoDeSaude() {
		return estadoDeSaude;
	}

	public void setEstadoDeSaude(Character estadoDeSaude) {
		this.estadoDeSaude = estadoDeSaude;
	}

	public String toString() {
		String formato = "%-5s%-25s%-20s%-5s%-30s";
		return String.format(formato, this.getIndentificador(), this.getNomeCompleto(), (this.getGenero() == 'M' ? "Masculino" : "Feminino"), "------",
				((this.getEstadoDeSaude() == 'E') ? "Em tratamento"
						: (this.getEstadoDeSaude() == 'F') ? "Falecido" : "Curado"));
	}
}
