package tarifa;

public class Tarifa {
	
	private double precio;
	
	public Tarifa(double precio) throws IllegalArgumentException{
		if(precio <= 0)
			throw new IllegalArgumentException();
		
		this.precio = precio;
	}
	
	public Double toDouble(){
		
		return precio;
	}
	
	public String toString(){
		
		return Double.toString(precio);
	}
	
}
