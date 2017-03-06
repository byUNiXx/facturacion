package datos;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import cliente.Cliente;
import tarifa.Tarifa;

public class DatosClientes {
    private List<Cliente> data;

    public DatosClientes(){
        data = new ArrayList<Cliente>();
    }

    public void añadirCliente(Cliente cliente){
        if (data.contains(cliente)){
            System.out.println("Ya existe este cliente mentecato");
            return;
        }
        data.add(cliente);
    }

    public void borrarCliente(Cliente cliente){
        if (!data.contains(cliente)){
            System.out.println("No existe este cliente mentecato");
            return;
        }
        data.remove(cliente);
    }

    public void cambiarTarifa(Cliente cliente, Tarifa tarifa){
        int posicion = data.indexOf(cliente);
        
        cliente.cambiarTarifa(tarifa);
        
        data.set(posicion, cliente);
    }

    public Cliente buscarCliente(String NIF) throws NoSuchElementException{
    	
    	for(Cliente cliente : data){
    		if(cliente.getNIF().equals(NIF))
    			return cliente;
    	}
    	throw new NoSuchElementException();	
    }

    public List<Cliente> listadoClientes(){

    	return data;
    }
}
