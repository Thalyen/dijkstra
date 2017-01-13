package dijkstra.aresta;

import dijkstra.vertice.Vertice;

/**
 *
 * @author Tat
 */
public class Aresta {

    private Vertice inicio;
    private Vertice fim;
    private int valor;
    private boolean direcao;

    @Override
    public String toString() {
        return "Aresta =" + inicio.getNome() + ", " + fim.getNome();
    }

    public Aresta(Vertice inicio, Vertice fim) {
        this.inicio = inicio;
        this.fim = fim;
        this.direcao = false;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFim() {
        return fim;
    }

    public void setFim(Vertice fim) {
        this.fim = fim;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean getDirecao(){
        return direcao;
    }
    
    public void setDirecao(){
        if(getDirecao() == false)
            this.direcao = true;
        else
            this.direcao = false;
    }
   
    public boolean hasVertice(Vertice a) {
        if (a.equals(getInicio()) || a.equals(getFim())) {
            return true;
        } else {
            return false;
        }
    }

}
