package MaratonaAED2.Arvoress;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ordenado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tamanhoV, numero;

        tamanhoV = sc.nextInt();
        int original[] = new int[tamanhoV];

        // indice 0 = Par, 1 = Impar
        List<Integer>[] listaSeparacao = new List[2];

        for (int i = 0; i < tamanhoV; i++) {
            numero = sc.nextInt();
            original[i] = numero;
            if (((i + 1) % 2) == 0) {
                if (listaSeparacao[0] == null) {
                    listaSeparacao[0] = new LinkedList();
                }
                listaSeparacao[0].add(numero);
            } else {
                if (listaSeparacao[1] == null) {
                    listaSeparacao[1] = new LinkedList();
                }
                listaSeparacao[1].add(numero);
            }
        }
        Collections.sort(listaSeparacao[1]);
        Collections.sort(listaSeparacao[0], Collections.reverseOrder());
        int i = 0;

        System.out.print("V = { ");
        for (; i < original.length - 1; i++) {
            System.out.print(original[i] + ", ");
        }
        System.out.println(original[i] + "}");

        int I = 0, P = 0;
        System.out.print("O = { ");

        i = 0;
        for (; i < tamanhoV - 1; i++) {
            if (((i + 1) % 2) == 0) {
                System.out.print(listaSeparacao[0].get(I) + ", ");
                I++;
            } else {
                System.out.print(listaSeparacao[1].get(P) + ", ");
                P++;
            }
        }
        if (((i + 1) % 2) == 0) {
            System.out.print(listaSeparacao[0].get(I) + "}");
            I++;
        } else {
            System.out.print(listaSeparacao[1].get(P) + "}");
        }
    }
}
