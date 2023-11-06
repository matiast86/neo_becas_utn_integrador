package trabajoPracticoCurso.Grupo7;

import java.util.ArrayList;

public class Ronda {

	private int nro;
	private ArrayList<Partido> partidos;
	
	
	
	public Ronda (int numero) {
		this.nro=numero;
		this.partidos= new ArrayList<Partido>();
	}
	
	public void agregarPartido (Partido partido) {
		this.partidos.add(partido);
	}

	
	public int getNro() {
		return this.nro;
	}
		
	public ArrayList<Partido> getPartidos (){
		return this.partidos;
	}
	

	
	
	
}
