package MaratonaAED2.Arvoress;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joice
 */

public class Navalha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> linhas = new LinkedList();
        List<List<Integer>> listaListaLinha = new LinkedList();

        List<Integer> colunas = new LinkedList();
        List<List<Integer>> listaListaColuna = new LinkedList();

        int qntNavios, tamanhoMatriz, linha, coluna;

        tamanhoMatriz = sc.nextInt();
        qntNavios = sc.nextInt();

        for (int i = 0; i < qntNavios; i++) {
            linha = sc.nextInt();
            coluna = sc.nextInt();

            if (!linhas.contains(linha)) {
                linhas.add(linha);
                listaListaLinha.add(new LinkedList());
                listaListaLinha.get(linhas.size() - 1).add(coluna);
            } else {
                listaListaLinha.get(linhas.indexOf(linha)).add(coluna);
            }

            if (!colunas.contains(coluna)) {
                colunas.add(coluna);
                listaListaColuna.add(new LinkedList());
                listaListaColuna.get(colunas.size() - 1).add(linha);
            } else {
                listaListaColuna.get(colunas.indexOf(coluna)).add(linha);
            }
        }

        int linhasVazias, colunasVazias, anterior = 0, qnt = 0, aux = 0;
        double resLinhasVazias, resColunaVazias, resultado = 0;

        linhasVazias = tamanhoMatriz - (linhas.size());
        resLinhasVazias = ((tamanhoMatriz + 1) * tamanhoMatriz / 2) * linhasVazias;

        colunasVazias = tamanhoMatriz - (colunas.size());
        resColunaVazias = (((tamanhoMatriz + 1) * tamanhoMatriz / 2) * colunasVazias);

        for (int i = 0; i < linhas.size(); i++) {
            Collections.sort(listaListaLinha.get(i));

            for (int j = 0; j < listaListaLinha.get(i).size(); j++) {

                if (anterior == 0) {
                    anterior = listaListaLinha.get(i).get(j);
                    resultado += ((anterior + 1) * anterior / 2) - anterior;
                } else {
                    qnt = listaListaLinha.get(i).get(j) - 1 - anterior;
                    resultado += (qnt + 1) * qnt / 2;
                    anterior = listaListaLinha.get(i).get(j);
                }
            }
            qnt = tamanhoMatriz - anterior;
            resultado += (qnt + 1) * qnt / 2;
            anterior = 0;
            qnt = 0;
        }

        for (int i = 0; i < colunas.size(); i++) {
            Collections.sort(listaListaColuna.get(i));

            for (int j = 0; j < listaListaColuna.get(i).size(); j++) {

                if (anterior == 0) {
                    anterior = listaListaColuna.get(i).get(j);
                    resultado += ((anterior + 1) * anterior / 2) - anterior;
                } else {
                    qnt = listaListaColuna.get(i).get(j) - 1 - anterior;
                    resultado += (qnt + 1) * qnt / 2;
                    anterior = listaListaColuna.get(i).get(j);
                }
            }
            qnt = tamanhoMatriz - anterior;
            resultado += (qnt + 1) * qnt / 2;
            anterior = 0;
            qnt = 0;
        }

        resultado -= (tamanhoMatriz * tamanhoMatriz) - qntNavios;
        resultado += resColunaVazias + resLinhasVazias;
        System.out.print((int) resultado);
    }
}
