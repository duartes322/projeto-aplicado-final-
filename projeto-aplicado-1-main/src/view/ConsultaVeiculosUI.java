package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.VeiculoController;
import model.Veiculo;
import view.tables.VeiculoTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaVeiculosUI extends JInternalFrame {
	private JTable jtVeiculos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaVeiculosUI frame = new ConsultaVeiculosUI();
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
	public ConsultaVeiculosUI() {
		setTitle("Consulta de Ve\u00EDculos");
		setClosable(true);
		setBounds(100, 100, 833, 308);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new VeiculoTableModel(new VeiculoController().listar()).get(jtVeiculos.getSelectedRow());
				try {
					new VeiculoController().excluir(veiculo.getIdVeiculo());
					JOptionPane.showMessageDialog(null, "Veículo excluído com sucesso!");
					jtVeiculos.setModel(new VeiculoTableModel(new VeiculoController().listar()));
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir veículo.");
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new VeiculoTableModel(new VeiculoController().listar()).get(jtVeiculos.getSelectedRow());
				CadastroVeiculosUI cadVeiculosUI = new CadastroVeiculosUI();
				cadVeiculosUI.setVeiculoEdicao(veiculo);
				cadVeiculosUI.setVisible(true);
				getParent().add(cadVeiculosUI,0);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAtualizar = new JButton("Atualizar dados");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtVeiculos.setModel(new VeiculoTableModel(new VeiculoController().listar()));
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(468)
							.addComponent(btnAtualizar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 773, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnExcluir)
						.addComponent(btnEditar)
						.addComponent(btnAtualizar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		jtVeiculos = new JTable();
		jtVeiculos.setModel(new VeiculoTableModel(new VeiculoController().listar()));
		scrollPane.setViewportView(jtVeiculos);
		getContentPane().setLayout(groupLayout);

	}
}
