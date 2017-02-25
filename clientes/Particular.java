package cliente;

import fecha.Fecha;
import tarifa.Tarifa;

public class Particular extends Cliente{
	
	private String apellidos;
	
	public Particular(String NIF, String nombre, String apellidos,
			String correoElectronico, Direccion direccion, Fecha fecha, Tarifa tarifa){
		
		super(NIF, nombre, correoElectronico, direccion, fecha, tarifa);
		
		this.apellidos = apellidos;
	}
	
	public String getApellidos(){
		return apellidos;
	}
}
