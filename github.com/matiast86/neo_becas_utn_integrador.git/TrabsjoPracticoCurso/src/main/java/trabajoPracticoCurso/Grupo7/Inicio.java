package trabajoPracticoCurso.Grupo7;

import java.util.ArrayList;


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
			
			
			CreadorDeObjeto creadorObjetos = new CreadorDeObjeto(lectorArchivosPronostico.parsearArchivoPronosticos(),lectorArchivosResultado.parsearArchivoResultados());
			
			ArrayList<Ronda> rondas = creadorObjetos.ListarRonda();
			
			
			for (Ronda r : rondas) {
				
				System.out.println("numero de ronda"  +  " " + r.getNro());
				
				System.out.println("Partidos la Ronda");
				
				for(Partido p : r.getPartidos()) {
					
					System.out.println("-----------------------");
					System.out.println(p.getEquipo1().getNombre() + " " +p.getGolesEquipo1());
					System.out.println(p.getEquipo2().getNombre() + " " +p.getGolesEquipo2());
					System.out.println("-----------------------");
					
					
				}
				
				
				
				
				
			}
			
			
	 

			
			//System.out.println(pronosticos.size());
			
			

  
		
		}
	
	}
	
	
	
}