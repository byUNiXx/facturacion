package cliente;

import java.time.LocalDate;

import tarifa.Tarifa;

public class Empresa extends Cliente{
	
	public Empresa(){
		
	}

	public Empresa(String NIF, String nombre, String correoElectronico, Direccion direccion, 
			LocalDate fecha, Tarifa tarifa) {
        
		super(NIF, nombre, correoElectronico, direccion, fecha, tarifa);
    }	
}
