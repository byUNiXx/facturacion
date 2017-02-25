package fecha;

public class Fecha {
	
	private int dia;
	private int mes;
	private int año;
	
	public Fecha(int dia, int mes, int año){
		
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}
	
	public String toString(){
		
		return this.dia + "/" +  this.mes + "/" + this.año;
	}
}
