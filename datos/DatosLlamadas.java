package datos;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import cliente.Cliente;
import llamada.Llamada;

public class DatosLlamadas{
	
	private Map<Cliente, ArrayList<Llamada>> data;
	
	public DatosLlamadas(){
		
		data = new HashMap<>();
	}
	
	public Map<Cliente, ArrayList<Llamada>> getData(){
		
		return data;
	}
	
	public void añadirLlamada(Cliente cliente, Llamada llamada) throws IllegalArgumentException{
		
		if(!data.containsKey(cliente)){
			data.put(cliente, new ArrayList<>());
		}
		if(!data.get(cliente).contains(llamada)){
			data.get(cliente).add(llamada);
		}else{
			throw new IllegalArgumentException("Ya existe esa llamada en la base de datos");
		}
	}
	
	public ArrayList<Llamada> llamadasCliente(Cliente cliente) throws NoSuchElementException{
		if(!data.containsKey(cliente))
			throw new NoSuchElementException("El cliente no tiene ninguna llamada en la base de datos.");
		
		return data.get(cliente);
	}
	
	public ArrayList<LocalTime> buscarLlamadaPeriodo 
		(Cliente cliente, LocalDateTime periodoInicio, LocalDateTime periodoFinal)
				throws IllegalArgumentException, NoSuchElementException{
		
		if(periodoInicio.compareTo(periodoFinal) >= 0)
			throw new IllegalArgumentException("Periodo de busqueda invalido. "
					+ "La fecha de comienzo del periodo no puede ser mayor o igual a la del fin.");
		
		if(!data.containsKey(cliente))
			throw new NoSuchElementException("El cliente no tiene ninguna llamada en la base de datos.");
		
		ArrayList<Llamada> llamadasCliente = llamadasCliente(cliente);
		ArrayList<LocalTime> llamadasRango = new ArrayList<>();
		
		Llamada aux;
		
		for(int i = 0; i < llamadasCliente.size(); i++){
			
			aux = llamadasCliente.get(i);
			
			if(aux.getFecha().compareTo(periodoInicio) >= 0 && aux.getFecha().compareTo(periodoFinal) <= 0)
				llamadasRango.add(aux.getDuracion());
		}
		
		return llamadasRango;
	}
}
