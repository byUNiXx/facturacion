package factura;

import java.time.LocalDate;

import tarifa.Tarifa;

public class Factura {
	
	 private int codigo;
	 private Tarifa tarifa;
	 private LocalDate fechaEmision;
	 private LocalDate periodoInicio;
	 private LocalDate periodoFinal;
	 private double importe;
	    
	public Factura(){
		
	}
	
	public Factura(int codigo, Tarifa tarifa, LocalDate fechaEmision,
		LocalDate periodoInicio, LocalDate periodoFinal,double importe){
		
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.fechaEmision = fechaEmision;
		this.periodoInicio = periodoInicio;
		this.periodoFinal = periodoFinal;
		this.importe = importe;
			
	}
	
	public int getCodigo(){
		
		return codigo;
	}
	
	public Tarifa getTarifa(){
		
		return tarifa;
	}
	
	public LocalDate getFecha(){
		
		return fechaEmision;
	}
	
	public LocalDate getPeriodoInicio(){
		
		return periodoInicio;
	}
	
	public LocalDate getPeriodoFinal(){
	
		return periodoFinal;
}
	
	public double getImporte(){
		
		return importe;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
