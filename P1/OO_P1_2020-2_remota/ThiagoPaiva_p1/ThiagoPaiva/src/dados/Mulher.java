package dados;

public class Mulher extends Pessoa {
	private Character foiGestante;

	public Mulher(Integer id, StringBuilder nomeCompleto, Character foiGestante, Character situacaoSaude) {
		super(id, nomeCompleto, situacaoSaude);
		this.setFoiGestante(foiGestante);
	}

	public Character getFoiGestante() {
		return foiGestante;
	}

	public void setFoiGestante(Character foiGestante) {
		this.foiGestante = foiGestante;
	}

	public String getFoiGestanteExtenso() {
		switch (getFoiGestante()) {
		case 'S':
			return "Sim";
		case 'N':
			return "Não";
		default:
			return "Não tem certeza";
		}
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%-10s%-20s", "-", getFoiGestanteExtenso());
	}
}
