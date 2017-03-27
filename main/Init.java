package main;

import datos.DatosClientes;
import datos.DatosFacturas;
import datos.DatosLlamadas;
import menu.MenuPrincipal;

public class Init {
	
	public static DatosClientes dataClientes;
	public static DatosLlamadas dataLlamadas;
	public static DatosFacturas dataFacturas;

	public static void init(){
		 
		dataClientes = new DatosClientes();
		dataLlamadas = new DatosLlamadas();
		dataFacturas = new DatosFacturas();
		MenuPrincipal.inicio();
	}
}
