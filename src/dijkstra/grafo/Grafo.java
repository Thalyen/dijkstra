package dijkstra.grafo;

import dijkstra.aresta.Aresta;
import java.util.ArrayList;
import java.util.List;
import dijkstra.vertice.Vertice;

/**
 *
 * @author Tat
 */
public class Grafo {

    private List<Vertice> vertices;
    private List<Aresta> arestas;
    private Vertice raiz;
    // private ArrayList<Integer> matriz[][]; preciso?

    public void criarGrafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public List<Vertice> getVertices() {
        return this.vertices;
    }

    public List<Aresta> getArestas() {
        return this.arestas;
    }

    public Vertice getRaiz() {
        return this.raiz;
    }

    public void insereVertice(String nome) {
        if (vertices == null) {
            this.criarGrafo();
            this.raiz = new Vertice(nome);
            this.vertices.add(raiz);
        } else {
            this.vertices.add(new Vertice(nome));
        }
    }

    public void insereVertice(Vertice vertice) {
        if (vertices == null) {
            this.criarGrafo();
            this.vertices.add(vertice);
        } else {
            this.vertices.add(vertice);
        }
    }

    public void setVertices(List<Vertice> arquivo) {
        if (vertices == null) {
            this.criarGrafo();
            this.vertices.addAll(arquivo);
        } else {
            this.vertices.addAll(arquivo);
        }
    }

    public Aresta insereAresta(String a, String b) {
        if (vertices.isEmpty()) {
            System.out.println("Erro: grafo sem vertices");
            return null;
        } else {
            Vertice x = buscarVertice(a);
            Vertice y = buscarVertice(b);
            Aresta aresta = new Aresta(x, y);
            if (x != null && y != null) {
                arestas.add(aresta);
                return aresta;
            } else {
                System.out.println("Erro:vertices info não existem");
                return null;
            }
        }
    }

    public Aresta buscarAresta(Vertice v) {
        for (Aresta next : arestas) {
            if (next.hasVertice(v)) {
                return next;
            }
        }
        System.out.println("Erro:arestas info não existem");
        return null;
    }

    public List<Aresta> arestasIncidentes(String nome) {
        Vertice v = buscarVertice(nome);
        List<Aresta> incidentes = new ArrayList<>();
        for (Aresta next : arestas) {
            if (next.hasVertice(v)) {
                incidentes.add(next);
            }
        }
        if (!incidentes.isEmpty()) {
            return incidentes;
        }
        System.out.println("Erro:arestas info não existem");
        return null;
    }

    public Vertice buscarVertice(String nome) {
        for (Vertice next : vertices) {
            if (next.getNome().equals(nome)) {
                return next;
            }
        }
        System.out.println("Erro:vertices info não existem");
        return null;
    }

    public Aresta remocaoAresta(String a, String b) {

        for (Aresta aresta : arestas) {
            if (aresta.getInicio().getNome().equals(a) && aresta.getFim().getNome().equals(b)) {
                arestas.remove(aresta);
                return aresta;
            }
        }
        return null;
    }

    public Vertice removerVertice(String v) {
        Vertice r = buscarVertice(v);

        if (r != null) {
            List<Aresta> incidentes = arestasIncidentes(r.getNome());
            for (Aresta incidente : incidentes) {
                arestas.remove(incidente);
            }
            vertices.remove(r);
            return r;
        }
        return null;
    }

    /*
    * finalVertices(e)    aresta e.
    * oposto(v, e) vertice v,e.
    * éAdjacente(v, w) arestas
    substituir(v, x) vertice v, x  || aresta v,x
    * removeAresta(e)
    * arestasIncidentes(v) arestas do vertice v
    * éDirecionado(e)
    * inserirArestaDirecionada(v,w,o)
     */
    public Vertice oposto(Vertice e, Aresta a) {
        if (a.getFim().equals(e)) {
            return a.getInicio();
        } else if (a.getInicio().equals(e)) {
            return a.getFim();
        }
        return null;
    }

    public boolean eAdjacente(Aresta a, Aresta b) {
        if (a.equals(b)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDirecionada(Aresta a) {
        return a.getDirecao();
    }

    public void inserirArestaDirecionada(String a, String b) {
        insereAresta(a, b).setDirecao();
    }

    public Vertice finalVertice(Aresta a) {
        return a.getFim();
    }

    public boolean hasCaminhoEuler() {
        //grau = lista de incidente.size
        //se grau for impar  soma++ se soma > 2 false
        int soma = 0;

        for (Vertice vertice : vertices) {
            int grau = arestasIncidentes(vertice.getNome()).size();
            if (grau % 2 != 0) {
                soma++;
            }
        }

        if (soma > 2) {
            return false;
        } else {
            return true;
        }
    }

}
