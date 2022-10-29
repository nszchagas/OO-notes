package principal;

import dados.*;
import validacao.Validacao;
import saida.Saida;
import servicos.Servicos;

public class Principal {
	public static void main(String[] args) {
		// Declaracoes
		final int MAXIMO = 1000;
		int totalHabitantes = 0;
		int menorIdade = 0;
		int totalHomens = 0;
		float maiorSalario = 0f;
		float mediaFilhos = 0f;
		float mediaSalarios = 0f;
		float mediaHomens = 0f;
		int pessoasSalarioMaiorMedia = 0;

		// Instruções
		HabitantesCidade grupoHabitantes = new HabitantesCidade(MAXIMO);
		do {
			System.out.println("Habitante " + (totalHabitantes + 1) + ":");
			Habitante habitante = new Habitante(Validacao.validaSalario(), Validacao.validaIdade(),
					Validacao.validaSexo(), Validacao.validaNumeroFilhos());
			grupoHabitantes.setHabitantes(habitante, totalHabitantes);

			if (totalHabitantes == 0) {
				menorIdade = habitante.getIdade();
				maiorSalario = habitante.getSalario();
			}
			menorIdade = Servicos.menorIdade(habitante.getIdade(), menorIdade);
			maiorSalario = Servicos.maiorSalario(habitante.getSalario(), maiorSalario);
			mediaFilhos += habitante.getNumeroFilhos();
			mediaSalarios += habitante.getSalario();
			if (habitante.getSalario() > 300f && habitante.getSexo() == 'M')
				mediaHomens += habitante.getSalario();
			if (habitante.getSexo() == 'M')
				totalHomens++;
			totalHabitantes++;
		} while (totalHabitantes < MAXIMO && Validacao.validaContinua());

		mediaFilhos /= totalHabitantes;
		mediaSalarios /= totalHabitantes;
		if (totalHomens != 0)
			mediaHomens /= totalHomens;
		pessoasSalarioMaiorMedia = Servicos.pessoasSalarioMaiorMedia(grupoHabitantes, mediaSalarios, totalHabitantes);

		Saida.imprimeResultado(MAXIMO, totalHabitantes, menorIdade, maiorSalario, mediaFilhos, mediaSalarios,
				mediaHomens, pessoasSalarioMaiorMedia);

	}
}
