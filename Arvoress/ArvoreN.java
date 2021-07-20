package MaratonaAED2.Arvoress;

import java.util.LinkedList;
import java.util.List;

public class ArvoreN {

    private No raiz;

    public class No {

        public int valor;
        List<No> listaDeFilhos;
        No raiz;

        public No(int contem) {
            this.listaDeFilhos = new LinkedList();
            this.valor = contem;
        }

        public No setFilho(int filho) {
            No n = new No(filho);
            this.listaDeFilhos.add(n);
            return n;
        }

        public int getValor() {
            return valor;
        }

        public List<No> getFilhos() {
            return listaDeFilhos;
        }

        public No buscar(int procura) {
            if (procura == valor) {
                return this;
            }
            for (No filho : listaDeFilhos) {
                No parar = filho.buscar(procura);
                if (parar != null) {
                    return parar;
                }
            }
            return null;

        }
    }

    public ArvoreN(int contemRaiz) {
        this.raiz = new No(contemRaiz);
    }

    public No getRaiz() {
        return raiz;
    }

    public No busca(int procura) {
        return raiz.buscar(procura);
    }
}
