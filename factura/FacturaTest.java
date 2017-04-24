package factura;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import cliente.Direccion;
import datos.DatosLlamadas;
import es.uji.www.GeneradorDatosINE;
import llamada.Llamada;
import tarifa.Tarifa;
import tarifa.TarifaDomingo;
import tarifa.TarifaTarde;

public class FacturaTest {
	private Cliente cliente;
	private Factura factura;
	private Llamada llamada;
	private DatosLlamadas data;
	private GeneradorDatosINE generador;
	private Tarifa tarifa = new Tarifa(1);
	private TarifaDomingo domingo = new TarifaDomingo(tarifa, 0) ;
	private TarifaTarde tarde1 = new TarifaTarde(tarifa, 0.5);
	@Before
	public void init(){
		generador = new GeneradorDatosINE();
		data = new DatosLlamadas();
		
		
	}

	@Test
	public void testCalcularImporte() {
			factura = new Factura("1", new Tarifa(0.1), LocalDateTime.of(2019, 2, 13, 0, 0, 0), 
				LocalDateTime.of(2017, 1, 12, 0, 0), LocalDateTime.of(2018, 2, 12, 0, 0), 0.0);
		
		for(int i = 0; i < 2; i++){
			if(i==0)
				cliente = new Cliente(generador.getNIF(), generador.getNombre(), generador.getNombre() + "@mail", 
						new Direccion("12560", "Ben", "cs"), LocalDateTime.of(2017, 03, 06, 0, 0 ,0), new TarifaDomingo(new Tarifa(1),0.0));
			
			llamada = new Llamada("676562332", LocalDateTime.of(2017, 04, 23+i, 16+i, 16+i,43), 
					LocalTime.of(1, i, 0));
			data.añadirLlamada(cliente, llamada);	
		}
		
		llamada = new Llamada("676562332", LocalDateTime.of(2017, 04, 23, 17, 17,43), 
				LocalTime.of(1, 0, 45));
		data.añadirLlamada(cliente, llamada);
		
		factura.calcularImporte(cliente, data);
		assertEquals(61.0,factura.getImporte(),0);
		
		
		
	}

}
