package MaratonaAED2.Arvoress;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Delacao {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numMarfiosos, numVidente, marfioso, k = 0, c = 0;

        numMarfiosos = sc.nextInt();
        numVidente = sc.nextInt();
        Map<Integer, Integer> mapa = new HashMap();

        for (int i = 0; i < numMarfiosos - 1; i++) {
            marfioso = sc.nextInt();
            if (mapa.get(marfioso) == null) {
                mapa.put(marfioso, 1);
                k = k + 1;
            } else {
                mapa.put(marfioso, mapa.get(marfioso) + 1);
            }
        }
/*
        for (Map.Entry<Integer, Integer> entry : mapa.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 1) {
                k = k + 1;
                c = c + 1;
            }
        }
*/
        if ((c + 1) == numVidente) {
            System.out.println(k + 1);
        } else {
            System.out.println(k);
        }
    }
}
