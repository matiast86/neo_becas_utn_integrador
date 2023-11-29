package Logica;

import java.util.ArrayList;

import ClaseErrores.DatoIngresadoNoEsperado;
import ClaseErrores.DatoIngresadoVacioException;
import Datos.CreadorDeObjetoCSV;
import Datos.CreadorDeObjetoDb;
import Datos.LectorDeArchivos;



public class Logica {

	public static ArrayList<Apostador> IniciarLogica(String[] args,boolean lecturaDatosCSV,int puntosGanar, int puntosPerder) {

		CalculadorDePuntos calculadora = null;
		ArrayList<Apostador> apostadores = null;
		ArrayList<Ronda> rondas = null;
		
		if(lecturaDatosCSV) {
			
			
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
					

					try {
						try {
							rondas = creadorObjetos.ListarRonda();
						} catch (DatoIngresadoNoEsperado e) {
							System.out.println("Los datos ingresados en la parte de gol no puede ser negativos");
							e.printStackTrace();
						}
					} catch (DatoIngresadoVacioException e) {
						System.out.println("Los datos no pueden estar vacios");
						e.printStackTrace();
					}
					
	
	
					try {
						apostadores = creadorObjetos.listarApostadores(rondas);
					} catch (DatoIngresadoNoEsperado e)  {
						System.out.println("valor no esperado");
					}
					  catch (DatoIngresadoVacioException e) {
							System.out.println("algun valor esta vacio");
					}
		
			}
		}
			
		else {
			
				CreadorDeObjetoDb RBDD = new CreadorDeObjetoDb();
				rondas = RBDD.procesarResultados();
				try {
					apostadores = RBDD.obtenerApostadores(rondas);
				} catch (DatoIngresadoNoEsperado e1) {
					System.out.println("En gana1, empata o gana 2 dentro de pronostico, no se puede ingresar un valor distinto de 'X' ");	
				}	
			
		}
		
		
		try {
			calculadora = new CalculadorDePuntos(puntosGanar,puntosPerder);
			calculadora.calcularPuntosDeApostadores(apostadores, rondas);
		} catch (DatoIngresadoNoEsperado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		
		for(Apostador a : apostadores) {
			
			System.out.println(a.getNombre() + " = "  + a.getPuntos());
			
		}
		
			
			return apostadores;
			
			
			
	

        
       


        
        

        

		
		
		
		
	
		

		
	
	}
	
}	
	
