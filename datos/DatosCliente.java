package datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import cliente.Cliente;
import cliente.Direccion;
import cliente.Empresa;
import cliente.Particular;
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
    
    public static void main(String[] args) {
    	
    	Cliente cliente = new Particular("63788220Y","Diego","Cano","al342376@uji.es",
    			new Direccion("12540","Vila-real","Castellón"), LocalDate.of(2017, 11, 23), new Tarifa(0.37));
    	
    	Cliente cliente2 = new Empresa("53788220Y","Diego","al342376@uji.es",
    			new Direccion("12540","Vila-real","Castellón"), LocalDate.of(2017, 8, 29), new Tarifa(0.37));
    	
    	DatosClientes datos = new DatosClientes();
    	
    	datos.añadirCliente(cliente);
    	datos.añadirCliente(cliente2);
    	
    	datos.cambiarTarifa(cliente2, new Tarifa(0.50));
    	
    	List<Cliente> lista = datos.listadoClientes();
    	
    	for(int i = 0; i < datos.data.size(); i++){
    		System.out.println(datos.data.get(i));
    	}
    	
    	System.out.println(datos.buscarCliente("53788220Y").getTarifa());
    }


}
