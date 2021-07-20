package MaratonaAED2.Arvoress;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TabHash {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N, M = 0, C, chave, valor;

        List<List<Integer>[]> listasDeVetores = new LinkedList();

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            M = sc.nextInt();
            C = sc.nextInt();

            List[] Mlist = new List[M];

            for (int j = 0; j < C; j++) {
                chave = sc.nextInt();
                valor = chave % M;

                if (Mlist[valor] == null) {
                    Mlist[valor] = new LinkedList<>();
                }
                Mlist[valor].add(chave);

            }
            listasDeVetores.add(Mlist);
        }
        int k = 0;

        for (; k < listasDeVetores.size() - 1; k++) {
            List<Integer>[] lista = listasDeVetores.get(k);

            for (int i = 0; i < lista.length; i++) {
                System.out.print(i + " -> ");
                if (lista[i] != null) {
                    for (int j : lista[i]) {
                        System.out.print(j + " -> ");
                    }
                }
                System.out.println("\\");
            }
            System.out.println();
        }

        List<Integer>[] lista = listasDeVetores.get(k);

        for (int i = 0; i < lista.length; i++) {
            System.out.print(i + " -> ");
            if (lista[i] != null) {
                for (int j : lista[i]) {
                    System.out.print(j + " -> ");
                }
            }
            System.out.println("\\");
        }

    }
}
