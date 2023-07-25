package org.treino;

import org.treino.busca_padrao.FiltroDePaginaImp;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        String termo = "bloques";
        String url = "hes.wikipedia.org/wiki/Pirámides_de_Egipto";
        FiltroDePaginaImp filtro = new FiltroDePaginaImp(url, termo);
        System.out.println(filtro.busca());
        String novaUrl = url.replaceFirst("(^[https://]{0,8})","https://");
    }
}