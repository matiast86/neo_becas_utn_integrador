package trabajoPracticoCurso.Grupo7;

import java.util.ArrayList;
import java.util.List;

public class CreadorDeObjeto {

	
    List<ArchivosPronosticos> pronosticosList;
    List<ArchivoResultados> resultadosList;
    
    
    
    public CreadorDeObjeto (List<ArchivosPronosticos> pronosticoObtenido,List<ArchivoResultados> resultadoObtenido) {
    	this.pronosticosList=pronosticoObtenido;
    	this.resultadosList=resultadoObtenido;
    }
	
	
	public ArrayList<Apostador> listarApostadores(ArrayList<Ronda> RondasRealizadas) {
		ArrayList<Apostador> apostadoresCreados = new ArrayList<Apostador>();
		ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();

		for (ArchivosPronosticos lineaArchivoPronostico : this.pronosticosList) {
			Apostador apostadorSeleccionado;
			
			if(!Apostador.ApostadorEstaEnLista(lineaArchivoPronostico.getApostador(),apostadoresCreados)) {
				apostadorSeleccionado= new Apostador(lineaArchivoPronostico.getApostador());
				apostadoresCreados.add(apostadorSeleccionado);
			}
			
			apostadorSeleccionado= Apostador.obtenerApostador(lineaArchivoPronostico.getApostador(),apostadoresCreados);
			int chequeoRonda = lineaArchivoPronostico.getRonda();
			String chequeoEquipo1 = lineaArchivoPronostico.getEquipo1();
			String chequeoEquipo2 = lineaArchivoPronostico.getEquipo2();
			Pronostico nuevoPronostico = null;
			
			if(Ronda.estaEnLista(chequeoRonda, RondasRealizadas)) {
				Ronda ronda = Ronda.obtenerRondaConNumero(chequeoRonda, RondasRealizadas);
				for (Partido p : ronda.getPartidos()) {
					
					if (p.getEquipo1().getNombre().equals(chequeoEquipo1)
							&& p.getEquipo2().getNombre().equals(chequeoEquipo2)) {
						if (lineaArchivoPronostico.getGana1() == 'X') {
							nuevoPronostico = new Pronostico(p, p.getEquipo1(), resultadoEnum.Ganador);
						} else if (lineaArchivoPronostico.getGana2() == 'X') {
							nuevoPronostico = new Pronostico(p, p.getEquipo2(), resultadoEnum.Ganador);
						} else {
							nuevoPronostico = new Pronostico(p, p.getEquipo1(), resultadoEnum.Empato);
						}
					
					}
			
				}

			}
			
			if (!pronosticos.contains(nuevoPronostico)) {
				pronosticos.add(nuevoPronostico);
			}

		}

		return apostadoresCreados;

	}






	public ArrayList<Ronda> ListarRonda() {
		ArrayList<Ronda> rondasCreadas = new ArrayList<Ronda>();
		for (ArchivoResultados lineaArchivoResultado : this.resultadosList) {
			Ronda RondaCaptada;
			if (!Ronda.estaEnLista(lineaArchivoResultado.getRonda(), rondasCreadas)) {
				RondaCaptada = new Ronda(lineaArchivoResultado.getRonda());
				rondasCreadas.add(RondaCaptada);
			}

			RondaCaptada = Ronda.obtenerRondaConNumero(lineaArchivoResultado.getRonda(), rondasCreadas);

			Equipo nuevoEquipo1 = new Equipo(lineaArchivoResultado.getEquipo1());
			Equipo nuevoEquipo2 = new Equipo(lineaArchivoResultado.getEquipo2());


			Partido nuevoPartido = new Partido(nuevoEquipo1, nuevoEquipo2, lineaArchivoResultado.getGoles1(),
					lineaArchivoResultado.getGoles2());

			if (!RondaCaptada.getPartidos().contains(nuevoPartido)) {
				RondaCaptada.getPartidos().add(nuevoPartido);
			}

		}
		return rondasCreadas;
	}



	

    

	
    
}
