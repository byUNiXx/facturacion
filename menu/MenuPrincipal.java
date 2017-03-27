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
				entrada = metodoEntrada();
				buscarNIF(entrada);
			case "BUSCAR_COD_FAC":
				System.out.println(opcionMenuPrincipal.name());
			case "RECUPERAR_CLIENTES":
				System.out.println(opcionMenuPrincipal.name());
			case "BUSCAR_CLIENTES_PERIODO":
				System.out.println(opcionMenuPrincipal.name());
			case "DAR_ALTA_CLIENTE":
				System.out.println(opcionMenuPrincipal.name());
			case "FINALIZAR":
				
			default:
				MenuPrincipal.inicio();
		}
	}

}
