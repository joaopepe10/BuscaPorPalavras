package org.treino;

import org.treino.busca_padrao.FiltroDePaginaImp;


import java.io.IOException;
import java.util.Scanner;

public class RunAplicacao {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        try{
            String url = "https://es.wikipedia.org/wiki/Pirámides_de_Egipto";
            System.out.println("URL UTILIZADA FOI ESTA: " + url);
            String palavra = "bloques de piedra";
            System.out.println("Palavras utilizadas na busca: " + palavra);

            FiltroDePaginaImp filtro = new FiltroDePaginaImp(url, palavra);
            System.out.println(filtro.busca());
        }catch (IOException e){
            System.out.println("Url invalida!");
        }

    }
}