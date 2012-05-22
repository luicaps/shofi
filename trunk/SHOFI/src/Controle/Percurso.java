package Controle;

import Modelo.Cidade;
import Modelo.Esquina;
import Modelo.Rua;
import java.util.LinkedList;

/**
 *
 * @author Spanhol e da Silva
 */
public class Percurso {

	public static LinkedList<Esquina> buscaAmplitude(Esquina origem, Esquina destino, Cidade cidade) {
		LinkedList<Esquina> caminho;
		if (origem == destino) {
			caminho = new LinkedList<>();
			caminho.add(origem);
			return caminho;
		}
		Tabela[] table = new Tabela[cidade.getEsquinas().size()];
		LinkedList<Esquina> expansao = new LinkedList();
		//aloca lista de vertices na tabela hash
		for (int i = 0; i < table.length; i++) {
			table[i] = new Tabela(cidade.getEsquinas().get(i));
		}
		int idAtual = cidade.getEsquinas().indexOf(origem);
		int idDestino;
		Esquina temp;
		boolean acaba = false;

		origem.setVisitado(true);
		expansao.add(origem);

		while (!acaba) {
			if (expansao.size() > 0) {
				temp = expansao.getFirst();
				expansao.removeFirst();
				for (Rua rua : temp.getRuas()) {
					if (rua.getDestino() == destino) {
						idDestino = cidade.getEsquinas().indexOf(rua.getDestino());
						table[idDestino].setCaminho(temp);
						acaba = true;
						break;
					}
					if (!rua.getDestino().isVisitado()) {
						idDestino = cidade.getEsquinas().indexOf(rua.getDestino());
						table[idDestino].setCaminho(temp);
						expansao.add(rua.getDestino());
						rua.getDestino().setVisitado(true);
					}
				}
			} else {
				acaba = true;
			}
		}
		cidade.setEsquinasNotVisited();
		caminho = new LinkedList<>();
		idAtual = cidade.getEsquinas().indexOf(destino);
		caminho.add(destino);
		if (table[idAtual].getCaminho() == null) {
			System.out.println("Nao existe caminho");
			return null;
		}
		while (table[idAtual].getCaminho() != null) {
			temp = table[idAtual].getCaminho();
			caminho.add(temp);
			idAtual = cidade.getEsquinas().indexOf(temp);
		}
		caminho.add(origem);
		return caminho;
	}

	//percurso em largura, usando fila//TODO
	public static LinkedList<Esquina> buscaAmplitude(Esquina origem, Esquina destino, Cidade cidade, int movimentada, int semaforo) {
		boolean evitarMovimentada = false;
		if (semaforo == 100) {
			cidade.setSemaforoVisited();
		}
		if (movimentada == 100) {
			evitarMovimentada = true;
		}
		LinkedList<Esquina> caminho;
		if (origem == destino) {
			caminho = new LinkedList<>();
			caminho.add(origem);
			return caminho;
		}
		Tabela[] table = new Tabela[cidade.getEsquinas().size()];
		LinkedList<Esquina> expansao = new LinkedList();
		//aloca lista de vertices na tabela hash
		for (int i = 0; i < table.length; i++) {
			table[i] = new Tabela(cidade.getEsquinas().get(i));
		}
		int idAtual;
		int idDestino;
		Esquina temp;
		boolean acaba = false;

		origem.setVisitado(true);
		expansao.add(origem);

		while (!acaba) {
			if (expansao.size() > 0) {
				temp = expansao.getFirst();
				expansao.removeFirst();
				for (Rua rua : temp.getRuas()) {
					if (rua.getDestino() == destino) {
						if (!(evitarMovimentada && rua.isMovimentada())) {
							idDestino = cidade.getEsquinas().indexOf(rua.getDestino());
							table[idDestino].setCaminho(temp);
							acaba = true;
							break;
						}
					}
					if (!rua.getDestino().isVisitado()) {
						if (!(evitarMovimentada && rua.isMovimentada())) {
							idDestino = cidade.getEsquinas().indexOf(rua.getDestino());
							table[idDestino].setCaminho(temp);
							expansao.add(rua.getDestino());
							rua.getDestino().setVisitado(true);
						}
					}
				}
			} else {
				acaba = true;
			}
		}
		cidade.setEsquinasNotVisited();
		caminho = new LinkedList<>();
		idAtual = cidade.getEsquinas().indexOf(destino);
		caminho.add(destino);
		if (table[idAtual].getCaminho() == null) {
			System.out.println("Nao existe caminho");
			return null;
		}
		while (table[idAtual].getCaminho() != null) {
			temp = table[idAtual].getCaminho();
			caminho.add(temp);
			idAtual = cidade.getEsquinas().indexOf(temp);
		}
		caminho.add(origem);
		return caminho;
	}

	public static LinkedList<Esquina> buscaProfundidade(Esquina origem, Esquina destino, Cidade cidade) {
		LinkedList<Esquina> caminho;
		if (origem == destino) {
			caminho = new LinkedList<>();
			caminho.add(origem);
			return caminho;
		}
		Tabela[] table = new Tabela[cidade.getEsquinas().size()];
		LinkedList<Esquina> expansao = new LinkedList();
		//aloca lista de vertices na tabela hash
		for (int i = 0; i < table.length; i++) {
			table[i] = new Tabela(cidade.getEsquinas().get(i));
		}
		int idDestino;
		Esquina temp;
		boolean acaba = false;

		origem.setVisitado(true);
		expansao.addFirst(origem);

		while (!acaba) {
			if (expansao.size() > 0) {
				temp = expansao.getFirst();
				expansao.removeFirst();
				for (Rua rua : temp.getRuas()) {
					if (rua.getDestino() == destino) {
						table[cidade.getEsquinas().indexOf(rua.getDestino())].setCaminho(temp);
						acaba = true;
						break;
					}
					if (!rua.getDestino().isVisitado()) {
						table[cidade.getEsquinas().indexOf(rua.getDestino())].setCaminho(temp);
						expansao.addFirst(rua.getDestino());
						rua.getDestino().setVisitado(true);
					}
				}
			} else {
				acaba = true;
			}
		}
		cidade.setEsquinasNotVisited();

		caminho = new LinkedList<>();
		int id = cidade.getEsquinas().indexOf(destino);
		caminho.add(destino);
		if (table[id].getCaminho() == null) {
			System.out.println("Nao existe caminho");
			return null;
		}
		while (table[id].getCaminho() != null) {
			temp = table[id].getCaminho();
			caminho.add(temp);
			id = cidade.getEsquinas().indexOf(temp);
		}
		caminho.add(origem);
		return caminho;
	}

	public static LinkedList<Esquina> buscaProfundidade(Esquina origem, Esquina destino, Cidade cidade, int maximoSemaforos) {
		int semaforosPassados = 0;
		if (maximoSemaforos <= 0) {
			cidade.setSemaforoVisited();
		}
		LinkedList<Esquina> caminho;
		if (origem == destino) {
			caminho = new LinkedList<>();
			caminho.add(origem);
			return caminho;
		}
		Tabela[] table = new Tabela[cidade.getEsquinas().size()];
		LinkedList<Esquina> expansao = new LinkedList();
		//aloca lista de vertices na tabela hash
		for (int i = 0; i < table.length; i++) {
			table[i] = new Tabela(cidade.getEsquinas().get(i));
		}
		int idDestino;
		Esquina temp;
		boolean acaba = false;

		origem.setVisitado(true);
		expansao.addFirst(origem);

		while (!acaba) {
			if (expansao.size() > 0) {
				temp = expansao.getFirst();
				if (temp.haveSemaforo()) {
					semaforosPassados++;
				}
				if (semaforosPassados >= maximoSemaforos) {
					cidade.setSemaforoVisited();
				}
				expansao.removeFirst();
				for (Rua rua : temp.getRuas()) {
					if (rua.getDestino() == destino) {
						table[cidade.getEsquinas().indexOf(rua.getDestino())].setCaminho(temp);
						acaba = true;
						break;
					}
					if (!rua.getDestino().isVisitado()) {
						table[cidade.getEsquinas().indexOf(rua.getDestino())].setCaminho(temp);
						expansao.addFirst(rua.getDestino());
						rua.getDestino().setVisitado(true);
					}
				}
			} else {
				acaba = true;
			}
		}
		cidade.setEsquinasNotVisited();

		caminho = new LinkedList<>();
		int id = cidade.getEsquinas().indexOf(destino);
		caminho.add(destino);
		if (table[id].getCaminho() == null) {
			System.out.println("Nao existe caminho");
			return null;
		}
		while (table[id].getCaminho() != null) {
			temp = table[id].getCaminho();
			caminho.add(temp);
			id = cidade.getEsquinas().indexOf(temp);
		}
		caminho.add(origem);
		return caminho;
	}

	public static LinkedList<Esquina> buscaProfundidadeIterativa(Esquina origem, Esquina destino, Cidade cidade) {
		LinkedList<Esquina> caminho;
		if (origem == destino) {
			caminho = new LinkedList<>();
			caminho.add(origem);
			return caminho;
		}
		Tabela[] table = new Tabela[cidade.getEsquinas().size()];
		int limite = 1;
		int limitantelimite = 5;
		int atual = 0;
		//aloca lista de vertices na tabela hash
		Esquina temp;
		boolean acaba = false;

		origem.setVisitado(true);

		LinkedList<LinkedList<Esquina>> expansao;
		while (!acaba) {
			table = new Tabela[cidade.getEsquinas().size()];
			for (int i = 0; i < table.length; i++) {
				table[i] = new Tabela(cidade.getEsquinas().get(i));
			}
			expansao = new LinkedList();
			for (int i = 0; i <= limite; i++) {
				expansao.add(new LinkedList());
			}
			expansao.get(0).add(origem);
			while (atual <= limite) {
				if (atual < 0) {
					break;
				}
				if (expansao.get(atual).size() != 0) {
					temp = expansao.get(atual).removeFirst();
					temp.setVisitado(true);
					if (temp == destino) {
						acaba = true;
						break;
					}
				} else {
					atual--;
					continue;
				}
				if (atual < limite) {
					for (Rua rua : temp.getRuas()) {
						if (!rua.getDestino().isVisitado()) {
							table[cidade.getEsquinas().indexOf(rua.getDestino())].setCaminho(temp);
							expansao.get(atual + 1).add(rua.getDestino());
						}
					}
					atual++;
				}
			}
			if (acaba) {
				break;
			}

			limite++;
			if (limite > limitantelimite) {
				break;
			}
			atual = 0;
			cidade.setEsquinasNotVisited();
		}

		cidade.setEsquinasNotVisited();

		caminho = new LinkedList<>();
		int id = cidade.getEsquinas().indexOf(destino);
		caminho.add(destino);
		if (table[id].getCaminho() == null) {
			System.out.println("Nao existe caminho");
			return null;
		}
		while (table[id].getCaminho() != null) {
			temp = table[id].getCaminho();
			caminho.add(temp);
			id = cidade.getEsquinas().indexOf(temp);
		}
		caminho.add(origem);
		return caminho;
	}

	public static LinkedList<Esquina> dijkistra(Esquina origem, Esquina destino, Cidade cidade) {
		//tabela hash (1:1) com tanho igual ao numero de de verices 
		Tabela[] table = new Tabela[cidade.getEsquinas().size()];

		double menorDistancia = Double.MAX_VALUE;
		//ponteiro auxiliar para vertice sendo processado no momento
		Esquina atual = origem;
		//id do vertice atual na lista de vertices
		int idAtual = cidade.getEsquinas().indexOf(atual);
		int idDestino;
		//aloca lista de vertices na tabela hash
		for (int i = 0; i < table.length; i++) {
			table[i] = new Tabela(cidade.getEsquinas().get(i));
		}
		//distancia da origem para ela mesma = 0
		table[idAtual].setDistanciaOrigem(0);
		boolean acabar = false;
		while (!acabar) {
			//quando as distancias de todas as arestas de um vertice sao computadas
			//ele é marcado como acabado
			table[idAtual].setPermanente(true);
			atual = cidade.getEsquinas().get(idAtual);
			//processa todas as arestas do vertice atual
			for (Rua rua : atual.getRuas()) {
				idDestino = cidade.getEsquinas().indexOf(rua.getDestino());
				//se a distacia do vertice de destino ao de origem for MAXIMA entao
				//o caminho atual é o menor caminho para ele
				if (table[idDestino].getDistanciaOrigem() == Double.MAX_VALUE) {
					table[idDestino].setDistanciaOrigem(rua.getDistancia() + +table[idAtual].getDistanciaOrigem());
					table[idDestino].setCaminho(atual);
					//se a distacia no vertice de destino for maior que a distacia do vertice atual mais o custo da aresta
					//entao o novo caminho é, atualmente, o menor
				} else if (table[idDestino].getDistanciaOrigem() > (table[idAtual].getDistanciaOrigem() + rua.getDistancia())) {
					table[idDestino].setDistanciaOrigem(rua.getDistancia() + table[idAtual].getDistanciaOrigem());
					table[idDestino].setCaminho(atual);
				}
			}
			//procura pelo vertice mais proximo do vertice atual para continuar a procura
			//pelo caminho menor
			for (int j = 0; j < table.length; j++) {
				if (!table[j].isPermanente()) {
					if (table[j].getDistanciaOrigem() < menorDistancia) {
						menorDistancia = table[j].getDistanciaOrigem();
						//continua apartir do vertice j
						idAtual = j;
					}
				}
			}
			if (table[idAtual].isPermanente()) {
				acabar = true;
			}
			menorDistancia = Double.MAX_VALUE;
		}

		LinkedList<Esquina> caminho = new LinkedList<>();
		idAtual = cidade.getEsquinas().indexOf(destino);
		caminho.add(destino);
		if (table[idAtual].getCaminho() == null) {
			System.out.println("Nao existe caminho");
			return null;
		}
		while (table[idAtual].getCaminho() != null) {
			atual = table[idAtual].getCaminho();
			caminho.add(atual);
			idAtual = cidade.getEsquinas().indexOf(atual);
		}
		caminho.add(origem);
		return caminho;
	}

	public static LinkedList<Esquina> buscaBidirecional(Esquina origem, Esquina destino, Cidade cidade) {
		LinkedList<Esquina> caminho = new LinkedList<>();
		if (origem == destino) {
			caminho.add(origem);
			return caminho;
		}
		for (Rua rua : origem.getRuas()) {
			if (rua.getDestino() == destino) {
				caminho.add(destino);
				caminho.add(origem);
				return caminho;
			}
		}
		Tabela[] tableOrigem = new Tabela[cidade.getEsquinas().size()];
		Tabela[] tableDestino = new Tabela[cidade.getEsquinas().size()];
		//aloca lista de vertices na tabela hash
		for (int i = 0; i < tableOrigem.length; i++) {
			tableOrigem[i] = new Tabela(cidade.getEsquinas().get(i));
			tableDestino[i] = new Tabela(cidade.getEsquinas().get(i));
		}

		tableOrigem[cidade.getEsquinas().indexOf(origem)].setPermanente(true);
		tableDestino[cidade.getEsquinas().indexOf(destino)].setPermanente(true);

		LinkedList<Esquina> expansaoOrigem = new LinkedList();
		LinkedList<Esquina> expansaoDestino = new LinkedList();

		Esquina intercessao = null;

		Esquina esquinaDestino = null;
		Esquina esquinaOrigem = null;
		boolean acaba = false;
		LinkedList<Esquina> visitadosOrigem = new LinkedList();
		LinkedList<Esquina> visitadosDestino = new LinkedList();

		expansaoOrigem.add(origem);
		expansaoDestino.add(destino);
		int k = 0;
		while (!acaba) {
			//expande de traz pra frente
			if (expansaoDestino.size() > 0) {
				esquinaDestino = expansaoDestino.getFirst();
				visitadosDestino.add(esquinaDestino);
				expansaoDestino.removeFirst();
				//esquinas que vao para destino
				for (Esquina esq : cidade.getEsquinas()) {
					for (Rua rua : esq.getRuas()) {
						if (rua.getDestino() == esquinaDestino) {
							if (!tableDestino[cidade.getEsquinas().indexOf(esq)].isPermanente()) {
								tableDestino[cidade.getEsquinas().indexOf(esq)].setCaminho(esquinaDestino);
								tableDestino[cidade.getEsquinas().indexOf(esq)].setPermanente(true);
								expansaoDestino.add(esq);
								if (esq == origem) {
									intercessao = esq;
									acaba = true;
									break;
								}
								for (Esquina esquina : visitadosOrigem) {
									//se esquina pertence a lista das esquinas visitadas apartir da origem
									if (esq == esquina) {
										intercessao = esquina;
										acaba = true;
										break;
									}
								}
							}
						}
					}
					if (acaba == true) {
						break;
					}
				}
			}

			//expande de frente pra traz
			if (expansaoOrigem.size() > 0) {
				esquinaOrigem = expansaoOrigem.getFirst();
				visitadosOrigem.add(esquinaOrigem);
				expansaoOrigem.removeFirst();

				for (Rua rua : esquinaOrigem.getRuas()) {
					if (!tableOrigem[cidade.getEsquinas().indexOf(rua.getDestino())].isPermanente()) {
						tableOrigem[cidade.getEsquinas().indexOf(rua.getDestino())].setCaminho(esquinaOrigem);
						tableOrigem[cidade.getEsquinas().indexOf(rua.getDestino())].setPermanente(true);
						expansaoOrigem.add(rua.getDestino());
						for (Esquina esquina : visitadosDestino) {
							if (rua.getDestino() == esquina) {
								intercessao = esquina;
								tableOrigem[cidade.getEsquinas().indexOf(esquina)].setCaminho(esquinaOrigem);
								acaba = true;
								break;
							}
						}
						if (acaba == true) {
							break;
						}
						if (rua.getDestino() == destino) {
							tableOrigem[cidade.getEsquinas().indexOf(rua.getDestino())].setCaminho(esquinaOrigem);
							acaba = true;
							break;
						}
					}
				}
			}
			if (expansaoOrigem.size() <= 0 && expansaoDestino.size() <= 0) {
				acaba = true;
			}
		}
		//caminho da intercessao até o destino
		int id = cidade.getEsquinas().indexOf(intercessao);
		if (intercessao == null) {
			System.out.println("Nao existe caminho (intercessao == null)");
			return null;
		}
		caminho.add(intercessao);
		if (intercessao != destino) {
			while (tableDestino[id].getCaminho() != destino) {
				esquinaDestino = tableDestino[id].getCaminho();
				if (esquinaDestino == null) {
					System.out.println("destino: sem intercessao");
				}
				caminho.add(esquinaDestino);
				id = cidade.getEsquinas().indexOf(esquinaDestino);
			}
			caminho.add(destino);
			//inverte lista
			LinkedList<Esquina> temp = new LinkedList(caminho);
			caminho = new LinkedList<>();
			while (temp.size() > 0) {
				caminho.add(temp.removeLast());
			}
		}
		//caminho da intercessao até a origem
		if (intercessao != origem) {
			id = cidade.getEsquinas().indexOf(intercessao);
			while (tableOrigem[id].getCaminho() != origem) {
				esquinaDestino = tableOrigem[id].getCaminho();
				if (esquinaDestino == null) {
					System.out.println("origem: sem intercessao");
				}
				caminho.add(esquinaDestino);
				id = cidade.getEsquinas().indexOf(esquinaDestino);
			}
			caminho.add(origem);
		}
		return caminho;
	}

	public static LinkedList<Esquina> aEstrela(Esquina origem, Esquina destino, Cidade cidade) {
		//tabela hash (1:1) com tanho igual ao numero de de verices 
		Tabela[] table = new Tabela[cidade.getEsquinas().size()];

		double menorDistancia = Double.MAX_VALUE;
		//ponteiro auxiliar para vertice sendo processado no momento
		Esquina atual = origem;
		//id do vertice atual na lista de vertices
		int idAtual = cidade.getEsquinas().indexOf(atual);
		int idDestino;
		//aloca lista de vertices na tabela hash
		double dist;
		for (int i = 0; i < table.length; i++) {
			table[i] = new Tabela(cidade.getEsquinas().get(i));
			//dist = distancia em linha reta entre nó i e destino
			dist = Math.sqrt(Math.pow((destino.getX() - table[i].getEsquina().getX()), 2) + Math.pow((destino.getY() - table[i].getEsquina().getY()), 2));
			table[i].setDistanciaDestino(dist);
		}
		//distancia da origem para ela mesma = 0
		table[idAtual].setDistanciaOrigem(0);
		boolean acabar = false;
		while (!acabar) {
			//quando as distancias de todas as arestas de um vertice sao computadas
			//ele é marcado como acabado
			table[idAtual].setPermanente(true);
			atual = cidade.getEsquinas().get(idAtual);
			//processa todas as arestas do vertice atual
			for (Rua rua : atual.getRuas()) {

				idDestino = cidade.getEsquinas().indexOf(rua.getDestino());
				//se a distacia do vertice de destino ao de origem for MAXIMA entao
				//o caminho atual é o menor caminho para ele
				if (table[idDestino].getDistanciaOrigem() == Double.MAX_VALUE) {
					table[idDestino].setDistanciaOrigem(rua.getDistancia() + table[idAtual].getDistanciaOrigem());
					table[idDestino].setCaminho(atual);
					//se a distacia no vertice de destino for maior que a distacia do vertice atual mais o custo da aresta
					//entao o novo caminho é, atualmente, o menor
				} else if (table[idDestino].getDistanciaOrigem() > (table[idAtual].getDistanciaOrigem() + rua.getDistancia())) {
					table[idDestino].setDistanciaOrigem(rua.getDistancia() + table[idAtual].getDistanciaOrigem());
					table[idDestino].setCaminho(atual);
				}
			}
			//observa a relacao (distancia do caminho para o nó + distancia em linha reta do nó até o destino)
			//o nó com o menor resultado é escolhido para continuar a busca
			for (int j = 0; j < table.length; j++) {
				if (!table[j].isPermanente()) {
					if ((table[j].getDistanciaDestino() + table[j].getDistanciaOrigem()) < menorDistancia) {
						menorDistancia = table[j].getDistanciaOrigem() + table[j].getDistanciaOrigem();
						//continua apartir do vertice j
						idAtual = j;
					}
				}
			}
			if (table[idAtual].isPermanente()) {
				acabar = true;
			}
			menorDistancia = Double.MAX_VALUE;
		}

		LinkedList<Esquina> caminho = new LinkedList<>();
		idAtual = cidade.getEsquinas().indexOf(destino);
		caminho.add(destino);
		if (table[idAtual].getCaminho() == null) {
			System.out.println("Nao existe caminho");
			return null;
		}
		while (table[idAtual].getCaminho() != null) {
			atual = table[idAtual].getCaminho();
			caminho.add(atual);
			idAtual = cidade.getEsquinas().indexOf(atual);
		}
		caminho.add(origem);
		return caminho;
	}
}
