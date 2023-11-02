package trabajoPracticoCurso.Grupo7;

import com.opencsv.bean.CsvBindByPosition;

public class ArchivoResultados {
	
	@CsvBindByPosition(position = 0)
	private String equipo1;
	
	@CsvBindByPosition(position = 1)
	private char goles1;
	
	@CsvBindByPosition(position = 2)
	private char goles2;
	
	@CsvBindByPosition(position = 3)
	private String equipo2;

	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public char getGoles1() {
		return goles1;
	}

	public void setGoles1(char goles1) {
		this.goles1 = goles1;
	}

	public char getGoles2() {
		return goles2;
	}

	public void setGoles2(char goles2) {
		this.goles2 = goles2;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
	
	

}
