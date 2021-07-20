package MaratonaAED2.Arvoress;

import MaratonaAED2.Arvoress.Arvore;
import java.util.Scanner;

public class ArvoreBinaria {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int qntTestes = 0, qntsNumeros = 0, numero;

        qntTestes = sc.nextInt();
        for (int i = 0; i < qntTestes; i++) {

            Arvore arvore = new Arvore();
            qntsNumeros = sc.nextInt();
            for (int j = 0; j < qntsNumeros; j++) {
                numero = sc.nextInt();
                arvore.inserir(numero);
            }
            if (i != 0) {
                System.out.println();
            }
            System.out.print("Case " + (i + 1) + ":");
            arvore.imprimir();
        }
    }
}
