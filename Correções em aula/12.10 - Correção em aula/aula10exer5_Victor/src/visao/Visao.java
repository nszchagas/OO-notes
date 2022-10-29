package visao;

import java.util.Collections;
import javax.swing.JOptionPane;
import dados.*;

public class Visao {
	public static int confirmar(String message) {
		return JOptionPane.showConfirmDialog(null, message, "Pergunta", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE);
	}

	public static void mostraMensagemAviso(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Alerta", JOptionPane.WARNING_MESSAGE);
	}

	public static void mostraResultado(Colecao listaCidades) {
		if (listaCidades.getListaCidades().size() != 0) {
			System.out.println("DDD\tCidade\n=== ============");

			Collections.sort(listaCidades.getListaCidades());
			for (Cidade cidade : listaCidades.getListaCidades())
				System.out.println(cidade);

		}
	}
}
