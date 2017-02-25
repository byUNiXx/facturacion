package cliente;

public class Particular extends Cliente{
	
	private String apellidos;
	
	public Particular(String NIF, String nombre, String apellidos, String correoElectronico, Direccion direccion){
		super(NIF, nombre, correoElectronico, direccion);
		
		this.apellidos = apellidos;
	}
	
	public String getApellidos(){
		return this.apellidos;
	}
}
