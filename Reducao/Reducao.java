package MaratonaAED2.Reducao;

import java.util.HashMap;
import java.util.Scanner;

public class Reducao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCidades, numRodovias, comprimento;
        String origem, destino;

        numCidades = sc.nextInt();
        numRodovias = sc.nextInt();
        Grafo g = new Grafo();
        Vertice vertice;
        Vertice v = null, v1 = null;
        Aresta a = null;
        Dijkstra dj = null;

        for (int i = 0; i < numRodovias; i++) {
            origem = sc.next();
            v = new Vertice(origem);
            g.addV(v);
            destino = sc.next();
            v1 = new Vertice(destino);
            g.addV(v);
            comprimento = sc.nextInt();
            a = new Aresta(comprimento);
            g.conecta(v, v1, a);
            g.conecta(v1, v, a);
        }
        
        for (int i = 0; i < g.ordem(); i++) {
            System.out.println(g.vertices().get(i).getAdj());
        }
    }
}
