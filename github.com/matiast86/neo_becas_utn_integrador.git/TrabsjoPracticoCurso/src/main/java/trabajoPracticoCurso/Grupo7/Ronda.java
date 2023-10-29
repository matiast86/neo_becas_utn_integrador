package trabajoPracticoCurso.Grupo7;

import java.util.ArrayList;

public class Ronda {

	private String nro;
	private ArrayList<Partido> partidos;
	
	
	
	public Ronda (String numero) {
		this.nro=numero;
	}
	
	public void agregarPartido (Partido partido) {
		this.partidos.add(partido);
	}
	
}
