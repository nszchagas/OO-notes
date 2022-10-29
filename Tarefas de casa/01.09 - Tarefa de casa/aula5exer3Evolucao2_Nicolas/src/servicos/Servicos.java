package servicos;

import dados.GrupoHabitantes;

public class Servicos {

	public static Integer getMenorIdade(GrupoHabitantes grupo) { //Integer para poder usar o .toString() na apresentacao
		Integer menorIdade = 500;
		for (int contador = 0; contador < grupo.getHabitantes().size(); contador++)
			menorIdade = Integer.min(menorIdade, grupo.getHabitanteNaPosicao(contador).getIdade());
		return menorIdade;
	}

	public static float getMaiorSalario(GrupoHabitantes grupo) {
		float maiorSalario = 0f;
		for (int contador = 0; contador < grupo.getHabitantes().size(); contador++)
			maiorSalario = Float.max(maiorSalario, grupo.getHabitanteNaPosicao(contador).getSalario());
		return maiorSalario;
	}

	public static float getMediaFilhos(GrupoHabitantes grupo) {
		float mediaFilhos = 0f;
		for (int contador = 0; contador < grupo.getHabitantes().size(); contador++)
			mediaFilhos += grupo.getHabitanteNaPosicao(contador).getNumeroFilhos();
		return (grupo.getHabitantes().size() != 0 ? mediaFilhos / grupo.getHabitantes().size() : mediaFilhos);
	}

	public static float getMediaSalario(GrupoHabitantes grupo) {
		float mediaSalario = 0f;
		for (int contador = 0; contador < grupo.getHabitantes().size(); contador++)
			mediaSalario += grupo.getHabitanteNaPosicao(contador).getSalario();
		return (grupo.getHabitantes().size() != 0 ? mediaSalario / grupo.getHabitantes().size() : mediaSalario);
	}

	public static float getMediaHomensAcimaMin(GrupoHabitantes grupo) {
		Float mediaHomens = 0f;
		int contaHomens = 0;
		final int MIN = 300;
		for (int contador = 0; contador < grupo.getHabitantes().size(); contador++)
			if (grupo.getHabitanteNaPosicao(contador).getSalario() > MIN) {
				mediaHomens += grupo.getHabitanteNaPosicao(contador).getSalario();
				contaHomens++;
			}
		return (contaHomens != 0 ? mediaHomens / contaHomens : mediaHomens);
	}

	public static Integer getPessoasAcimaMediaSalarial(GrupoHabitantes grupo) {
		Integer numPessoas = 0;
		Float mediaSalarial = getMediaSalario(grupo);
		for (int contador = 0; contador < grupo.getHabitantes().size(); contador++)
			if (grupo.getHabitanteNaPosicao(contador).getSalario() > mediaSalarial)
				numPessoas++;
		return numPessoas;
	}
}
