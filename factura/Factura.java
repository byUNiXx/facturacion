package factura;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import cliente.Cliente;
import datos.DatosLlamadas;
import genericidad.Data;
import genericidad.Fecha;
import llamada.Llamada;
import tarifa.Tarifa;

public class Factura implements Data, Serializable {
	
	 private String codigo;
	 private Tarifa tarifa;
	 private LocalDateTime fechaEmision;
	 private LocalDateTime periodoInicio;
	 private LocalDateTime periodoFinal;
	 private double importe;
	
	public Factura(String codigo, Tarifa tarifa, LocalDateTime fechaEmision,
		LocalDateTime periodoInicio, LocalDateTime periodoFinal, double importe)
		throws IllegalArgumentException{
		
		if(periodoInicio.compareTo(periodoFinal) >= 0)
			throw new IllegalArgumentException("La factura tiene un periodo de facturacion invalido. "
					+ "La fecha de comienzo del periodo no puede ser mayor o igual a la del fin.");
		
		if(fechaEmision.compareTo(periodoFinal) < 0)
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
		
		ArrayList<Llamada> llamadasRango;
		
		try{
			llamadasRango = llamadas.llamadasCliente(cliente);
		}catch(NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}
		
		ArrayList<Llamada> listaAux = Fecha.getFecha(periodoInicio, periodoFinal, llamadasRango);
		
		
		
		if(!listaAux.isEmpty()){
			double total = 0;
			
			for(int i = 0; i < listaAux.size(); i++){
				
				total += tarifa.calcular(listaAux.get(i));
			}
			importe = total;
		}else{
			
			importe = 0;
		}
	}
	
	private double timeToMin(LocalTime tiempo){
		
		double min = tiempo.getHour()* 60 + tiempo.getMinute() + tiempo.getSecond() / 60.0;
		
		return min;
	}
	
	public String getCodigo(){
		
		return codigo;
	}
	
	public Tarifa getTarifa(){
		
		return tarifa;
	}
	
	public LocalDateTime getFecha(){
		
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
