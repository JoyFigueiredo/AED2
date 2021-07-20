 package MaratonaAED2.Arvoress;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Happy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int qntAlunos = 0;
        String text;

        Map<Character, Integer>[] mapa = new HashMap[6];

        qntAlunos = sc.nextInt();
        for (int i = 0; i < qntAlunos; i++) {
            
            for (int j = 0; j < 6; j++) {
                text = sc.next();
                if (mapa[j] == null) {
                    mapa[j] = new HashMap<>();
                }
                for (int k = 0; k < text.length(); k++) {
                    char C = text.charAt(k);
                    if (mapa[j].get(C) == null) {
                        mapa[j].put(C, 1);
                    } else {
                        mapa[j].put(C, mapa[j].get(C) + 1);
                    }
                }
            }
        }

        for (int i = 0; i < mapa.length; i++) {
            if (mapa[i] != null) {
                for (Map.Entry<Character, Integer> entry : mapa[i].entrySet()) {
                    char key = entry.getKey();
                    int value = entry.getValue();
                    //System.out.println(value);
                    if (value == qntAlunos) {
                        System.out.print(key);
                    }
                }
                System.out.print(" ");
            }
        }
    }
}
