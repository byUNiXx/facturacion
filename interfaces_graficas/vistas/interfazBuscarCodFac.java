package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class interfazBuscarCodFac {

	private JFrame frame;
	private JTextField txtCodigo;
	private JTextField txtCliente;
	private JTextField txtFechaEmision;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFinal;
	private JTextField txtTarifa;
	private JTextField txtImporte;

	public interfazBuscarCodFac() {
		initInterfazCodFac();
	}

	
	private void initInterfazCodFac() {
		frame = new JFrame();
		frame.setTitle("Facturacón 0.1a");
		frame.setBounds(100, 100, 450, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(10, 40, 46, 14);
		frame.getContentPane().add(lblCodigo);
		
		JLabel lblInformacion = new JLabel("Informacion de la factura");
		lblInformacion.setBounds(150, 11, 150, 14);
		frame.getContentPane().add(lblInformacion);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(62, 37, 113, 20);
		frame.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(185, 40, 59, 14);
		frame.getContentPane().add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setBounds(236, 37, 188, 20);
		frame.getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblFechaDeEmision = new JLabel("Fecha de emision: ");
		lblFechaDeEmision.setBounds(10, 90, 120, 14);
		frame.getContentPane().add(lblFechaDeEmision);
		
		txtFechaEmision = new JTextField();
		txtFechaEmision.setEditable(false);
		txtFechaEmision.setBounds(140, 87, 284, 20);
		frame.getContentPane().add(txtFechaEmision);
		txtFechaEmision.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio periodo: ");
		lblFechaInicio.setBounds(10, 140, 120, 14);
		frame.getContentPane().add(lblFechaInicio);
		
		JLabel lblFechaFinal = new JLabel("Fecha final periodo: ");
		lblFechaFinal.setBounds(10, 190, 120, 14);
		frame.getContentPane().add(lblFechaFinal);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setEditable(false);
		txtFechaInicio.setBounds(140, 137, 284, 20);
		frame.getContentPane().add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		txtFechaFinal = new JTextField();
		txtFechaFinal.setEditable(false);
		txtFechaFinal.setBounds(140, 187, 284, 20);
		frame.getContentPane().add(txtFechaFinal);
		txtFechaFinal.setColumns(10);
		
		JLabel lblTarifa = new JLabel("Tarifa: ");
		lblTarifa.setBounds(10, 240, 46, 14);
		frame.getContentPane().add(lblTarifa);
		
		txtTarifa = new JTextField();
		txtTarifa.setEditable(false);
		txtTarifa.setBounds(60, 237, 86, 20);
		frame.getContentPane().add(txtTarifa);
		txtTarifa.setColumns(10);
		
		JLabel lblImporte = new JLabel("Importe total: ");
		lblImporte.setBounds(156, 240, 88, 14);
		frame.getContentPane().add(lblImporte);
		
		txtImporte = new JTextField();
		txtImporte.setEditable(false);
		txtImporte.setBounds(250, 237, 86, 20);
		frame.getContentPane().add(txtImporte);
		txtImporte.setColumns(10);
		
		JButton botVolver = new JButton("Volver");
		botVolver.setBounds(335, 289, 89, 23);
		frame.getContentPane().add(botVolver);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazBuscarCodFac window = new interfazBuscarCodFac();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
