package busca_minas;

public class Juego {

	Tablero tablero;

	public Juego(int fila, int columna, int minas) {

		tablero = new Tablero(fila, columna, minas);

	}



	/**
	 * Coloca una bandera en la casilla seleccionada si en esta casilla
	 * anteriormente no hubiese una bandera y no estuviese visible
	 * 
	 * @param fila    Posicion de fila en la que se encuentra la casilla
	 * @param columna Posicion de columna en la que se encuentra la casilla
	 */
	public void ponerBandera(int fila, int columna) {
		if (!tablero.getTablero()[fila][columna].isBandera() && !tablero.getTablero()[fila][columna].isVisible()) {
			tablero.getTablero()[fila][columna].setBandera(true);
		}

	}

	/**
	 * 
	 * Quita la bandera de una casilla que anteriormente ya estuviese puesta
	 * 
	 * @param fila    Posicion de fila en la que se encuentra la casilla
	 * @param columna Posicion de columna en la que se encuentra la casilla
	 */
	public void quitarBandera(int fila, int columna) {
		if (tablero.getTablero()[fila][columna].isBandera()) {
			tablero.getTablero()[fila][columna].setBandera(false);
		}

	}

}
