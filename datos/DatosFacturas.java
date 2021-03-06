package datos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import cliente.Cliente;
import factura.Factura;

public class DatosFacturas{
	
	private Map<Cliente, ArrayList<Factura>> data;
	
	public DatosFacturas(){
		
		data = new HashMap<>();
	}
	
	public void añadirFactura(Cliente cliente, Factura factura) throws IllegalArgumentException{
		
		if(!data.containsKey(cliente))
			data.put(cliente, new ArrayList<>());
		
		if(!data.get(cliente).contains(factura))
			data.get(cliente).add(factura);
		else
			throw new IllegalArgumentException("Ya existe esa factura en la base de datos.");
	}
	
	public Factura buscarCodigo(String codigo) throws NoSuchElementException{
		
		Collection<ArrayList<Factura>> coleccion = data.values();
		
		for(ArrayList<Factura> lista : coleccion){
			for(Factura factura : lista){
				if(factura.getCodigo().equals(codigo)){
					return factura;
				}
			}
		}
 
    	throw new NoSuchElementException("Operación abortada. No existe esa factura.");
	}
	
	public ArrayList<Factura> facturasCliente(Cliente cliente) throws NoSuchElementException{
		if(!data.containsKey(cliente))
			throw new NoSuchElementException("El cliente no tiene ninguna llamada en la base de datos.");
		
		return data.get(cliente);
	}
}
