package Testeos;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Test;

import ClaseErrores.DatoIngresadoNoEsperado;
import ClaseErrores.DatoIngresadoVacioException;
import Datos.CreadorDeObjetoCSV;
import Datos.LectorDeArchivos;
import Logica.Apostador;
import Logica.CalculadorDePuntos;
import Logica.Ronda;

public class TesteosCreadosObjetosCSV {

	
	public ArrayList<Apostador> ObtenerApostadores() {
		LectorDeArchivos lectorArchivosResultado = new LectorDeArchivos("./src\\main\\archivoTesteo\\resultadoTesteo.csv");
		lectorArchivosResultado.parsearArchivoResultados();
		
;
		LectorDeArchivos lectorArchivosPronostico = new LectorDeArchivos("./src\\main\\archivoTesteo\\pronosticoTesteo.csv");
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
		
		try {
			CalculadorDePuntos calculadora = new CalculadorDePuntos(1,0);
			calculadora.calcularPuntosDeApostadores(apostadores, rondas);
		} catch (DatoIngresadoNoEsperado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return apostadores;
		
		
	}
	
	
	public ArrayList<Apostador> ObtenerApostadoresConError(){
		LectorDeArchivos lectorArchivosResultado = new LectorDeArchivos("./src\\main\\archivoTesteo\\resultadoTesteoConError.csv");
		lectorArchivosResultado.parsearArchivoResultados();
		
;
		LectorDeArchivos lectorArchivosPronostico = new LectorDeArchivos("./src\\main\\archivoTesteo\\pronosticoTesteo.csv");
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
		
	private ArrayList<Apostador> obtenerApostadoresConValorNegativo() {
		LectorDeArchivos lectorArchivosResultado = new LectorDeArchivos("./src\\main\\archivoTesteo\\resultadoTesteo.csv");
		lectorArchivosResultado.parsearArchivoResultados();
		
;
		LectorDeArchivos lectorArchivosPronostico = new LectorDeArchivos("./src\\main\\archivoTesteo\\pronosticoTesteoNegativo.csv");
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
		
		try {
			CalculadorDePuntos calculadora = new CalculadorDePuntos(1,5);
			calculadora.calcularPuntosDeApostadores(apostadores, rondas);
		} catch (DatoIngresadoNoEsperado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return apostadores;
	}
	
	
	
	
	
	
	@Test
	public void chequeoControlDePuntosPositivo() {
		ArrayList<Apostador> apostadores = ObtenerApostadores();
		
	
		Apostador apostador1 = apostadores.get(0);
		Apostador apostador2 = apostadores.get(1);
		
		assertTrue(apostador1.getPuntos()==apostador2.getPuntos());
		
	}

	 @Test(expected = NullPointerException.class)
	public void chequeoDeExceptiones() {
		ArrayList<Apostador> apostadores = ObtenerApostadoresConError();
				
	}
	
	
	@Test
	public void chequeoControlDePuntosNegativo() {
		ArrayList<Apostador> apostadores = obtenerApostadoresConValorNegativo();
		


		for (Apostador a : apostadores) {
			assertTrue(a.getPuntos()<0);
		}
		
		
		
		
	}



	
	
	
	
	
}
