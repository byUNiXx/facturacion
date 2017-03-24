package datos;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import cliente.Direccion;
import es.uji.www.GeneradorDatosINE;
import llamada.Llamada;
import tarifa.Tarifa;

public class DatosLlamadasTest {
	
	private Cliente cliente;
	private Llamada llamada;
	private DatosLlamadas data;
	private GeneradorDatosINE generador;
	@Before
	public void init(){
		generador = new GeneradorDatosINE();
		data = new DatosLlamadas();
	}

	@Test
	public void testAñadirLlamada() {
		ArrayList<Cliente> lista  =new ArrayList<>();
		
		for(int i = 0; i <10; i++){
			if(i == 0 || i == 3 || i == 8){
				cliente = new Cliente(generador.getNIF(), generador.getNombre(), generador.getNombre() + "@mail", 
						new Direccion("12560", "Ben", "cs"), LocalDate.of(2017, 03, 06), new Tarifa(0.50));
				lista.add(cliente);
			}
			llamada = new Llamada("676562332", LocalDateTime.of(2017, 03, 06, 12, 19), 
					LocalTime.of(0, i, 45));
			data.añadirLlamada(cliente, llamada);	
		}
		
		assertEquals(3, data.llamadasCliente(lista.get(0)).size(), 0);
		assertEquals(5, data.llamadasCliente(lista.get(1)).size(), 0);
		assertEquals(2, data.llamadasCliente(lista.get(2)).size(), 0);
		
	}

	@Test
	public void testBuscarLlamadaPeriodo() {
		ArrayList<Cliente> lista  = new ArrayList<>();
		
		for(int i = 0; i <4; i++){
			if(i == 0){
				cliente = new Cliente(generador.getNIF(), generador.getNombre(), generador.getNombre() + "@mail", 
						new Direccion("12560", "Ben", "cs"), LocalDate.of(2017, 03, 06), new Tarifa(0.50));
				lista.add(cliente);
			}
			llamada = new Llamada("676562332", LocalDateTime.of(2017, i+1, 14, 0, 0), 
					LocalTime.of(0, 1, 45));
			
			data.añadirLlamada(cliente, llamada);	
			
			llamada = new Llamada("676562332", LocalDateTime.of(2017, 2, 17, 0, 0), 
					LocalTime.of(0, i, 45));
			
			data.añadirLlamada(cliente, llamada);
		}
		
		int i = data.buscarLlamadaPeriodo(lista.get(0), LocalDateTime.of(2017, 2, 14, 0, 0),
				LocalDateTime.of(2017, 3, 14, 0, 0)).size();
		
		assertEquals(6, i, 0);
		
	}

}
