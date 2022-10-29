package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import saida.Visao;

public class Validacao {

	public static char validaOpcao(String numerosValidos) {
		char opcao;

		do {
			opcao = Leitura.lerChar();

			if (!numerosValidos.contains(Character.toString(opcao)))
				Visao.erro("Voce escreveu uma opcao invalida, por favor insira uma opcao correta:", 2);

		} while (!numerosValidos.contains(Character.toString(opcao)));

		return opcao;
	}

	public static StringBuilder nome() {
		String nome;
		StringBuilder nomeCompleto = new StringBuilder();

		do {
			Visao.mensagem("Por favor digite o nome completo do Pacinte:", 3);
			nome = Leitura.lerString();

			if (nome.isBlank() || nome.isEmpty() && nome.length() < 3) 
				Visao.erro("Erro! Voce nao pode deixar o nome em branco e ele nao pode conter menos de 3 caracteres!", 2);

		} while (nome.isBlank() || nome.isEmpty() && nome.length() < 3);

		nomeCompleto.append(nome);
		
		return nomeCompleto;
	}

	public static Character genero() {
		char sexo = 0;
		
		Visao.mensagem("Digite o sexo do paciente: 'M - Masculino ou F - Feminino'", 0);
		sexo = Leitura.lerChar();
		while (!"MF".contains(Character.toString(sexo))) {
			Visao.erro("Entrada invalida! Digite apenas 'M' ou 'F'", 2);
			sexo = Leitura.lerChar();
		}
		
		return sexo;
	}

	public static Integer identificador() {
		final int MINIMO = 1;
		int identificador = 0;
		
		do {
		Visao.mensagem("Digite o codigo identificador desse paciente: (Nao pode ser menor que 1!)", 0);
		identificador = Leitura.lerInt();
		try {
		if(identificador < MINIMO)
			Visao.erro("Erro! O codigo nao pode ser menor que 1!", 2);
		}catch(InputMismatchException e){
			Visao.erro("Voce deve digitar apenas numeros.", 2);
		}
	}while(identificador < MINIMO);
		
		return identificador;
	}

	public static Integer idade() {
		int idade;
		
		do {
			Visao.mensagem("Por favor digite a idade do paciente!", 0);
			idade = Leitura.lerInt();
			try {
			if(idade <= 0 || idade > 130)
				Visao.erro("Erro! O paciente nao pode ter menos que 0 anos e mais que 130 anos!", 2);
			}catch(InputMismatchException e){
				Visao.erro("Voce deve digitar apenas numeros.", 2);
			}
		}while(idade <= 0 || idade > 48);
	
	return idade;
}

	public static Character situacaoDeSaude() {
		char situacaoDeSaude;
		
		Visao.mensagem("Por favor digite o estado de saude do paciente: ('E' - em tratamento, 'F' - Falecido, 'C' - Curado)", 0);
		situacaoDeSaude = Leitura.lerChar();
		while (!"EFC".contains(Character.toString(situacaoDeSaude))) {
			Visao.erro("Entrada invalida! Digite apenas 'E', 'F' ou 'C'.", 2);
			situacaoDeSaude = Leitura.lerChar();
		}

		return situacaoDeSaude;
	}

}
