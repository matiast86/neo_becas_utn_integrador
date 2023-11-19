package controllers;

import java.util.ArrayList;

import Datos.ResultadosDb;
import Logica.Equipo;
import Logica.Partido;
import Logica.Ronda;
import dao.DAO;
import dao.Impl.MysqlDaoImpl;

public class ResultadosController {


        public void procesarResultados() {
        	DAO dao = new MysqlDaoImpl();
            ArrayList<Ronda> rondas = new ArrayList<>();

            try {
                ArrayList<ResultadosDb> resultados = dao.findAllResultados();

                // Create Partido objects and assign resultadosEnum
                for (ResultadosDb resultado : resultados) {
                    Equipo equipo1 = new Equipo(resultado.getEquipo1());
                    Equipo equipo2 = new Equipo(resultado.getEquipo2());

                    Partido partido = new Partido(equipo1, equipo2, resultado.getCantGoles1(), resultado.getCantGoles2());

                    // Assign resultadosEnum based on actual results
                    
                    partido.resultado(equipo2);
                    partido.resultado(equipo1);

                    // Assuming you have a list of rounds
                    Ronda ronda = Ronda.obtenerRondaConNumero(resultado.getRonda(), rondas);
                    if (ronda == null) {
                        ronda = new Ronda(resultado.getRonda());
                        rondas.add(ronda);
                    }

                    // Add Partido to Ronda
                    ronda.agregarPartido(partido);
                }

                // Print resultados
                System.out.println("Resultados:");
                for (Ronda ronda : rondas) {
                    System.out.println("Ronda " + ronda.getNro() + ":");
                    for (Partido partido : ronda.getPartidos()) {
                        System.out.println(partido.toString() + " - Resultado: " + partido.resultado(null) + partido.resultado(null));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

