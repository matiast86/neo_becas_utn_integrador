package Datos;

public class ResultadosDb {
	
	private int ronda;
	private String equipo1;
	private int cantGoles1;
	private int cantGoles2;
	private String equipo2;
	
	public ResultadosDb(int ronda, String equipo1, int cantGoles1, int cantGoles2, String equipo2) {
		super();
		this.ronda = ronda;
		this.equipo1 = equipo1;
		this.cantGoles1 = cantGoles1;
		this.cantGoles2 = cantGoles2;
		this.equipo2 = equipo2;
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

	public int getCantGoles1() {
		return cantGoles1;
	}

	public void setCantGoles1(int cantGoles1) {
		this.cantGoles1 = cantGoles1;
	}

	public int getCantGoles2() {
		return cantGoles2;
	}

	public void setCantGoles2(int cantGoles2) {
		this.cantGoles2 = cantGoles2;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
	
    public String toString() {
        return 
               ", Ronda: " + ronda +
               ", Equipo1: " + equipo1 +
               ", cantGoles1: " + cantGoles1 +
               ", cantGoles1: " + cantGoles2 +
               ", Equipo2: " + equipo2;
    }
	
	

}
