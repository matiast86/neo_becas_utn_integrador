package controllers;

import java.util.ArrayList;

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

    public ArrayList<Pronostico> obtenerPronosticos(ArrayList<Ronda> rondasCreadas) {
        DAO dao = new MysqlDaoImpl();
        ArrayList<Pronostico> pronosticos = new ArrayList<>();

        try {
            ArrayList<PronosticosDb> pronosticosDb = dao.findAllPronosticos();


            for (PronosticosDb item : pronosticosDb) {
                Apostador apostador = new Apostador(item.getApostador());


                Equipo equipo1 = new Equipo(item.getEquipo1());
                Equipo equipo2 = new Equipo(item.getEquipo2());
                Partido partido = new Partido(equipo1, equipo2, 0, 0); 


                resultadoEnum guessedResult = null;
                if ("gana1".equalsIgnoreCase(item.getGana1())) {
                    guessedResult = resultadoEnum.Ganador;
                } else if ("empata".equalsIgnoreCase(item.getEmpata())) {
                    guessedResult = resultadoEnum.Empato;
                } else if ("gana2".equalsIgnoreCase(item.getGana2())) {
                    guessedResult = resultadoEnum.Perdedor;
                }


                Pronostico pronostico = new Pronostico(partido, equipo1, guessedResult);


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
    

}

