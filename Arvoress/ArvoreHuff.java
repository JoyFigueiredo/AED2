package MaratonaAED2.Arvoress;

import static java.nio.file.Files.lines;
import static java.nio.file.Files.lines;
import java.util.Scanner;
import java.util.stream.Stream;

public class ArvoreHuff {

    class No {

        char simbolo;
        int frequencia;
        public No direita;
        public No esquerda;
        No raiz;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Stream<String> lines = str.lines();
        String palavra;

        lines.forEach(System.out::println);

    }
}
