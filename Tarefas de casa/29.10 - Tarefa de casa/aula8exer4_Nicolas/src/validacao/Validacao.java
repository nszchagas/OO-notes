package validacao;

import dados.Empresa;
import visao.Visao;

public class Validacao {

	public static boolean isMatricula(int matricula, Empresa empresa) {
		if (matricula <= 0) {
			Visao.mostraMensagemErro("A matricula deve ser inteira e positiva.");
			return false;
		} else if (empresa.getEmpregados().size() > 0) {
			if (empresa.getDuplicados(matricula) != null) {
				Visao.mostraMensagemErro("Matricula ja inserida!");
				return false;
			}
		}
		return true;

	}

	public static boolean isArea(int area) {
		if (area <= 0)
			Visao.mostraMensagemErro("A area deve ser inteira e positiva.");
		return (area > 0);
	}

	public static boolean isNome(String texto) {
		if (texto == null || texto.isEmpty())
			Visao.mostraMensagemErro("O nome nao pode estar em branco.");
		return (texto != null && !texto.isEmpty());
	}

	public static boolean isValorDinheiro(Float salario) {
		if (salario <= 0)
			Visao.mostraMensagemErro("O salario deve ser positivo.");
		return (salario > 0);

	}

}
