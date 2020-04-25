import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainScene {

	private JFrame frame;
	private JTextField txtMinutos;
	private JTextField txtHoras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScene window = new MainScene();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScene() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][179.00,grow][38.00][118.00,grow][11.00,grow]", "[][][][][][][][][11.00][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Horas: ");
		frame.getContentPane().add(lblNewLabel_1, "cell 0 1,alignx trailing,aligny center");
		
		txtHoras = new JTextField();
		txtHoras.setText("");
		frame.getContentPane().add(txtHoras, "cell 1 1,growx,aligny top");
		txtHoras.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Minutos: ");
		frame.getContentPane().add(lblNewLabel, "cell 0 2,alignx trailing,aligny center");
		
		txtMinutos = new JTextField();
		frame.getContentPane().add(txtMinutos, "cell 1 2,growx,aligny top");
		txtMinutos.setColumns(10);
		
		JButton btnSomar = new JButton("Acumular");

		frame.getContentPane().add(btnSomar, "cell 3 1 1 2,grow");
		
		JLabel lblNewLabel_2 = new JLabel("Total Minutos: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblNewLabel_2, "cell 1 6,growx");
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblResultado, "cell 3 6,growx");
		lblResultado.setText("0.0");
		
		JLabel lblNewLabel_3 = new JLabel("Horas e  Minutos");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblNewLabel_3, "cell 1 7,growx,aligny baseline");
		
		JLabel lblHorasMinutos = new JLabel("0.0");
		lblHorasMinutos.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblHorasMinutos, "cell 3 7,growx");
		
		JButton btnZerar = new JButton("Zerar");
		btnZerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblResultado.setText("0");
			}
		});
		frame.getContentPane().add(btnZerar, "cell 3 9,growx");
		
		btnSomar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controladora controladora = new Controladora();
				String mensagem = controladora.verificarCampos(txtHoras.getText(), txtMinutos.getText());
				if (mensagem.isEmpty()) {

					Tempo calculado = controladora.criarTempo(txtHoras.getText(), txtMinutos.getText(), lblResultado.getText());
					if(calculado == null) JOptionPane.showMessageDialog(null, "Digites apenas\nnumeros inteiros");
					//System.out.println(calculado.toString()+"  "+calculado.getTotalMinutes());
					lblResultado.setText(calculado.getTotalMinutes()+"");
					lblHorasMinutos.setText(calculado.toString());
				}
				
			}
		});
		

	}

}
