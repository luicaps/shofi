/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Esquina;

/**
 *
 * @author Fernando Spanhol
 */
public class Tabela {

	Esquina esquina;
	Esquina caminho;
	double distanciaOrigem;
	double distanciaDestino;
	boolean permanente;

	public Tabela() {
		this.esquina = null;
		this.caminho = null;
		this.distanciaOrigem = Double.MAX_VALUE;
		this.distanciaDestino = Double.MAX_VALUE;
		this.permanente = false;
	}

	public Tabela(Esquina esquina) {
		this.esquina = esquina;
		this.caminho = null;
		this.distanciaOrigem = Double.MAX_VALUE;
		this.distanciaDestino = Double.MAX_VALUE;
		this.permanente = false;
	}

	public Esquina getCaminho() {
		return caminho;
	}

	public void setCaminho(Esquina caminho) {
		this.caminho = caminho;
	}

	public Esquina getEsquina() {
		return esquina;
	}

	public void setEsquina(Esquina esquina) {
		this.esquina = esquina;
	}

	public double getDistanciaOrigem() {
		return distanciaOrigem;
	}

	public void setDistanciaOrigem(double distancia) {
		this.distanciaOrigem = distancia;
	}

	public double getDistanciaDestino() {
		return distanciaDestino;
	}

	public void setDistanciaDestino(double distanciaDestino) {
		this.distanciaDestino = distanciaDestino;
	}

	public void setPermanente(boolean permanente) {
		this.permanente = permanente;
	}

	public boolean isPermanente() {
		return permanente;
	}
}
