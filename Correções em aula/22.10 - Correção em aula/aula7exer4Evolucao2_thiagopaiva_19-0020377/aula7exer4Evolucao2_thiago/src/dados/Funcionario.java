package dados;

public class Funcionario extends Pessoa {

	public Funcionario(String nome, String dataNascimento, String cpf) {
		super(nome, dataNascimento, cpf);
	}

	public final float getPiso() {
		return 232.0f;
	}

	public float calculaSalario() {
		return getPiso() * 1.1F;
	}

	public float[] calculaSalarioCategorias(float[] salariosRegularPrestadorGerente) {
		return new float[] { salariosRegularPrestadorGerente[0] + this.calculaSalario(),
				salariosRegularPrestadorGerente[1], salariosRegularPrestadorGerente[2] };
	}

	public int[] contaFuncionariosCategorias(int[] qtdRegularPrestadorGerente) {
		return new int[] { qtdRegularPrestadorGerente[0] + 1, qtdRegularPrestadorGerente[1],
				qtdRegularPrestadorGerente[2] };
	}

}
