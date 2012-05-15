/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Span
 */
public class Rua implements Serializable {

	Esquina origem;
	Esquina destino;
	int velocidade;
	double distancia;

	public Rua(Esquina origem, Esquina destino) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = Math.sqrt(Math.pow((destino.getX() - origem.getX()), 2) + Math.pow((destino.getY() - origem.getY()), 2));
	}

	public double getDistancia() {
		return distancia = Math.sqrt(Math.pow((destino.getX() - origem.getX()), 2) + Math.pow((destino.getY() - origem.getY()), 2));
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public Esquina getDestino() {
		return destino;
	}

	public void setDestino(Esquina destino) {
		this.destino = destino;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public Esquina getOrigem() {
		return origem;
	}

	public void setOrigem(Esquina origem) {
		this.origem = origem;
	}
}
