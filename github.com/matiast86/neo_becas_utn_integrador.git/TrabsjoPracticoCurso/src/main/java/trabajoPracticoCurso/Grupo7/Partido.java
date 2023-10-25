package trabajoPracticoCurso.Grupo7;

public class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	
	
	public Partido(Equipo e1, Equipo e2, int golesE1, int golesE2) {
	
		this.equipo1=e1;
		this.equipo2=e2;
		this.golesEquipo1=golesE1;
		this.golesEquipo2=golesE2;
	}

	public resultadoEnum resultado(Equipo equipo) {
		if(!this.equipo1.equals(equipo)) {
			if(!this.equipo2.equals(equipo)) {
				System.out.println("Error, el equipo no coincide con los equipos que compiten en este partido");
			}
		}
		
		if(this.golesEquipo1==this.golesEquipo2) {
			return resultadoEnum.Empato;
		}	
	
		if(this.equipo1.equals(equipo)) {
			if(this.golesEquipo1>this.golesEquipo2) {
				return resultadoEnum.Ganador;
			} else {
				return resultadoEnum.Perdedor;
			}
		}
		
		if(this.golesEquipo2>this.golesEquipo1) {
			return resultadoEnum.Ganador;
		}
		else {
			return resultadoEnum.Perdedor;
		}

	}
}		
		
