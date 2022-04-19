package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.FuncionarioController;
import controller.VeiculoController;

import java.text.SimpleDateFormat;  
import java.util.Date;

import model.Funcionario;
import model.Veiculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroFuncionarioUI extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtAniversario;
	private JTextField txtIngresso;
	private JTextField txtEndereco;
	private JTextField txtHabilitacao;
	private Funcionario funcionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionarioUI frame = new CadastroFuncionarioUI();
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
	public CadastroFuncionarioUI() {
		setClosable(true);
		setTitle("Cadastrode Funcion\u00E1rios");
		setBounds(100, 100, 653, 298);
		
		JPanel jpCadastroFuncionarios = new JPanel();
		jpCadastroFuncionarios.setBorder(new TitledBorder(null, "Funcion\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
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
					if(funcionario != null && funcionario.getIdFuncionario() > 0){
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						Date date1 = formatter.parse(txtAniversario.getText());
						Date date2 = formatter.parse(txtIngresso.getText());
						funcionario.setNome(txtNome.getText());
						funcionario.setAniversario(new java.sql.Date(date1.getTime()));
						funcionario.setIngresso(new java.sql.Date(date2.getTime()));
						funcionario.setEndereco(txtEndereco.getText());
						funcionario.setHabilitacao(txtHabilitacao.getText());
						new FuncionarioController().atualizar(funcionario);
						JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
					}else {
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						Date date1 = formatter.parse(txtAniversario.getText());
						Date date2 = formatter.parse(txtIngresso.getText());
						Funcionario funcionario = new Funcionario(0, null , null, null, null, null);
						funcionario.setNome(txtNome.getText());
						funcionario.setAniversario(new java.sql.Date(date1.getTime()));
						funcionario.setIngresso(new java.sql.Date(date2.getTime()));
						funcionario.setEndereco(txtEndereco.getText());
						funcionario.setHabilitacao(txtHabilitacao.getText());
							
						new FuncionarioController().salvar(funcionario);
						JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso!");
					}
						dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar o funcionário.");
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
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar))
						.addComponent(jpCadastroFuncionarios, GroupLayout.PREFERRED_SIZE, 614, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroFuncionarios, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel jlNome = new JLabel("Nome:");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel jlAniversario = new JLabel("Anivers\u00E1rio:");
		
		txtAniversario = new JTextField();
		txtAniversario.setColumns(10);
		
		JLabel jlIngresso = new JLabel("Ingresso:");
		
		txtIngresso = new JTextField();
		txtIngresso.setColumns(10);
		
		JLabel jlEndereco = new JLabel("Endere\u00E7o:");
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		
		JLabel jlHabilitacao = new JLabel("Habilita\u00E7\u00E3o:");
		
		txtHabilitacao = new JTextField();
		txtHabilitacao.setColumns(10);
		GroupLayout gl_jpCadastroFuncionarios = new GroupLayout(jpCadastroFuncionarios);
		gl_jpCadastroFuncionarios.setHorizontalGroup(
			gl_jpCadastroFuncionarios.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroFuncionarios.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroFuncionarios.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpCadastroFuncionarios.createSequentialGroup()
							.addComponent(jlNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
						.addGroup(gl_jpCadastroFuncionarios.createSequentialGroup()
							.addComponent(jlAniversario)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtAniversario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroFuncionarios.createSequentialGroup()
							.addComponent(jlIngresso)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtIngresso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroFuncionarios.createSequentialGroup()
							.addComponent(jlEndereco)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtEndereco, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
						.addGroup(gl_jpCadastroFuncionarios.createSequentialGroup()
							.addComponent(jlHabilitacao)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtHabilitacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_jpCadastroFuncionarios.setVerticalGroup(
			gl_jpCadastroFuncionarios.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroFuncionarios.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroFuncionarios.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroFuncionarios.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlAniversario)
						.addComponent(txtAniversario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroFuncionarios.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlIngresso)
						.addComponent(txtIngresso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroFuncionarios.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlEndereco)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroFuncionarios.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlHabilitacao)
						.addComponent(txtHabilitacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		jpCadastroFuncionarios.setLayout(gl_jpCadastroFuncionarios);
		getContentPane().setLayout(groupLayout);

	}
	public void setFuncionarioEdicao(Funcionario funcionario)
	{
		this.funcionario = funcionario;
		preencherFormulario();
	}
	
	private void preencherFormulario() {
		if(funcionario != null) {
			SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
			txtNome.setText(funcionario.getNome());
			txtAniversario.setText(date.format(funcionario.getAniversario()));
			txtIngresso.setText((date.format(funcionario.getIngresso())));
			txtEndereco.setText(funcionario.getEndereco());
			txtHabilitacao.setText(funcionario.getHabilitacao());
		}
	}

}
