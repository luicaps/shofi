package Modelo;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Fernando Spanhol
 */
public class Esquina implements Serializable {

	private int x;		//posicao x do ponto
	private int y;		//posicao y do ponto
	String nome;
	boolean visitado;
	boolean semaforo;
	LinkedList<Rua> ruas;

	public Esquina() {
		this.x = 0;
		this.y = 0;
		this.semaforo = false;
		ruas = new LinkedList<>();
	}

	public Esquina(int x, int y) {
		this.x = x;
		this.y = y;
		this.semaforo = false;
		ruas = new LinkedList<>();
	}

	public void addRua(Esquina destino) {
		if (!RuasContem(destino)) {
			Rua temp = new Rua(this, destino);
			ruas.add(temp);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean haveSemaforo() {
		return semaforo;
	}

	public void setSemaforo(boolean semaforo) {
		this.semaforo = semaforo;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean equals(Esquina p) {
		if (this.getX() == p.getX()) {
			if (this.getY() == p.getY()) {
				return true;
			}
		}
		return false;
	}

	public LinkedList<Rua> getRuas() {
		return ruas;
	}

	public void setRuas(LinkedList<Rua> ruas) {
		this.ruas = ruas;
	}

	@Override
	public String toString() {
		return (x + " | " + y);
	}

	//temporario
	public boolean changeSemaforo() {
		if (semaforo == true) {
			return (semaforo = false);
		} else {
			return (semaforo = true);
		}
	}

	private boolean RuasContem(Esquina destino) {
		for (Rua rua : ruas) {
			if (rua.getDestino() == destino) {
				return true;
			}
		}
		return false;
	}
}
