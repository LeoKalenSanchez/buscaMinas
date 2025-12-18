package busca_minas;

import entrada.Teclado;

public class Buscaminas {
	/**
	 * Clase principal del juego buscaminas
	 */
	public static void main(String[] args) {
		Juego juego = confInicialJuego();
		System.out.println(juego);
		int numMenu;
		boolean derrota = false;
		do {
			numMenu = menuOpciones();
			switch (numMenu) {
			// Salir del menu
			case 0:
				break;
			// Descubrir casilla
			case 1:
				derrota = descubrirCasilla(juego);
				break;
			// Poner bandera
			case 2:
				ponerBandera(juego);
				break;
			// quitar bandera
			case 3:
				quitarBandera(juego);
				break;
			// opcion equivocada
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 3.");
				break;
			}
		} while (numMenu != 0 && !derrota);
		resolucionJuego(derrota);

	}

	/**
	 * Opcion del menu que llama al metodo descubrirCasilla de la clase Juego para
	 * descubrir las casillas en la posicion pasada por consola e imprime el tablero
	 * con las casillas descubiertas
	 * 
	 * @param juego
	 */
	private static boolean descubrirCasilla(Juego juego) {
		int fila;
		int columna;
		do {
			fila = Teclado.leerNatural("Fila de la Casilla a descubrir ");
			if (fila > juego.getNumFilas()) {
				System.out.println("Error, la fila sobrepasa el maximo");
			}
		} while (fila > juego.getNumFilas());
		do {
			columna = Teclado.leerNatural("Columna de la Casilla a descubrir ");
			if (fila > juego.getNumFilas()) {
				System.out.println("Error, la columna sobrepasa el maximo");
			}
		} while (columna > juego.getNumColumnas());
		boolean tieneMina = juego.descubrirCasilla(fila, columna);
		System.out.println(juego);
		return tieneMina;
	}

	/**
	 * Opcion del menu que llama al metodo ponerBandera de la clase Juego para
	 * marcar una casilla como mina en el tablero e imprime el tablero con la
	 * bandera puesta
	 * 
	 * @param juego
	 */
	private static void ponerBandera(Juego juego) {
		int fila;
		int columna;
		do {
			fila = Teclado.leerNatural("Fila de la Casilla a descubrir ");
			if (fila > juego.getNumFilas()) {
				System.out.println("Error, la fila sobrepasa el maximo");
			}
		} while (fila > juego.getNumFilas());
		do {
			columna = Teclado.leerNatural("Columna de la Casilla a descubrir ");
			if (fila > juego.getNumFilas()) {
				System.out.println("Error, la columna sobrepasa el maximo");
			}
		} while (columna > juego.getNumColumnas());
		// juego.ponerBandera(fila, columna);
		System.out.println(juego);
	}

	/**
	 * Opcion del menu que llama al metodo quitarBandera de la clase Juego para
	 * desmarcar una casilla como mina en el tablero e imprime el tablero con la
	 * bandera quitada
	 * 
	 * @param juego
	 */
	public static void quitarBandera(Juego juego) {
		int fila;
		int columna;
		do {
			fila = Teclado.leerNatural("Fila de la Casilla a descubrir ");
			if (fila > juego.getNumFilas()) {
				System.out.println("Error, la fila sobrepasa el maximo");
			}
		} while (fila > juego.getNumFilas());
		do {
			columna = Teclado.leerNatural("Columna de la Casilla a descubrir ");
			if (fila > juego.getNumFilas()) {
				System.out.println("Error, la columna sobrepasa el maximo");
			}
		} while (columna > juego.getNumColumnas());
		// juego.quitarBandera(fila, columna);
		System.out.println(juego);
	}

	/**
	 * Metodo que recibe un booleano y declara victoria o derrota
	 * 
	 * @param derrota
	 */
	public static void resolucionJuego(boolean derrota) {
		if (derrota) {
			System.out.println("Has perdido");
		} else {
			System.out.println("Has ganado");
		}
	}

	/**
	 * Metodo que recibe los valores para crear el juego
	 * 
	 * @return juego creado
	 */
	public static Juego confInicialJuego() {
		int fila = Teclado.leerNatural("¿Cuantas filas quieres? ");
		int columna = Teclado.leerNatural("¿Cuantas columnas quieres? ");
		int minas = Teclado.leerNatural("Numero de minas ");
		return new Juego(fila, columna, minas);
	}

	/**
	 * Metodo que saca por pantalla las opciones del menu
	 * 
	 * @return opcion elegida
	 */
	public static int menuOpciones() {
		System.out.println("Eliga el tipo de operacion");
		System.out.println("1 --> Descubrir");
		System.out.println("2 --> Poner Bandera");
		System.out.println("3 --> Quitar Bandera");
		return Teclado.leerEntero("");
	}
}
