package MaratonaAED2.Reducao;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Grafo {
    static List<Vertice> vertices;
    List<Vertice> visitados;
    
    public Grafo(){
        vertices = new LinkedList<Vertice>();
    }
    
    public void addV(Vertice vertice){
        if(!vertices.contains(vertice)){
            vertices.add(vertice);
            return;
        }
       // System.out.println("Valor ja existe!!!");
    }
    
    public void removeV(Vertice vertice){
        if(vertices.contains(vertice)){
            vertices.remove(vertice);
            for (Vertice v : vertice.getAdj().keySet()) {
                vertice.removerA(v);
            }
        }
        System.out.println(" Valor invalido!!! ");
    }
    
    public void conecta(Vertice origem, Vertice destino, Aresta aresta){
        if(!origem.getAdj().containsKey(destino)){
            origem.addA(aresta, destino);
            destino.addA(aresta, origem);
        }else{
            System.out.println("Ja existe");
        }
    }
    
    public void desconecta(Vertice origem, Vertice destino){
        if(origem.getAdj().containsKey(destino)){
            origem.removerA(destino);
            destino.removerA(origem);
        }else{
            System.out.println("");
        }
    }
    
    public int ordem(){
        return vertices.size();
    }
    
    public List<Vertice> vertices(){
        return vertices;
    }
    
    public Set<Vertice> adjs(Vertice v){
        return v.getAdj().keySet();
    }
    
    public int grau(Vertice v){
        return v.getAdj().size();
    }
    
    public static boolean existe(Vertice v){ //teste se vertice existe;
        if(vertices.contains(v)){
            return true;
        }
        return false;
    }
    
    public String toString(){
        return vertices.toString();
    }
}
