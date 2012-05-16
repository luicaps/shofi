/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Controle.Percurso;
import Modelo.Cidade;
import Modelo.Esquina;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 *
 * @author Span
 */
public class Main extends javax.swing.JFrame {

	private File file;
	int serialName = 0;

	public Main() {

		//Look and Feel
		javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
		String piru = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(piru);
		} catch (Exception e) {
			System.out.println("fudeu");
		}
		//Acaba Look and Feel

		initComponents();
		jpPercurso.setVisible(false);
		jlRestricoes.setVisible(false);
		jcbEvitarSemaforos.setVisible(false);
	}

	public void showPropriedades(Esquina e) {
		if (e != null) {
			jtfPosicaoX.setText(Integer.toString(e.getX()));
			jtfPosicaoY.setText(Integer.toString(e.getY()));
			jtfNome.setText(e.getNome());
			jcbSemaforo.setSelected(e.haveSemaforo());
		} else {
			jtfPosicaoX.setText("");
			jtfPosicaoY.setText("");
			jtfNome.setText("");
			jcbSemaforo.setSelected(false);
		}
	}

	public void setPropriedades(Esquina e) {
		if (e != null) {
			if (jtfPosicaoX.getText().compareTo("") != 0) {
				e.setX(Integer.parseInt(jtfPosicaoX.getText()));
			}
			if (jtfPosicaoY.getText().compareTo("") != 0) {
				e.setY(Integer.parseInt(jtfPosicaoY.getText()));
			}
			e.setNome(jtfNome.getText());
			e.setSemaforo(jcbSemaforo.isSelected());
			jpDraw.paintComponent(jpDraw.getGraphics());
		}
	}

//	public void atualizaCombo() {
//        Objeto aux = objMundo;
//        LinkedList<String> i = new LinkedList<String>();
//        if (selecao3D == null) {
//            while (aux != null) {
//                i.add(Integer.toString(aux.getId()));
//                aux = aux.getProximo();
//            }
//            jcObjeto.removeAllItems();
//            jcObjeto.addItem("None");
//            for (int j = 0; j < i.size(); j++) {
//                jcObjeto.addItem(i.get(j));
//            }
//        } else {
//            Object cmboitem = jcObjeto.getSelectedItem();
//            while (aux != null) {
//                i.add(Integer.toString(aux.getId()));
//                aux = aux.getProximo();
//            }
//            jcObjeto.removeAllItems();
//            jcObjeto.addItem("None");
//            for (int j = 0; j < i.size(); j++) {
//                jcObjeto.addItem(i.get(j));
//                if (cmboitem.equals(i.get(j))) {
//                    cmboitem = jcObjeto.getItemAt(j + 1);
//                }
//            }
//            jcObjeto.setSelectedItem(cmboitem);
//        }
//
//    }
	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
	 * method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jpPercurso = new javax.swing.JPanel();
        jbProcurar = new javax.swing.JButton();
        jcbAlgoritmo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jbEditar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jlRestricoes = new javax.swing.JLabel();
        jcbEvitarSemaforos = new javax.swing.JCheckBox();
        jpPropriedades = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfPosicaoX = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfPosicaoY = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jcRuas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jbMenorDistancia = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jcbSemaforo = new javax.swing.JCheckBox();
        jScrollPane = new javax.swing.JScrollPane();
        jpDraw = new Interface.Draw();
        jMenuBar2 = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmNovo = new javax.swing.JMenuItem();
        jmSalvar = new javax.swing.JMenuItem();
        jmSalvarComo = new javax.swing.JMenuItem();
        jmAbrirMapa = new javax.swing.JMenuItem();
        jmAbrirImagem = new javax.swing.JMenuItem();
        jmSair = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbProcurar.setText("Procurar");
        jbProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcurarActionPerformed(evt);
            }
        });

        jcbAlgoritmo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Amplitude", "Profundidade", "Profundidade iterativa", "Bidirecional", "Dijkstra", "A*" }));
        jcbAlgoritmo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAlgoritmoItemStateChanged(evt);
            }
        });

        jLabel2.setText("Algoritmo:");

        jbEditar.setText("<< Editar Grafo");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jLabel3.setText("Botão esquerdo do mouse: origem");

        jLabel4.setText("Botão direito do mouse: destino");

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Passo a passo");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Animação:");

        jlRestricoes.setText("Restrições:");

        jcbEvitarSemaforos.setText("Evitar Semaforos");

        javax.swing.GroupLayout jpPercursoLayout = new javax.swing.GroupLayout(jpPercurso);
        jpPercurso.setLayout(jpPercursoLayout);
        jpPercursoLayout.setHorizontalGroup(
            jpPercursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPercursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPercursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbEvitarSemaforos)
                    .addComponent(jCheckBox2)
                    .addComponent(jcbAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jbProcurar)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jlRestricoes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPercursoLayout.setVerticalGroup(
            jpPercursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPercursoLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jbProcurar)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addGap(18, 18, 18)
                .addComponent(jlRestricoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbEvitarSemaforos)
                .addGap(33, 33, 33)
                .addComponent(jbEditar)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jpPropriedades.setAlignmentX(0.0F);
        jpPropriedades.setAlignmentY(0.0F);

        jLabel5.setText("Coordenadas:");

        jLabel6.setText("x: ");

        jtfPosicaoX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPosicaoXActionPerformed(evt);
            }
        });
        jtfPosicaoX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfPosicaoXFocusLost(evt);
            }
        });

        jLabel7.setText("y: ");

        jtfPosicaoY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPosicaoYActionPerformed(evt);
            }
        });
        jtfPosicaoY.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfPosicaoYFocusLost(evt);
            }
        });

        jLabel8.setText("nome:");

        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });
        jtfNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNomeFocusLost(evt);
            }
        });

        jcRuas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "selecione" }));

        jLabel1.setText("Ruas para:");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Mão dupla");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jbMenorDistancia.setText("Percursos  >>");
        jbMenorDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenorDistanciaActionPerformed(evt);
            }
        });

        jButton1.setText("Remover rua");

        jcbSemaforo.setText("Semaforo");
        jcbSemaforo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSemaforoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPropriedadesLayout = new javax.swing.GroupLayout(jpPropriedades);
        jpPropriedades.setLayout(jpPropriedadesLayout);
        jpPropriedadesLayout.setHorizontalGroup(
            jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPropriedadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPropriedadesLayout.createSequentialGroup()
                        .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPropriedadesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPropriedadesLayout.createSequentialGroup()
                                .addComponent(jtfPosicaoX, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfPosicaoY, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jcRuas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpPropriedadesLayout.createSequentialGroup()
                        .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbSemaforo)
                            .addComponent(jLabel5)
                            .addComponent(jCheckBox1)
                            .addComponent(jLabel1)
                            .addComponent(jbMenorDistancia)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpPropriedadesLayout.setVerticalGroup(
            jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPropriedadesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfPosicaoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtfPosicaoY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbSemaforo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcRuas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(29, 29, 29)
                .addComponent(jbMenorDistancia))
        );

        jpDraw.setPreferredSize(new java.awt.Dimension(500, 500));
        jpDraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpDrawMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jpDrawMouseReleased(evt);
            }
        });
        jpDraw.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpDrawMouseDragged(evt);
            }
        });
        jpDraw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpDrawKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jpDrawLayout = new javax.swing.GroupLayout(jpDraw);
        jpDraw.setLayout(jpDrawLayout);
        jpDrawLayout.setHorizontalGroup(
            jpDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        jpDrawLayout.setVerticalGroup(
            jpDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        jScrollPane.setViewportView(jpDraw);

        jmFile.setText("File");

        jmNovo.setText("Novo");
        jmNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNovoActionPerformed(evt);
            }
        });
        jmFile.add(jmNovo);

        jmSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmSalvar.setText("Salvar");
        jmSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalvarActionPerformed(evt);
            }
        });
        jmFile.add(jmSalvar);

        jmSalvarComo.setText("Salvar como...");
        jmFile.add(jmSalvarComo);

        jmAbrirMapa.setText("Abrir mapa...");
        jmAbrirMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAbrirMapaActionPerformed(evt);
            }
        });
        jmFile.add(jmAbrirMapa);

        jmAbrirImagem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jmAbrirImagem.setText("Abrir imagem...");
        jmAbrirImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAbrirImagemActionPerformed(evt);
            }
        });
        jmFile.add(jmAbrirImagem);

        jmSair.setText("Sair");
        jmFile.add(jmSair);

        jMenuBar2.add(jmFile);

        jMenu3.setText("Ajuda");
        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpPropriedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpPercurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jpPercurso, jpPropriedades});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPropriedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPercurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jpDrawMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDrawMouseDragged
		if (jpDraw.isEditar()) {
			if (jpDraw.getSelected() != null) {
				Esquina e = new Esquina(evt.getPoint().x, evt.getPoint().y);
				jpDraw.move(e);
				showPropriedades(jpDraw.getSelected());
			}
		}
	}//GEN-LAST:event_jpDrawMouseDragged

	private void jpDrawMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDrawMouseReleased
		if (evt.getButton() == MouseEvent.BUTTON1) {
			if (!jpDraw.isEditar()) {
				//retorna esquina proxima ao ponto clicado ou uma nova esquina se nao houver nenhuma proxima
				Esquina p = jpDraw.getCidade().getEsquinaProxima(evt.getPoint().x, evt.getPoint().y);
				//se a selecao nao mudou nao ha nada para fazer
				if (p == jpDraw.getSelected2() || p == null) {
					return;
				}
				//se a selecao mudou, seta selecao para o novo ponto
				jpDraw.setSelected2(p);
				//mostra propriedades da esquina selecionada
				showPropriedades(p);
				//se existem duas esquinas selecionadas sera calculado o menor caminho entre elas atraves do algoritmo selecionado
				if (jpDraw.getSelected2() != null && jpDraw.getSelected() != null) {
					if (jcbAlgoritmo.getSelectedItem().toString().equals("A*")) {
						System.out.println("fazendo busca atravez do algoritmo A*");
						jpDraw.setCaminho(Percurso.aEstrela(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Dijkstra")) {
						System.out.println("fazendo busca atravez do algoritmo Dijkstra");
						jpDraw.setCaminho(Percurso.dijkstra(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Bidirecional")) {
						System.out.println("fazendo busca atravez do algoritmo Bidirecional");
						jpDraw.setCaminho(Percurso.buscaBidirecional(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Amplitude")) {
						System.out.println("fazendo busca atravez do algoritmo Amplitude");
						if (jcbEvitarSemaforos.isSelected()) {
							jpDraw.getCidade().setSemaforoVisited();
						}
						jpDraw.setCaminho(Percurso.buscaAmplitude(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade")) {
						System.out.println("fazendo busca atravez do algoritmo Profundidade");
						if (jcbEvitarSemaforos.isSelected()) {
							jpDraw.getCidade().setSemaforoVisited();
						}
						jpDraw.setCaminho(Percurso.buscaProfundidade(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade iterativa")) {
						System.out.println("fazendo busca atravez do algoritmo Profundidade iterativa");
						jpDraw.setCaminho(Percurso.buscaProfundidadeIterativa(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (!jcbAlgoritmo.getSelectedItem().toString().equals("Selecione")) {
						if (jpDraw.getCaminho() == null) {
							jpDraw.setStatusText("Não foi possível encontrar um caminho");
						} else {
							jpDraw.setStatusText("");
						}
					}
				}
			}
		} else if (evt.getButton() == MouseEvent.BUTTON3) {
			//retorna esquina proxima ao ponto clicado ou uma nova esquina se nao houver nenhuma proxima
			Esquina p = jpDraw.getCidade().getEsquinaProxima(evt.getPoint().x, evt.getPoint().y);
			//se a selecao nao mudou nao ha nada para fazer
			if (p == jpDraw.getSelected()) {
				return;
			}
			if (!jpDraw.isEditar() && p == null) {
				return;
			}
			//se a selecao mudou, seta selecao para o novo ponto
			jpDraw.setSelected(p);
			//mostra propriedades da esquina selecionada
			showPropriedades(p);
			//se existem duas esquinas selecionadas sera calculado o menor caminho entre elas atraves do algoritmo selecionado
			if (!jpDraw.isEditar()) {
				if (jpDraw.getSelected2() != null && jpDraw.getSelected() != null) {
					if (jcbAlgoritmo.getSelectedItem().toString().equals("A*")) {
						System.out.println("fazendo busca atravez do algoritmo A*");
						jpDraw.setCaminho(Percurso.aEstrela(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Dijkstra")) {
						System.out.println("fazendo busca atravez do algoritmo Dijkstra");
						jpDraw.setCaminho(Percurso.dijkstra(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Bidirecional")) {
						System.out.println("fazendo busca atravez do algoritmo Bidirecional");
						jpDraw.setCaminho(Percurso.buscaBidirecional(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Amplitude")) {
						System.out.println("fazendo busca atravez do algoritmo Amplitude");
						if (jcbEvitarSemaforos.isSelected()) {
							jpDraw.getCidade().setSemaforoVisited();
						}
						jpDraw.setCaminho(Percurso.buscaAmplitude(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade")) {
						System.out.println("fazendo busca atravez do algoritmo Profundidade");
						if (jcbEvitarSemaforos.isSelected()) {
							jpDraw.getCidade().setSemaforoVisited();
						}
						jpDraw.setCaminho(Percurso.buscaProfundidade(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade iterativa")) {
						System.out.println("fazendo busca atravez do algoritmo Profundidade iterativa");
						jpDraw.setCaminho(Percurso.buscaProfundidadeIterativa(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (!jcbAlgoritmo.getSelectedItem().toString().equals("Selecione")) {
						if (jpDraw.getCaminho() == null) {
							jpDraw.setStatusText("Não foi possível encontrar um caminho");
						} else {
							jpDraw.setStatusText("");
						}
					}
				}
			}
		}
		jpDraw.paintComponent(jpDraw.getGraphics());
	}//GEN-LAST:event_jpDrawMouseReleased

	private void jpDrawMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDrawMousePressed
		jpDraw.requestFocus();
		if (jpDraw.isEditar()) {
			setPropriedades(jpDraw.getSelected());
			if (evt.getButton() == MouseEvent.BUTTON1) {
				if (jpDraw.isEditar()) {
					Esquina e = new Esquina(evt.getPoint().x, evt.getPoint().y);
					serialName++;
					e.setNome(Integer.toString(serialName));
					jpDraw.addNaLista(e);
					showPropriedades(e);
//					jpDraw.paintComponent(jpDraw.getGraphics());
				}
			}
			if (evt.getButton() == MouseEvent.BUTTON3) {
				Esquina p = jpDraw.cidade.getEsquinaProxima(evt.getPoint().x, evt.getPoint().y);
				jpDraw.setSelected(p);
				showPropriedades(p);
				jpDraw.paintComponent(jpDraw.getGraphics());
			}
		}
	}//GEN-LAST:event_jpDrawMousePressed

	private void jmAbrirImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAbrirImagemActionPerformed
		JFileChooser j = new JFileChooser();
		int i = j.showOpenDialog(null);
		if (i == JFileChooser.APPROVE_OPTION) {
			file = j.getSelectedFile();
			try {
				BufferedImage bf = ImageIO.read(file);
				jpDraw.setBgimage(bf);
				jpDraw.redimenciona(bf.getWidth(), bf.getHeight());
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jmAbrirImagemActionPerformed

	private void jtfPosicaoXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPosicaoXActionPerformed
		setPropriedades(jpDraw.getSelected());
	}//GEN-LAST:event_jtfPosicaoXActionPerformed

	private void jtfPosicaoYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPosicaoYActionPerformed
		setPropriedades(jpDraw.getSelected());
	}//GEN-LAST:event_jtfPosicaoYActionPerformed

	private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
		setPropriedades(jpDraw.getSelected());
	}//GEN-LAST:event_jtfNomeActionPerformed

	private void jtfPosicaoXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPosicaoXFocusLost
		setPropriedades(jpDraw.getSelected());
	}//GEN-LAST:event_jtfPosicaoXFocusLost

	private void jtfPosicaoYFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPosicaoYFocusLost
		setPropriedades(jpDraw.getSelected());
	}//GEN-LAST:event_jtfPosicaoYFocusLost

	private void jtfNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNomeFocusLost
		setPropriedades(jpDraw.getSelected());
	}//GEN-LAST:event_jtfNomeFocusLost

	private void jmNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNovoActionPerformed
		jpDraw.novo();
	}//GEN-LAST:event_jmNovoActionPerformed

	private void jpDrawKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpDrawKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
			if (jpDraw.getSelected() != null) {
				jpDraw.getCidade().remove(jpDraw.getSelected());
				jpDraw.setSelected(null);
				jpDraw.paintComponent(jpDraw.getGraphics());
			}
		}
	}//GEN-LAST:event_jpDrawKeyPressed

	private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
		jpDraw.switchMaoDupla();
	}//GEN-LAST:event_jCheckBox1ActionPerformed

	private void jmSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSalvarActionPerformed
		JFileChooser j = new JFileChooser();
		j.setApproveButtonText("Save");
		int i = j.showOpenDialog(null);
		if (i == JFileChooser.APPROVE_OPTION) {
			file = j.getSelectedFile();
			try {
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(jpDraw.getCidade());
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				System.out.println("Erro ao tentar salvar" + ex);
				System.exit(0);
			}
		}
	}//GEN-LAST:event_jmSalvarActionPerformed

	private void jmAbrirMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAbrirMapaActionPerformed
		JFileChooser j = new JFileChooser();
		int i = j.showOpenDialog(null);
		if (i == JFileChooser.APPROVE_OPTION) {
			file = j.getSelectedFile();
			FileInputStream fis;
			ObjectInputStream ois;
			try {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				try {
					jpDraw.setCidade((Cidade) ois.readObject());
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
				ois.close();
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				jpDraw.novo();
			}

		}
		jpDraw.paintComponent(jpDraw.getGraphics());
		jScrollPane.paintComponents(jScrollPane.getGraphics());
	}//GEN-LAST:event_jmAbrirMapaActionPerformed

	private void jbProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcurarActionPerformed
		if (jpDraw.getSelected2() != null && jpDraw.getSelected() != null) {
			if (jcbAlgoritmo.getSelectedItem().toString().equals("A*")) {
				System.out.println("fazendo busca atravez do algoritmo A*");
				jpDraw.setCaminho(Percurso.aEstrela(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
			}
			if (jcbAlgoritmo.getSelectedItem().toString().equals("Dijkstra")) {
				System.out.println("fazendo busca atravez do algoritmo Dijkstra");
				jpDraw.setCaminho(Percurso.dijkstra(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
			}
			if (jcbAlgoritmo.getSelectedItem().toString().equals("Bidirecional")) {
				System.out.println("fazendo busca atravez do algoritmo Bidirecional");
				jpDraw.setCaminho(Percurso.buscaBidirecional(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
			}
			if (jcbAlgoritmo.getSelectedItem().toString().equals("Amplitude")) {
				System.out.println("fazendo busca atravez do algoritmo Amplitude");
				jpDraw.setCaminho(Percurso.buscaAmplitude(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
			}
			if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade")) {
				System.out.println("fazendo busca atravez do algoritmo Profundidade");
				jpDraw.setCaminho(Percurso.buscaProfundidade(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
			}
			jpDraw.paintComponent(jpDraw.getGraphics());
		}
	}//GEN-LAST:event_jbProcurarActionPerformed

	private void jbMenorDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenorDistanciaActionPerformed
		jpPropriedades.setVisible(false);
		jpPercurso.setVisible(true);
		jpDraw.setEditar(false);
		jpDraw.paintComponent(jpDraw.getGraphics());
	}//GEN-LAST:event_jbMenorDistanciaActionPerformed

	private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
		jpPercurso.setVisible(false);
		jpPropriedades.setVisible(true);
		jpDraw.setEditar(true);
		jpDraw.setSelected2(null);
		jpDraw.setSelected(null);
		jpDraw.setCaminho(null);
		jpDraw.paintComponent(jpDraw.getGraphics());
	}//GEN-LAST:event_jbEditarActionPerformed

	private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
		jpDraw.switchAnimar();
	}//GEN-LAST:event_jCheckBox2ActionPerformed

	private void jcbAlgoritmoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAlgoritmoItemStateChanged
		if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade")
				|| jcbAlgoritmo.getSelectedItem().toString().equals("Amplitude")) {
			jlRestricoes.setVisible(true);
			jcbEvitarSemaforos.setVisible(true);
		} else {
			jlRestricoes.setVisible(false);
			jcbEvitarSemaforos.setVisible(false);
			jcbEvitarSemaforos.setSelected(false);
		}
	}//GEN-LAST:event_jcbAlgoritmoItemStateChanged

	private void jcbSemaforoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSemaforoActionPerformed
		setPropriedades(jpDraw.getSelected());
	}//GEN-LAST:event_jcbSemaforoActionPerformed
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new Main().setVisible(true);
			}
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbMenorDistancia;
    private javax.swing.JButton jbProcurar;
    private javax.swing.JComboBox jcRuas;
    private javax.swing.JComboBox jcbAlgoritmo;
    private javax.swing.JCheckBox jcbEvitarSemaforos;
    private javax.swing.JCheckBox jcbSemaforo;
    private javax.swing.JLabel jlRestricoes;
    private javax.swing.JMenuItem jmAbrirImagem;
    private javax.swing.JMenuItem jmAbrirMapa;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenuItem jmNovo;
    private javax.swing.JMenuItem jmSair;
    private javax.swing.JMenuItem jmSalvar;
    private javax.swing.JMenuItem jmSalvarComo;
    private Interface.Draw jpDraw;
    private javax.swing.JPanel jpPercurso;
    private javax.swing.JPanel jpPropriedades;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPosicaoX;
    private javax.swing.JTextField jtfPosicaoY;
    // End of variables declaration//GEN-END:variables
}
