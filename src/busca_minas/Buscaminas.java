package busca_minas;

import java.util.Scanner;

public class Buscaminas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entry  = new Scanner(System.in);
		Juego j = new Juego(5,5,1);
		int terminar;
		do{
			System.out.println(j.tablero.toString());
			terminar = entry.nextInt();
			int fila = entry.nextInt();
			int columna = entry.nextInt();
			
			j.descubrirCasilla(fila, columna);
			
		}while(terminar == 0);
		
		System.out.println(j.tablero.toString());
	}

}
