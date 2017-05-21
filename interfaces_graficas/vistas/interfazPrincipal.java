package vistas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class interfazPrincipal {

	private JFrame frame;
	private JTextField txtBuscarNif;
	private JTextField txtBuscarCodFac;


	private void initInterfazPrincipal() {
		
		//frame de la aplicacion
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Facturación v0.1a");
		frame.setBounds(100, 100, 470, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//huecos para texto
		
		txtBuscarNif = new JTextField();
		txtBuscarNif.setText("Introduce el NIF para buscar");
		txtBuscarNif.setBounds(10, 11, 434, 20);
		frame.getContentPane().add(txtBuscarNif);
		txtBuscarNif.setColumns(10);
		
		txtBuscarCodFac = new JTextField();
		txtBuscarCodFac.setText("Introduce el codfac para buscar");
		txtBuscarCodFac.setBounds(10, 72, 434, 20);
		frame.getContentPane().add(txtBuscarCodFac);
		txtBuscarCodFac.setColumns(10);
		
		//Botones
		
		JButton botBuscarClientes = new JButton("Buscar Cliente");     
		botBuscarClientes.setBounds(314, 41, 130, 20);
		frame.getContentPane().add(botBuscarClientes);
		
		JButton botBuscarFactura = new JButton("Buscar factura");
		botBuscarFactura.setBounds(314, 103, 130, 20);
		frame.getContentPane().add(botBuscarFactura);
		
		JButton botListadoClientes = new JButton("Listado Clientes");
		botListadoClientes.setBounds(10, 155, 160, 23);
		frame.getContentPane().add(botListadoClientes);
		
		JButton botClientesFecha = new JButton("Clientes entre fechas");
		botClientesFecha.setBounds(10, 205, 160, 23);
		frame.getContentPane().add(botClientesFecha);
		
		JButton botAltaCliente = new JButton("Dar de alta un cliente");
		botAltaCliente.setBounds(199, 155, 160, 23);
		frame.getContentPane().add(botAltaCliente);
		
		JButton botSalir = new JButton("Salir");
		botSalir.setBounds(355, 205, 89, 23);
		frame.getContentPane().add(botSalir);
	}
	
	public interfazPrincipal() {
		initInterfazPrincipal();
	}
	
	//En otro lugar, donde los listeners
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazPrincipal window = new interfazPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
