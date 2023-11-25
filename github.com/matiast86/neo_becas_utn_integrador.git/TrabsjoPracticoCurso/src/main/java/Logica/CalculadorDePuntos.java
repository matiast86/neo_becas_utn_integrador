package Logica;

import java.util.ArrayList;

import ClaseErrores.DatoIngresadoNoEsperado;

public class CalculadorDePuntos {

		private int puntosAlGanar;
		private int puntosAlPerder;
		private int multiplicadorPorRonda;
		private int multiplicadorPorFase;
	
	
		
		
	public 	CalculadorDePuntos (int valorGanar, int valorPerder) throws DatoIngresadoNoEsperado {
		if(valorGanar<0 || valorPerder <0) {
			throw new DatoIngresadoNoEsperado();
		}
	
		
		
		
		this.puntosAlGanar=valorGanar;
		this.puntosAlPerder=valorPerder;
		this.multiplicadorPorRonda=2;
		this.multiplicadorPorFase=5;
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
				puntosApostador = puntosApostador + (this.puntosAlGanar*multiplicadorPorFase);
				
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
				puntosApostador = puntosApostador - this.puntosAlPerder;
			}            
		}
		
		if(pronosticosAcertados == ronda.obtenerCantidadPartido()) {
			puntosApostador = puntosApostador + (this.puntosAlGanar*multiplicadorPorRonda);
		}
		
		
		return puntosApostador;
	}
	
	
	private int calcularMaximoPuntajeDeRonda(Ronda ronda) {
		return (ronda.obtenerCantidadPartido()*this.puntosAlGanar) + (this.puntosAlGanar*multiplicadorPorRonda);
	}

	
	
	
	
}
