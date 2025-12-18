package busca_minas;

public class Casilla {
	private boolean mina;
	private boolean blanco;
	private boolean bandera;
	private boolean visible;
	private int numeroMinas;

	/**
	 * @return the mina
	 */
	public boolean isMina() {
		return mina;
	}

	/**
	 * @param mina the mina to set
	 */
	public void setMina(boolean mina) {
		this.mina = mina;
	}

	/**
	 * @return the blanco
	 */
	public boolean isBlanco() {
		return blanco;
	}

	/**
	 * @param blanco the blanco to set
	 */
	public void setBlanco(boolean blanco) {
		this.blanco = blanco;
	}

	/**
	 * @return the bandera
	 */
	public boolean isBandera() {
		return bandera;
	}

	/**
	 * @param bandera the bandera to set
	 */
	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the numeroMinas
	 */
	public int getNumeroMinas() {
		return numeroMinas;
	}

	/**
	 * @param numeroMinas the numeroMinas to set
	 */
	public void setNumeroMinas(int numeroMinas) {
		this.numeroMinas = numeroMinas;
	}

	@Override
	public String toString() {
		if (bandera) {
			return "B";
		}
		if (!visible) {
			return ".";
		}
		if (mina) {
			return "M";
		}
		if (blanco) {
			return " ";
		}
		return "" + numeroMinas;
	}
public static void main(String[] args) {
	Casilla casilla1 = new Casilla();
	casilla1.setBandera(true);
	System.out.println(casilla1);
}
}
