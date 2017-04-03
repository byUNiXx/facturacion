package cliente;

import java.time.LocalDate;

import tarifa.Tarifa;

public class Cliente{
	
    private String NIF;
    private String nombre;
    private String correoElectronico;
    private Direccion direccion;
    private LocalDate fechaAlta;
    private Tarifa tarifa;
    

    public Cliente(String NIF, String nombre, String correoElectronico, Direccion direccion, 
    		LocalDate fecha, Tarifa tarifa) {
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
    
    public LocalDate getFecha() {
        return fechaAlta;
    }
    
    public Tarifa getTarifa() { 
        return tarifa;
    }
    
    public void cambiarTarifa(Tarifa nueva){
    	tarifa = nueva;
    }
    
    public String toString(){
    	
    	return NIF + "  " +  nombre + "  " + correoElectronico + "  " + direccion 
    			+ "  " + fechaAlta + "  " + tarifa;
    }
}
