package cliente;

import fecha.Fecha;

public class Particular extends Cliente{
	
	private String apellidos;
	
	public Particular(String NIF, String nombre, String correoElectronico, Direccion direccion, Fecha fecha, Tarifa tarifa){
		super(NIF, nombre, correoElectronico, direccion, fecha, tarifa);
		
		this.apellidos = apellidos;
	}
	
	public String getApellidos(){
		return this.apellidos;
	}
}
