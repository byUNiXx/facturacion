package datos;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import cliente.Direccion;
import es.uji.www.GeneradorDatosINE;
import tarifa.Tarifa;

public class DatosClientesTest {
	
	private Cliente cliente;
	private DatosClientes data;
	private GeneradorDatosINE generador;
	private ArrayList<Cliente> lista;
	
	@Before
	public void init(){
		generador = new GeneradorDatosINE();
		data = new DatosClientes();
	}

	@Test
	public void testAñadirCliente() {
		lista  = new ArrayList<>();
		
		for(int i = 0; i <10; i++){
			
			cliente = new Cliente(generador.getNIF(), generador.getNombre(), generador.getNombre() + "@mail", 
					new Direccion("12560", "Ben", "cs"), LocalDate.of(2017, 03, 06), new Tarifa(0.50));
			data.añadirCliente(cliente);
			lista.add(cliente);
		}
		assertEquals(10, data.getSize(), 0);
	}

	@Test
	public void testBorrarCliente() {
		lista  = new ArrayList<>();
		
		for(int i = 0; i <10; i++){
			
			cliente = new Cliente(generador.getNIF(), generador.getNombre(), generador.getNombre() + "@mail", 
					new Direccion("12560", "Ben", "cs"), LocalDate.of(2017, i+1, 06), new Tarifa(0.50));
			data.añadirCliente(cliente);
			lista.add(cliente);
		}
	
		cliente = lista.get(3);
		data.borrarCliente(cliente);
		assertEquals(9, data.getSize(), 0);
		assertEquals(false, data.contains(cliente));
		
		boolean existe = true;
		cliente = new Cliente("No valido", "No valido", "No valido" + "@mail", 
				new Direccion("12560", "Ben", "cs"), LocalDate.of(2017, 1, 06), new Tarifa(0.50));
		try{
			data.borrarCliente(cliente);
		}catch(NoSuchElementException exception){
			existe = false;
		}
		assertEquals(false, existe);
	}

	@Test
	public void testCambiarTarifa() {
		lista  = new ArrayList<>();
		
		for(int i = 0; i <10; i++){
			
			cliente = new Cliente(generador.getNIF(), generador.getNombre(), generador.getNombre() + "@mail", 
					new Direccion("12560", "Ben", "cs"), LocalDate.of(2017, i+1, 06), new Tarifa(0.50));
			data.añadirCliente(cliente);
			lista.add(cliente);
		}
		cliente = lista.get(5);
		data.cambiarTarifa(cliente, new Tarifa(1.00));
		assertEquals(1.00, data.listadoClientes().get(5).getTarifa().toDouble(), 0);
	}

	@Test
	public void testBuscarCliente() {

		lista  = new ArrayList<>();
		
		for(int i = 0; i <10; i++){
			
			cliente = new Cliente(generador.getNIF(), generador.getNombre(), generador.getNombre() + "@mail", 
					new Direccion("12560", "Ben", "cs"), LocalDate.of(2017, i+1, 06), new Tarifa(0.50));
			data.añadirCliente(cliente);
			lista.add(cliente);
		}
		
		cliente = lista.get(6);
		assertEquals(cliente, data.buscarCliente(cliente.getNIF()));
		boolean existe = true;
		try{
			data.buscarCliente("Incorrecto");
		}catch(NoSuchElementException exception){
			existe = false;
		}
		assertEquals(false, existe);
	}

}
