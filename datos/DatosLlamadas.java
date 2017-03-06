package datos;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	public void añadirLlamada(Cliente cliente, Llamada llamada){
		
		if(!data.containsKey(cliente)){
			data.put(cliente, new ArrayList<>());
		}
		data.get(cliente).add(llamada);
	}
	
	public ArrayList<Llamada> llamadasCliente(Cliente cliente){
		
		return data.get(cliente);
	}
	
	public ArrayList<LocalTime> buscarLlamadaPeriodo 
	(Cliente cliente, LocalDateTime periodoInicio, LocalDateTime periodoFinal){
		
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
