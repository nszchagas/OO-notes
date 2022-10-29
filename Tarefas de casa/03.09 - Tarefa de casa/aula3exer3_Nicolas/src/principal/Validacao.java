package principal;
/*
 * Validar nome, idade e altura conforme:
 * nome = String nao vazia com no min. 3 caracteres
 * idade = int >0 e <151
 * altura = float > 0.4 e < 2.6 metros
 * 
 * 
 */

public class Validacao {

	public static boolean validaNome(String nome) {
		if (nome.length() < 3) {
			System.out.println("Nome invalido. Insira nome com no minimo 3 caracteres.");
			return false;
		} else
			return true;
	}

	public static boolean validaIdade(int idade) {
		final int IDADEMAX = 151, IDADEMIN = 0;
		if (idade <= IDADEMIN || idade >= IDADEMAX) {
			System.out.println("Idade invalida. Insira valor entre 0 e 151 anos.");
			return false;
		} else
			return true;
	}

	public static boolean validaAltura(float altura) {
		final float ALTURAMAX = 2.6F, ALTURAMIN = 0.4F;
		if (altura <= ALTURAMIN || altura >= ALTURAMAX) {
			System.out.println("Altura invalida. Insira valor entre 0,4 m e 2,6 m.");
			return false;
		} else
			return true;
	}

	public static boolean validaContinua(char continua, char LETRAFINAL) {
		if (continua != LETRAFINAL)
			return false;
		else
			return true;

	}

}
