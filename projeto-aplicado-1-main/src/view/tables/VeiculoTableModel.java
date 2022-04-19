package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import model.Veiculo;

public class VeiculoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_PLACA = 0;
	private static final int COL_MODELO = 1;
	private static final int COL_KM = 2;
	private static final int COL_CONSUMO = 3;

	private List<Veiculo> valores;       

	//Esse é um construtor, que recebe a nossa lista de clientes
	public VeiculoTableModel(List<Veiculo> valores) {
		this.valores = new ArrayList<Veiculo>(valores);
	}

	public int getRowCount() {
		//Quantas linhas tem sua tabela? Uma para cada item da lista.
		return valores.size();
	}

	public int getColumnCount() {
		//Quantas colunas tem a tabela? Nesse exemplo, sï¿½ 2.
		return 4;
	}

	public String getColumnName(int column) {
		//Qual é o nome das nossas colunas?
		if (column == COL_PLACA) return "Placa";
		if (column == COL_MODELO) return "Modelo";
		if (column == COL_KM) return "Quilometragem";
		if (column == COL_CONSUMO) return "Consumo";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column) {
		//Precisamos retornar o valor da coluna column e da linha row.
		Veiculo veiculo = valores.get(row);
		if (column == COL_PLACA)
			return veiculo.getPlaca();
		else 
			if (column == COL_MODELO) 
					return veiculo.getModelo();
			else
				if (column == COL_KM) 
					return veiculo.getKm();
				else
					if (column == COL_CONSUMO) 
						return veiculo.getConsumo();
		return ""; //Nunca deve ocorrer
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Veiculo veiculo = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parï¿½metro.
		//Note que vc poderia alterar 2 campos ao invï¿½s de um sï¿½.
		if (columnIndex == COL_PLACA)
			veiculo.setPlaca(aValue.toString());
		else 
			if (columnIndex == COL_MODELO) 
				veiculo.setModelo(aValue.toString());
			else
				if (columnIndex == COL_KM) 
					veiculo.setKm(Integer.parseInt(aValue.toString()));
				else 
					if (columnIndex == COL_CONSUMO) 
						veiculo.setConsumo(Float.parseFloat(aValue.toString()));
	}

	public Class<?> getColumnClass(int columnIndex) {
		//Qual a classe das nossas colunas? Como estamos exibindo texto, ï¿½ string.
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda ï¿½.
		return true;
	}
	//Já que esse tableModel é de clientes, vamos fazer um get que retorne um objeto cliente inteiro.
	//Isso elimina a necessidade de chamar o getValueAt() nas telas. 
	public Veiculo get(int row) {
		return valores.get(row);
	}
	
}
