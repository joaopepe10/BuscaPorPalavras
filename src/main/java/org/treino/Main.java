package org.treino;

import org.treino.busca_padrao.FiltroDePaginaImp;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException{
        String termo = "bloques de piedra";
        String url = "https://es.wikipedia.org/wiki/Pirámides_de_Egipto";
        FiltroDePaginaImp filtro = new FiltroDePaginaImp(url, termo);

        String x = "bloques de piedra";
        String[] xy = x.split("\\s");
        List<String> teste = new ArrayList<>();


        /*for (int i = 0; i <= xy.length ; i++){
            if (i == 0){
                teste.add(x);
            }else {
                teste.add(xy[i-1]);
            }
        }
        for (String i: teste){
            System.out.println(i);
        }*/

        System.out.println(filtro.buscaDe());

    }
}