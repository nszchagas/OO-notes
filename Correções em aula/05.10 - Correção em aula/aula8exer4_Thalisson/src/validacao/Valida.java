package validacao;

import dados.Empresa;
import leitura.Leitura;
import saida.Saida;

public class Valida {
	private static int converteEscolha(Object[] opcoes, Object escolha) {
		if (escolha == null)
			return -1;

		int index = 0;
		while (!opcoes[index].equals(escolha))
			index++;
		return index;
	}

	private static boolean isContinua() {
		return Leitura.lerConfirmacao("Deseja sair da opcao escolhida?", "Atencao", 0) != 0;
	}

	public static int validaEscolhaMenu(String... menu) {
		int escolha = converteEscolha(menu, Leitura.lerOpcao("Escolha a opcao desejada", "Menu", 1, menu));
		if (escolha == -1) {
			Saida.mostraMensagem("Janela fechou inesperadamente.", "Erro", 0);
			escolha = (isContinua() ? validaEscolhaMenu(menu) : -1);
		}

		return escolha;
	}

	public static StringBuilder validaNome() {
		String nome;
		do {
			nome = Leitura.lerString("Informe o nome:", "Cadastro", 1);
		} while (isStringVazia(nome) || isNomeComNumeros(nome));

		return new StringBuilder(nome);
	}

	private static boolean isStringVazia(String string) {
		if (string == null || (string = string.trim()).isEmpty()) {
			Saida.mostraMensagem("Campo nao pode estar vazio.", "Erro", 0);
			return true;
		}
		return false;
	}

	private static boolean isNomeComNumeros(String nome) {
		for (char c : nome.toCharArray()) {
			if (Character.isDigit(c)) {
				Saida.mostraMensagem("Nome nao pode conter numeros.", "Erro", 0);
				return true;
			}
		}
		return false;
	}

	public static float validaSalario() {
		float salario;
		do {
			try {
				salario = Float.parseFloat(Leitura.lerString("Informe o salario", "Cadastro", 1));
			} catch (NumberFormatException e) {
				Saida.mostraMensagem("A entrada deve ser numerica.", "Erro", 0);
				salario = validaSalario();
			}
		} while (!isNumeroPositivo(salario));

		return salario;
	}

	public static int validaMatricula(Empresa empresa) {
		int matricula;
		do {
			try {
				matricula = Integer.parseInt(Leitura.lerString("Informe a matricula", "Cadastro", 1));
			} catch (NumberFormatException e) {
				Saida.mostraMensagem("Matricula deve ser um numero inteiro.", "Erro", 0);
				matricula = validaMatricula(empresa);
			}
		} while (!isNumeroPositivo(matricula) || !isMatriculaUnica(empresa, matricula));

		return matricula;
	}

	private static boolean isMatriculaUnica(Empresa empresa, int matricula) {
		if (!empresa.isValorDuplicado(matricula))
			return true;
		Saida.mostraMensagem("Matricula deve ser unica.", "Erro", 0);
		return false;
	}

	public static StringBuilder validaEndereco() {
		String endereco;
		do {
			endereco = Leitura.lerString("Informe o endereco completo:", "Cadastro", 1);
		} while (isStringVazia(endereco));

		return new StringBuilder(endereco);
	}

	public static int validaArea() {
		int area;
		do {
			try {
				area = Integer.parseInt(Leitura.lerString("Informe a area ocupada:", "Cadastro", 1));
			} catch (NumberFormatException e) {
				Saida.mostraMensagem("Area deve ser um numero inteiro.", "Erro", 0);
				area = validaArea();
			}
		} while (!isNumeroPositivo(area));

		return area;
	}

	public static float validaPreco() {
		float preco;
		do {
			try {
				preco = Float.parseFloat(Leitura.lerString("Informe o preco:", "Cadastro", 1));
			} catch (NumberFormatException e) {
				Saida.mostraMensagem("Preco deve ser numerico.", "Erro", 0);
				preco = validaPreco();
			}
		} while (!isNumeroPositivo(preco));

		return preco;
	}

	public static int validaNumeroPositivo() {
		int numero;
		do {
			try {
				numero = Integer.parseInt(Leitura.lerString("Informe um numero positivo: ", "Analise", 1));
			} catch (NumberFormatException e) {
				Saida.mostraMensagem("Valor deve ser numerico", "Erro", 0);
				numero = validaNumeroPositivo();
			}
		} while (!isNumeroPositivo(numero));

		return numero;
	}

	private static <T extends Number> boolean isNumeroPositivo(T numero) {
		if (numero.doubleValue() > 0.0)
			return true;

		Saida.mostraMensagem("Valor deve ser maior do que 0.", "Erro", 0);
		return false;
	}
}
