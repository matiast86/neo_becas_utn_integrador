package Datos;

import java.util.ArrayList;

import Logica.Apostador;
import Logica.Pronostico;
import Logica.Ronda;

public class CalculadorDePuntos {

		private int puntosAlGanar;
		private int puntosAlPerder;
	
	
		
		
	public 	CalculadorDePuntos (int valorGanar, int valorPerder) {
		this.puntosAlGanar=valorGanar;
		this.puntosAlPerder=valorPerder;
	}
		
		
		
	public  void calcularPuntosDeApostadores(ArrayList<Apostador> apostadores, ArrayList<Ronda> rondas) {
		
		for (Apostador apostadorElegido : apostadores) {
			int puntosApostador=0;
			int rondasAcertadasCompletas=0;
			
			
			for(Ronda rondaSeleccionada : rondas) {
				int puntosObtenidosEnRonda=0;
				
				puntosObtenidosEnRonda= calcularPuntosDeApostadorEnRonda(apostadorElegido,rondaSeleccionada);
				
				if(calcularMaximoPuntajeDeRonda(rondaSeleccionada) == puntosObtenidosEnRonda ) {
					rondasAcertadasCompletas++;
				}
				puntosApostador = puntosApostador + puntosObtenidosEnRonda;
				
			}
			
			if (rondasAcertadasCompletas == rondas.size()) {
				puntosApostador = puntosApostador + (this.puntosAlGanar*10);
			}
			
			apostadorElegido.setPuntos(puntosApostador);
		}
		
		
		
	}



	private int calcularPuntosDeApostadorEnRonda(Apostador apostador, Ronda ronda) {
		int puntosApostador=0;
		int pronosticosAcertados=0;
		for(Pronostico pronosticoSeleccionado : apostador.obtenerPronosticosPorRonda(ronda.getNro())) {
			if(pronosticoSeleccionado.getPartido().resultado(pronosticoSeleccionado.getEquipo()).equals(pronosticoSeleccionado.getResultado())) {
				puntosApostador = puntosApostador + this.puntosAlGanar;
				pronosticosAcertados ++;
			} else {
				puntosApostador = puntosApostador + this.puntosAlPerder;
			}            
		}
		
		if(pronosticosAcertados == ronda.obtenerCantidadPartido()) {
			puntosApostador = puntosApostador + (this.puntosAlGanar*5);
		}
		
		
		return puntosApostador;
	}
	
	
	private int calcularMaximoPuntajeDeRonda(Ronda ronda) {
		return (ronda.obtenerCantidadPartido()*this.puntosAlGanar) + (this.puntosAlGanar*5);
	}

	
	
	
	
}
