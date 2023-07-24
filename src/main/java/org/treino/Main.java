package org.treino;

import org.treino.busca_padrao.FiltroDePaginaImp;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException{
        FiltroDePaginaImp filtro = new FiltroDePaginaImp();
        filtro.busca("Teste", "https://pt.wikipedia.org/wiki/Albert_Einstein");

        String termo = "blocos de pedra";
        String[] termos = termo.split("\s") ;
        int [] contadores = new int[termos.length];
        for (String i: termos){
            System.out.println(i);

            //FAZ A ITERACAO USANDO O TAMANHO DOS TERMOS PARA ITERAR SOBRE O CONTADOR
            System.out.println(contadores[i.indexOf(i)]);
        }

    }
}