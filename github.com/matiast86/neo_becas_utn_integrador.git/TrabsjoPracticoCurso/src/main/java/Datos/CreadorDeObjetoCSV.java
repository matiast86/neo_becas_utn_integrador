package Datos;

import java.util.ArrayList;
import java.util.List;

import ClaseErrores.DatoIngresadoNoEsperado;
import ClaseErrores.DatoIngresadoVacioException;
import Logica.Apostador;
import Logica.Equipo;
import Logica.Partido;
import Logica.Pronostico;
import Logica.Ronda;
import Logica.resultadoEnum;

public class CreadorDeObjetoCSV {

	
    List<ArchivosPronosticos> pronosticosList;
    List<ArchivoResultados> resultadosList;
    
    
    
    public CreadorDeObjetoCSV (List<ArchivosPronosticos> pronosticoObtenido,List<ArchivoResultados> resultadoObtenido) {
    	this.pronosticosList=pronosticoObtenido;
    	this.resultadosList=resultadoObtenido;
    }
	
	
	public ArrayList<Apostador> listarApostadores(ArrayList<Ronda> RondasRealizadas) throws  DatoIngresadoNoEsperado {
		ArrayList<Apostador> apostadoresCreados = new ArrayList<Apostador>();

		for (ArchivosPronosticos lineaArchivoPronostico : this.pronosticosList) {
			Apostador apostadorSeleccionado;
			
			
			if(lineaArchivoPronostico.getEquipo1().equals("")) {
				throw new DatoIngresadoVacioException();
			}
			if(lineaArchivoPronostico.getEquipo2().equals("")) {
				throw new DatoIngresadoVacioException();
			}
			
			if (lineaArchivoPronostico.getRonda()==0) {
				throw new DatoIngresadoVacioException();
			}
			
			if(lineaArchivoPronostico.getGana1()== ' ') {
				throw new DatoIngresadoVacioException();
			} else if (lineaArchivoPronostico.getGana1() != 'X') {
					throw new DatoIngresadoNoEsperado(lineaArchivoPronostico.getGana1());
				}
			
			if(lineaArchivoPronostico.getGana2()== ' ') {
				throw new DatoIngresadoVacioException();
			} else if (lineaArchivoPronostico.getGana2() != 'X') {
				throw new DatoIngresadoNoEsperado (lineaArchivoPronostico.getGana2());
				}
			
			
			
			
			
			if(!Apostador.ApostadorEstaEnLista(lineaArchivoPronostico.getApostador(),apostadoresCreados) && !lineaArchivoPronostico.getApostador().equals("")) {
				apostadorSeleccionado= new Apostador(lineaArchivoPronostico.getApostador());
				apostadoresCreados.add(apostadorSeleccionado);
			} /*else if(!lineaArchivoPronostico.getApostador().equals("")) {
				throw new Exception ("El nombre del apostador no puede ser vacio");
			} hay que preguntar al profe sobre el problema que lee una linea de mas 
			*/	
			apostadorSeleccionado= Apostador.obtenerApostador(lineaArchivoPronostico.getApostador(),apostadoresCreados);
			int chequeoRonda = lineaArchivoPronostico.getRonda();
			
			String chequeoEquipo1 = lineaArchivoPronostico.getEquipo1();
			
			String chequeoEquipo2 = lineaArchivoPronostico.getEquipo2();
			
			Pronostico nuevoPronostico = null ;
			
			
			
			
			
			if(Ronda.estaEnLista(chequeoRonda, RondasRealizadas)) {
				Ronda ronda = Ronda.obtenerRondaConNumero(chequeoRonda, RondasRealizadas);
				
				for (Partido p : ronda.getPartidos()) {
					
					if (p.getEquipo1().getNombre().equals(chequeoEquipo1) && p.getEquipo2().getNombre().equals(chequeoEquipo2)) {
						if (lineaArchivoPronostico.getGana1() == 'X') {
							nuevoPronostico = new Pronostico(p, p.getEquipo1(), resultadoEnum.Ganador);
						} else if (lineaArchivoPronostico.getGana2() == 'X') {
							nuevoPronostico = new Pronostico(p, p.getEquipo2(), resultadoEnum.Ganador);
						} else {
							nuevoPronostico = new Pronostico(p, p.getEquipo1(), resultadoEnum.Empato);
						}
					
					}
					
				}
					
				if (!apostadorSeleccionado.getPronostico().contains(nuevoPronostico)) {
						apostadorSeleccionado.agregarPronosticos(nuevoPronostico);
				}
					
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
