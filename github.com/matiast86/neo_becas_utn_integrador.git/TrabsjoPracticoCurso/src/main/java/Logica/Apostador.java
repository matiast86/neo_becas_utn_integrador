package Logica;

import java.util.ArrayList;
import java.util.Comparator;


public class Apostador {

	private String nombre;
	private ArrayList<Pronostico> pronostico;
	private int puntos;
	
	
	
	
	
	
	public Apostador(String nombre) {
		this.nombre = nombre;
		this.pronostico = new ArrayList<Pronostico>();
		this.puntos = 0;
	}
	
	
	//metodos
	
	 public void agregarPronosticos(Pronostico pronostico) {
		 this.pronostico.add(pronostico);
	 }

	
	public static boolean ApostadorEstaEnLista(String apostador, ArrayList<Apostador> apostadoresCreados) {
			for(Apostador a : apostadoresCreados) {
				if(a.getNombre().equals(apostador)) {
					return true;
				}
			}
		return false;
	}
		
	public static Apostador obtenerApostador(String apostador, ArrayList<Apostador> apostadoresCreados) {
		for(Apostador a : apostadoresCreados) {
			if(a.getNombre().equals(apostador)) {
					return a;
			}
		}
			return null;
	}
		
		
	public ArrayList<Pronostico> obtenerPronosticosPorRonda (int numeroRonda){
		ArrayList<Pronostico> listaPronosticos= new ArrayList<Pronostico>();
			
			
		for(Pronostico p : this.pronostico) {
				
			if(p.getNumeroRonda()==numeroRonda) {
				listaPronosticos.add(p);
			}
				
		}
			
		return listaPronosticos;
	 }
	
	public static void ordenarApostadores(ArrayList<Apostador> apostadores) {
	    // Define un Comparator para ordenar por puntos en orden descendente
	    Comparator<Apostador> comparadorPorPuntos = Comparator.comparingInt(Apostador::getPuntos).reversed();

	    // Utiliza el método sort de la lista para ordenar utilizando el Comparator
	    apostadores.sort(comparadorPorPuntos);
	}

	

	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Pronostico> getPronostico() {
		return pronostico;
	}
	public void setPronostico(ArrayList<Pronostico> pronostico) {
		this.pronostico = pronostico;
	}
	
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	@Override
	public String toString() {
	    StringBuilder stringBuilder = new StringBuilder();
	    stringBuilder.append("Apostador{");
	    stringBuilder.append(System.lineSeparator());
	    stringBuilder.append("nombre='").append(nombre).append('\'');
	    stringBuilder.append(System.lineSeparator());
	    stringBuilder.append(", pronostico=").append(pronostico);
	    stringBuilder.append(System.lineSeparator());
	    stringBuilder.append(", puntos=").append(puntos);
	    stringBuilder.append(System.lineSeparator());
	    stringBuilder.append('}');
	    stringBuilder.append(System.lineSeparator()); // Agrega un salto de línea después de cada apostador
	    return stringBuilder.toString();
	}
	

	

	
}
