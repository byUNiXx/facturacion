package main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import datos.DatosClientes;
import datos.DatosFacturas;
import datos.DatosLlamadas;
import menu.MenuPrincipal;

public class Init {
	
	public static DatosClientes dataClientes;
	public static DatosLlamadas dataLlamadas;
	public static DatosFacturas dataFacturas;

	public static void preInit(){
		 
		dataClientes = new DatosClientes();
		dataLlamadas = new DatosLlamadas();
		dataFacturas = new DatosFacturas();
		
		init();
	}
	
	private static void init(){
		
		
		try{
			FileInputStream fichero = new FileInputStream("datosClientes.bin");
			ObjectInputStream carga = new ObjectInputStream(fichero);
			
			dataClientes = (DatosClientes)carga.readObject();
			
			fichero = new FileInputStream("datosLlamadas.bin");
			carga = new ObjectInputStream(fichero);
			
			dataLlamadas = (DatosLlamadas)carga.readObject();
			
			fichero = new FileInputStream("datosFacturas.bin");
			carga = new ObjectInputStream(fichero);
			
			dataFacturas = (DatosFacturas)carga.readObject();
			
			carga.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			
			MenuPrincipal.inicio();
		}
		
	}
}
