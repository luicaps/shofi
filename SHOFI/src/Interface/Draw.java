package Interface;

import Modelo.Cidade;
import Modelo.Esquina;
import Modelo.Rua;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import javax.swing.JPanel;

public class Draw extends JPanel {

	Cidade cidade = new Cidade();
	Esquina selected;
	Esquina selected2;
	LinkedList<Esquina> caminho;
	LinkedList<Esquina> visitados;
	Image bgimage = null;
	boolean maoDupla = true;
	boolean movimentada = false;
	boolean editar = true;
	boolean somenteInteresse = true;
	String statusText = "";

	//funcao responsavel por pintar as esquinas e ruas
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (bgimage != null) {
			g.drawImage(bgimage, 0, 0, this);
		}
		if (cidade != null) {
			for (Esquina esquina : cidade.getListaEsquinas()) {
				if (editar || (!somenteInteresse && !editar)) {
					if (esquina.isInteresse()) {
						g.setColor(Color.black);
						g.fillRect(esquina.getX() - 5, esquina.getY() - 5, 10, 10);
						if (esquina.isSemaforo()) {//preenche de verde
							g.setColor(Color.yellow);
							g.fillRect(esquina.getX() - 3, esquina.getY() - 3, 6, 6);
							g.setColor(Color.black);
						} else {
							g.setColor(Color.green);
							g.fillRect(esquina.getX() - 3, esquina.getY() - 3, 6, 6);
							g.setColor(Color.black);
						}
					} else if (esquina.isSemaforo()) {
						g.fillOval(esquina.getX() - 5, esquina.getY() - 5, 10, 10);
						g.setColor(Color.yellow);
						g.fillOval(esquina.getX() - 4, esquina.getY() - 4, 8, 8);
						g.setColor(Color.black);
					} else {//esquina simples
						g.fillRect(esquina.getX() - 2, esquina.getY() - 2, 4, 4);
					}
				} else {
					if (esquina.isInteresse()) {
						g.setColor(Color.black);
						g.fillRect(esquina.getX() - 5, esquina.getY() - 5, 10, 10);
						if (esquina.isSemaforo()) {
							g.setColor(Color.yellow);
							g.fillRect(esquina.getX() - 3, esquina.getY() - 3, 6, 6);
							g.setColor(Color.black);
						} else {
							g.setColor(Color.green);
							g.fillRect(esquina.getX() - 3, esquina.getY() - 3, 6, 6);
							g.setColor(Color.black);
						}
					}
				}

				if (editar) {
					for (Rua rua : esquina.getRuas()) {
						if (!rua.isMovimentada()) {
							drawThickLine(g, esquina.getX(), esquina.getY(), rua.getDestino().getX(), rua.getDestino().getY(), 2, Color.black);
						}
						if (rua.isMovimentada()) {
							drawThickLine(g, esquina.getX(), esquina.getY(), rua.getDestino().getX(), rua.getDestino().getY(), 2, Color.blue);
							g.setColor(Color.black);
						}
//					if (editar) {
//						int ratex = (rua.getDestino().getX() - esquina.getX()) / 4;
//						int ratey = (rua.getDestino().getY() - esquina.getY()) / 4;
//						ratex = ratex + esquina.getX();
//						ratey = ratey + esquina.getY();
//						if (esquina.getX() == rua.getDestino().getX()) {
//							ratex = ratex + 5;
//						}
//						if (esquina.getX() >= rua.getDestino().getX()) {
//							g.drawString("<=", ratex, ratey);
//						} else {
//							g.drawString("=>", ratex, ratey);
//						}
//					}
					}
				}
			}
		}
		//pinta selecao de esquina
		if (selected != null) {
			g.setColor(Color.black);
			g.fillRect(selected.getX() - 5, selected.getY() - 5, 10, 10);
			g.setColor(Color.orange);
			g.fillRect(selected.getX() - 3, selected.getY() - 3, 6, 6);
			if (editar) {
				for (Rua rua : selected.getRuas()) {
					drawThickLine(g, rua.getOrigem().getX(), rua.getOrigem().getY(), rua.getDestino().getX(), rua.getDestino().getY(), 2, g.getColor());
//					int ratex = (rua.getDestino().getX() - selected.getX()) / 4;
//					int ratey = (rua.getDestino().getY() - selected.getY()) / 4;
//					ratex = ratex + selected.getX();
//					ratey = ratey + selected.getY();
//					if (selected.getX() == rua.getDestino().getX()) {
//						ratex = ratex + 5;
//					}
//					if (selected.getX() >= rua.getDestino().getX()) {
//						g.drawString("<=", ratex, ratey);
//					} else {
//						g.drawString("=>", ratex, ratey);
//					}
				}
			}
		}
		if (!editar) {
			if (selected2 != null) {
				g.setColor(Color.black);
				g.fillRect(selected2.getX() - 5, selected2.getY() - 5, 10, 10);
				g.setColor(Color.orange);
				g.fillRect(selected2.getX() - 3, selected2.getY() - 3, 6, 6);
			}
			if (caminho != null) {
				g.setColor(Color.red);
				for (Esquina esquina : caminho) {
					if (esquina.isSemaforo()) {
						g.fillOval(esquina.getX() - 5, esquina.getY() - 5, 10, 10);
						g.setColor(Color.yellow);
						g.fillOval(esquina.getX() - 4, esquina.getY() - 4, 8, 8);
						g.setColor(Color.red);
					}
//					g.fillRect(esquina.getX() - 3, esquina.getY() - 3, 6, 6);
					int i = caminho.indexOf(esquina);
					if (i + 1 < caminho.size()) {
						drawThickLine(g, esquina.getX(), esquina.getY(), caminho.get(i + 1).getX(), caminho.get(i + 1).getY(), 2, g.getColor());
					}
				}
			}
			if (visitados != null) {
				g.setColor(Color.black);
				for (Esquina esquina : visitados) {
					g.fillRect(esquina.getX() - 3, esquina.getY() - 3, 6, 6);
				}
				g.setColor(Color.blue);
				for (Esquina esquina : visitados) {
					g.fillRect(esquina.getX() - 2, esquina.getY() - 2, 4, 4);
				}
			}
		}
		g.setColor(Color.red);
		g.drawString(statusText, 10, 12);
	}

	//adiciona pontos na lista enquanto uma face nao estiver pronta
	public void addNaLista(Esquina e) {
		Esquina E = cidade.getEsquinaProxima(e.getX(), e.getY());
		if (E == null) {
			if (selected != null) {
				cidade.add(selected, e, maoDupla, movimentada);
				setSelected(e);
			} else {
				cidade.add(e);
				setSelected(e);
			}
		} else {
			E.setNome(e.getNome());
			if (selected != null) {
				cidade.add(selected, E, maoDupla, movimentada);
			}
			setSelected(E);
		}
	}

	//limpa lista de pontos para recomeçar o desenho
	public void novo() {
		cidade = new Cidade();
		bgimage = null;
		setSelected(null);
		setSelected2(null);
		setCaminho(null);
		this.paintComponent(this.getGraphics());
		visitados = null;
	}

	//permite arastar um ponto da lista para modificar sua posicao
	public boolean move(Esquina p) {
		if (!editar) {
			return false;
		}
		if (selected == null) {
			return false;
		}
		selected.setX(p.getX());
		selected.setY(p.getY());
		paintComponent(this.getGraphics());
		return true;
	}

	public Esquina getSelected() {
		return selected;
	}

	public void setSelected(Esquina e) {
		this.selected = e;
//        paintComponent(this.getGraphics());
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public Esquina getSelected2() {
		return selected2;
	}

	public void setSelected2(Esquina selected2) {
		this.selected2 = selected2;
//        this.paintComponent(this.getGraphics());
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Image getBgimage() {
		return bgimage;
	}

	public void setBgimage(Image bgimage) {
		this.bgimage = bgimage;
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

	public boolean isSomenteInteresse() {
		return somenteInteresse;
	}

	public void setSomenteInteresse(boolean somenteInteresse) {
		this.somenteInteresse = somenteInteresse;
	}

	public void redimenciona(int largura, int altura) {
		Dimension d = new Dimension(largura, altura);
		this.setPreferredSize(d);
		this.setSize(d);
		paintComponent(this.getGraphics());
	}

	public void switchMaoDupla() {
		if (maoDupla == true) {
			maoDupla = false;
		} else {
			maoDupla = true;
		}
	}

	public void switchMovimentada() {
		if (movimentada == true) {
			movimentada = false;
		} else {
			movimentada = true;
		}
	}

	void setStatusText(String texto) {
		statusText = texto;
	}

	void select(String nome) {
		selected = cidade.getEsquina(nome);
		System.out.println(selected.toString());
	}

	public void drawThickLine(Graphics g, int x1, int y1, int x2, int y2, int thickness, Color c) {
		g.setColor(c);
		int dX = x2 - x1;
		int dY = y2 - y1;
		double lineLength = Math.sqrt(dX * dX + dY * dY);
		double scale = (double) (thickness) / (2 * lineLength);
		double ddx = -scale * (double) dY;
		double ddy = scale * (double) dX;
		ddx += (ddx > 0) ? 0.5 : -0.5;
		ddy += (ddy > 0) ? 0.5 : -0.5;
		int dx = (int) ddx;
		int dy = (int) ddy;
		int xPoints[] = new int[4];
		int yPoints[] = new int[4];
		xPoints[0] = x1 + dx;
		yPoints[0] = y1 + dy;
		xPoints[1] = x1 - dx;
		yPoints[1] = y1 - dy;
		xPoints[2] = x2 - dx;
		yPoints[2] = y2 - dy;
		xPoints[3] = x2 + dx;
		yPoints[3] = y2 + dy;
		g.fillPolygon(xPoints, yPoints, 4);
	}
}
