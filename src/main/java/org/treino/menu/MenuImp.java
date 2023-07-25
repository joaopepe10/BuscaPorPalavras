package org.treino.menu;

import org.treino.busca_padrao.FiltroDePaginaImp;

import java.io.IOException;


public  class MenuImp implements Menu {

    @Override
    public void chamarMenu() throws IOException {
        FiltroDePaginaImp filtrar = new FiltroDePaginaImp("https://es.wikipedia.org/wiki/Pirámides_de_Egipto", "piedra");


    }

}