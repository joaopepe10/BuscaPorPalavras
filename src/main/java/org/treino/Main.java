package org.treino;

import org.treino.busca_padrao.FiltroDePaginaImp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException{
        String termo = "blocos de pedra";
        String url = "https://es.wikipedia.org/wiki/Pirámides_de_Egipto";
        FiltroDePaginaImp filtro = new FiltroDePaginaImp(url, termo);
    }
}