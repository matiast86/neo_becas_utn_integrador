package Logica;

public class Pronostico {

	private int numeroRonda;
	private Partido partido;
	private Equipo equipo;
	private resultadoEnum resultado;
	private PartidoPronosticado partidoPronosticado;
	
	
	public Pronostico (int ronda,Partido partido, Equipo equipo, resultadoEnum resultado) {
		this.numeroRonda=ronda;
		this.partido=partido;
		this.equipo=equipo;
		this.resultado=resultado;
	}
	
	public Pronostico (PartidoPronosticado partidoPronosticado, Equipo equipo, resultadoEnum resultado) {
		this.partidoPronosticado = partidoPronosticado;
		this.equipo=equipo;
		this.resultado=resultado;
	}


		
	
	public Partido getPartido() {
		return this.partido;
	}




	public Equipo getEquipo() {
		return equipo;
	}




	public resultadoEnum getResultado() {
		return resultado;
	}
	
	public PartidoPronosticado getPArtidoPrnosticado() {
		return partidoPronosticado;
	}

	public int getNumeroRonda() {
		return numeroRonda;
	}

	public void setNumeroRonda(int numeroRonda) {
		this.numeroRonda = numeroRonda;
	}


	

}
