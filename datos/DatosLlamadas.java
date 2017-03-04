package datos;

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
	
	public void añadirLlamada(Cliente cliente, Llamada llamada){
		
		if(!data.containsKey(cliente)){
			data.put(cliente, new ArrayList<>());
		}
		data.get(cliente).add(llamada);
	}
	
	public ArrayList<Llamada> llamadasCliente(Cliente cliente){
		
		return data.get(cliente);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
