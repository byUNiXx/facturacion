package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Shutdown {

	public static void shutdown(){
		
		try{
			FileOutputStream fichero = new FileOutputStream("datosClientes.bin");
			ObjectOutputStream guardar = new ObjectOutputStream(fichero);
			
			guardar.writeObject(Init.dataClientes);
			
			fichero = new FileOutputStream("datosLlamadas.bin");
			guardar = new ObjectOutputStream(fichero);
			
			guardar.writeObject(Init.dataLlamadas);
			
			fichero = new FileOutputStream("datosFacturas.bin");
			guardar = new ObjectOutputStream(fichero);
			
			guardar.writeObject(Init.dataFacturas);;
			
			guardar.flush();
			guardar.close();
		
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			System.exit(0);
		}
	}
}

