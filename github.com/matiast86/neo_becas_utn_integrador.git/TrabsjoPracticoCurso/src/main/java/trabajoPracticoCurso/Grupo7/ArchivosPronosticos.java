package trabajoPracticoCurso.Grupo7;
import com.opencsv.bean.CsvBindByPosition;



public class ArchivosPronosticos {
	
	@CsvBindByPosition(position = 0)
	private String equipo1;
	
	@CsvBindByPosition(position = 1)
	private char gana1;
	
	@CsvBindByPosition(position = 2)
	private char empata;
	
	@CsvBindByPosition(position = 3)
	private char gana2;
	
	@CsvBindByPosition(position = 4)
	private String equipo2;

	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public char getGana1() {
		return gana1;
	}

	public void setGana1(char gana1) {
		this.gana1 = gana1;
	}

	public char getEmpata() {
		return empata;
	}

	public void setEmpata(char empata) {
		this.empata = empata;
	}

	public char getGana2() {
		return gana2;
	}

	public void setGana2(char gana2) {
		this.gana2 = gana2;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
	
}
