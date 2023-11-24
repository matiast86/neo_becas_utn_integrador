package controllers;

import java.util.ArrayList;

import ClaseErrores.DatoIngresadoNoEsperado;
import ClaseErrores.DatoIngresadoVacioException;
import Datos.ArchivosPronosticos;
import Datos.PronosticosDb;
import Logica.Apostador;
import Logica.Equipo;
import Logica.Partido;
import Logica.Pronostico;
import Logica.Ronda;
import Logica.resultadoEnum;
import dao.DAO;
import dao.Impl.MysqlDaoImpl;

public class PronosticosController {

    public ArrayList<Pronostico> obtenerPronosticos(ArrayList<Ronda> rondasRealizadas) {
        DAO dao = new MysqlDaoImpl();
        ArrayList<Pronostico> pronosticos = new ArrayList<>();

        try {
            ArrayList<PronosticosDb> pronosticosDb = dao.findAllPronosticos();


            for (PronosticosDb item : pronosticosDb) {
                Apostador apostador = new Apostador(item.getApostador());


                Equipo equipo1 = new Equipo(item.getEquipo1());
                Equipo equipo2 = new Equipo(item.getEquipo2());
                Partido partido = new Partido(equipo1, equipo2); 


                Pronostico pronostico = null;
                
                resultadoEnum guessedResult = null;
                if (item.getGana1().equals("X")) {
                    pronostico = new Pronostico();
                } else if (item.getGana2().equals("X")) {
                    guessedResult = resultadoEnum.Ganador;
                } else if ("gana2".equalsIgnoreCase(item.getGana2())) {
                    guessedResult = resultadoEnum.Perdedor;
                }


                Pronostico pronostico = new Pronostico(partido, equipo2, guessedResult);


                apostador.agregarPronosticos(pronostico);
                pronosticos.add(pronostico);
            }


            System.out.println("Pronosticos:");
            for (Pronostico pronostico : pronosticos) {
                System.out.println(pronostico.getPartido().toString() + " - Pronostico: " + pronostico.getResultado());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }

        return pronosticos;
    }
  /*  
	public ArrayList<Apostador> listarApostadores(ArrayList<Ronda> RondasRealizadas) throws  DatoIngresadoNoEsperado, DatoIngresadoVacioException {
		ArrayList<Apostador> apostadoresCreados = new ArrayList<Apostador>();

		for (PronosticosDb lineaArchivoPronostico : ArrayList<PronosticosDb> {
			Apostador apostadorSeleccionado;
			// chequeos en las entradas del archivo
			
			
			if(!(lineaArchivoPronostico.getGana1() == NULL) && !(lineaArchivoPronostico.getGana1() == 'X')) {
				throw new DatoIngresadoNoEsperado();
			} 
			
			if(!(lineaArchivoPronostico.getGana2() == NULL) && !(lineaArchivoPronostico.getGana2() == 'X')) {
				throw new DatoIngresadoNoEsperado();
			} 
			if(!(lineaArchivoPronostico.getEmpata() == NULL) && !(lineaArchivoPronostico.getEmpata() == 'X')) {
				throw new DatoIngresadoNoEsperado();
			} 
			
			
			
			
			if(!Apostador.ApostadorEstaEnLista(lineaArchivoPronostico.getApostador(),apostadoresCreados) && !lineaArchivoPronostico.getApostador().equals("")) {
				apostadorSeleccionado= new Apostador(lineaArchivoPronostico.getApostador());
				apostadoresCreados.add(apostadorSeleccionado);
			} /*else if(!lineaArchivoPronostico.getApostador().equals("")) {
				throw new Exception ("El nombre del apostador no puede ser vacio");
			} hay que preguntar al profe sobre el problema que lee una linea de mas 
				
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
				

		
		return apostadoresCreados;

	}
*/
    

}

