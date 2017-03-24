package llamada;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Llamada {
	
	private String numeroDest;
	private LocalDateTime fechaHoraLlamada;
	private LocalTime duracion;
	
	public Llamada(){
		
	}
	
	public Llamada(String numeroDest, LocalDateTime fechaHoraLlamada, LocalTime duracion)
			throws IllegalArgumentException{
		
		if(duracion.compareTo(LocalTime.of(0, 0, 0)) == 0)
			throw new IllegalArgumentException("Duración invalida");
		
		this.numeroDest = numeroDest;
		this.fechaHoraLlamada = fechaHoraLlamada;
		this.duracion = duracion;
	}
	
	public String getNumeroDest(){
		
		return numeroDest;
	}
	
	public LocalDateTime getFecha(){
		
		return fechaHoraLlamada;
	}
	
	public LocalTime getDuracion(){
		
		return duracion;
	}
	
	public String toString(){
		
		return numeroDest + " | " + fechaHoraLlamada + " | " + duracion;
	}
}
