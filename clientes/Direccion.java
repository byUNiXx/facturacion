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
	
	public String getCP(){
		
		return cod;
	}
	
	public String getPoblacion(){
		
		return pob;
	}

	public String getProvincia(){
		return prov;
	}
	
	public String toString(){
		
		return cod + " " +  pob + " " + prov;
		
	}
}
