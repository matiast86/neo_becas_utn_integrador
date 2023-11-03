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
	public ArrayList<Pronostico> listarPronosticos(){
		return null;
		
	}
    
	
	public ArrayList<Partido> listaPartidos(){
		return null;
	}
		
	
}		
	


