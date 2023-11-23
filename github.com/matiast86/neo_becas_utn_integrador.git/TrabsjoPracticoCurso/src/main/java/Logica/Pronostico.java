package Logica;

public class Pronostico {

	private int numeroRonda;
	private Partido partido;
	private Equipo equipo;
<<<<<<< HEAD
	private resultadoEnum resultado;
=======
	private resultadoEnum resultado;	
>>>>>>> a96c16b8b9492045e5f1a151716cf4ecf5ba535a
	
	public Pronostico (int ronda,Partido partido, Equipo equipo, resultadoEnum resultado) {
		this.numeroRonda=ronda;
		this.partido=partido;
		this.equipo=equipo;
		this.resultado=resultado;
	}
	
<<<<<<< HEAD
	
	
	public Pronostico(Partido partido, Equipo equipo, resultadoEnum resultado) {
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = resultado;
	}










=======
		
	
>>>>>>> a96c16b8b9492045e5f1a151716cf4ecf5ba535a
	public Partido getPartido() {
		return this.partido;
	}




	public Equipo getEquipo() {
		return equipo;
	}




	public resultadoEnum getResultado() {
		return resultado;
	}
	
<<<<<<< HEAD

=======
>>>>>>> a96c16b8b9492045e5f1a151716cf4ecf5ba535a

	public int getNumeroRonda() {
		return numeroRonda;
	}

	public void setNumeroRonda(int numeroRonda) {
		this.numeroRonda = numeroRonda;
	}


	

}
