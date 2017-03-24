ppackage cliente;

import java.time.LocalDate;

import tarifa.Tarifa;

public class Particular extends Cliente{
	
	private String apellidos;
	
	public Particular(String NIF, String nombre, String apellidos,
			String correoElectronico, Direccion direccion, LocalDate fecha, Tarifa tarifa){
		
		super(NIF, nombre, correoElectronico, direccion, fecha, tarifa);
		
		this.apellidos = apellidos;
	}
	
	public String getApellidos(){
		return apellidos;
	}
	
	public String toString(){
		
		return getNIF() + "  " +  getNombre() + "  " + getApellidos() + "  " 
				+getCorreoElectronico() + "  " + getDireccion() + "  " + getFecha() 
				+ "  " + getTarifa();
	}
}
