package cliente;

public class Cliente{
	
    private String NIF;
    private String nombre;
    private String correoElectronico;
    private Direccion direccion;
    
    public Cliente(){
    }
    
    public Cliente(String NIF, String nombre, String correoElectronico, Direccion direccion) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
    }
    
    public Direccion getDireccion() {
        return this.direccion;
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
    
    public static void main(String[] args) {
        
    	Particular cliente = new Particular("53788220Y","Diego","Cano","al342376@uji.es",new Direccion("12540","Vila-real"
                ,"Castellón"));
        System.out.println(cliente.getCorreoElectronico());
    }
}
