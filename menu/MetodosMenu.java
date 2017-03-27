package menu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cliente.Cliente;
import cliente.Direccion;
import cliente.Particular;
import factura.Factura;
import generacidad.Fecha;
import main.Init;
import tarifa.Tarifa;

public class MetodosMenu {
	
	private static String entradaDatos(){
		
		Scanner entrada = new Scanner(System.in);
		String salida = entrada.nextLine();
		
		return salida;
	}

	public static void buscarNIF(){
		
		System.out.println("Introduce el NIF: ");
		String entrada = entradaDatos();
		Cliente cliente;
		
		try{
			cliente = Init.dataClientes.buscarCliente(entrada);
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
			return;
		}
		System.out.println(cliente.toString());
	}
	
	public static void buscarCodFac(){
		
		System.out.println("Introduce el codigo de la factura: ");
		String entrada = entradaDatos();
		Factura factura;
		
		try{
			factura = Init.dataFacturas.buscarCodigo(entrada);
		}catch(NoSuchElementException e){
			e.getMessage();
			return;
		}
		System.out.println("codigo  tarifa  fechaEmision  periodoInicio  periodoFinal  importe");
		System.out.println(factura.toString());
	}
	
	public static void listadoClientes(){
		
		ArrayList<Cliente> lista = Init.dataClientes.listadoClientes();
		
		if(lista.size()==0){
			System.out.println("No hay clientes.");
			return;
		}
		
		for(Cliente cliente : lista)
			System.out.println(cliente.toString());
	}
	
	public static void buscarClientePeriodo(){
		
		System.out.println("Introduce la fecha de inicio");
		LocalDateTime fechaInicio = entradaFecha();
		System.out.println("Introduce la fecha final");
		LocalDateTime fechaFinal = entradaFecha();
		
		ArrayList<Cliente> lista;
		
		try{
			lista = Fecha.getFecha(fechaInicio, fechaFinal, Init.dataClientes.listadoClientes());
		}catch(IllegalArgumentException e){
			e.getMessage();
			return;
		}
		if(lista.size()==0){
			System.out.println("No hay clientes en ese periodo.");
			return;
		}
		
		for(Cliente cliente : lista)
			System.out.println(cliente.toString());
		
		
	}
	
	private static LocalDateTime entradaFecha(){
		System.out.println("Introduce la fecha con el formato yyyy-mm-ddThh:mm:ss ");
		LocalDateTime fecha = LocalDateTime.parse(entradaDatos());
		
		return fecha;
	}
	
	private static Direccion entradaDireccion(){
		String[] vector = {"CP", "Provincia", "Población"};
		String[] entrada = new String[3];
		
		for(int i = 0; i < vector.length; i++){
			System.out.printf("Introduce el/la " + vector[i] + ": ");
			entrada[i] = entradaDatos();
		}
		
		Direccion salida = new Direccion(entrada[0], entrada[1], entrada[2]);
		
		return salida;
	}
	
	public static void altaCliente(){
		String[] vectorNormal = {"NIF", "nombre", "correoElectronico", "tarifa"};
		String[] vectorParticular = {"NIF", "nombre", "apellidos", "correoElectronico", "tarifa"};
		String[] entrada = new String[7];
		Cliente cliente;
		
		System.out.println("¿Es particular?(S/N)");
		String particular = entradaDatos();
		
		if(particular.toLowerCase().equals("s")){
			for(int i = 0; i < vectorParticular.length; i++){
				System.out.printf("Introduce el/la " + vectorParticular[i] + ": ");
				entrada[i] = entradaDatos();
			}
			cliente = new Particular(entrada[0], entrada[1], entrada[2], entrada[3], entradaDireccion(),
					entradaFecha(), new Tarifa(Double.valueOf(entrada[4])));
		
		}else{
			for(int i = 0; i < vectorNormal.length; i++){
				System.out.printf("Introduce el/la " + vectorNormal[i] + ": ");
				entrada[i] = entradaDatos();
			}
			
			cliente = new Cliente(entrada[0], entrada[1], entrada[2], entradaDireccion(), 
					entradaFecha(), new Tarifa(Double.valueOf(entrada[3])));
		}
		
		Init.dataClientes.añadirCliente(cliente);
	}
	
	public static void main(String[] args) {
		
		
	}
}
