package saida;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import colecionadores.OrdenaNome;
import dados.ColecaoTimes;
import dados.TimeFutebol;

public class Visao {
	public static void mostraMensagemErro (String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void mostraMensagem (String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int mostraMenuConfirmacao (String mensagem, String titulo) {
		return JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int mostraMenu (String mensagem, String [] opcao) {
		return JOptionPane.showOptionDialog(null, mensagem, "Menu", 0, JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);
	}
	
	public static void mostraMensagemConsole (ColecaoTimes colecaoTimes) {
		if (colecaoTimes.getColecaoTimes().size() >= 1) {
			limpaTela(5);
			System.out.println(colecaoTimes.getColecaoTimes().size() + " time[s] registrado[s] com sucesso.");
		}
	}
	
	public static void mostraMenuRegistros (ColecaoTimes colecaoTimes) {
		String [] opcao = {"Ordem Alfabetica", "Ordem de Insercao", "Cancelar"};
		switch (mostraMenu("Escolha uma forma de apresentacao.", opcao)) {
		case 0:
			List<TimeFutebol> ordenado = new ArrayList<TimeFutebol>(colecaoTimes.getColecaoTimes());
			Collections.sort(ordenado, new OrdenaNome());
			mostraTimes(ordenado);
			break;
		case 1:
			mostraTimes(colecaoTimes.getColecaoTimes());
		}
	}

	private static void mostraTimes (List<TimeFutebol> colecaoTimes) {
		limpaTela(50);
		System.out.format("%-30s%s\n", "NOME", "ANOS VITORIOSOS");
		for (TimeFutebol time : colecaoTimes) {
			System.out.println(time);
		}
	}
	
	private static void limpaTela(int n) {
		for (int i = 0; i < n; i++)
			System.out.println();
	}
}
