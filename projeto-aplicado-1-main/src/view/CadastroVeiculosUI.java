package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.VeiculoController;
import model.Veiculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroVeiculosUI extends JInternalFrame {
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtKm;
	private JTextField txtConsumo;
	private Veiculo veiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculosUI frame = new CadastroVeiculosUI();
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
	public CadastroVeiculosUI() {
		
		setClosable(true);
		setTitle("Cadastro de Ve\u00EDculos");
		setBounds(100, 100, 588, 283);
		
		JPanel jpCadastroVeicullos = new JPanel();
		jpCadastroVeicullos.setBorder(new TitledBorder(null, "Ve\u00EDculo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton brnCancelar = new JButton("Cancelar");
		brnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(veiculo != null && veiculo.getIdVeiculo() > 0) {
						veiculo.setPlaca(txtPlaca.getText());
						veiculo.setModelo(txtModelo.getText());
						veiculo.setKm(Integer.parseInt(txtKm.getText()));
						veiculo.setConsumo(Float.parseFloat(txtConsumo.getText()));
						new VeiculoController().atualizar(veiculo);
						JOptionPane.showMessageDialog(null, "Veículo atualizado com sucesso!");
					} else {
						Veiculo veiculo = new Veiculo(0, null, null, 0, 0);
						veiculo.setPlaca(txtPlaca.getText());
						veiculo.setModelo(txtModelo.getText());
						veiculo.setKm(Integer.parseInt(txtKm.getText()));
						veiculo.setConsumo(Float.parseFloat(txtConsumo.getText()));
					
						new VeiculoController().salvar(veiculo);
						JOptionPane.showMessageDialog(null, "Veículo salvo com sucesso!");
					}
					dispose();
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar o produto.");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(brnCancelar))
						.addComponent(jpCadastroVeicullos, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroVeicullos, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(brnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		JLabel jlPlaca = new JLabel("Placa:");
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		
		JLabel jlModelo = new JLabel("Modelo:");
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		
		JLabel jlKm = new JLabel("Quilometragem (km):");
		
		txtKm = new JTextField();
		txtKm.setColumns(10);
		
		JLabel jlConsumo = new JLabel("Consumo de gasolina (litros):");
		
		txtConsumo = new JTextField();
		txtConsumo.setColumns(10);
		GroupLayout gl_jpCadastroVeicullos = new GroupLayout(jpCadastroVeicullos);
		gl_jpCadastroVeicullos.setHorizontalGroup(
			gl_jpCadastroVeicullos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroVeicullos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroVeicullos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpCadastroVeicullos.createSequentialGroup()
							.addComponent(jlPlaca)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroVeicullos.createSequentialGroup()
							.addComponent(jlModelo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroVeicullos.createSequentialGroup()
							.addComponent(jlKm)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtKm, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroVeicullos.createSequentialGroup()
							.addComponent(jlConsumo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtConsumo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(211, Short.MAX_VALUE))
		);
		gl_jpCadastroVeicullos.setVerticalGroup(
			gl_jpCadastroVeicullos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroVeicullos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroVeicullos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPlaca)
						.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroVeicullos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlModelo)
						.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroVeicullos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlKm)
						.addComponent(txtKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroVeicullos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlConsumo)
						.addComponent(txtConsumo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		jpCadastroVeicullos.setLayout(gl_jpCadastroVeicullos);
		getContentPane().setLayout(groupLayout);

	}
	public void setVeiculoEdicao(Veiculo veiculo)
	{
		this.veiculo = veiculo;
		preencherFormulario();
	}
	
	private void preencherFormulario() {
		if(veiculo != null) {
			txtPlaca.setText(veiculo.getPlaca());
			txtModelo.setText(veiculo.getModelo());
			txtKm.setText(String.valueOf(veiculo.getKm()));
			txtConsumo.setText(String.valueOf(veiculo.getConsumo()));
		}
	}
}
