package org.treino;

import org.treino.busca_padrao.RemocaoDeTagsHtml;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        RemocaoDeTagsHtml buscarDados = new RemocaoDeTagsHtml("https://pt.wikipedia.org/wiki/Pirâmides_egípcias");
        System.out.println(buscarDados.removeTags());
    }
}