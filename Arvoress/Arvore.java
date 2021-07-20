package MaratonaAED2.Arvoress;

public class Arvore {

    class No {

        public int valor;
        public No direita;
        public No esquerda;
        No raiz;
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public long getValor() {
		return this.valor;
	}
	
	
	public void setEsquerdo(No esquerdo) {
		this.esquerda = esquerdo;
		if(esquerdo != null)
		esquerdo.raiz = this;
	}
	
	public void setDireito(No direito) {
		this.direita = direito;
		if(direito != null)
		direito.raiz = this;
	}
	
	public No getNoEsquerdo() {
		return this.esquerda;
	}
	
	public No getNoDireito() {
		return this.direita;
	}
	
	public String toString() {
		return Integer.toString(this.valor);
	}
	
	public void setPai(No pai) {
		this.raiz = pai;
	}
	
	public No getPai() {
		return this.raiz;
	}
    }
    
    //Pai ou raiz...
    private No root; 

    public Arvore() {
        root = null;
    } 

    public void inserir(int v) {
        No novo = new No(); 
        novo.valor = v; 
        novo.direita = null;
        novo.esquerda = null;

        if (root == null) {
            root = novo;
        } else { // entra no else se não for Raiz/Pai
            No atual = root;
            No anterior;
            while (true) {
                anterior = atual;
                if (v <= atual.valor) { //adiciona a esquerda se valor menor q Raiz/Pai
                    atual = atual.esquerda;
                    if (atual == null) {
                        anterior.esquerda = novo;
                        return;
                    }
                } 
                else { //adiciona a direita se valor maior q Raiz/Pai
                    atual = atual.direita;
                    if (atual == null) {
                        anterior.direita = novo;
                        return;
                    }
                } 
            } 
        }
    }
    
    public void imprimir() {
        System.out.print("\nPre.: ");
        pre(root);
        System.out.print("\nIn..: ");
        in(root);
        System.out.print("\nPost: ");
        pos(root);
    }
    
    public void in(No atual) {
        if (atual != null) {
            in(atual.esquerda);
            System.out.print(atual.valor + " ");
            in(atual.direita);
        }
    }

    public void pre(No atual) {
        if (atual != null) {
            System.out.print(atual.valor + " ");
            pre(atual.esquerda);
            pre(atual.direita);
        }
    }

    public void pos(No atual) {
        if (atual != null) {
            pos(atual.esquerda);
            pos(atual.direita);
            System.out.print(atual.valor + " ");
        }
    }
}
