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
			
			ArrayList<Partido> partidos = lectorArchivosResultado.listaPartidos();
			LectorDeArchivos lectorArchivosPronostico = new LectorDeArchivos(args[1]);
			lectorArchivosPronostico.parsearArchivoPronosticos();
			
			//elimino un partido que se crea sin valores en la ultima posicion del array
			partidos.remove(partidos.size()-1);
	 
			ArrayList<Pronostico> pronosticos = lectorArchivosPronostico.listarPronosticos(partidos);
			
			System.out.println(pronosticos.size());
			

		
		}
	
	}
}