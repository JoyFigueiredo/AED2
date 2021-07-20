package MaratonaAED2.Reducao;

import java.util.HashMap;
import java.util.List;

public class Dijkstra {

    HashMap<Vertice, Integer> mapa = new HashMap<Vertice, Integer>();
    Grafo g;
    List<Vertice> grafoV;

    public Dijkstra(Grafo grafo) {
        this.g = grafo;
    }

    public int menorCaminhoD(Vertice origem, Vertice destino) {
        grafoV = g.vertices();
        int somatorio =0;
        for (int i = 0; i < g.ordem(); i++) {
            mapa.put(grafoV.get(i), Integer.MAX_VALUE);//cria grafo valor maximo
        }

        mapa.put(origem, Integer.MIN_VALUE); //vertice inicial

        int peso, pesoV;
        Vertice aux;
        HashMap<Vertice, Aresta> aresta = null;
        Object[] adjacentes;

        do {
            aux = getMenor(); //auxiliar recebe o menor caminho;
            aux.setValidar("false"); // o auxiliar recebe marcação
            aresta = aux.getAdj(); // busca aresta adjacente
            adjacentes = aux.getAdj().keySet().toArray(); //adj vai receber a aresta adjacente;

            pesoV = mapa.get(aux); //busca o peso da aresta aux

            for (int i = 0; i < aresta.size(); i++) {  // percorre as arestas
                peso = aresta.get(adjacentes[i]).getPeso(); //add valor de peso;

                if ((pesoV + peso) < mapa.get((Vertice) adjacentes[i])) { //cast de garantia q valor passado é adj
                    mapa.put((Vertice) adjacentes[i], (pesoV + peso));
                    somatorio = somatorio+peso;
                    System.out.println(aresta.get(i).peso);
                }
            }
        } while (isFechado() == false);

        return mapa.get(destino);
    }

    public Vertice getMenor() { //busca do menor cominho
        Integer menor = Integer.MAX_VALUE; //inicia com maior valor
        Integer aux;
        Vertice vertM = null;

        //gostei desse ordem... melhor q ficar usando .size(), ja deixa direto salvo;
        for (int i = 0; i < g.ordem(); i++) { 
            aux = mapa.get(grafoV.get(i));
            if (aux <= menor && grafoV.get(i).validar.equals("") == true) {
                menor = aux;
                vertM = grafoV.get(i);
            }
        }
        return vertM;
    }

    //Verifica se o vertice foi fechado;
    public boolean isFechado() {
        for (int i = 0; i < g.ordem(); i++) {
            if (!grafoV.get(i).getValidar().equals("false")) { //se não fechado retorna false
                return false;
            }
        }
        return true;
    }
}
