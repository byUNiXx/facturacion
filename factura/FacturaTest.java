package factura;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import cliente.Direccion;
import datos.DatosLlamadas;
import es.uji.www.GeneradorDatosINE;
import llamada.Llamada;
import tarifa.Tarifa;

public class FacturaTest {
	private Cliente cliente;
	private Factura factura;
	private Llamada llamada;
	private DatosLlamadas data;
	private GeneradorDatosINE generador;
	@Before
	public void init(){
		generador = new GeneradorDatosINE();
		data = new DatosLlamadas();
		
	}

	@Test
	public void testCalcularImporte() {
		factura = new Factura(1, new Tarifa(0.0), LocalDate.of(2017, 2, 13), 
				LocalDateTime.of(2017, 1, 12, 0, 0), LocalDateTime.of(2017, 2, 12, 0, 0), 0.0);
		
		for(int i = 0; i <2; i++){
			if(i==0)
				cliente = new Cliente(generador.getNIF(), generador.getNombre(), generador.getNombre() + "@mail", 
						new Direccion("12560", "Ben", "cs"), LocalDate.of(2017, 03, 06), new Tarifa(0.50));
			
			llamada = new Llamada("676562332", LocalDateTime.of(2017, 1, 17, 12, 19), 
					LocalTime.of(1, i, 45));
			data.añadirLlamada(cliente, llamada);	
		}
		
		factura.calcularImporte(cliente, data);
		assertEquals(122.5*cliente.getTarifa().toDouble(),factura.getImporte(),0);
	}

}
