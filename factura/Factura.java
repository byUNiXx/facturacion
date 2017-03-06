package factura;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import cliente.Cliente;
import cliente.Direccion;
import cliente.Particular;
import datos.DatosLlamadas;
import llamada.Llamada;
import main.Init;
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
	
	public void calcularImporte(Cliente cliente){//Probar que calcule bien
												 //Probar data init si es asi
		
		this.tarifa = cliente.getTarifa();
		
		ArrayList<LocalTime> llamadasRango = Init.dataLlamadas.buscarLlamadaPeriodo(cliente, periodoInicio, periodoFinal);
		
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
	
	public double timeToMin(LocalTime tiempo){
		
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
	
	public static void main(String[] args) {
		Init.init();
		
		Cliente cliente = new Particular("53788220Y","Diego","Cano","al342376@uji.es",
    			new Direccion("12540","Vila-real","Castellón"),LocalDate.of(2017, 1, 12) , new Tarifa(0.37));
		
		Cliente cliente2 = new Particular("5378822220Y","Antonio","Cano","al342376@uji.es",
    			new Direccion("12540","Vila-real","Castellón"),LocalDate.of(2017, 2, 12) , new Tarifa(0.37));
		
		Cliente cliente3 = new Particular("53788220qY","Pere","Cano","al342376@uji.es",
    			new Direccion("12540","Vila-real","Castellón"),LocalDate.of(2017, 2, 13) , new Tarifa(0.37));
		
		Llamada llamada = new Llamada("19002993", 
				LocalDateTime.of(2017, 1, 12, 0, 0, 0), LocalTime.of(1, 54, 34));
		
		Llamada llamada3 = new Llamada("39002993", 
				LocalDateTime.of(2017, 1, 17, 0, 0, 0), LocalTime.of(0, 20, 0));
		
		Llamada llamada2 = new Llamada("29002993", 
				LocalDateTime.of(2017, 2, 12, 0, 0, 0), LocalTime.of(1, 0, 0));
		
		Llamada llamada4 = new Llamada("49002993", 
				LocalDateTime.of(2017, 1, 11, 0, 0, 0), LocalTime.of(1, 59, 32));
		
		Llamada llamada5 = new Llamada("59002993", 
				LocalDateTime.of(2017, 2, 13, 0, 0, 0), LocalTime.of(0, 1, 32));
		
		Llamada llamada6 = new Llamada("69002993", 
				LocalDateTime.of(2017, 1, 12, 0, 0, 0), LocalTime.of(1, 54, 32));
		
		Llamada llamada7 = new Llamada("79002993", 
				LocalDateTime.of(2017, 1, 12, 13, 2, 23), LocalTime.of(1, 54, 0));
		
		Init.dataLlamadas.añadirLlamada(cliente, llamada);
		Init.dataLlamadas.añadirLlamada(cliente, llamada2);
		Init.dataLlamadas.añadirLlamada(cliente, llamada3);
		Init.dataLlamadas.añadirLlamada(cliente, llamada4);
		Init.dataLlamadas.añadirLlamada(cliente, llamada5);
		
		System.out.println((54 + 60)*cliente.getTarifa().toDouble());
		
		Factura nueva = new Factura(1, cliente.getTarifa(), LocalDate.of(2017, 2, 13),
				LocalDateTime.of(2017, 1, 12, 0, 0), LocalDateTime.of(2017, 2, 12, 0, 0),0);
		nueva.calcularImporte(cliente);
		System.out.println(nueva.getImporte());
		System.out.println((54 + 60)*cliente.getTarifa().toDouble()+ nueva.getImporte());
		Init.dataFacturas.añadirFactura(cliente, nueva);
	}
}
