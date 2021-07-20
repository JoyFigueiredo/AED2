package MaratonaAED2.Arvoress;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Monk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qntNumeros = 0;

        qntNumeros = sc.nextInt();
        long numero[] = new long[qntNumeros];

        for (int i = 0; i < qntNumeros; i++) {
            numero[i] = sc.nextLong();
        }

        double k = 0, comparador = 9;

        while (true) {
            comparador = 0;

            for (int i = 0; i < 5; i++) {
                List<Long>[] lista = new List[20];

                for (int j = 0; j < numero.length; j++) {
                    int aux = (int) ((numero[j] / ((long) Math.pow(10.0, k))) % 10);

                    if (lista[aux+9] == null) {
                        lista[aux+9] = new LinkedList();
                    }
                    lista[aux+9].add(numero[j]);
                    comparador += aux;
                }
                k++;

                int c = 0;
                for (int j = 0; j < lista.length; j++) {
                    if (lista[j] != null) {
                        for (int m = 0; m < lista[j].size(); m++) {
                            numero[c] = lista[j].get(m);
                            c++;
                        }
                    }
                }
            }
            int n = 0;
            if (comparador == 0) {
                break;
            }
            for (; n < numero.length - 1; n++) {
                System.out.printf("%d ", numero[n]);
            }

            System.out.printf("%d\n", numero[n]);

        }
    }
}
