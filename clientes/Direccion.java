package cliente;

public class Direccion {
	
	private String cod;
	private String prov;
	private String pob;

	public Direccion(String cod, String pob, String prov){
		this.cod=cod;
		this.prov=prov;
		this.pob=pob;
	}
	
	public String toString(){
		
		return this.cod + " " +  this.pob + " " + this.prov;
		
	}
}

