package validacao;

import java.util.Calendar;

import dados.Galeria;
import visao.Visao;

public class Validacao {

	private static boolean validaNomeSeparado(String nome) {
		return (nome.length() >= 2);
	}

	public static boolean isPreco(float preco) {
		if (preco <= 0)
			Visao.mensagemValorInvalido("o preco deve ser maior do que zero!");
		return (preco > 0);
	}

	public static boolean isNome(String nome) {
		boolean nomeValido = false;
		for (int contador = 0; contador < nome.split(" ").length; contador++)
			nomeValido = validaNomeSeparado(nome.split(" ")[contador]);
		if (!nomeValido)
			Visao.mensagemValorInvalido("cada nome deve ter pelo menos 2 letras.");
		return nomeValido;
	}

	public static boolean isAno(int ano) {
		final int ANOMINIMO = 1000, ANOMAX = Calendar.getInstance().get(Calendar.YEAR);
		if (ano <= ANOMINIMO || ano > ANOMAX)
			Visao.mensagemValorInvalido("o ano deve estar entre " + ANOMINIMO + " e " + ANOMAX);
		return (ano > ANOMINIMO && ano <= ANOMAX);

	}

	public static boolean isCodigo(Integer codigo) {
		if (codigo.toString().trim().charAt(0) != '1')
			Visao.mensagemValorInvalido("o codigo deve comecar com 1");
		return (codigo.toString().trim().charAt(0) == '1');
	}

	public static boolean isCodigoValidoPintor(int codigo, Galeria galeria) {
		boolean codRepetido = false;

		if (!isCodigo(codigo))
			return false;

		codRepetido = galeria.getCodigosPintor().contains(codigo);

		if (codRepetido)
			Visao.mostraMensagem(
					"Codigo ja cadastrado. Insira outro ou escolha cadastrar novo quadro para esse pintor.");
		return (!codRepetido);

	}

	public static boolean isCodigoValidoQuadro(int codigo, Galeria galeria) {
		boolean codRepetido = false;

		if (!isCodigo(codigo))
			return false;
		
		codRepetido = galeria.getCodigosQuadro().contains(codigo);

		if (codRepetido)
			Visao.mostraMensagem("Codigo ja cadastrado.");
		return (!codRepetido);

	}

	public static boolean isOpcao(int opcao, int MAX) {
		final int MIN = 0;
		if (opcao < MIN || opcao > MAX)
			Visao.mensagemValorInvalido("a opcao deve estar entre " + MIN + " e " + MAX);
		return (opcao <= MAX && opcao >= MIN);

	}

	public static boolean isSimOuNao(char opcao) {
		if (opcao != 'S' && opcao != 'N')
			Visao.mensagemValorInvalido("deve ser SIM ou NAO.");
		return (opcao == 'S' && opcao == 'N');
	}
}
