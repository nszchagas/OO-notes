package dados;

public class Feminino extends Pessoa {
	private Character historicoGestante;

	public Feminino(String codigoPessoa, StringBuilder nome, Character situacaoSaude, Character historicoGestante) {
		super(codigoPessoa, nome, situacaoSaude);
		setHistoricoGestante(historicoGestante);
	}

	//Getters
	public Character getHistoricoGestante() {
		return historicoGestante;
	}
	
	//Setters
	public void setHistoricoGestante(Character historicoGestante) {
		this.historicoGestante = historicoGestante;
	}

	//Metodo toString
	public String toString() {
		return String.format("%-30s%-30s%-35s%-30s%-20%", getCodigoPessoa(), getNome(), getSituacaoSaude(),
				 "#", getHistoricoGestante());
	}
	
	public int mulheresSemContaminacao() {
		int contador = 0;
		if (getSituacaoSaude() == 'S')
			contador++;
		return contador;
	}

}
