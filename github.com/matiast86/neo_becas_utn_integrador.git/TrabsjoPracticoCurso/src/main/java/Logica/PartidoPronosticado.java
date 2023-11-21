package Logica;

import Datos.PronosticosDb;

public class PartidoPronosticado {
	
	private String equipo1;
	private String equipo2;
	private String resultadoEquipo1;
	private String resultadoEquipo2;
	
	public PartidoPronosticado(String equipo1, String equipo2, String resultadoEquipo1, String resultadoEquipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.resultadoEquipo1 = resultadoEquipo1;
		this.resultadoEquipo2 = resultadoEquipo2;
	}
	
	
	
	public PartidoPronosticado(Equipo equipo12, Equipo equipo22) {
		
		// TODO Auto-generated constructor stub
	}



	public String getEquipo1() {
		return equipo1;
	}



	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}



	public String getEquipo2() {
		return equipo2;
	}



	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}



	public String getResultadoEquipo1() {
		return resultadoEquipo1;
	}



	public void setResultadoEquipo1(String resultadoEquipo1) {
		this.resultadoEquipo1 = resultadoEquipo1;
	}



	public String getResultadoEquipo2() {
		return resultadoEquipo2;
	}



	public void setResultadoEquipo2(String resultadoEquipo2) {
		this.resultadoEquipo2 = resultadoEquipo2;
	}



	public resultadoEnum resultado(Equipo equipo) {

		if (!this.equipo1.equals(equipo) && !this.equipo2.equals(equipo)) {
			System.out.println("Error, el equipo no coincide con los equipos que compiten en este partido");
			
		}
			PronosticosDb pronosticosDb = new PronosticosDb();

		if (pronosticosDb.getGana1() != null && pronosticosDb.getEmpata() == null && pronosticosDb.getGana2() == null) {
		    return resultadoEnum.Ganador;
		} else if (pronosticosDb.getGana1() == null && pronosticosDb.getEmpata() == null && pronosticosDb.getGana2() != null) {
		    return resultadoEnum.Perdedor;
		} else if (pronosticosDb.getGana1() == null && pronosticosDb.getEmpata() != null && pronosticosDb.getGana2() == null) {
		    return resultadoEnum.Empato;
		} else {
		    System.out.println("Error: Apostador debe marcar la columna con 'X'.");
		    throw new IllegalStateException("Error: Apostador debe marcar la columna con 'X'.");
		}
	}
	
}
	

