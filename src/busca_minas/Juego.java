package busca_minas;

public class Juego {
	private int numFilas;
	private int numColumnas;
	private int numMinas;
	/**
	 * @param fila
	 * @param columna
	 * @param minas
	 */
	public Juego(int fila, int columna, int minas) {
		super();
		this.numFilas = fila;
		this.numColumnas = columna;
		this.numMinas = minas;
	}
	/**
	 * @return the numFilas
	 */
	public int getNumFilas() {
		return numFilas;
	}
	/**
	 * @return the numColumnas
	 */
	public int getNumColumnas() {
		return numColumnas;
	}
	/**
	 * @return the numMinas
	 */
	public int getNumMinas() {
		return numMinas;
	}
	public boolean descubrirCasilla(int fila, int columna) {
		return true;
	}
	
}
