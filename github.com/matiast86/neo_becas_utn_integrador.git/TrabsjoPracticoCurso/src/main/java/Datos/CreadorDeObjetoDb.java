package Datos;

import java.util.ArrayList;

import ClaseErrores.DatoIngresadoNoEsperado;
import Logica.Apostador;
import Logica.Equipo;
import Logica.Partido;
import Logica.Pronostico;
import Logica.Ronda;
import Logica.resultadoEnum;
import dao.DAO;
import dao.Impl.MysqlDaoImpl;

public class CreadorDeObjetoDb {
	
	DAO dao;

	public CreadorDeObjetoDb() {
		this.dao = new MysqlDaoImpl();
	}
	
    
	public ArrayList<Ronda> procesarResultados() {
    		
		ArrayList<Ronda> rondas = new ArrayList<>();
		try {
    		ArrayList<ResultadosDb> resultados = this.dao.findAllResultados();
            for (ResultadosDb resultado : resultados) {
                Equipo equipo1 = new Equipo(resultado.getEquipo1());
                Equipo equipo2 = new Equipo(resultado.getEquipo2());

                Partido partido = new Partido(equipo1, equipo2, resultado.getCantGoles1(), resultado.getCantGoles2());


    
                Ronda ronda = Ronda.obtenerRondaConNumero(resultado.getRonda(), rondas);
                if (ronda == null) {
                    ronda = new Ronda(resultado.getRonda());
                    rondas.add(ronda);
                }

                ronda.agregarPartido(partido);
            }

            System.out.println("Resultados:");
            for (Ronda ronda : rondas) {
                System.out.println("Ronda " + ronda.getNro() + ":");
                for (Partido partido : ronda.getPartidos()) {
                    System.out.println(partido.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        return rondas;
	}
	
        public ArrayList<Apostador> obtenerApostadores(ArrayList<Ronda> rondasRealizadas) {
        	
        	ArrayList<Apostador> apostadoresCreados = new ArrayList<Apostador>();
        	
        	try {
				ArrayList<PronosticosDb> pronosticosProcesados = dao.findAllPronosticos();
				
				for (PronosticosDb item : pronosticosProcesados) {
					
					//Chequear ingreso de datos
					if(item.getGana1() != null && !item.getGana1().equals("X")) {
						throw new DatoIngresadoNoEsperado();
					} 
					
					if(item.getGana2() != null && !item.getGana2().equals("X")) {
						throw new DatoIngresadoNoEsperado();
					} 
					if(item.getEmpata() != null && !item.getEmpata().equals("X")) {
						throw new DatoIngresadoNoEsperado();
					}
					Apostador apostador = Apostador.obtenerApostador(item.getApostador(),apostadoresCreados);
					if (apostador == null) {
						apostador = new Apostador(item.getApostador());
						apostadoresCreados.add(apostador);
					}
					int chequeoRondas = item.getRonda();
					String chequeoEquipo1 = item.getEquipo1();
					String chequeoEquipo2 = item.getEquipo2();
					
					Pronostico nuevoPronostico = null;
				
				
				
					if(Ronda.estaEnLista(chequeoRondas, rondasRealizadas)) {
						Ronda ronda = Ronda.obtenerRondaConNumero(chequeoRondas, rondasRealizadas);
						
						for (Partido p : ronda.getPartidos()) {
							
							if (p.getEquipo1().getNombre().equals(chequeoEquipo1) && p.getEquipo2().getNombre().equals(chequeoEquipo2)) {
								if (item.getGana1() != null) {
									nuevoPronostico = new Pronostico(chequeoRondas,p, p.getEquipo1(), resultadoEnum.Ganador);
								} else if (item.getGana2() != null) {
									nuevoPronostico = new Pronostico(chequeoRondas,p, p.getEquipo2(), resultadoEnum.Ganador);
								} else {
									nuevoPronostico = new Pronostico(chequeoRondas,p, p.getEquipo1(), resultadoEnum.Empato);
								}
							
							}
							
						}
							
						if (!apostador.getPronostico().contains(nuevoPronostico)) {
							apostador.agregarPronosticos(nuevoPronostico);
						}
							
					}
				}
					

			
			

		
				
				
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	return apostadoresCreados;
        	
        	
        	
        	
        	
        	
        	
	}
	
	
	
	


}