package trabajoPracticoCurso.Grupo7;

import java.util.ArrayList;

public class Inicio {

	public static void main(String[] args) {
		//C:\Users\Pais Gamer\git\TrabajoCursoJava\github.com\matiast86\neo_becas_utn_integrador.git\TrabsjoPracticoCurso\src\main\archivos
		
		if(args.length==0) {
			System.out.println("ERROR: No ingrestaste ningun archivo como argumento!");
			System.exit(88);
		}
		
		LectorDeArchivos lectorArchivos = new LectorDeArchivos(args[0]);
		
		ArrayList<Partido> partidos = lectorArchivos.listaPartidos();
		
	}
	
}
