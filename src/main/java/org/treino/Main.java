package org.treino;

import org.treino.busca_padrao.FiltroDePaginaImp;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException{
        FiltroDePaginaImp filtro = new FiltroDePaginaImp();
        filtro.busca("Teste", "https://pt.wikipedia.org/wiki/Albert_Einstein");
    }
}