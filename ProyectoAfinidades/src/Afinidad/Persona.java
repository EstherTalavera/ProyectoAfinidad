package Afinidad;

/**
 * <h2>Clase Persona <h2>
 * Esta clase contiene los datos de una persona necesarios para el programa
 * 
 * @author Grupo3
 * @version 1.0
 *
 */
public class Persona {

	/**
	 * Atributo nombre
	 * 
	 * Indica el nombre de la persona
	 */
	private String nombre;
	
	/**
	 * Atributo edad
	 * 
	 * Indica el edad de la persona
	 */
	private int edad;
	
	/**
	 * Atributo numAficiones
	 * 
	 * Numero de aficiones que tiene la persona
	 */
	private int numAficiones = 0;
	
	/**
	 * Atributo aficiones
	 * 
	 * Array que contiene las aficiones de la persona
	 */
	private Aficion [] aficiones = new Aficion[numAficiones];
	
	public static void main(String[] args) {
		Persona [] personas = new Persona [10];
		
		for (int i = 0; i < personas.length; i++) {
			System.out.println("Introduce el nombre de la persona");
		}
	}
}
