package ClaseErrores;

public class DatoIngresadoNoEsperado extends Exception{

	private char valor;
	
	public DatoIngresadoNoEsperado(char v) {
		this.valor=v;
	}
}
