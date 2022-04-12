package view.tables;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;  
import java.util.Date;


import javax.swing.table.AbstractTableModel;

import model.Funcionario;

public class FuncionarioTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_NOME = 0;
	private static final int COL_ANIVERSARIO = 1;
	private static final int COL_INGRESSO = 2;
	private static final int COL_ENDERECO = 3;
	private static final int COL_HABILITACAO = 4;

	private List<Funcionario> valores;       

	//Esse é um construtor, que recebe a nossa lista de clientes
	public FuncionarioTableModel(List<Funcionario> valores) {
		this.valores = new ArrayList<Funcionario>(valores);
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
		if (column == COL_NOME) return "Nome";
		if (column == COL_ANIVERSARIO) return "Aniversário";
		if (column == COL_INGRESSO) return "Ingresso";
		if (column == COL_ENDERECO) return "Endereço";
		if (column == COL_HABILITACAO) return "Habilitação";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column) {
		//Precisamos retornar o valor da coluna column e da linha row.
		Funcionario funcionario = valores.get(row);
		if (column == COL_NOME)
			return funcionario.getNome();
		else 
			if (column == COL_ANIVERSARIO) 
					return funcionario.getAniversario();
			else
				if (column == COL_INGRESSO) 
					return funcionario.getIngresso();
				else
					if (column == COL_ENDERECO) 
						return funcionario.getEndereco();
					else
						if (column == COL_HABILITACAO) 
							return funcionario.getHabilitacao();
		return ""; //Nunca deve ocorrer
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Funcionario funcionario = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parï¿½metro.
		//Note que vc poderia alterar 2 campos ao invï¿½s de um sï¿½.
		if (columnIndex == COL_NOME)
			funcionario.setNome(aValue.toString());
		else 
			if (columnIndex == COL_ANIVERSARIO) {
				try {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date1 = formatter.parse(aValue.toString());
				funcionario.setAniversario(new java.sql.Date(date1.getTime()));
				}catch(ParseException e) {
					e.printStackTrace();
				}
			}
			else
				if (columnIndex == COL_INGRESSO) {
					try {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date1 = formatter.parse(aValue.toString());
					funcionario.setIngresso(new java.sql.Date(date1.getTime()));
					}catch(ParseException e) {
						e.printStackTrace();
					}
				}
				else 
					if (columnIndex == COL_ENDERECO) 
						funcionario.setEndereco(aValue.toString());
					else
						if(columnIndex == COL_HABILITACAO)
							funcionario.setHabilitacao(aValue.toString());
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
	public Funcionario get(int row) {
		return valores.get(row);
	}
	
}
