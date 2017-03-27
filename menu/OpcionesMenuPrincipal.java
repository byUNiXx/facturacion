package menu;

public enum OpcionesMenuPrincipal {

	
	BUSCAR_CLIENTE_NIF("Busqueda de cliente por NIF."),
	BUSCAR_COD_FAC("Busqueda de factura por codigo."),
	RECUPERAR_CLIENTES("Listado de todos los clientes."),
	BUSCAR_CLIENTES_PERIODO("Listado clientes dados de alta entre dos fechas."),
	DAR_ALTA_CLIENTE("Dar de alta un nuevo clientes."),
	FINALIZAR("Finaliza la sesion.");
	
	private String descripcion;
	
	private OpcionesMenuPrincipal(String descripcion){
		
		this.descripcion = descripcion;
	}
	
	public String getDescripcion(){
		
		return descripcion;
	}
	
	public static OpcionesMenuPrincipal getOpcion(int posicion){
		
		return values()[posicion];
	}
	
	public static String getMenu(){
		
		StringBuilder sb = new StringBuilder();
		
		for(OpcionesMenuPrincipal opcion : OpcionesMenuPrincipal.values()){
			sb.append(opcion.ordinal());
			sb.append(".- ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
}
