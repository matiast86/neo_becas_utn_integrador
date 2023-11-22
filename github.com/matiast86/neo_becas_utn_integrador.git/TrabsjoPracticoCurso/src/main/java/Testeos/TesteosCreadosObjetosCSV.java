package Testeos;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Test;

import ClaseErrores.DatoIngresadoNoEsperado;
import ClaseErrores.DatoIngresadoVacioException;
import Datos.CreadorDeObjetoCSV;
import Datos.LectorDeArchivos;
import Logica.Apostador;
import Logica.Ronda;

public class TesteosCreadosObjetosCSV {

	
	public ArrayList<Apostador> ObtenerApostadores() {
		LectorDeArchivos lectorArchivosResultado = new LectorDeArchivos("C:\\Users\\Pais Gamer\\git\\neo_becas_utn_integrador\\neo_becas_utn_integrador\\github.com\\matiast86\\neo_becas_utn_integrador.git\\TrabsjoPracticoCurso\\src\\main\\archivoTesteo\\resultadoTesteo.csv");
		lectorArchivosResultado.parsearArchivoResultados();
		
;
		LectorDeArchivos lectorArchivosPronostico = new LectorDeArchivos("C:\\Users\\Pais Gamer\\git\\neo_becas_utn_integrador\\neo_becas_utn_integrador\\github.com\\matiast86\\neo_becas_utn_integrador.git\\TrabsjoPracticoCurso\\src\\main\\archivoTesteo\\pronosticoTesteo.csv");
		lectorArchivosPronostico.parsearArchivoPronosticos();
		
		CreadorDeObjetoCSV creadorObjetos = new CreadorDeObjetoCSV(lectorArchivosPronostico.parsearArchivoPronosticos(),lectorArchivosResultado.parsearArchivoResultados());
		
		ArrayList<Ronda> rondas = null;
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
		
		ArrayList<Apostador> apostadores = null;

		try {
			apostadores = creadorObjetos.listarApostadores(rondas);
		} catch (DatoIngresadoNoEsperado e)  {
			System.out.println("valor no esperado");
		}
		  catch (DatoIngresadoVacioException e) {
				System.out.println("algun valor esta vacio");
		}
		
		return apostadores;
		
		
	}
	
	
	public ArrayList<Apostador> ObtenerApostadoresConError(){
		LectorDeArchivos lectorArchivosResultado = new LectorDeArchivos("C:\\Users\\Pais Gamer\\git\\neo_becas_utn_integrador\\neo_becas_utn_integrador\\github.com\\matiast86\\neo_becas_utn_integrador.git\\TrabsjoPracticoCurso\\src\\main\\archivoTesteo\\resultadoTesteoConError.csv");
		lectorArchivosResultado.parsearArchivoResultados();
		
;
		LectorDeArchivos lectorArchivosPronostico = new LectorDeArchivos("C:\\Users\\Pais Gamer\\git\\neo_becas_utn_integrador\\neo_becas_utn_integrador\\github.com\\matiast86\\neo_becas_utn_integrador.git\\TrabsjoPracticoCurso\\src\\main\\archivoTesteo\\pronosticoTesteo.csv");
		lectorArchivosPronostico.parsearArchivoPronosticos();
		
		CreadorDeObjetoCSV creadorObjetos = new CreadorDeObjetoCSV(lectorArchivosPronostico.parsearArchivoPronosticos(),lectorArchivosResultado.parsearArchivoResultados());
		
		ArrayList<Ronda> rondas = null;
		try {
			try {
				rondas = creadorObjetos.ListarRonda();
			} catch (DatoIngresadoNoEsperado e) {
				System.out.println("Los datos ingresados en la parte de gol no puede ser negativos");
			}
		} catch (DatoIngresadoVacioException e) {
			System.out.println("Los datos no pueden estar vacios");

		}
		
		ArrayList<Apostador> apostadores = null;

		try {
			apostadores = creadorObjetos.listarApostadores(rondas);
		} catch (DatoIngresadoNoEsperado e)  {
			System.out.println("valor no esperado");
			e.printStackTrace();
		}
		  catch (DatoIngresadoVacioException e) {
				System.out.println("algun valor esta vacio");
				System.exit(1);
		}

		return apostadores;
		
		
	}
		
	
	
	@Test
	public void chequeoControlDePuntosPositivo() {
		ArrayList<Apostador> apostadores = ObtenerApostadores();
		
	
		Apostador apostador1 = apostadores.get(0);
		Apostador apostador2 = apostadores.get(1);
		
		
	/*	assertTrue(apostador1.obtenerPuntos()==apostador2.obtenerPuntos());*/
		
	}

	 @Test(expected = NullPointerException.class)
	public void chequeoDeExceptiones() {
		ArrayList<Apostador> apostadores = ObtenerApostadoresConError();
				
	}
	
	
	
	
	
	
	
	
}
