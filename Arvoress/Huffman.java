package MaratonaAED2.Arvoress;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Huffman {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<List<Character>[]> list = new LinkedList<>();
        List<Character>[] vetor = new List[256];

        String palavra;

        palavra = sc.nextLine();

        for (int i = 0; i < palavra.length(); i++) {
            char aux = palavra.charAt(i);
            if(vetor[aux]==null){
                vetor[aux] = new  LinkedList();
            }
        }     
    }
}
