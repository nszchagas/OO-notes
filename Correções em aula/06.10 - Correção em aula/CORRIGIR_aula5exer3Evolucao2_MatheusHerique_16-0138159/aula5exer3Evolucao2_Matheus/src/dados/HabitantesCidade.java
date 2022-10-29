package dados;

public class HabitantesCidade {
	// Declaracoes
	private Habitante habitantes[];

	// Metodo Construtor
	public HabitantesCidade(final int MAXIMO) {
		this.habitantes = new Habitante[MAXIMO];
	}

	// Getters e Setters
	public void setHabitantes(Habitante habitantes, int numeroCadastro) {
		this.habitantes[numeroCadastro] = habitantes;
	}

	public Habitante getHabitantes(int numeroCadastro) {
		return habitantes[numeroCadastro];
	}

	public Habitante[] getHabitantes() {
		return habitantes;
	}
}