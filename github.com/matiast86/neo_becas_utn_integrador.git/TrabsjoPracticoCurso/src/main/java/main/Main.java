package main;

import trabajoPracticoCurso.Grupo7.LectorDeArchivos;

public class Main {
	
	public static void main(String[] args) {
		
		//en args va la ruta de acceso
		if(args.length == 0) {
			System.out.println("ERROR: No ingresaste archivo!");
			System.exit(88);
		}
		
		LectorDeArchivos lectorPronostico = new LectorDeArchivos(args[0]);
		lectorPronostico.parsearArchivoPronosticos();
	}

}
