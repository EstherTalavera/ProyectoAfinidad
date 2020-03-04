package Afinidad;

public class Aficion {
	
	/**
	 * Atributo cod_Aficion
	 * 
	 * Indica el numero dado a x aficion
	 * 
	 */
	private int cod_Aficion;
	
	/**
	 * Atributo aficiones
	 * 
	 * Indica el nombre de la aficion
	 * 
	 */
	private String nombre_Aficion;
	
	/**
	 * 
	 * @param cod Codigo a asignar a la aficion
	 * @param nombre Nombre a asignar la aficion
	 * 
	 */
	public Aficion(int cod, String nombre) {
		cod_Aficion = cod;
		nombre_Aficion = nombre;		
	}
	
	/**
	 * 
	 * @param nombreAficion Fija el nombre a una aficion en concreto
	 * 
	 */
	public void setNombreAficion (String nombreAficion) {
		nombre_Aficion = nombreAficion;
	}
	
	/**
	 * 
	 * @return Devuelve el nombre de la aficion
	 * 
	 */
	public String getNombreAficion () {
		return nombre_Aficion;
	}
	
	/**
	 * 
	 * @param codAficion Fija el codigo a una aficion en concreto
	 * 
	 */
	public void setCodAficion (int codAficion) {
		cod_Aficion = codAficion;
	}
	
	/**
	 * 
	 * @return Devuelve el codigo de la aficion
	 * 
	 */
	public int getCodAficion () {
		return cod_Aficion;
	}
}