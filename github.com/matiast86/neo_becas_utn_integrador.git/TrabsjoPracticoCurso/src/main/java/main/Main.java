package main;

import java.util.ArrayList;

import Datos.LectorDeArchivos;
import Logica.Partido;
import Logica.Pronostico;
import controllers.PronosticosController;

public class Main {
	
	public static void main(String[] args) {
		
        PronosticosController pronosticosController = new PronosticosController();
        ArrayList<Pronostico> pronosticos = pronosticosController.obtenerPronosticos();

        // Do something with the pronosticos list
        for (Pronostico pronostico : pronosticos) {
            System.out.println("Pronostico: " + pronostico.toString());
;

            // Access the Partido object within Pronostico
            Partido partido = pronostico.getPartido();
            System.out.println("Partido: " + partido.toString());
        }
		
		
	}

}
