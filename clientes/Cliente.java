package cliente;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import tarifa.Tarifa;

public class Cliente{
	
    private String NIF;
    private String nombre;
    private String correoElectronico;
    private Direccion direccion;
    private LocalDate fechaAlta;
    private Tarifa tarifa;
    
    public Cliente(){
    }

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
    
    public static void main(String[] args) {
    	
    	LocalDate fecha = LocalDate.of(2017, 11, 23);
    	
    	LocalTime hora = LocalTime.now();
    	
    	Cliente cliente = new Particular("53788220Y","Diego","Cano","al342376@uji.es",
    			new Direccion("12540","Vila-real","Castellón"),fecha , new Tarifa(0.37));
    	
    	/*Cliente cliente2 = new Empresa("53788220Y","Diego","al342376@uji.es",
    			new Direccion("12540","Vila-real","Castellón"), new Fecha(25, 01, 2017), new Tarifa(0.37));*/
        
    	System.out.println(cliente);
    	System.out.println(hora.truncatedTo(ChronoUnit.SECONDS)); //No hagas caso a esto, solo estaba probando cosas.
    }
}
