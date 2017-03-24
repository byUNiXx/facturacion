package datos;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import cliente.Cliente;
import tarifa.Tarifa;

public class DatosClientes {
    private List<Cliente> data;
    private int size;

    public DatosClientes(){
        data = new ArrayList<Cliente>();
        size = 0;
    }

    public void añadirCliente(Cliente cliente) throws IllegalArgumentException{
        if (data.contains(cliente)){
        	throw new IllegalArgumentException("Operacion abortada. Ya existe ese cliente en la base de datos.");
        }
        data.add(cliente);
        size++;
    }

    public void borrarCliente(Cliente cliente) throws NoSuchElementException{
        if (!data.contains(cliente)){
        	throw new NoSuchElementException("Operación abortada. No existe ese cliente en la base de datos.");
        }
        data.remove(cliente);
        size--;
    }

    public void cambiarTarifa(Cliente cliente, Tarifa tarifa) throws NoSuchElementException{
    	if(data.contains(cliente) == false)
    		throw new NoSuchElementException("Operación abortada. No existe ese cliente en la base de datos.");
        
    	int posicion = data.indexOf(cliente);
        
        cliente.cambiarTarifa(tarifa);
        
        data.set(posicion, cliente);
    }

    public Cliente buscarCliente(String NIF) throws NoSuchElementException{
    	
    	for(int i = 0; i < data.size(); i++){
    		if(data.get(i).getNIF().equals(NIF))
    			return data.get(i);
    	}
    	throw new NoSuchElementException("Operación abortada. No existe ese cliente.");	
    }
    
    public boolean contains(Cliente cliente){
    	
    	if(!data.contains(cliente))
    		return false;
    	
    	return true;
    }

    public List<Cliente> listadoClientes(){

    	return data;
    }
    
    public int getSize(){
    	
    	return size;
    }
}
