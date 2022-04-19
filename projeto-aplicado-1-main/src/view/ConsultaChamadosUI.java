package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ChamadoController;
import controller.VeiculoController;
import model.Chamado;
import model.Veiculo;
import view.tables.ChamadoTableModel;
import view.tables.VeiculoTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ConsultaChamadosUI extends JInternalFrame {
	private JTable jtChamados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaChamadosUI frame = new ConsultaChamadosUI();
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
	public ConsultaChamadosUI() {
		setTitle("Consulta de Chamados");
		setClosable(true);
		setBounds(100, 100, 690, 286);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado chamado = new ChamadoTableModel(new ChamadoController().listar()).get(jtChamados.getSelectedRow());
				try {
					new ChamadoController().excluir(chamado.getIdChamado());
					JOptionPane.showMessageDialog(null, "Chamado excluído com sucesso!");
					jtChamados.setModel(new ChamadoTableModel(new ChamadoController().listar()));
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir chamado.");
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado chamado = new ChamadoTableModel(new ChamadoController().listar()).get(jtChamados.getSelectedRow());
				RegistroChamadoUI regChamadoUI = new RegistroChamadoUI();
				regChamadoUI.setChamadoEdicao(chamado);
				regChamadoUI.setVisible(true);
				getParent().add(regChamadoUI, 0);
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar Dados");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtChamados.setModel(new ChamadoTableModel(new ChamadoController().listar()));
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(273)
							.addComponent(btnAtualizar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE)))
					.addGap(12))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnExcluir)
						.addComponent(btnEditar)
						.addComponent(btnAtualizar))
					.addContainerGap(149, Short.MAX_VALUE))
		);
		
		jtChamados = new JTable();
		jtChamados.setModel(new ChamadoTableModel(new ChamadoController().listar()));
		scrollPane.setViewportView(jtChamados);
		getContentPane().setLayout(groupLayout);

	}

}
