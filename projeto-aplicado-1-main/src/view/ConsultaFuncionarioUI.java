package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.FuncionarioController;
import controller.VeiculoController;
import model.Funcionario;
import model.Veiculo;
import view.tables.FuncionarioTableModel;
import view.tables.VeiculoTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaFuncionarioUI extends JInternalFrame {
	private JTable jtFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionarioUI frame = new ConsultaFuncionarioUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaFuncionarioUI() {
		setTitle("Consulta de Funcion\u00E1rios");
		setClosable(true);
		setBounds(100, 100, 643, 254);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new FuncionarioTableModel(new FuncionarioController().listar()).get(jtFuncionario.getSelectedRow());
				try {
					new FuncionarioController().excluir(funcionario.getIdFuncionario());
					JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
					jtFuncionario.setModel(new FuncionarioTableModel(new FuncionarioController().listar()));
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário.");
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new FuncionarioTableModel(new FuncionarioController().listar()).get(jtFuncionario.getSelectedRow());
				CadastroFuncionarioUI cadFuncionarioUI = new CadastroFuncionarioUI();
				cadFuncionarioUI.setFuncionarioEdicao(funcionario);
				cadFuncionarioUI.setVisible(true);
				getParent().add(cadFuncionarioUI,0);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAtualizar = new JButton("Atualizar dados");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtFuncionario.setModel(new FuncionarioTableModel(new FuncionarioController().listar()));
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(299, Short.MAX_VALUE)
					.addComponent(btnAtualizar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEditar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnExcluir)
						.addComponent(btnEditar)
						.addComponent(btnAtualizar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		jtFuncionario = new JTable();
		jtFuncionario.setModel(new FuncionarioTableModel(new FuncionarioController().listar()));
		scrollPane.setViewportView(jtFuncionario);
		getContentPane().setLayout(groupLayout);

	}

}
