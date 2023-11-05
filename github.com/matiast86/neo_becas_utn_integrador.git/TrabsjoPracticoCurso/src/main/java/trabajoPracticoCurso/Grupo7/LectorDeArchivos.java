package trabajoPracticoCurso.Grupo7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class LectorDeArchivos {

    String rutaArchivo;
    List<ArchivosPronosticos> pronosticosList;
    List<ArchivoResultados> resultadosList;

    public LectorDeArchivos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        pronosticosList = new ArrayList<>();
        resultadosList = new ArrayList<>();
    }

    public void parsearArchivoPronosticos() {
        try {
            pronosticosList = new CsvToBeanBuilder<ArchivosPronosticos>(new FileReader(this.rutaArchivo))
                    .withSkipLines(1)
                    .withSeparator(';')
                    .withType(ArchivosPronosticos.class)
                    .build()
                    .parse();
        } catch (IllegalStateException | FileNotFoundException e) {
            e.printStackTrace();
  
        }
        
        
    }

    public void parsearArchivoResultados() {
        try {
            resultadosList = new CsvToBeanBuilder<ArchivoResultados>(new FileReader(this.rutaArchivo))
                    .withSkipLines(1)
                    .withSeparator(';')
                    .withType(ArchivoResultados.class)
                    .build()
                    .parse();
        } catch (IllegalStateException | FileNotFoundException e) {
            e.printStackTrace();
         
        }
    }
	public ArrayList<Pronostico> listarPronosticos(ArrayList<Partido> PartidosRealizados){
		ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();
		
		for (ArchivosPronosticos lineaArchivoPronostico : this.pronosticosList) {
			 String chequeoEquipo1= lineaArchivoPronostico.getEquipo1();
			 String chequeoEquipo2= lineaArchivoPronostico.getEquipo2();
			Pronostico nuevoPronostico =null;
			for(Partido p : PartidosRealizados){
				 //chequeo
				 System.out.println(chequeoEquipo1);
				 System.out.println(chequeoEquipo2);
				 //
				 
				 
				if(p.getEquipo1().getNombre().equals(chequeoEquipo1) && p.getEquipo2().getNombre().equals(chequeoEquipo2)){
					if(lineaArchivoPronostico.getGana1()=='X') {
						nuevoPronostico = new Pronostico (p,p.getEquipo1(),resultadoEnum.Ganador);  
					}
					else if (lineaArchivoPronostico.getGana2()=='X') {
						nuevoPronostico = new Pronostico (p,p.getEquipo2(),resultadoEnum.Ganador);  
					}
					else {
						nuevoPronostico = new Pronostico (p,p.getEquipo1(),resultadoEnum.Empato);
					}
					
				}
				 
				 
			 }
			
			if(!pronosticos.contains(nuevoPronostico)) {
				pronosticos.add(nuevoPronostico);
				System.out.println("pronostico creado");
			}
			
		
		}
		
		
		return pronosticos;
		
	}


   
	
	public ArrayList<Partido> listaPartidos(){
		ArrayList<Partido> partidos = new ArrayList<Partido>();
		
		for(ArchivoResultados lineaArchivoResultado : this.resultadosList) {
			Equipo nuevoEquipo1= new Equipo(lineaArchivoResultado.getEquipo1());
			Equipo nuevoEquipo2= new Equipo(lineaArchivoResultado.getEquipo2());
			
			
			
			
			Partido nuevoPartido= new Partido (nuevoEquipo1,nuevoEquipo2, lineaArchivoResultado.getGoles1(),lineaArchivoResultado.getGoles2());
			
			
			if(!partidos.contains(nuevoPartido)) {
				partidos.add(nuevoPartido);
			}
		}
		
		
		
		return partidos;
	}
		
	
}		
	


