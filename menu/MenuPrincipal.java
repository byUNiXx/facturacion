package menu;

import java.util.Scanner;

public class MenuPrincipal {
	
	public static void inicio(){
		
		System.out.println(OpcionesMenuPrincipal.getMenu());
		Scanner entrada = new Scanner(System.in);
		System.out.println("Elije una opcion: ");
		byte opcion = entrada.nextByte();
		OpcionesMenuPrincipal opcionMenuPrincipal = OpcionesMenuPrincipal.getOpcion(opcion);
		
		switch(opcionMenuPrincipal.name()){
		
			case "BUSCAR_CLIENTE_NIF":
				MetodosMenu.buscarNIF();
				break;
			case "BUSCAR_COD_FAC":
				MetodosMenu.buscarCodFac();
				break;
			case "RECUPERAR_CLIENTES":
				MetodosMenu.listadoClientes();
				break;
			case "BUSCAR_CLIENTES_PERIODO":
				MetodosMenu.buscarClientePeriodo();
				break;
			case "DAR_ALTA_CLIENTE":
				MetodosMenu.altaCliente();
				break;
			case "FINALIZAR":
				MenuPrincipal.inicio(); //No puesto aun, falta ficheros
			default:
				MenuPrincipal.inicio();
				
		}
		MenuPrincipal.inicio();
	}

}
