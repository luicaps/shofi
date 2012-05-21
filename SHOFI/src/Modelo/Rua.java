package Modelo;

import java.io.Serializable;

/**
 *
 * @author Spanhol e da Silva
 */
public class Rua implements Serializable {

	private Esquina origem;
	private Esquina destino;
	private double distancia;
	private boolean calculado;

	public Rua(Esquina origem, Esquina destino) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = Math.sqrt(Math.pow((destino.getX() - origem.getX()), 2) + Math.pow((destino.getY() - origem.getY()), 2));
		calculado = true;
	}

	public double getDistancia() {
		if (!calculado) {
			calculado = true;
			return distancia = Math.sqrt(Math.pow((destino.getX() - origem.getX()), 2) + Math.pow((destino.getY() - origem.getY()), 2));
		} else {
			return distancia;
		}
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public Esquina getDestino() {
		return destino;
	}

	public void setDestino(Esquina destino) {
		this.destino = destino;
		calculado = false;
	}

	public Esquina getOrigem() {
		return origem;
	}

	public void setOrigem(Esquina origem) {
		this.origem = origem;
		calculado = false;
	}
}
