package factura;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

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
		LocalDateTime periodoInicio, LocalDateTime periodoFinal, double importe)
		throws IllegalArgumentException{
		
		if(periodoInicio.compareTo(periodoFinal) >= 0)
			throw new IllegalArgumentException("La factura tiene un periodo de facturacion invalido. "
					+ "La fecha de comienzo del periodo no puede ser mayor o igual a la del fin.");
		
		if(fechaEmision.compareTo(periodoFinal.toLocalDate()) < 0)
			throw new IllegalArgumentException("La factura tiene una fecha de emision invalida. "
					+ "La fecha de emisión de la factura es anterior a la fecha de finalización del periodo de facturación.");
			
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.fechaEmision = fechaEmision;
		this.periodoInicio = periodoInicio;
		this.periodoFinal = periodoFinal;
		this.importe = importe;
	}
	
	public void calcularImporte(Cliente cliente, DatosLlamadas llamadas)
			throws IllegalArgumentException, NoSuchElementException{
		
		this.tarifa = cliente.getTarifa();
		
		ArrayList<LocalTime> llamadasRango;
		
		try{
			llamadasRango = llamadas.buscarLlamadaPeriodo(cliente, periodoInicio, periodoFinal);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Periodo de busqueda invalido. "
					+ "La fecha de comienzo del periodo no puede ser mayor o igual a la del fin.");
		}catch(NoSuchElementException e){
			throw new NoSuchElementException("El cliente no tiene ninguna llamada en la base de datos. No se puede calcular el importe");
		}
		
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
