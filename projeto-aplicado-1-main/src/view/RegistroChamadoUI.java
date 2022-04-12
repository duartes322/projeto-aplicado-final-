package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ChamadoController;
import controller.FuncionarioController;
import controller.VeiculoController;
import model.Chamado;
import model.Funcionario;
import model.Veiculo;
import view.tables.ChamadoTableModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class RegistroChamadoUI extends JInternalFrame {
	private JTextField txtData;
	private JTextField txtEndereco;
	private JTextField txtDistancia;
	private JTable jtChamado;

	JComboBox<Funcionario> cbFuncionario = new JComboBox<Funcionario>();
	JComboBox<Veiculo> cbVeiculo = new JComboBox<Veiculo>();
	
	List<Chamado> chamados = new ArrayList<Chamado>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroChamadoUI frame = new RegistroChamadoUI();
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
	public RegistroChamadoUI() {
		setTitle("Registrar Chamados");
		setClosable(true);
		setBounds(100, 100, 568, 400);
		
		DefaultComboBoxModel<Funcionario> modelFuncionario = new DefaultComboBoxModel<Funcionario>(); 
		for(Funcionario funcionario : new FuncionarioController().listar()) {
			modelFuncionario.addElement(funcionario);
		}
		cbFuncionario.setModel(modelFuncionario);
		
		DefaultComboBoxModel<Veiculo> modelVeiculo = new DefaultComboBoxModel<Veiculo>(); 
		for(Veiculo veiculo : new VeiculoController().listar()) {
			modelVeiculo.addElement(veiculo);
		}
		cbVeiculo.setModel(modelVeiculo);
		
		JLabel lblFuncionario = new JLabel("Funcion\u00E1rio:");
		
		JLabel lblVeiculo = new JLabel("Ve\u00EDculo:");
		
		JLabel lblData = new JLabel("Data:");
		
		txtData = new JTextField();
		txtData.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Funcionario funcionario = (Funcionario) cbFuncionario.getSelectedItem();
					Veiculo veiculo = (Veiculo) cbVeiculo.getSelectedItem();
					String endereco = txtEndereco.getText();
					Float distancia = Float.parseFloat(txtDistancia.getText());
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date1 = formatter.parse(txtData.getText());
					Date data = new java.sql.Date(date1.getTime());
					Chamado chamado = new Chamado(0, data, endereco, distancia, veiculo, funcionario);
					chamados.add(chamado);
					jtChamado.setModel(new ChamadoTableModel(chamados));
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao adicionar o chamado.");
				}
			}
		});
		
		JLabel lblDistancia = new JLabel("Dist\u00E2ncia:");
		
		txtDistancia = new JTextField();
		txtDistancia.setColumns(10);
		
		jtChamado = new JTable();
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Funcionario funcionario = (Funcionario) cbFuncionario.getSelectedItem();
				Veiculo veiculo = (Veiculo) cbVeiculo.getSelectedItem();
				String endereco = txtEndereco.getText();
				Float distancia = Float.parseFloat(txtDistancia.getText());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date1 = formatter.parse(txtData.getText());
				Date data = new java.sql.Date(date1.getTime());
				Chamado chamado = new Chamado(0, data, endereco, distancia, veiculo, funcionario);
				new ChamadoController().salvar(chamado);
				JOptionPane.showMessageDialog(null, "Chamado registrado com sucesso!");
				dispose();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar o chamado.");
				}
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jtChamado, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFuncionario)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbFuncionario, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblVeiculo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbVeiculo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblData)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtData, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDistancia)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDistancia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEndereco)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdicionar))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFuncionario)
						.addComponent(cbFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblData)
						.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVeiculo)
						.addComponent(cbVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDistancia)
						.addComponent(txtDistancia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereco)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdicionar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jtChamado, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
