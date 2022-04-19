package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
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
	public PrincipalUI() {
		setTitle("Sistema de Medi\u00E7\u00E3o da Pegada de Carbono");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 551);
		
		JMenuBar jbPrincipal = new JMenuBar();
		setJMenuBar(jbPrincipal);
		
		JMenu jmCadastros = new JMenu("Cadastros");
		jbPrincipal.add(jmCadastros);
		
		JMenuItem jmiVeiculos = new JMenuItem("Ve\u00EDculos");
		jmiVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroVeiculosUI cadVeiculo = new CadastroVeiculosUI();
				cadVeiculo.setVisible(true);
				contentPane.add(cadVeiculo,0);
			}
		});
		jmCadastros.add(jmiVeiculos);
		
		JMenuItem jmiFuncionarios = new JMenuItem("Funcion\u00E1rios");
		jmiFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFuncionarioUI cadFuncionario = new CadastroFuncionarioUI();
				cadFuncionario.setVisible(true);
				contentPane.add(cadFuncionario,0);
			}
		});
		jmCadastros.add(jmiFuncionarios);
		
		JMenu jmConsultas = new JMenu("Consultas");
		jbPrincipal.add(jmConsultas);
		
		JMenuItem jmiConsultaVeiculo = new JMenuItem("Ve\u00EDculos");
		jmiConsultaVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaVeiculosUI consultaVeiculoUI = new ConsultaVeiculosUI();
				consultaVeiculoUI.setVisible(true);
				contentPane.add(consultaVeiculoUI,0);
			}
		});
		jmConsultas.add(jmiConsultaVeiculo);
		
		JMenuItem jmiConsultaFuncionarios = new JMenuItem("Funcion\u00E1rios");
		jmiConsultaFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaFuncionarioUI consultaFuncionarioUI = new ConsultaFuncionarioUI();
				consultaFuncionarioUI.setVisible(true);
				contentPane.add(consultaFuncionarioUI,0);
			}
		});
		jmConsultas.add(jmiConsultaFuncionarios);
		
		JMenu jmChamados = new JMenu("Chamados");
		jbPrincipal.add(jmChamados);
		
		JMenuItem jmiRegistrarChamados = new JMenuItem("Registrar Chamados");
		jmiRegistrarChamados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroChamadoUI registroChamadoUI = new RegistroChamadoUI();
				registroChamadoUI.setVisible(true);
				contentPane.add(registroChamadoUI,0);
			}
		});
		jmChamados.add(jmiRegistrarChamados);
		
		JMenuItem jmiVisualizarChamados = new JMenuItem("Visualizar Chamados");
		jmiVisualizarChamados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaChamadosUI consultaChamadoUI = new ConsultaChamadosUI();
				consultaChamadoUI.setVisible(true);
				contentPane.add(consultaChamadoUI, 0);
			}
		});
		jmChamados.add(jmiVisualizarChamados);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
