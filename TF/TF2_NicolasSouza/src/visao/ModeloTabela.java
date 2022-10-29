package visao;

import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
class ModeloTabela extends JTable {

	ModeloTabela(Vector<Vector<String>> lista) {
		Vector<String> colunas = new Vector<String>();
		colunas.add("ID");
		colunas.add("Nome completo");
		colunas.add("Situacao de saúde");
		colunas.add("Idade");
		colunas.add("Já foi gestante?");

		DefaultTableModel modeloTabela = new DefaultTableModel(lista, colunas);
		setModel(modeloTabela);
		getTableHeader().setReorderingAllowed(false);
		getTableHeader().setResizingAllowed(false);
		setAutoCreateRowSorter(true);
		getColumnModel().getColumn(0).setMaxWidth(40); // ID
		getColumnModel().getColumn(1).setMaxWidth(200); // NOME
		getColumnModel().getColumn(2).setMaxWidth(200); // SAUDE
		getColumnModel().getColumn(3).setMaxWidth(40); // IDADE
		getColumnModel().getColumn(4).setMaxWidth(160); // GESTANTE
		setRowSelectionAllowed(false);
		setColumnSelectionAllowed(false);

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		setDefaultRenderer(Object.class, renderer); // todas as células que tem valor do tipo Object serão
													// centralizadas
	}

}
