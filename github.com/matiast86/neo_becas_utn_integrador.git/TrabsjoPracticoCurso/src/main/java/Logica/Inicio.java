package Logica;

import java.util.ArrayList;

import ClaseErrores.DatoIngresadoNoEsperado;

import Datos.CreadorDeObjetoCSV;
import Datos.LectorDeArchivos;


public class Inicio {

	public static void main(String[] args) {
		//src\main\archivos\pronosticos.csv
		
		if(args.length==0) {
			System.out.println("ERROR: No ingrestaste ningun archivo como argumento!");
			System.exit(88);
		}
		else  if (args.length==1){
			System.out.println("ERROR: solo ingrestaste un archivo como argumento!");
			System.exit(88);
		}
		
		else{
			LectorDeArchivos lectorArchivosResultado = new LectorDeArchivos(args[0]);
			lectorArchivosResultado.parsearArchivoResultados();
			
			LectorDeArchivos lectorArchivosPronostico = new LectorDeArchivos(args[1]);
			lectorArchivosPronostico.parsearArchivoPronosticos();
			
			
			CreadorDeObjetoCSV creadorObjetos = new CreadorDeObjetoCSV(lectorArchivosPronostico.parsearArchivoPronosticos(),lectorArchivosResultado.parsearArchivoResultados());
			
			ArrayList<Ronda> rondas = creadorObjetos.ListarRonda();
			
			ArrayList<Apostador> apostadores = null;

			try {
				apostadores = creadorObjetos.listarApostadores(rondas);
			} catch (DatoIngresadoNoEsperado e) {
					e.printStackTrace();
			}

			

			for (Apostador a : apostadores) {
					
				System.out.println("puntos de " +  a.getNombre() + "= "  + a.obtenerPuntos());

			}
						

				
				
					
					
			
	
		

		}
	
	}
	
}	
	
