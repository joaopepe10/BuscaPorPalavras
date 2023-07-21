package org.treino;

import org.treino.busca_padrao.BuscaPorPadrao;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BuscaPorPadrao buscarDados = new BuscaPorPadrao("https://pt.wikipedia.org/wiki/Pirâmides_egípcias");
        System.out.println(buscarDados.buscaPorParagrafo());
    }
}