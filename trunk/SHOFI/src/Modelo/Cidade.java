 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Span
 */
public class Cidade implements Serializable {

	LinkedList<Esquina> esquinas;

	public Cidade() {
		this.esquinas = new LinkedList<>();
	}

	public Cidade(LinkedList<Esquina> esquinas) {
		this.esquinas = esquinas;
	}

	//encontra, na lista de esquinas, uma esquina com as mesmas coordenadas x,y, ou retorna null
	public Esquina getEsquinaProxima(int x, int y) {
		for (Esquina esquina : esquinas) {
			if (esquina.getX() - x <= 6) {
				if (esquina.getX() - x >= -6) {
					if (esquina.getY() - y <= 6) {
						if (esquina.getY() - y >= -6) {
							return esquina;
						}
					}
				}
			}
		}
		return null;
	}

	public Esquina getEsquina(int x, int y) {
		for (Esquina esquina : esquinas) {
			if (esquina.getX() == x) {
				if (esquina.getY() == y) {
					return esquina;
				}
			}
		}
		return null;
	}

	public void remove(Esquina e) {
		//remove ruas que leva a esquina que esta sendo removida
		for (Esquina esquina : esquinas) {
			for (Rua rua : esquina.getRuas()) {
				if (rua.getDestino() == e) {
					esquina.getRuas().remove(rua);
					break;
				}
			}
		}
		//remove esquina
		esquinas.remove(e);
	}

	//adiciona esquina na lista de esquinas
	public void add(Esquina e) {
		esquinas.add(e);
	}

	//adiciona
	public void add(Esquina origem, Esquina destino, boolean maoDupla) {
		if (origem == destino) {
			return;
		}
		if (maoDupla == false) {
			if (!esquinas.contains(origem)) {
				esquinas.add(origem);
			}
			if (!esquinas.contains(destino)) {
				esquinas.add(destino);
			}
			origem.addRua(destino);
		}
		if (maoDupla == true) {
			if (!esquinas.contains(origem)) {
				esquinas.add(origem);
			}
			if (!esquinas.contains(destino)) {
				esquinas.add(destino);
			}
			origem.addRua(destino);
			destino.addRua(origem);
		}

	}

	public LinkedList<Esquina> getListaEsquinas() {
		return esquinas;
	}

	public void setListaEsquinas(LinkedList<Esquina> esquinas) {
		this.esquinas = esquinas;
	}

	public LinkedList<Esquina> getEsquinas() {
		return esquinas;
	}

	public void setEsquinas(LinkedList<Esquina> esquinas) {
		this.esquinas = esquinas;
	}

	public void setEsquinasNotVisited() {
		for (Esquina esquina : esquinas) {
			esquina.setVisitado(false);
		}
	}
}
