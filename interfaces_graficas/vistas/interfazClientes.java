package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;

public class interfazClientes {

	private JFrame frame;
	private JTextPane txtMostrarCli;

	public interfazClientes() {
		initInterfazClientes();
	}

	
	private void initInterfazClientes() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Facturaci\u00F3n v0.1a");
		frame.setBounds(100, 100, 500, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtMostrarCli = new JTextPane(); //Saca como atrib clase, para poder añadir txt
		txtMostrarCli.setEditable(false);
		//txtpnAlgo.setText("algo");
		txtMostrarCli.setBounds(10, 11, 464, 20);
		frame.getContentPane().add(txtMostrarCli);
		
		JLabel lblEligeLaOpcion = new JLabel("Elige la opcion que quiera realizar: ");
		lblEligeLaOpcion.setBounds(10, 46, 220, 14);
		frame.getContentPane().add(lblEligeLaOpcion);
		
		String[] datos = new String[] {"Ver mas info.", "Borrar este cliente", "Dar de alta una llamada para este cliente.", "Dar de alta una factura para este cliente.", "Mostrar listado de llamadas de este cliente.", "Mostrar listado de facturas de este cliente.", "Mostrar listado de llamadas de este cliente entre dos fechas.", "Mostrar listado de facturas de este cliente emitidas entre dos fechas.", "Cambiar la tarifa de este cliente."};
		JList list = new JList(datos);
		list.setBounds(10, 71, 464, 165);
		frame.getContentPane().add(list);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(275, 247, 89, 23);
		frame.getContentPane().add(btnContinuar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(385, 247, 89, 23);
		frame.getContentPane().add(btnVolver);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazClientes window = new interfazClientes();
					window.txtMostrarCli.setText("algopredet"); //Para cliente en cuestion
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
