package MaratonaAED2.Imposto;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ImpostoReal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCidades, capCarga, origem, destino, peso;

        numCidades = sc.nextInt();
        capCarga = sc.nextInt();

        Aresta arestas = new Aresta(numCidades+1);
        int imposto[] = new int[numCidades+1];

        for (int i = 1; i < numCidades+1; i++) {
            imposto[i] = sc.nextInt();
        }

        for (int i = 0; i < (numCidades-1); i++) {
            origem = sc.nextInt();
            destino = sc.nextInt();
            peso = sc.nextInt();

            arestas.add(origem, destino, peso);
        }     
        
        System.out.println(arestas.Floyd(1, -1, arestas.matriz, imposto, numCidades, capCarga));
    }
}
