package MaratonaAED2.Imposto;

public class Aresta {

    static int[][] matriz;
    static int numVertices;
    //static int caminho;

    public Aresta(int num) {
        this.numVertices = num;
        this.matriz = new int[num+1][num+1];
    }

    static void add(int origem, int destino, int peso) {
        matriz[origem][destino] = peso;
        matriz[destino][origem] = peso;
    }

    static int Floyd(int cidade, int vCidade, int matriz[][],
            int imposto[], int numVertice, int carga) {

        int cidad[] = matriz[cidade];
        int  depositar = 0, constante =1, caminho =0;

        //for (int constante = 1; constante <= numVertice + 1; constante++) {
        while(constante < numVertice +1){

            if (constante == vCidade || constante == cidade || cidad[constante] == 0) {
                constante++;
                //continue;
            } else if (imposto[constante] > 0) {
                caminho = caminho + (cidad[constante]*2)+ Floyd(constante, cidade, matriz, imposto, numVertice, carga);

                if (imposto[constante] > carga) {
                    depositar = carga;
                } else {
                    depositar = imposto[constante];
                }

                imposto[cidade] =imposto[cidade]+ depositar;
                imposto[constante] = imposto[constante]- depositar;
            }else{
                constante++;
            }
        }
        return caminho;
    }
}
