package tarifa;

public class Tarifa {
	
	private double precio;
	
	public Tarifa(double precio){
		
		this.precio = precio;
	}
	
	public Double toDouble(){
		
		return precio;
	}
	
	public String toString(){
		
		return Double.toString(precio);
	}
}
