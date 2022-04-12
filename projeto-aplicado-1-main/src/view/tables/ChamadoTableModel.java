package view.tables;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Chamado;
import model.Funcionario;

public class ChamadoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_FUNCIONARIO = 0;
	private static final int COL_VEICULO = 1;
	private static final int COL_DATA = 2;
	private static final int COL_ENDERECO = 3;
	private static final int COL_DISTANCIA = 4;

	private List<Chamado> valores;       

	//Esse é um construtor, que recebe a nossa lista de clientes
	public ChamadoTableModel(List<Chamado> valores) {
		this.valores = new ArrayList<Chamado>(valores);
	}

	public int getRowCount() {
		//Quantas linhas tem sua tabela? Uma para cada item da lista.
		return valores.size();
	}

	public int getColumnCount() {
		//Quantas colunas tem a tabela? Nesse exemplo, sï¿½ 2.
		return 5;
	}

	public String getColumnName(int column) {
		//Qual é o nome das nossas colunas?
		if (column == COL_FUNCIONARIO) return "Funcionário";
		if (column == COL_VEICULO) return "Veículo";
		if (column == COL_DATA) return "Data";
		if (column == COL_ENDERECO) return "Endereço";
		if (column == COL_DISTANCIA) return "Distância";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column) {
		//Precisamos retornar o valor da coluna column e da linha row.
		Chamado chamado = valores.get(row);
		if (column == COL_FUNCIONARIO)
			return chamado.getFuncionario();
		else 
			if (column == COL_VEICULO) 
					return chamado.getVeiculo().getPlaca();
			else
				if (column == COL_DATA) 
					return chamado.getData();
				else
					if (column == COL_ENDERECO) 
						return chamado.getEndereco();
					else
						if (column == COL_DISTANCIA) 
							return chamado.getDistancia();
		return ""; //Nunca deve ocorrer
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Chamado chamado = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parï¿½metro.
		//Note que vc poderia alterar 2 campos ao invï¿½s de um sï¿½.
		if (columnIndex == COL_FUNCIONARIO)
			chamado.getFuncionario().setNome(aValue.toString());
		else 
			if (columnIndex == COL_VEICULO) 
				chamado.getVeiculo().setPlaca(aValue.toString());
			else
				if (columnIndex == COL_DATA) {
					try {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date1 = formatter.parse(aValue.toString());
					chamado.setData(new java.sql.Date(date1.getTime()));
					}catch(ParseException e) {
						e.printStackTrace();
					}
				}
				else 
					if (columnIndex == COL_ENDERECO) 
						chamado.setEndereco(aValue.toString());
					else
						if(columnIndex == COL_DISTANCIA)
							chamado.setDistancia(Float.parseFloat(aValue.toString()));
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
	public Chamado get(int row) {
		return valores.get(row);
	}
	
}

