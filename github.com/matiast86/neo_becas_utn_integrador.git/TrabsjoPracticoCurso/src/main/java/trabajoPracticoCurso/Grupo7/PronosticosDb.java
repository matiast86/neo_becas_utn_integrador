package trabajoPracticoCurso.Grupo7;

public class PronosticosDb {
	
	private String apostador;
	private int ronda;
	private String equipo1;
	private String gana1;
	private String empata;
	private String gana2;
	private String equipo2;
	
	public PronosticosDb(String apostador, int ronda, String equipo1, String gana1, String empata, String gana2,
			String equipo2) {	
		this.apostador = apostador;
		this.ronda = ronda;
		this.equipo1 = equipo1;
		this.gana1 = gana1;
		this.empata = empata;
		this.gana2 = gana2;
		this.equipo2 = equipo2;
	}






	public String getApostador() {
		return apostador;
	}

	public void setApostador(String apostador) {
		this.apostador = apostador;
	}

	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public String getGana1() {
		return gana1;
	}

	public void setGana1(String gana1) {
		this.gana1 = gana1;
	}

	public String getEmpata() {
		return empata;
	}

	public void setEmpata(String empata) {
		this.empata = empata;
	}

	public String getGana2() {
		return gana2;
	}

	public void setGana2(String gana2) {
		this.gana2 = gana2;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
	
	
	
	

	
	
	
	
	

}
