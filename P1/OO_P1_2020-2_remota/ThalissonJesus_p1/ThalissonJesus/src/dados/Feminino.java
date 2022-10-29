package dados;

public class Feminino extends Pessoa {
	private Character situacaoGestante;
	
	public Feminino(int id, StringBuilder nome, char situacaoSaude, char situacaoGestante) {
		super(id, nome, situacaoSaude);
		this.situacaoGestante = situacaoGestante;
	}
	
	public String converteGestanteExtenso() {
		switch (situacaoGestante) {
		case 'S':
			return "Sim";
		case 'N':
			return "Nao";
		default:
			return "Talvez";
		}
	}

	public String toString() {
		return String.format("%s %-10.10s %s", super.toString(), "-", converteGestanteExtenso());
	}
}
