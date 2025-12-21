package busca_minas;

public class Juego {

	Tablero tablero;

	public Juego(int fila, int columna, int minas) {

		tablero = new Tablero(fila, columna, minas);

	}

	/**
	 * 
	 * <pre>
	 * 	Muestra la casilla seleccionada
	 * 	
	 * 	Se pueden dar 3 casos diferentes
	 * 	<ol>
	 * 		<li>La casilla es una mina: se revelaran todas las minas y el jugador perdera</li>
	 *  	<li>La casilla esta cerca de mina: solo se revelara la casilla seleccionada</li>
	 * 		<li>La casilla no tiene mina adyacente: se revelara la casilla seleccionada y todas las adyacentes hata chocar con una que sea adyacente de mina</li>  
	 * 	</ol>
	 * </pre>
	 * 
	 * @param fila Posicion en fila de la casilla seleccionada
	 * @param columna Posicion en columna de la casilla seleccionada
	 * @return true si la casilla es mina(pierde el juego), false se la casilla no es mina(el juego continua)
	 */
	public boolean descubrirCasilla(int fila, int columna) {

		if (tablero.getTablero()[fila][columna].getNumeroMinas() != 0) {
			tablero.getTablero()[fila][columna].setVisible(true);
			return false;

		} else if (tablero.getTablero()[fila][columna].isMina()) {
			for (int i = 0; i < tablero.getTablero().length; i++) {
				for (int j = 0; j < tablero.getTablero().length; j++) {
					if (tablero.getTablero()[i][j].isMina() && !tablero.getTablero()[i][j].isVisible()) {
						tablero.getTablero()[i][j].setVisible(true);
					}
				}
				return true;
			}
		} else if (!hayCasilla(fila, columna)) {
			tablero.getTablero()[fila][columna].setVisible(true);
			return false;
		} else {
			tablero.getTablero()[fila][columna].setVisible(true);

			if (fila - 1 >= 0 && tablero.getTablero()[fila - 1][columna].getNumeroMinas() == 0
					&& !tablero.getTablero()[fila - 1][columna].isVisible()) {
				
				revelarNumeroAdyacente(fila - 1,columna);
				return descubrirCasilla(fila - 1, columna);

			} else if (columna + 1 < tablero.getTablero().length
					&& tablero.getTablero()[fila][columna + 1].getNumeroMinas() == 0
					&& !tablero.getTablero()[fila][columna + 1].isVisible()) {
				
				revelarNumeroAdyacente(fila,columna+1);
				return descubrirCasilla(fila, columna + 1);

			} else if (fila + 1 < tablero.getTablero().length
					&& tablero.getTablero()[fila + 1][columna].getNumeroMinas() == 0
					&& !tablero.getTablero()[fila + 1][columna].isVisible()) {
				
				revelarNumeroAdyacente(fila + 1, columna);
				return descubrirCasilla(fila + 1, columna);

			} else if (columna - 1 >= 0 && tablero.getTablero()[fila][columna - 1].getNumeroMinas() == 0
					&& !tablero.getTablero()[fila][columna - 1].isVisible()) {
				
				revelarNumeroAdyacente(fila, columna - 1);
				return descubrirCasilla(fila, columna - 1);

			} else {
				return false;
			}

		}
		return false;
	}

	/**
	 * 
	 * Metodo que confirma si hay alguna casilla a la que moverse alrededor de una
	 * casilla de refenrecia
	 * 
	 * @param fila
	 * @param columna
	 * @return true si hay una casilla a la que moverse, false si no la hay
	 */
	private boolean hayCasilla(int fila, int columna) {
		Casilla[][] tableroUsado = tablero.getTablero();

		if (fila - 1 >= 0 && fila + 1 < tablero.getTablero().length && columna - 1 >= 0
				&& columna + 1 < tablero.getTablero().length) {
			if (tableroUsado[fila - 1][columna].isVisible() && tableroUsado[fila + 1][columna].isVisible()
					&& tableroUsado[fila][columna - 1].isVisible() && tableroUsado[fila][columna + 1].isVisible()) {
				return false;

			} else {
				return true;
			}
		} else {
			return true;
		}

	}
	
	/**
	 * 
	 * Revela las casillas adyacentes que son numeros, es revela las casillas con minas adyacentes
	 * 
	 * @param fila
	 * @param columna
	 */
	private void revelarNumeroAdyacente(int fila, int columna) {
		
		for(int i = fila - 1; i <= fila + 1; i++) {
			for(int j = columna - 1; j <= columna + 1; j++) {
				if(posicionValida(i,j) && tablero.getTablero()[i][j].getNumeroMinas() > 0) {
					tablero.getTablero()[i][j].setVisible(true);
				}
			}
		}
		
	}
	
	/**
	 * 
	 * Comprueba si la posicion pasada se encuentra dentro del rango del tablero
	 * 
	 * @param fila
	 * @param columna
	 * @return true esta en rango, false esta fuera de rango
	 */
	private boolean posicionValida(int fila, int columna) {
		
		return fila >= 0 && fila < tablero.getTablero().length && columna >= 0 && columna < tablero.getTablero().length;
		
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

	/**
	 * 
	 * Recorre el tablero comprobando que solo quedan minas por descubrir
	 * 
	 * @return true si se hanrevelado todas las casillas normales, false si aun
	 *         quedan casilla por revelar o se revelan minas
	 */
	public boolean condicionVictoria() {

		int numCasillasReveladas = 0;

		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero().length; j++) {
				if (tablero.getTablero()[i][j].isVisible() && !tablero.getTablero()[i][j].isMina()) {
					numCasillasReveladas++;
				}
			}
		}

		if (numCasillasReveladas == tablero.getFilas() * tablero.getColumnas() - tablero.getFilas()) {
			return true;
		} else {
			return false;
		}

	}

}
