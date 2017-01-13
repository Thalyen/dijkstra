package dijkstra;

import dijkstra.vertice.Vertice;
import dijkstra.grafo.Grafo;
import dijkstra.aresta.Aresta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LerArquivo {

    public static List<Vertice> lerGrafo(String nomeArquivo) {

        Grafo g = new Grafo();
        Vertice v;
        File arquivo = new File(nomeArquivo);
        String vertices[];
        String linha;
        ArrayList<String[]> entrada = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            Map<String, Vertice> mapa = new HashMap<>();

            while ((linha = br.readLine()) != null) {

                if (linha.contains(",")) {
                    entrada.add(linha.split("/"));
                    vertices = entrada.get(0)[0].split(",");
                    v = (Vertice) mapa.get(vertices[0]);

                    if (v == null) {
                        v = new Vertice();
                    }

                    List<Vertice> vizinhosAtual = new ArrayList<>();
                    List<Aresta> arestasAtual = new ArrayList<>();
                    v.setNome(vertices[0]);
                    mapa.put(vertices[0], v);

                    if (linha.contains("/")) {
                        String pesoArestas[] = entrada.get(0)[1].split(",");

                        for (int i = 1; i < vertices.length; i++) {
                            Vertice vit;
                            vit = mapa.get(vertices[i]);

                            if (vit == null) {
                                vit = new Vertice();
                            }

                            vit.setNome(vertices[i]);
                            vizinhosAtual.add(vit);
                            mapa.put(vertices[i], vit);

                            Aresta ait = new Aresta(v, vit);
                            ait.setValor(Integer.parseInt(pesoArestas[i - 1]));
                            arestasAtual.add(ait);
                        }
                        v.setVizinhos(vizinhosAtual);
                        v.setArestas(arestasAtual);
                    }
                } else {
                    v = (Vertice) mapa.get(linha);
                    if (v == null) {
                        v = new Vertice();
                    }
                    v.setNome(linha);
                    mapa.put(linha, v);
                }
                g.insereVertice(v);
               // System.out.println(v.toString());
                entrada.clear();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nao encontrou o arquivo");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return g.getVertices();
    }

    public static void main(String args[]) {

        Grafo grafo = new Grafo();
        grafo.setVertices(lerGrafo("teste.txt"));
        //System.out.println(grafo.getVertices());
       // System.out.println(grafo.getVertices().size());
        Vertice i1 = grafo.buscarVertice("v1");
        Vertice i2 = grafo.buscarVertice("v4");
       
        Dijkstra algoritmo = new Dijkstra();
        List<Vertice> resultado = algoritmo.Dijkstra(grafo, i1, i2);
        System.out.println("Esse é o menor caminho feito pelo algoritmo:" + resultado);
    }
}
/*
 try {
            Scanner leitor = new Scanner(new File("teste.txt"));
            List<String> linhas = new ArrayList<>();
            while (leitor.hasNextLine()) {
                linhas.add(leitor.nextLine());
            }
            leitor.close();
            System.out.println(linhas);
        } catch (FileNotFoundException e) {
            System.out.println("Nao encontrou o arquivo");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
