/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Esquina;
import java.util.LinkedList;

/**
 *
 * @author Span
 */
public class Resultado {
	LinkedList<Esquina> caminho;
	LinkedList<Esquina> visitados;

	public Resultado(LinkedList<Esquina> caminho, LinkedList<Esquina> visitados) {
		this.caminho = caminho;
		this.visitados = visitados;
	}
	
	public LinkedList<Esquina> getCaminho() {
		return caminho;
	}

	public void setCaminho(LinkedList<Esquina> caminho) {
		this.caminho = caminho;
	}

	public LinkedList<Esquina> getVisitados() {
		return visitados;
	}

	public void setVisitados(LinkedList<Esquina> visitados) {
		this.visitados = visitados;
	}
}
