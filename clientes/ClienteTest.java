package cliente;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import tarifa.Tarifa;

public class ClienteTest {
	
	private Cliente cliente;
	
	@Before
	public void init(){
		cliente = new Cliente("68907546Y", "Antonio", "ant@mail.com", 
				new Direccion("12560", "Benicasim", "Cs"), LocalDate.of(2017, 12, 14), new Tarifa(0.23));
	}

	@Test
	public void testCambiarTarifa() {
		cliente.cambiarTarifa(new Tarifa(0.50));
		assertEquals(0.50, cliente.getTarifa().toDouble() , 0);
		cliente.cambiarTarifa(new Tarifa(0.10));
		assertEquals(0.10, cliente.getTarifa().toDouble() , 0);
	}

}
