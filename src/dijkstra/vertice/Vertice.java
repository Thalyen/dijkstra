package dijkstra.vertice;

import dijkstra.aresta.Aresta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tat
 */

public class Vertice implements Comparable<Vertice> {

    private String nome;
    private int valor;
    private boolean visitado = false;
    private Vertice pai;
    private List<Aresta> arestas = new ArrayList<Aresta>();
    private List<Vertice> vizinhos = new ArrayList<Vertice>();

   
     public Vertice(String nome) {
        this.nome = nome;
    }

    public Vertice() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setValor(int distancia) {
        this.valor = distancia;
    }

    public int getValor() {
        return this.valor;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public Vertice getPai() {
        return this.pai;
    }
    
    public void visitar() {
        this.visitado = true;
    }

    public boolean verificarVisita() {
        return visitado;
    }

    public void setVizinhos(List<Vertice> vizinhos) {
        this.vizinhos.addAll(vizinhos);
    }

    public List<Vertice> getVizinhos() {
        return this.vizinhos;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas.addAll(arestas);
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public int compareTo(Vertice vertice) {
        if (this.getValor() < vertice.getValor()) {
            return -1;
        } else if (this.getValor() == vertice.getValor()) {
            return 0;
        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertice) {
            Vertice vRef = (Vertice) obj;
            if (this.getNome().equals(vRef.getNome())) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Vertice=" + nome ;
    }


}
