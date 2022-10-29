package dados;

public class Gerente extends Funcionario {
	private Integer quantidadeProjetos;

	public Gerente(String nome, String dataNascimento, String cpf, Integer quantidadeProjetos) {
		super(nome, dataNascimento, cpf);
		setQuantidadeProjetos(quantidadeProjetos);
	}

	@Override
	public float calculaSalario() {
		return super.getPiso() * (1 + 0.5F * quantidadeProjetos);
	}

	public Integer getQuantidadeProjetos() {
		return quantidadeProjetos;
	}

	public void setQuantidadeProjetos(Integer quantidadeProjetos) {
		this.quantidadeProjetos = quantidadeProjetos;
	}

	@Override
	public float[] calculaSalarioCategorias(float[] salariosRegularPrestadorGerente) {
		return new float[] { salariosRegularPrestadorGerente[0], salariosRegularPrestadorGerente[1],
				salariosRegularPrestadorGerente[2] + this.calculaSalario() };
	}

	@Override
	public int[] contaFuncionariosCategorias(int[] qtdRegularPrestadorGerente) {
		return new int[] { qtdRegularPrestadorGerente[0], qtdRegularPrestadorGerente[1],
				qtdRegularPrestadorGerente[2] + 1 };
	}
}
