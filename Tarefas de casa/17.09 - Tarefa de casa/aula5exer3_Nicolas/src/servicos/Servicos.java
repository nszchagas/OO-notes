package servicos;

import java.util.Vector;

import dados.Pessoa;

public class Servicos {

	public static int getMenorIdade(Vector<Pessoa> vetor) {
		int menorIdade = 200;

		for (int aux = 0; aux < vetor.size(); aux++) {
			if (vetor.elementAt(aux).getIdade() < menorIdade)
				menorIdade = vetor.elementAt(aux).getIdade();
		}

		return menorIdade;
	}

	public static float getMaiorSalario(Vector<Pessoa> vetor) {
		float maiorSalario = 0;

		for (int aux = 0; aux < vetor.size(); aux++) {
			if (vetor.elementAt(aux).getSalario() > maiorSalario)
				maiorSalario = vetor.elementAt(aux).getSalario();
		}

		return maiorSalario;
	}

	public static float getMediaNumDeFilhos(Vector<Pessoa> vetor) {
		float media = 0;
		for (int aux = 0; aux < vetor.size(); aux++)
			media += vetor.elementAt(aux).getNumeroDeFilhos();

		return ((vetor.size() != 0) ? media / vetor.size() : media);
	}

	public static float getMediaSalario(Vector<Pessoa> vetor) {
		float media = 0;

		for (int aux = 0; aux < vetor.size(); aux++)
			media += vetor.elementAt(aux).getSalario();

		return ((vetor.size() != 0) ? media / vetor.size() : media);

	}

	public static float getMediaSalarialMasculinaAcimaDeValor(Vector<Pessoa> vetor, float minimo) {
		float media = 0;
		int qtdHomens = 0;

		for (int aux = 0; aux < vetor.size(); aux++)

			if (vetor.elementAt(aux).getSexo() == 'M' && vetor.elementAt(aux).getSalario() > minimo) {
				media += vetor.elementAt(aux).getSalario();
				qtdHomens++;

			}

		return ((qtdHomens != 0) ? media / qtdHomens : media);
	}

	public static int getNumPessoasSalarioAcimaDaMedia(Vector<Pessoa> vetor) {
		int qtdPessoas = 0;
		for (int aux = 0; aux < vetor.size(); aux++)
			if (vetor.elementAt(aux).getSalario() >= getMediaSalario(vetor))
				qtdPessoas++;
		return qtdPessoas;
	}

}
