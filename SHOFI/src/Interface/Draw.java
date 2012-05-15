package Interface;

import Modelo.Cidade;
import Modelo.Esquina;
import Modelo.Rua;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Draw extends JPanel {

	Cidade cidade = new Cidade();
	Esquina selected;
	Esquina selected2;
	LinkedList<Esquina> caminho;
	Image bgimage = null;
	boolean maoDupla = true;
	boolean editar = true;
	boolean animar = true; //abilita passo a passo do desenho do caminho

	//funcao responsavel por pintar as esquinas e ruas
	@Override
	public void paintComponent(Graphics g) {
		if (bgimage != null) {
			g.drawImage(bgimage, 0, 0, this);
		} else {
			super.paintComponent(g);
		}
		if (cidade != null) {
			g.setColor(Color.black);
			for (Esquina esquina : cidade.getListaEsquinas()) {
				g.fillRect(esquina.getX() - 3, esquina.getY() - 3, 6, 6);
				for (Rua rua : esquina.getRuas()) {
					g.drawLine(esquina.getX(), esquina.getY(), rua.getDestino().getX(), rua.getDestino().getY());
					int ratex = (rua.getDestino().getX() - esquina.getX()) / 4;
					int ratey = (rua.getDestino().getY() - esquina.getY()) / 4;
					ratex = ratex + esquina.getX();
					ratey = ratey + esquina.getY();
					if (esquina.getX() == rua.getDestino().getX()) {
						ratex = ratex + 5;
					}
					if (esquina.getX() >= rua.getDestino().getX()) {
						g.drawString("<=", ratex, ratey);
					} else {
						g.drawString("=>", ratex, ratey);
					}
				}
			}
		}
		//pinta selecao de esquina
		if (selected != null) {
			g.setColor(Color.black);
			g.fillRect(selected.getX() - 5, selected.getY() - 5, 10, 10);
			g.setColor(Color.white);
			g.fillRect(selected.getX() - 3, selected.getY() - 3, 6, 6);
		}
		if (!editar) {
			if (selected2 != null) {
				g.setColor(Color.black);
				g.fillRect(selected2.getX() - 5, selected2.getY() - 5, 10, 10);
				g.setColor(Color.green);
				g.fillRect(selected2.getX() - 3, selected2.getY() - 3, 6, 6);
			}
			if (caminho != null) {
				g.setColor(Color.red);
				for (Esquina esquina : caminho) {
					g.fillRect(esquina.getX() - 3, esquina.getY() - 3, 6, 6);
					int i = caminho.indexOf(esquina);
					if (animar) {
						try {
							Thread.sleep(300);
						} catch (InterruptedException ex) {
							Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (i + 1 < caminho.size()) {
						g.drawLine(esquina.getX(), esquina.getY(), caminho.get(i + 1).getX(), caminho.get(i + 1).getY());
					}
				}
			}
		}
	}

	//adiciona pontos na lista enquanto uma face nao estiver pronta
	public void addNaLista(Esquina e) {
		Esquina E = cidade.getEsquinaProxima(e.getX(), e.getY());
		if (E == null) {
			if (selected != null) {
				cidade.add(selected, e, maoDupla);
				setSelected(e);
			} else {
				cidade.add(e);
				setSelected(e);
			}
		} else {
			if (selected != null) {
				cidade.add(selected, E, maoDupla);
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

	public void redimenciona(int largura, int altura) {
		Dimension d = new Dimension(largura, altura);
		this.setPreferredSize(d);
		paintComponent(this.getGraphics());
	}

	public void switchMaoDupla() {
		if (maoDupla == true) {
			maoDupla = false;
		} else {
			maoDupla = true;
		}
	}

	public void switchAnimar() {
		if (animar == true) {
			animar = false;
		} else {
			animar = true;
		}
	}
}
