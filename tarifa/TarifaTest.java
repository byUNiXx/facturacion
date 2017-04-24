package tarifa;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import llamada.Llamada;

public class TarifaTest {
	private Tarifa tarifa = new Tarifa(1);
	private TarifaDomingo domingo = new TarifaDomingo(tarifa, 0) ;
	private TarifaTarde tarde = new TarifaTarde(tarifa, 0);
	private TarifaTarde tarde1 = new TarifaTarde(tarifa, 0.5);
	private Llamada llamada;
	private Llamada llamada1;
	
	@Before
	public void init(){
		llamada = new Llamada("24",LocalDateTime.of(2017, 04, 23, 12, 0), LocalTime.of(0,1));
		llamada1 = new Llamada("24",LocalDateTime.of(2017, 04, 24, 17, 0,54), LocalTime.of(0,1));
	}
	
	@Test
	public void testTarifa() {
		assertEquals(0.0, domingo.calcular(llamada),0);
		assertEquals(0.0, tarde.calcular(llamada1),0);
		assertEquals(0.5, tarde1.calcular(llamada1),0);
	}

}
