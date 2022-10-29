package valida;

import java.util.ArrayList;
import java.util.InputMismatchException;

import dados.Hospital;
import dados.Pessoa;
import leitura.Leitura;
import saida.Visao;

public class Valida {

	// Pergunta se o usuário quer continuar a fazer os cadastros
	public static boolean isContinua(Hospital pacientes) {
		// Declaracoes
		Character opcao;

		// Instrucoes
		Visao.mostraDados(pacientes);
		
		
		
		Visao.limpaTela(3);
		System.out.println("Deseja continuar cadastrando?\nDigite 'S' se sim ou 'N' se não");
		opcao = Leitura.lerChar();
		while ((opcao != 'S') && (opcao != 'N') && (opcao != 's') && (opcao != 'n')) {
			Visao.limpaTela(30);
			System.out.print("Opção inválida! Continuar cadastrando?\nDigite 'S' para sim e 'N' para não: ");
			opcao = Leitura.lerChar();
		}
		Visao.limpaTela(30);
		return ((opcao == 'S') ? true : (opcao == 's') ? true : false);
	}

	public static Integer isIdentificador(Hospital pessoa) {
		// Declaracoes
		Integer identificador = 100;
		Integer MAIOR = 100;

		// Instrucoes
		try {
			System.out.println("Digite a identificacao do paciente (Maior que 100): ");
			identificador = Leitura.lerInt();
			if (identificador <= MAIOR) {
				System.err.println("Identificacao tem que ser maior que " + MAIOR + "! Tente novamente!");
				identificador = isIdentificador(pessoa);
			}
		} catch (InputMismatchException e) {
			System.err.println("Erro, entrada fora do padrão esperado (inteiros)! Tente novamente!\n ");
			identificador = isIdentificador(pessoa);
		}
		return identificador;
	}

	public static StringBuffer isNome() {
		// Declaracoes
		String nome;
		StringBuffer nomesb = new StringBuffer();
		// Instrucoes
		do {
			Visao.limpaTela(1);
			System.out.println("Digite o nome completo do paciente: ");
			nome = Leitura.lerLinha();
			if (nome.length() <= 2) {
				Visao.limpaTela(2);
				System.err.println("Nome invalido. Nome tem que conter mais que 2 caracteres!");
			}
		} while (nome.isEmpty() || nome.length() <= 2);
		nomesb.append(nome);
		return nomesb;
	}

	public static StringBuffer isSaude() {
		// Declaracoes
		Character saude;
		String situacao = new String();
		StringBuffer sb = new StringBuffer();
		
		// Instrucoes
		
		Visao.limpaTela(2);
		
		System.out.println(
				"Digite a letra da situacao de saude do paciente (T = contaminada  em  Tratamento, F = contaminada falecida, C = contaminada  Curada  e S = Sem contaminação): ");
		saude = Leitura.lerChar();
		
		if (saude == null || !saude.equals('T') && !saude.equals('C') && !saude.equals('F') && !saude.equals('S')) {
			sb = isSaude();
		}

		if (saude.equals('T')) {
			situacao = "Contaminada  em  Tratamento";
			sb.append(situacao);
		}
		if (saude.equals('F')) {
			situacao = "Contaminada falecida";
			sb.append(situacao);
		}
		if (saude.equals('C')) {
			situacao = "Contaminada  Curada";
			sb.append(situacao);
		}
		if (saude.equals('S')) {
			situacao = "Sem Contaminação";
			sb.append(situacao);
		}
		return sb;
	}

	public static Integer isIdade() {
		Integer idade = 0;

		try {
			System.out.println("Digite a idade do paciente (em anos, digite 0 se nao completou 1 ano de idade): ");
			idade = Leitura.lerInt();
			if (idade < 0 || idade > 150) {
				System.err.println(
						"Idade invalida, idade tem que ser maior que 0 e menor que 150 anos de idade! Tente novamente!");
				idade = isIdade();
			}
		} catch (InputMismatchException e) {
			System.err.println("Erro, entrada fora do padrão esperado (inteiros)! Tente novamente!\n ");
			idade = isIdade();
		}
		return idade;
	}

	public static StringBuffer isGestante() {
		// Declaracoes
		Character gestante;
		String situacao = new String();
		StringBuffer sb = new StringBuffer();
		// Instrucoes
		Visao.limpaTela(2);
		System.out.println(
				"Digite a letra da situacao de gestacao da paciente (S = Sim, N = Nao Tem Certeza, T = Nao Tem Certeza): ");

		gestante = Leitura.lerChar();

		if (gestante == null || gestante.equals('T') || gestante.equals('N') || gestante.equals('S')) {
			sb = isSaude();
		}

		if (gestante.equals('T')) {
			situacao = "Nao Tem Certeza";
			sb.append(situacao);
		}
		if (gestante.equals('N')) {
			situacao = "Nao Tem Certeza";
			sb.append(situacao);
		}
		if (gestante.equals('S')) {
			situacao = "Sim";
			sb.append(situacao);
		}

		return sb;
	}

	public static StringBuffer isSexo() {
		// Declaracoes
		Character sexo;
		StringBuffer sb = new StringBuffer();
		Integer idade;
		StringBuffer gestacao;
		// Instrucoes
		do {
			System.out.println("Informe seu sexo (M para masculino /F para feminino):");

			sexo = Leitura.lerChar();
			sb.append((sexo.equals('M')) ? "MASCULINO" : (sexo.equals('F')) ? "FEMININO" : null);

//			if (sexo.equals('M')) 
//				idade = isIdade();
//			
//			if (sexo.equals('F'))
//				gestacao = isGestante();

			if (sb.equals(null)) {
				System.err.println("Não tem sexo correspondente, tente novamente!");
				sb = isSexo();
			}

		} while (sexo == null);

		return sb;
	}

	public static int isOpcao() {
		Integer escolha = -1;

		try {
			escolha = Leitura.lerInt();
			if (escolha < 0 || escolha > 3) {
				System.err.println("Erro, opcao invalida");
				escolha = isOpcao();
			}
		} catch (InputMismatchException e) {
			System.err.println("Erro, a entrada deve ser numerica(inteiros).");
			escolha = isOpcao();
		}
		return escolha;
	}

}
