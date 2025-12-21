package busca_minas;

import java.util.Arrays;
import java.util.Random;

/**
 * Genera un Array de Casillas
 */
public class Tablero {

	private Casilla[][] tablero;
	private int numMinas;
	private int numFilas;
	private int numColumnas;

	/**
	 * 
	 * Constructor de la clase Tablero
	 * 
	 * Crea un array bidimensional usando los parametros de filas y columnas
	 * 
	 * @param filas
	 * @param columnas
	 */
	public Tablero(int filas, int columnas, int minas) {

		numFilas = filas;
		numColumnas = columnas;
		numMinas = minas;

		tablero = new Casilla[numFilas][numColumnas];

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = new Casilla();

			}
		}

		colocarMinas();
		minasAdyacentes();

	}
	
	public Casilla[][] getTablero() {
		return tablero;
	}
	
	public int getMinas() {
		return numMinas;
	}
	
	public int getFilas() {
		return numFilas;
	}
	
	public int getColumnas() {
		return numColumnas;
	}

	/**
	 * Coloca Minas en posiciones aleatoria dentro del tablero
	 * 
	 * Genera posiciones aleatorias de filas y de columnas, si en estas posiciones
	 * la casilla no es mina, entonces la transformara en mina, al llegar a la
	 * canridad de minas se detiene.
	 * 
	 * @param numMinas Numero maximo de minas que habra en el tablero
	 * @see Casilla#isMina()
	 */
	private void colocarMinas() {

		int index = 0;
		Random r = new Random();

		while (index < numMinas) {

			int fila = r.nextInt(tablero.length);
			int columna = r.nextInt(tablero[fila].length);

			if (!tablero[fila][columna].isMina()) {

				tablero[fila][columna].setMina(true);
				index++;

			}

		}

	}

	/**
	 * Establece el numero de minas adyacentes a cada casilla
	 * 
	 * @see Casilla#isMina()
	 * @see Casilla#setMina(boolean)
	 * @see Casilla#setNumeroMinas(int)
	 */
	public void minasAdyacentes() {
		final int POS_INICIAL = 0;
		int numMinas = 0;

		for (int i = POS_INICIAL; i < tablero.length; i++) {
			for (int j = POS_INICIAL; j < tablero.length; j++) {
				for (int k = i - 1; k <= i + 1; k++) {
					for (int l = j - 1; l <= j + 1; l++) {
						if (k >= POS_INICIAL && k < tablero.length && l >= POS_INICIAL && l < tablero.length) {
							if (tablero[k][l].isMina()) {
								numMinas++;
							}
						}
					}
				}
				tablero[i][j].setNumeroMinas(numMinas);
				numMinas = 0;
			}
		}
	}
	
	/**
	 * Muestra el tablero de juego
	 */
	public String toString() {
		//TODO Fila de numeros superior e inferior
		String cadena = "";
		for (int i = 0; i < tablero.length; i++) {
			cadena += i + "|";
			for (int j = 0; j < tablero.length; j++) {
				cadena += " " + tablero[i][j] + " ";
				if(j == tablero.length - 1) {
					cadena += "|" + i + "\n";
				}
			}
			
		}

		return cadena;

	}

}
