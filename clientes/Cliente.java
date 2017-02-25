package cliente;

import fecha.Fecha;
import tarifa.Tarifa;

public class Cliente{
	
    private String NIF;
    private String nombre;
    private String correoElectronico;
    private Direccion direccion;
    private Fecha fechaAlta;
    private Tarifa tarifa; 
    
    public Cliente(){
    }
    
    public Cliente(String NIF, String nombre, String correoElectronico, Direccion direccion, Fecha fecha, Tarifa tarifa) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.fechaAlta = fecha;
        this.tarifa = tarifa;
    }
    
    public Direccion getDireccion() {
        return direccion;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getNIF() {
        return NIF;
    }
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    public String getFecha() {
        return fechaAlta.toString();
    }
    
    public String getTarifa() { 
        return tarifa.toString();
    }
    
    public static void main(String[] args) {
        
    	Particular cliente = new Particular("53788220Y","Diego","Cano","al342376@uji.es",
    			new Direccion("12540","Vila-real","Castellón"), new Fecha(25, 01, 2017), new Tarifa(0.37));
        
    	System.out.println(cliente.getTarifa().toString());
    }
}
