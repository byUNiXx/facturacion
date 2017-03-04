package llamada;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Llamada {
	
	private String numeroDest;
	private LocalDateTime fechaHoraLlamada;
	private LocalTime duracion;
	
	public Llamada(){
		
	}
	
	public Llamada(String numeroDest, LocalDateTime fechaHoraLlamada, LocalTime duracion){
		
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Llamada llamada = new Llamada("690693021", LocalDateTime.of(2017, 12, 25, 12, 56, 12), 
				LocalTime.of(1, 12, 13));
		
		System.out.println(llamada);
	}

}
