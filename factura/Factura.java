package factura;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import cliente.Cliente;
import datos.DatosLlamadas;
import tarifa.Tarifa;

public class Factura {
	
	 private int codigo;
	 private Tarifa tarifa;
	 private LocalDate fechaEmision;
	 private LocalDateTime periodoInicio;
	 private LocalDateTime periodoFinal;
	 private double importe;
	
	public Factura(int codigo, Tarifa tarifa, LocalDate fechaEmision,
		LocalDateTime periodoInicio, LocalDateTime periodoFinal, double importe){
		
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.fechaEmision = fechaEmision;
		this.periodoInicio = periodoInicio;
		this.periodoFinal = periodoFinal;
		this.importe = importe;
	}
	
	public void calcularImporte(Cliente cliente, DatosLlamadas llamadas){
		
		this.tarifa = cliente.getTarifa();
		
		ArrayList<LocalTime> llamadasRango = llamadas.buscarLlamadaPeriodo(cliente, periodoInicio, periodoFinal);
		
		if(!llamadasRango.isEmpty()){
			double total = 0;
			
			for(int i = 0; i < llamadasRango.size(); i++){
				
				total += timeToMin(llamadasRango.get(i));
			}
			importe = total * cliente.getTarifa().toDouble();
		
		}else{
			
			importe = 0;
		}
	}
	
	private double timeToMin(LocalTime tiempo){
		
		double min = tiempo.getHour()* 60 + tiempo.getMinute() + tiempo.getSecond() / 60.0;
		
		return min;
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
	
	public LocalDateTime getPeriodoInicio(){
		
		return periodoInicio;
	}
	
	public LocalDateTime getPeriodoFinal(){
	
		return periodoFinal;
	}
	
	public double getImporte(){
		
		return importe;
	}
}
