package trabajoPracticoCurso.Grupo7;

import java.util.Objects;

public class Equipo {
	
	private String nombre;

	
	

	
	public Equipo(String nombre) {
		
		this.nombre=nombre;
	}
	
	
	
	public String getNombre() {
		return this.nombre;
		
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}



	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + "]";
	}
	
	
}
