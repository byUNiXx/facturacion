package datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cliente.Cliente;
import factura.Factura;

public class DatosFacturas{
	
	private Map<Cliente, ArrayList<Factura>> data;
	
	public DatosFacturas(){
		
		data = new HashMap<>();
	}
	
	public void añadirLlamada(Cliente cliente, Factura factura){
		
		if(!data.containsKey(cliente)){
			data.put(cliente, new ArrayList<>());
		}
		data.get(cliente).add(factura);
	}
	
	public ArrayList<Factura> llamadasCliente(Cliente cliente){
		
		return data.get(cliente);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
