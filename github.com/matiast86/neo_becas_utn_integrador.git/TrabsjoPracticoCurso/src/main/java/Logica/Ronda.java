	package Logica;
	
	import java.util.ArrayList;
	
	public class Ronda {
	
		private int nro;
		private ArrayList<Partido> partidos;
		
		
		
		public Ronda (int numero) {
			this.nro=numero;
			this.partidos= new ArrayList<Partido>();
		}
		
		public void agregarPartido (Partido partido) {
			this.partidos.add(partido);
		}
	
		
		public int getNro() {
			return this.nro;
		}
			
		public ArrayList<Partido> getPartidos (){
			return this.partidos;
		}
		
	
		public static Ronda obtenerRondaConNumero(int numeroRonda, ArrayList<Ronda> rondas) {
			for (Ronda r : rondas) {
				if (r.getNro() == numeroRonda) {
					return r;
				}
			}
			return null;
	
		}
		
		
		public static boolean estaEnLista(int numeroRonda, ArrayList<Ronda> rondas) {
			for (Ronda r : rondas) {
				if (r.getNro() == numeroRonda) {
					return true;
				}
			}
			return false;
		}
		
		public int obtenerCantidadPartido() {
			return this.partidos.size();
		}
		
		
		
	}
