package MaratonaAED2.Reducao;

import java.util.HashMap;

public class Vertice {

    String nome;        //identificador do Vertice;
    HashMap<Vertice, Aresta> adj = new HashMap<Vertice, Aresta>();
    String validar;     //marcador;

    public Vertice(String nome) {
        this.nome = nome;
        validar = "";
    }

    public void addA(Aresta aresta, Vertice destino) {
        if (!Grafo.existe(destino)) {
            System.out.println("Vertice não mapeado.");
        } else if (!adj.containsKey(destino)) {
            adj.put(destino, aresta);
        } else {
            System.out.println("Aresta já existe.");
        }
    }

    public void removerA(Vertice vertice) {
        if (!adj.containsKey(vertice)) {
            System.out.println("Não mapeado");
            return;
        }
        adj.remove(vertice);
    }

    public String getNome() {
        return nome;
    }

    public void setNomeV(String vertice) {
        this.nome = vertice;
    }

    public HashMap<Vertice, Aresta> getAdj() {
        return adj;
    }

    public String getValidar() {
        return validar;
    }

    public void setValidar(String validar) {
        this.validar = validar;
    }

    @Override
    public String toString() {
        return "" + nome;
    }
}
