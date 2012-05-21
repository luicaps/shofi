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
 * @author Spanhol e da Silva
 */
public class Main extends javax.swing.JFrame {

	private File file;
	private int serialName = 0;

	public Main() {

		//Look and Feel
		javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
		String piru = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(piru);
		} catch (Exception e) {
			System.out.println("fu**u");
		}
		//Acaba Look and Feel

		initComponents();
		jpPercurso.setVisible(false);
		jpRestricoes.setVisible(false);
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
        jcbAlgoritmo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jbEditar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jpRestricoes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlRestricoes = new javax.swing.JLabel();
        jtfMaximoSemaforos = new javax.swing.JFormattedTextField();
        jpPropriedades = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfPosicaoX = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfPosicaoY = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jbMenorDistancia = new javax.swing.JButton();
        jcbSemaforo = new javax.swing.JCheckBox();
        jScrollPane = new javax.swing.JScrollPane();
        jpDraw = new Interface.Draw();
        jMenuBar2 = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmNovo = new javax.swing.JMenuItem();
        jmSalvar = new javax.swing.JMenuItem();
        jmAbrirMapa = new javax.swing.JMenuItem();
        jmAbrirImagem = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcbAlgoritmo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Amplitude", "Amplitude com restricoes", "Profundidade", "Profundidade com restricoes", "Profundidade iterativa", "Bidirecional", "Dijkistra", "A*" }));
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

        jLabel1.setText("Maximo de semaforos:");

        jlRestricoes.setText("Restrições:");

        jtfMaximoSemaforos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#+0"))));
        jtfMaximoSemaforos.setText("0");
        jtfMaximoSemaforos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMaximoSemaforosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpRestricoesLayout = new javax.swing.GroupLayout(jpRestricoes);
        jpRestricoes.setLayout(jpRestricoesLayout);
        jpRestricoesLayout.setHorizontalGroup(
            jpRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRestricoesLayout.createSequentialGroup()
                .addGroup(jpRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRestricoesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfMaximoSemaforos))
                    .addGroup(jpRestricoesLayout.createSequentialGroup()
                        .addComponent(jlRestricoes)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpRestricoesLayout.setVerticalGroup(
            jpRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRestricoesLayout.createSequentialGroup()
                .addComponent(jlRestricoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfMaximoSemaforos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpPercursoLayout = new javax.swing.GroupLayout(jpPercurso);
        jpPercurso.setLayout(jpPercursoLayout);
        jpPercursoLayout.setHorizontalGroup(
            jpPercursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPercursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPercursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpRestricoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpPercursoLayout.createSequentialGroup()
                        .addGroup(jpPercursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2)
                            .addComponent(jLabel9))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addGap(18, 18, 18)
                .addComponent(jpRestricoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jcbSemaforo)
                    .addComponent(jLabel5)
                    .addComponent(jCheckBox1)
                    .addComponent(jbMenorDistancia)
                    .addGroup(jpPropriedadesLayout.createSequentialGroup()
                        .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpPropriedadesLayout.createSequentialGroup()
                                .addComponent(jtfPosicaoX, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfPosicaoY, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpPropriedadesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtfPosicaoX, jtfPosicaoY});

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
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jbMenorDistancia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 728, Short.MAX_VALUE)
        );
        jpDrawLayout.setVerticalGroup(
            jpDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        jScrollPane.setViewportView(jpDraw);

        jmFile.setText("File");

        jmNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmNovo.setText("Novo");
        jmNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNovoActionPerformed(evt);
            }
        });
        jmFile.add(jmNovo);

        jmSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmSalvar.setText("Salvar mapa...");
        jmSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalvarActionPerformed(evt);
            }
        });
        jmFile.add(jmSalvar);

        jmAbrirMapa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jmAbrirMapa.setText("Abrir mapa...");
        jmAbrirMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAbrirMapaActionPerformed(evt);
            }
        });
        jmFile.add(jmAbrirMapa);

        jmAbrirImagem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jmAbrirImagem.setText("Abrir imagem...");
        jmAbrirImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAbrirImagemActionPerformed(evt);
            }
        });
        jmFile.add(jmAbrirImagem);

        jMenuBar2.add(jmFile);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpPercurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpPropriedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jpPropriedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPercurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
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
						jtfMaximoSemaforos.setText("");
						jpDraw.setCaminho(Percurso.aEstrela(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Dijkistra")) {
						jpDraw.setCaminho(Percurso.dijkistra(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Bidirecional")) {
						jpDraw.setCaminho(Percurso.buscaBidirecional(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Amplitude")) {
						jpDraw.setCaminho(Percurso.buscaAmplitude(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Amplitude com restricoes")) {
						int max;
						max = Integer.parseInt(jtfMaximoSemaforos.getText());
						jpDraw.setCaminho(Percurso.buscaAmplitude(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade(), max));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade")) {
						jpDraw.setCaminho(Percurso.buscaProfundidade(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade com restricoes")) {
						int max;
						max = Integer.parseInt(jtfMaximoSemaforos.getText());
						jpDraw.setCaminho(Percurso.buscaProfundidade(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade(), max));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade iterativa")) {
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
						jtfMaximoSemaforos.setText("");
						jpDraw.setCaminho(Percurso.aEstrela(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Dijkistra")) {
						jpDraw.setCaminho(Percurso.dijkistra(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Bidirecional")) {
						jpDraw.setCaminho(Percurso.buscaBidirecional(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Amplitude")) {
						jpDraw.setCaminho(Percurso.buscaAmplitude(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Amplitude com restricoes")) {
						int max;
						max = Integer.parseInt(jtfMaximoSemaforos.getText());
						jpDraw.setCaminho(Percurso.buscaAmplitude(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade(), max));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade")) {
						jpDraw.setCaminho(Percurso.buscaProfundidade(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade com restricoes")) {
						int max;
						max = Integer.parseInt(jtfMaximoSemaforos.getText());
						jpDraw.setCaminho(Percurso.buscaProfundidade(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade(), max));
					}
					if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade iterativa")) {
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
		jpDraw.setStatusText("");
	}//GEN-LAST:event_jbEditarActionPerformed

	private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
		jpDraw.switchAnimar();
	}//GEN-LAST:event_jCheckBox2ActionPerformed

	private void jcbAlgoritmoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAlgoritmoItemStateChanged
		if (jcbAlgoritmo.getSelectedItem().toString().equals("Amplitude com restricoes")
				|| jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade com restricoes")) {
			jpRestricoes.setVisible(true);
		} else {
			jpRestricoes.setVisible(false);
		}
	}//GEN-LAST:event_jcbAlgoritmoItemStateChanged

	private void jcbSemaforoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSemaforoActionPerformed
		setPropriedades(jpDraw.getSelected());
	}//GEN-LAST:event_jcbSemaforoActionPerformed

	private void jtfMaximoSemaforosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMaximoSemaforosActionPerformed
		if (jpDraw.getSelected2() != null && jpDraw.getSelected() != null) {
			if (jcbAlgoritmo.getSelectedItem().toString().equals("A*")) {
				jtfMaximoSemaforos.setText("");
				jpDraw.setCaminho(Percurso.aEstrela(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
			}
			if (jcbAlgoritmo.getSelectedItem().toString().equals("Dijkistra")) {
				jpDraw.setCaminho(Percurso.dijkistra(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
			}
			if (jcbAlgoritmo.getSelectedItem().toString().equals("Bidirecional")) {
				jpDraw.setCaminho(Percurso.buscaBidirecional(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
			}
			if (jcbAlgoritmo.getSelectedItem().toString().equals("Amplitude")) {
				jpDraw.setCaminho(Percurso.buscaAmplitude(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
			}
			if (jcbAlgoritmo.getSelectedItem().toString().equals("Amplitude com restricoes")) {
				int max;
				max = Integer.parseInt(jtfMaximoSemaforos.getText());
				jpDraw.setCaminho(Percurso.buscaAmplitude(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade(), max));
			}
			if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade")) {
				jpDraw.setCaminho(Percurso.buscaProfundidade(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade()));
			}
			if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade com restricoes")) {
				int max;
				max = Integer.parseInt(jtfMaximoSemaforos.getText());
				jpDraw.setCaminho(Percurso.buscaProfundidade(jpDraw.getSelected2(), jpDraw.getSelected(), jpDraw.getCidade(), max));
			}
			if (jcbAlgoritmo.getSelectedItem().toString().equals("Profundidade iterativa")) {
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
	}//GEN-LAST:event_jtfMaximoSemaforosActionPerformed
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbMenorDistancia;
    private javax.swing.JComboBox jcbAlgoritmo;
    private javax.swing.JCheckBox jcbSemaforo;
    private javax.swing.JLabel jlRestricoes;
    private javax.swing.JMenuItem jmAbrirImagem;
    private javax.swing.JMenuItem jmAbrirMapa;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenuItem jmNovo;
    private javax.swing.JMenuItem jmSalvar;
    private Interface.Draw jpDraw;
    private javax.swing.JPanel jpPercurso;
    private javax.swing.JPanel jpPropriedades;
    private javax.swing.JPanel jpRestricoes;
    private javax.swing.JFormattedTextField jtfMaximoSemaforos;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPosicaoX;
    private javax.swing.JTextField jtfPosicaoY;
    // End of variables declaration//GEN-END:variables
}