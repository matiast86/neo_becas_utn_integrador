package trabajoPracticoCurso.Grupo7;

public class Pronostico {

	
	private Partido partido;
	private Equipo equipo;
	private resultadoEnum resultado;
	
	
	public Pronostico (Partido partido, Equipo equipo, resultadoEnum resultado) {
		
		this.partido=partido;
		this.equipo=equipo;
		this.resultado=resultado;
	}


	
	public int puntos () {
		if(getPartido().resultado(getEquipo()).equals(resultado)) {
			return 1;
		}
		return 0;
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


	

}
