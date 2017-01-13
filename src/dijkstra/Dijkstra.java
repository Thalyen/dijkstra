package dijkstra;

import dijkstra.vertice.Vertice;
import dijkstra.grafo.Grafo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {

    Vertice atual = new Vertice();
    Vertice percurso = new Vertice();
    Vertice vizinho = new Vertice();
    List<Vertice> menorCaminho = new ArrayList<>();
    List<Vertice> naoVisitados = new ArrayList<>();

    public List<Vertice> Dijkstra(Grafo grafo, Vertice v1, Vertice v2) {
        menorCaminho.add(v1);

        for (int i = 0; i < grafo.getVertices().size(); i++) {
            if (grafo.getVertices().get(i).getNome().equals(v1.getNome())) {
                grafo.getVertices().get(i).setValor(0);
            } else {
                grafo.getVertices().get(i).setValor(9999);
            }
            this.naoVisitados.add(grafo.getVertices().get(i));
        }

        Collections.sort(naoVisitados);

        while (!this.naoVisitados.isEmpty()) {
            atual = this.naoVisitados.get(0);
            System.out.println("Pegou esse vertice:  " + atual);

            for (int i = 0; i < atual.getArestas().size(); i++) {
                vizinho = atual.getArestas().get(i).getFim();
                System.out.println("Vizinho de " + atual + ": " + vizinho);

                if (!vizinho.verificarVisita()) {
                    if (vizinho.getValor() > (atual.getValor() + atual.getArestas().get(i).getValor())) {
                        vizinho.setValor(atual.getValor() + atual.getArestas().get(i).getValor());
                        vizinho.setPai(atual);

                        if (vizinho == v2) {
                            menorCaminho.clear();
                            percurso = vizinho;
                            menorCaminho.add(vizinho);
                            while (percurso.getPai() != null) {
                                menorCaminho.add(percurso.getPai());
                                percurso = percurso.getPai();
                            }
                            Collections.sort(menorCaminho);
                        }
                    }
                }
            }

            atual.visitar();
            this.naoVisitados.remove(atual);
            Collections.sort(naoVisitados);
            System.out.println("Nao visitados:" + naoVisitados);
        }
        return menorCaminho;
    }
}
