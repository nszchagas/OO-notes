package servicos;

import dados.*;

public class Servicos {
	// Retorna a menor idade registrada
	public static int menorIdade(int idade, int menor) {
		return (idade < menor) ? idade : menor;
	}

	// Retorna o maior sal�rio registrado
	public static float maiorSalario(float salario, float maior) {
		return (salario > maior) ? salario : maior;
	}

	// Calcula a quantidade de pessoas que tem sal�rio maior que a m�dia de todas as
	// pessoas pesquisadas (registradas)
	public static int pessoasSalarioMaiorMedia(HabitantesCidade habitantes, float mediaSalarios, int totalHabitantes) {
		// Declaracoes
		int quantidadePessoas = 0;

		// Instru��es
		for (int aux = 0; aux < totalHabitantes; aux++) {
			if (habitantes.getHabitantes(aux).getSalario() > mediaSalarios)
				quantidadePessoas++;
		}
		return quantidadePessoas;
	}
}
