package afinidad;

import java.util.Scanner;

/**
 * <h2>Clase Persona <h2>
 * Esta clase contiene los datos de una persona necesarios para el programa
 * 
 * @author Grupo3
 * @version 1.0
 *
 */
public class Persona {
	
	public static Scanner stdin = new Scanner(System.in);
	
	/**
	 * Atributo nombre
	 * 
	 * Indica el nombre de la persona
	 * 
	 */
	private String nombre;
	
	/**
	 * Atributo edad
	 * 
	 * Indica el edad de la persona
	 * 
	 */
	
	private String apellido;

	/**
	 * Atributo edad
	 * 
	 * Indica el edad de la persona
	 * 
	 */

	private int edad;
	
	/**
	 * Atributo numAficiones
	 * 
	 * Numero de aficiones que tiene la persona
	 * 
	 */
	private int numAficiones;
	
	/**
	 * Atributo aficiones
	 * 
	 * Array que contiene las aficiones de la persona
	 * 
	 */	
	private Aficion[] aficiones;
	
	/**
	 * 
	 * @param nombre Fija el nombre a una persona en concreto
	 * 
	 */
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * 
	 * @return Devuelve el nombre de la persona
	 * 
	 */
	public String getNombre () {
		return nombre;
	}
	
	/**
	 * 
	 * @param apellido Fija el apellido a una persona
	 * 
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}	
	
	/**
	 * 
	 * @return Devuelve el apellido de la persona
	 * 
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * 
	 * @param edad Fija la edad a una persona en concreto
	 * 
	 */
	public void setEdad (int edad) {
		this.edad = edad;
	}
	
	/**
	 * 
	 * @return Devuelve la edad de la persona
	 * 
	 */
	public int getEdad () {
		return edad;
	}
	
	/**
	 * 
	 * @param numAficiones Fija el numero de aficiones a una persona en concreto
	 * 
	 */
	public void setNumAficiones (int numAficiones) {
		this.numAficiones = numAficiones;
	}
	
	/**
	 * 
	 * @return Devuelve el numero de aficiones de la persona
	 * 
	 */
	public int getNumAficiones () {
		return numAficiones;
	}
	
	/**
	 * 
	 * @param aficiones Fija la aficion a una persona en concreto
	 * 
	 */
	public void setAficiones (Aficion[] aficiones) {
		this.aficiones = aficiones;
	}
	
	/**
	 * 
	 * @return Devuelve la aficion de la persona
	 * 
	 */
	public Aficion[] getAficiones () {
		return this.aficiones;
	}
	
	/**
	 * 
	 * @param personas Array de personas
	 * 
	 */
	public static void rellenarArrayPersonas (Persona personas[]) {
		for (int i = 0; i < personas.length; i++) {
			personas[i] = new Persona();
		}
	}
	
	public static void main(String[] args) {
		//Array que contiene las personas
		Persona[] personas = new Persona[3];
		
		Persona.rellenarArrayPersonas(personas);
		
		//Array que contiene las aficiones disponibles para elegir
		Aficion[] aficiones = new Aficion[7];
		String[] nombreAficiones = {"Futbol", "Baloncesto", "Tenis", 
				"Formula 1", "Badminton", "Ajedrez", "Astrologia"};		
		for (int i = 0; i < 7; i++) {
			Aficion a = new Aficion(i+1, nombreAficiones[i]);
			aficiones[i] = a;
		}
		
		//For para pedir por pantalla los datos de las personas
		for (int i = 0; i < personas.length; i++) {
			System.out.println("---Introduce los datos de la persona " + (i + 1) + "---");
			
			System.out.println("\nIntroduce el nombre");
			personas[i].setNombre(stdin.next());
			
			System.out.println("\nIntroduce el apellido");
			personas[i].setApellido(stdin.next());
			
			System.out.println("\nIntroduce la edad");
			personas[i].setEdad(stdin.nextInt());
			
			System.out.println("¿Cuantas aficiones tiene? Puedes elegir un maximo de 7");
			personas[i].setNumAficiones(stdin.nextInt()); 
			
			//Menu que muestra por pantalla las aficiones entre las que puede elegir
			System.out.println("Elige " + personas[i].getNumAficiones() + " aficiones. Escribe los codigos separados por coma.");
			String aficionesTexto = "";
			for (int z = 0; z < aficiones.length; z++) {
				aficionesTexto = aficionesTexto + aficiones[z].getCodAficion() + ": " + aficiones[z].getNombreAficion() + "\n";
			}
			System.out.println(aficionesTexto);
			
			String seleccion = stdin.next();
			
			//Array con las aficiones elegidas pro el usuario
			String[] codigos = seleccion.split(",");
			
			//Añadimos las aficiones seleccionada a la persona
			Aficion[] afiPersona = new Aficion[personas[i].getNumAficiones()];
			for(int y = 0; y < codigos.length; y++) {
				int codigo = Integer.parseInt(codigos[y]);
				afiPersona[y] = new Aficion(codigo, nombreAficiones[codigo- 1]);
			}
			personas[i].setAficiones(afiPersona);
		}
		
		//For donde se comparan las personas en busca de afinidades
		String res = "";		
		for (int i = 0; i < personas.length; i++) {
			Persona p1 = personas[i];//p1 es la persona que va a ser comparada
			res = res + p1.getNombre() + " " + p1.getApellido() + " tiene afinidad con: ";
			if (p1.getNumAficiones() >= 3) {//si no tiene mas de 3 aficiones no hace falta que comparemos				
				int numeroPersonasConAfinidad = 0;
				for (int j = 0; j < personas.length; j++) {
					if (i != j) {					
						Persona p2 = personas[j];//p2 es la persona con la que va a ser comparada p1 en cada iteracion
						if (p2.getNumAficiones() >= 3) {//si no tiene mas de 3 aficiones no hace falta que comparemos
							int numeroCoincidencias = 0;
							for (int k = 0; k < p1.getNumAficiones(); k++) {//bucle que representa la aficion de p1 que esta siendo comparada
								boolean coincidencia = false;
								for (int h = 0; h < p2.getNumAficiones() && !coincidencia; h++) {//bucle que representa la aficion de p2 que esto siendo comparada
									if (p1.getAficiones()[k].getCodAficion() == p2.getAficiones()[h].getCodAficion()) {//si la aficion es la misma contamos que hemos encontrado una aficion en la que coinciden
										coincidencia = true;
										numeroCoincidencias++;
									}
								}
							}
							//si se han obtenido 3 o mas coincidencias, esas dos personas tienen afinidad
							if(numeroCoincidencias >= 3) {
								res = res + p2.getNombre() + "";
								numeroPersonasConAfinidad++;
							}
						}					
					}
				}
				if (numeroPersonasConAfinidad == 0) {
					res = res + " NADIE";
				}
			}
			else {
				res = res + " NADIE";
			}
			res = res + "." + "\n";
		}		
		System.out.println("Afinidad de las personas");
		System.out.println(res);
	}
}