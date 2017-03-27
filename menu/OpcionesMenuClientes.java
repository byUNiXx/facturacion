package menu;

public enum OpcionesMenuClientes {

	BORRAR_CLIENTE("Borrar este cliente."),
	DAR_ALTA_LLAMADA("Dar de alta una llamada para este cliente."),
	DAR_ALTA_FACTURA("Dar de alta una factura para este cliente."),
	RECUPERAR_LLAMADAS("Listado de llamadas de este cliente."),
	RECUPERAR_FACTURAS("Listado de facturas de este cliente."),
	RECUPERAR_LLAMADAS_PERIODO("Listado de llamadas de este cliente, que fueron realizadas entre dos fechas."),
	RECUPERAR_FACTURAS_PERIODO("Listado de facturas de este cliente, emitidas entre dos fechas."),
	CAMBIAR_TARIFA("Cambiar tarifa de este cliente.");
	
private String descripcion;
	
	private OpcionesMenuClientes(String descripcion){
		
		this.descripcion = descripcion;
	}
	
	public String getDescripcion(){
		
		return descripcion;
	}
	
	public static OpcionesMenuClientes getOpcion(int posicion){
		
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

