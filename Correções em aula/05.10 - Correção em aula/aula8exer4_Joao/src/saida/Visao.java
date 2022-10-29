package saida;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import dados.ColecaoEmpregados;
import dados.ColecaoTerrenos;
import dados.Empregado;
import dados.Terreno;

public class Visao {
	public static void mostraMensagemErro (String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void mostraMensagemAlerta (String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Alerta", JOptionPane.WARNING_MESSAGE);
	}
	
	public static void mostraMensagem (String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Informacao", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int mostraMenu (String mensagem, String [] opcao) {
		return JOptionPane.showOptionDialog(null, mensagem, "Menu", 0, JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);
	}
	
	public static void limpaTela (int qtd) {
		for (int i = 0; i < qtd; i++) {
			System.out.println();
		}
	}
	
	public static void mostraTerrenosIguais (ColecaoTerrenos terrenos, int valorEncontrado) {
		int qtd = 1;
		
		limpaTela(50);
		System.out.println("Terrenos com Areas Iguais a [" + valorEncontrado + "] metros quadrados.");
		for (Terreno terreno : terrenos.getColecaoTerrenos()) {
			if (terreno.getAreaOcupada().equals(valorEncontrado)) {
				System.out.println("Terreno " + new DecimalFormat("00").format(qtd++) + ": " + terreno.getEndereco());
			}
		}
	}
	
	public static void mostraResultadosFinais (ColecaoEmpregados empregados, ColecaoTerrenos terrenos) {
		limpaTela(50);
		System.out.format("%-40s%-40s%-30s%-50s%-30s%-40s\n", "MATRICULA", "NOME", "SALARIO", "ENDERECO", "AREA OCUPADA", "VALOR ATUAL");
		for (Empregado empregado : empregados.getColecaoEmpregados()) {
			System.out.println(empregado);
		}
		
		for (Terreno terreno : terrenos.getColecaoTerrenos()) {
			System.out.println(terreno);
		}
	}
}
