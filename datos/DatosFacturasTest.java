package datos;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import cliente.Direccion;
import es.uji.www.GeneradorDatosINE;
import factura.Factura;
import tarifa.Tarifa;

public class DatosFacturasTest {

	private Cliente cliente;
	private DatosFacturas data;
	private GeneradorDatosINE generador;
	private Factura factura;
	
	@Before
	public void init(){
		generador = new GeneradorDatosINE();
		data = new DatosFacturas();
	}

	@Test
	public void testAñadirFactura() {
		ArrayList<Cliente> lista  =new ArrayList<>();
		
		for(int i = 0; i <10; i++){
			if(i == 0 || i == 3 || i == 8){
				cliente = new Cliente(generador.getNIF(), generador.getNombre(), generador.getNombre() + "@mail", 
						new Direccion("12560", "Ben", "cs"), LocalDate.of(2017, 03, 06), new Tarifa(0.50));
				lista.add(cliente);
			}
			factura = new Factura(i, new Tarifa(0.27), LocalDate.of(2017, 2, 13), 
					LocalDateTime.of(2017, 1, 12, 0, 0), LocalDateTime.of(2017, 2, 12, 0, 0), 68.90);
			data.añadirFactura(cliente, factura);	
		}
		
		assertEquals(3, data.facturasCliente(lista.get(0)).size(), 0);
		assertEquals(5, data.facturasCliente(lista.get(1)).size(), 0);
		assertEquals(2, data.facturasCliente(lista.get(2)).size(), 0);
	}

}
