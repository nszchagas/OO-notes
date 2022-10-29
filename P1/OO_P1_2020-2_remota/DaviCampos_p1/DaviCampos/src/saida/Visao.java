package saida;

import dados.Pacientes;

public class Visao {

	public static void mensagem(String texto, int linhas) {
		limpaTela(linhas);
		System.out.println(texto);
	}
	
	public static void erro(String texto, int linhas) {
		limpaTela(linhas);
		System.err.println(texto);
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}

	public static void mostrarDados(Pacientes paciente) {
		String formato = "%-5s%-25s%-20s%-5s%-30s";
		
		if(paciente.getPacientes().size() == 0)
			Visao.erro("Nenhum paciente foi informado!", 4);
		else {
			System.out.format(formato, "IDENTIFICADOR |", "NOME COMPLETO |", "GENERO |",  "IDADE |", "SITUACAO DE SAUDE |");
			System.out.println("");
			for(Pacientes pacientes : paciente.getPacientes()) {
				System.out.println(pacientes);
			}
		}
	}
	
	public static void mostrarRelatorioFinal() {
		
	}

}
